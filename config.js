import fs from 'fs';
import sqlite3 from 'sqlite3';



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
      title TEXT,
      dates TEXT,
      description TEXT,
      accomplishments TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
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
    db.run(`CREATE TABLE languages (
      name TEXT,
      canid INTEGER,
      FOREIGN KEY(canid) REFERENCES canidate(canid)
      )
    `);
    db.run(`CREATE TABLE skills (
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

    const education = db.prepare("INSERT INTO education (title,dates,description,canid) VALUES (?,?,?,?)");
    education.run('work1', '2011-2020','worked',1);
    education.finalize();

    const languages = db.prepare("INSERT INTO languages (name,canid) VALUES (?,?)");
    languages.run('python', 1);
    languages.run('java', 1);
    languages.finalize();

    const skills = db.prepare("INSERT INTO skills (name,canid) VALUES (?,?)");
    skills.run('communication', 1);
    skills.run('attention to details', 1);
    skills.finalize();
  });

  db.close();
}

async function checkFiles(){

  if(!fs.existsSync('./data')){
      fs.mkdirSync('./data');
      const db = new sqlite3.Database('./data/db.sqlite');
      makeDatabase(db);
  } else {
    updateDatabase();
  }
  if(!fs.existsSync('./pdf')){
      fs.mkdirSync('./pdf');
  }
}

function updateDatabase(){
  const db = new sqlite3.Database('./data/db.sqlite');
}


export { checkFiles };
