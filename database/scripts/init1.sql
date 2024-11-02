-- DROP TABLE IF EXISTS candidates;

CREATE TABLE IF NOT EXISTS candidates (
    candidate_id SERIAL UNIQUE NOT NULL,
    first_name VARCHAR(15),
    last_name VARCHAR(15),
    date_created DATE,
    date_updated DATE DEFAULT NULL
);

-- DROP TABLE IF EXISTS urls;

CREATE TABLE IF NOT EXISTS urls(
    url_id SERIAL UNIQUE NOT NULL,
    url VARCHAR(150),
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS addresses;

CREATE TABLE IF NOT EXISTS addresses (
    address_id SERIAL UNIQUE NOT NULL,
    email VARCHAR(30),
    phone VARCHAR(15),
    street_address VARCHAR(35),
    city VARCHAR(15),
    zip_code INTEGER,
    state VARCHAR(20),
    country VARCHAR(30),
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE,
    url_id INTEGER REFERENCES urls(url_id)
);

-- DROP TABLE IF EXISTS types;

CREATE TABLE IF NOT EXISTS types (
    type_id SERIAL UNIQUE NOT NULL,
    name VARCHAR(20)
);

-- DROP TABLE IF EXISTS experiences;

CREATE TABLE IF NOT EXISTS experiences (
    experience_id SERIAL UNIQUE NOT NULL,
    name VARCHAR(30),
    establishment VARCHAR(30),
    description VARCHAR(200),
    start_date DATE,
    end_date DATE,
    type_id INTEGER REFERENCES types(type_id),
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE,
    url_id INTEGER REFERENCES urls(url_id)
);

-- DROP TABLE IF EXISTS accomplishments;

CREATE TABLE IF NOT EXISTS accomplishments(
    accomplishment_id SERIAL UNIQUE NOT NULL,
    description VARCHAR(200),
    experience_id INTEGER NOT NULL REFERENCES experiences(experience_id)
);

-- DROP TABLE IF EXISTS applications;

CREATE TABLE IF NOT EXISTS applications(
    application_id SERIAL UNIQUE NOT NULL,
    company VARCHAR(40),
    name VARCHAR(40),
    date_created DATE,
    date_updated DATE DEFAULT NULL,
    job_post VARCHAR(200),
    notes VARCHAR(200),
    status INTEGER,
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS categories;

CREATE TABLE IF NOT EXISTS categories(
     category_id SERIAL UNIQUE NOT NULL,
     name VARCHAR(30)
);

-- DROP TABLE IF EXISTS skills;

CREATE TABLE IF NOT EXISTS skills(
    skill_id SERIAL UNIQUE NOT NULL,
    name VARCHAR(20) UNIQUE,
    category_id INTEGER REFERENCES  categories(category_id) ON DELETE CASCADE
);


-- DROP TABLE IF EXISTS skill_categories;
-- May not need, will FIX
-- CREATE TABLE IF NOT EXISTS skill_categories(
--     skill_category_id SERIAL UNIQUE NOT NULL,
--     category_id INTEGER REFERENCES categories(category_id) ON DELETE CASCADE,
--     skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
-- );

-- DROP TABLE IF EXISTS application_skills;

CREATE TABLE IF NOT EXISTS application_skills(
   application_skill_id SERIAL UNIQUE NOT NULL,
   application_id INTEGER REFERENCES applications(application_id) ON DELETE CASCADE,
   skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS candidate_skills;

CREATE TABLE IF NOT EXISTS candidate_skills(
     candidate_skill_id SERIAL UNIQUE NOT NULL,
     ability INTEGER,
     years_of_experience INTEGER,
     candidate_id INTEGER REFERENCES candidates(candidate_id) ON DELETE CASCADE,
     skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
);

/*

TESTING INSERT DATA

*/


INSERT INTO candidates (first_name, last_name, date_created)
VALUES (
        'jane'
       , 'doe'
       , NOW()
       )
RETURNING *;


INSERT INTO urls (url, candidate_id)
SELECT 'Facebook.com'
     , candidates.candidate_id
FROM candidates
RETURNING *;

INSERT INTO addresses(email, phone, street_address, city, zip_code, state, country, candidate_id, url_id)
SELECT 'jdoe@fakeemail.com'
    , '2679943078'
    , '123 main st'
    , 'portland'
    , 97215
    , 'Oregon'
    , 'USA'
    , candidates.candidate_id
    , urls.url_id
FROM candidates, urls
WHERE candidates.first_name = 'jane' and urls.candidate_id = candidates.candidate_id
RETURNING  *;

INSERT INTO categories(name)
VALUES ('Operating Systems'),('Computer Language'),('Natural Language');

INSERT INTO skills(name, category_id)
SELECT 'Python'
    , categories.category_id
FROM categories
WHERE categories.name='Computer Language'
RETURNING *;

INSERT INTO skills(name, category_id)
SELECT 'Japanese'
     , categories.category_id
FROM categories
WHERE categories.name='Natural Language'
RETURNING *;

INSERT INTO skills(name, category_id)
SELECT 'MacOS'
     , categories.category_id
FROM categories
WHERE categories.name='Operating Systems'
RETURNING *;

INSERT INTO candidate_skills(ability, years_of_experience, candidate_id, skill_id)
SELECT 1
    , 15
    , candidates.candidate_id
    , skills.skill_id
FROM candidates, skills
WHERE candidates.first_name='jane' AND skills.name='Python';

INSERT INTO types(name) VALUES ('job'),('project');

INSERT INTO experiences (name, establishment, description, start_date, end_date, type_id, candidate_id, url_id)
SELECT
    'my title'
    , 'google'
    , 'professional googler'
    , NOW()
    , NOW()
    , types.type_id
    , candidates.candidate_id
    , urls.url_id
FROM types, candidates, urls
WHERE types.name='job'AND candidates.first_name='jane' AND urls.candidate_id = candidates.candidate_id;

INSERT INTO accomplishments (description, experience_id)
SELECT
     'worked hard on coding'
    , experiences.experience_id
FROM experiences
WHERE experiences.name='my title';

INSERT INTO accomplishments(description, experience_id)
SELECT
     'built sql database in docker'
     , experiences.experience_id
FROM experiences
WHERE experiences.name='my title'
RETURNING *;

INSERT INTO applications(company, name, date_created, date_updated, job_post, notes, status, candidate_id)
SELECT 'orenji'
    , 'Senior Software Engineer'
    , NOW()
    , NOW()
    , 'Leardership position with experience in Python'
    , 'This sounds like a great fit for me'
    , 1
    , candidates.candidate_id
FROM candidates
WHERE candidates.first_name ='jane';

INSERT INTO application_skills(application_id, skill_id)
SELECT applications.application_id
     , skills.skill_id
FROM applications, skills
WHERE applications.company='orenji' AND skills.name='Python'
RETURNING *;