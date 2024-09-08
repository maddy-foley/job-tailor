import fs from 'fs';
import sqlite3 from 'sqlite3';

function makeDatabase(db){
  db.serialize(() => {
    db.run(`CREATE TABLE canidate (
      canidateid INTEGER PRIMARY KEY,
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
      expcanidate INTEGER,
      FOREIGN KEY(expcanidate) REFERENCES artist(canidateid)
      )
    `);

    // db.run(`CREATE TABLE education (
    //   title TEXT,
    //   dates TEXT,
    //   description TEXT,
    //   educanidate INTEGER,
    //   FOREIGN KEY(educanidate) REFERENCES artist(canidateid)
    //   )
    // `);
    // db.run(`CREATE TABLE languages (
    //   name TEXT,
    //   langcanidate INTEGER,
    //   FOREIGN KEY(langcanidate) REFERENCES artist(canidateid)
    //   )
    // `);
    // db.run(`CREATE TABLE skills (
    //   name TEXT,
    //   skillscanidate INTEGER,
    //   FOREIGN KEY(skillscanidate) REFERENCES artist(canidateid)
    //   )
    // `);


    const stmt = db.prepare("INSERT INTO canidate (firstname, lastname, email, url) VALUES (?,?,?, ?)");
    stmt.run('text', 'test', 'test@test', 'test.test');
    stmt.finalize();
    db.each("SELECT rowid AS id, firstname FROM canidate", (err, row) => {
      console.log(row.firstname);
  });

  });

  db.close();
}

async function checkFiles(){

  if(!fs.existsSync('./data')){
      fs.mkdirSync('./data');
      const db = new sqlite3.Database('./data/.db');
      makeDatabase(db);
  } else {
    //run update
  }
  if(!fs.existsSync('./pdf')){
      fs.mkdirSync('./pdf');
  }
}

export { checkFiles };
