import fs from 'fs';
import sqlite3 from 'sqlite3';

function makeDatabase(db){
  db.serialize(() => {
    db.run("CREATE TABLE lorem (info TEXT)");

    const stmt = db.prepare("INSERT INTO lorem VALUES (?)");
    for (let i = 0; i < 10; i++) {
        stmt.run("Ipsum " + i);
    }
    stmt.finalize();

    db.each("SELECT rowid AS id, info FROM lorem", (err, row) => {
        console.log(row.id + ": " + row.info);
    });
  });

  db.close();
}

async function checkFiles(){

  if(!fs.existsSync('./data')){
      fs.mkdirSync('./data');
      const db = new sqlite3.Database('./data/.db');
      makeDatabase(db);
  }
  if(!fs.existsSync('./pdf')){
      fs.mkdirSync('./pdf');
  }
}

export { makeDatabase, checkFiles};