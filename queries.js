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

      db.run(`CREATE TABLE type (
         typeid INTEGER PRIMARY KEY,
         name TEXT
        )
        `);


      db.run(`CREATE TABLE experience (
        expid INTEGER PRIMARY KEY,
        title TEXT NOT NULL,
        dates TEXT,
        description TEXT,
        typeid INTEGER NOT NULL,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        FOREIGN KEY(typeid) REFERENCES type(typeid) ON DELETE CASCADE
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
        langid INTEGER PRIMARY KEY,
        name TEXT NOT NULL,
        canid INTEGER NOT NULL,
        FOREIGN KEY(langid) REFERENCES experience(expid) ON DELETE CASCADE
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);
      db.run(`CREATE TABLE skill (
        name TEXT NOT NULL,
        canid INTEGER NOT NULL,
        FOREIGN KEY(canid) REFERENCES canidate(canid) ON DELETE CASCADE
        )
      `);

      const type = db.run("INSERT INTO type (name) VALUES ('job'),('project')");
      // type.run('job');
      // type.run('project');
      // type.finalize();

      console.log("type added");

      insertData(db,profile);


      console.log('new database loaded');
    });

    db.close();
  } catch(error){
    console.error(error);
  }
}

function insertData(db,profile){
    const {canidate, experience, education, language, skill} = profile;


    const can = db.prepare("INSERT INTO canidate (firstname, lastname, email, url) VALUES (?,?,?,?)");
    can.run(canidate.firstname, canidate.lastname, canidate.email, canidate.url);
    can.finalize();


    // NEEDS CHANGE
    const canidateid = 1;


    for(let e of experience){
      const exp = db.prepare("INSERT INTO experience (title,dates,description,typeid,canid) VALUES (?,?,?,?,?)");
      //const typeid = db.run(`SELECT typeid FROM type WHERE name=${e.type}`);
      exp.run(e.title, e.dates, e.description, 1, canidateid);
      exp.finalize();

     // const expid = db.run(`SELECT expid FROM experience WHERE title=${e.title}`);
      const accomplishment = db.prepare("INSERT INTO accomplishment (description, expid) VALUES (?,?)");
      for(let a in e.accomplishment){
        accomplishment.run(a,1);
      }
      console.log("accomplishments added");
      accomplishment.finalize();
    }

    const edu = db.prepare("INSERT INTO education (title,dates,description,canid) VALUES (?,?,?,?)");
    for(let e of education){
      edu.run(e.title, e.dates, e.description,canidateid);
    }

    edu.finalize();

    const lang = db.prepare("INSERT INTO language (name,canid) VALUES (?,?)");
    for(let l of language){
      lang.run(l.name, canidateid);
    }

    lang.finalize();

    const sk = db.prepare("INSERT INTO skill (name,canid) VALUES (?,?)");
    for(let s of skill){
      sk.run(s.name, canidateid);
    }

    sk.finalize();


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
