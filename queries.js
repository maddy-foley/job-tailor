import fs from 'fs';
import sqlite3 from 'sqlite3';
import { DIR_PATH_DB } from './constants.js';



async function makeDatabase(db){
  try{
    const data = fetchData();
    const profile = JSON.parse(data);

  //load db
    const db = new sqlite3.Database(DIR_PATH_DB);

    db.exec('PRAGMA foreign_keys = ON;');
    db.serialize(() => {
      db.run(`CREATE TABLE canidate (
        canid INTEGER PRIMARY KEY,
        firstname TEXT NOT NULL,
        lastname TEXT NOT NULL,
        email TEXT,
        url TEXT
        )
        `);

      db.run(`CREATE TABLE experience (
        expid INTEGER PRIMARY KEY,
        title TEXT NOT NULL,
        dates TEXT,
        description TEXT,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);
      db.run(`CREATE TABLE accomplishment (
        description TEXT NOT NULL,
        expid INTEGER NOT NULL,
        FOREIGN KEY(expid) REFERENCES experience(expid) ON DELETE CASCADE
        )
      `);

      db.run(`CREATE TABLE education (
        title TEXT NOT NULL,
        dates TEXT,
        description TEXT,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);
      db.run(`CREATE TABLE language (
        name TEXT NOT NULL,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);
      db.run(`CREATE TABLE skill (
        name TEXT NOT NULL,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);

      insertData(db,profile);


      console.log('new database loaded');
    });

    db.close();
  } catch(error){
    console.error(error);
  }
}

function insertData(db,profile){

  const canidate = db.prepare("INSERT INTO canidate (firstname, lastname, email, url) VALUES (?,?,?,?)");
  canidate.run(profile.canidate.firstname, profile.canidate.lastname, profile.canidate.email, profile.canidate.url);
  canidate.finalize();

  const experience = db.prepare("INSERT INTO experience (title,dates,description,canid) VALUES (?,?,?,?)");
  experience.run(profile.experience.title, profile.experience.dates,profile.experience.description,1);
  experience.finalize();

  const accomplishment = db.prepare("INSERT INTO accomplishment (description, expid) VALUES (?,?)");
  accomplishment.run('built database',1);
  accomplishment.run('tested db',1);
  accomplishment.finalize();

      const education = db.prepare("INSERT INTO education (title,dates,description,canid) VALUES (?,?,?,?)");
      education.run('work1', '2011-2020','worked',1);
      education.finalize();

      const language = db.prepare("INSERT INTO language (name,canid) VALUES (?,?)");
      language.run('python', 1);
      language.run('java', 1);
      language.finalize();

      const skill = db.prepare("INSERT INTO skill (name,canid) VALUES (?,?)");
      skill.run('communication', 1);
      skill.run('attention to details', 1);
      skill.finalize();

}

function fetchData(){
  try{
    const res = fs.readFileSync("./examplecanidate.json");
    return res;
  } catch (error) {
    console.error(error);
    return null;
  }
}

async function checkFiles(){

  if(!fs.existsSync('./data')){
    fs.mkdirSync('./data');
    makeDatabase();
  } else {
    updateDatabase();
  }
  if(!fs.existsSync('./pdf')){
      fs.mkdirSync('./pdf');
  }
}

async function updateDatabase(){
  //testing

  // const db = new sqlite3.Database(DIR_PATH_DB);
  console.log('database updated');
}


export { checkFiles, fetchData };
