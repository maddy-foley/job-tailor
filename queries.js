import fs from 'fs';
import sqlite3 from 'sqlite3';
import { DIR_PATH_DB } from './constants.js';



function makeDatabase(db){
  db.serialize(() => {
    db.run(`CREATE TABLE canidate (
      canid INTEGER PRIMARY KEY,
      firstname TEXT,
      lastname TEXT,
      email TEXT,
      url TEXT
      )
      `);

    db.run(`CREATE TABLE experience (
      expid INTEGER PRIMARY KEY,
      title TEXT,
      dates TEXT,
      description TEXT,
      accomplishments TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
      )
    `);
    db.run(`CREATE TABLE accomplishment (
      description TEXT,
      expid INTEGER,
      FOREIGN KEY(expid) REFERENCES experience(expid)
      )
    `);

    db.run(`CREATE TABLE education (
      title TEXT,
      dates TEXT,
      description TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
      )
    `);
    db.run(`CREATE TABLE language (
      name TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
      )
    `);
    db.run(`CREATE TABLE skill (
      name TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
      )
    `);

    const canidate = db.prepare("INSERT INTO canidate (firstname, lastname, email, url) VALUES (?,?,?,?)");
    canidate.run('text', 'test', 'test@test', 'test.test');
    canidate.finalize();

    const experience = db.prepare("INSERT INTO experience (title,dates,description,accomplishments,canid) VALUES (?,?,?,?,?)");
    experience.run('work1', '2011-2020','worked', 'built database',1);
    experience.finalize();

    const accomplishment = db.prepare("INSERT INTO accomplishment (description, expid) VALUES (?,?)");
    accomplishment.run('built database',1);
    accomplishment.run('tested db',1);
    accomplishment.finalize();

    const education = db.prepare("INSERT INTO education (title,dates,description,canid) VALUES (?,?,?,?)");
    education.run('work1', '2011-2020','worked',1);
    education.finalize();

    const languages = db.prepare("INSERT INTO language (name,canid) VALUES (?,?)");
    languages.run('python', 1);
    languages.run('java', 1);
    languages.finalize();

    const skills = db.prepare("INSERT INTO skill (name,canid) VALUES (?,?)");
    skills.run('communication', 1);
    skills.run('attention to details', 1);
    skills.finalize();

    console.log('new database loaded');
  });

  db.close();
}

async function checkFiles(){

  if(!fs.existsSync('./data')){
    fs.mkdirSync('./data');
    const db = new sqlite3.Database(DIR_PATH_DB);
    makeDatabase(db);
  } else {
    updateDatabase();
  }
  if(!fs.existsSync('./pdf')){
      fs.mkdirSync('./pdf');
  }
}

function updateDatabase(){
  const db = new sqlite3.Database(DIR_PATH_DB);
  console.log('database updated');
}


export { checkFiles };
