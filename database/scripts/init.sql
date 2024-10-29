-- DROP TABLE IF EXISTS candidates;

CREATE TABLE candidates (
    candidate_id SERIAL UNIQUE NOT NULL,
    first_name VARCHAR(15),
    last_name VARCHAR(15),
    date_created DATE,
    date_updated DATE DEFAULT NULL
);

-- DROP TABLE IF EXISTS urls;

CREATE TABLE urls(
    url_id SERIAL UNIQUE NOT NULL,
    url VARCHAR(150)
);

-- DROP TABLE IF EXISTS addresses;

CREATE TABLE addresses (
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
    description TEXT,
    start_date DATE,
    end_date DATE,
    type_id INTEGER REFERENCES types(type_id),
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE,
    url_id INTEGER REFERENCES urls(url_id)
);

-- DROP TABLE IF EXISTS accomplishments;

CREATE TABLE IF NOT EXISTS accomplishments(
    accomplishment_id SERIAL UNIQUE NOT NULL,
    description TEXT,
    experience_id INTEGER NOT NULL REFERENCES experiences(experience_id)
);

-- DROP TABLE IF EXISTS applications;

CREATE TABLE IF NOT EXISTS applications(
    application_id SERIAL UNIQUE NOT NULL,
    company VARCHAR(30),
    name VARCHAR(20),
    date_created DATE,
    date_updated DATE DEFAULT NULL,
    job_post TEXT,
    notes TEXT,
    status INTEGER,
    candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS skills;

CREATE TABLE IF NOT EXISTS skills(
    skill_id SERIAL UNIQUE NOT NULL,
    name VARCHAR(20),
    ability INTEGER,
    years_of_experience INTEGER
);

-- DROP TABLE IF EXISTS categories;

CREATE TABLE IF NOT EXISTS categories(
     category_id SERIAL UNIQUE NOT NULL,
     name VARCHAR(30)
);

-- DROP TABLE IF EXISTS skill_categories;

CREATE TABLE IF NOT EXISTS skill_categories(
    id SERIAL UNIQUE NOT NULL,
    category_id INTEGER REFERENCES categories(category_id) ON DELETE CASCADE,
    skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS application_skillss;

CREATE TABLE IF NOT EXISTS application_skills(
   id SERIAL UNIQUE NOT NULL,
   application_id INTEGER REFERENCES applications(application_id) ON DELETE CASCADE,
   skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
);

-- DROP TABLE IF EXISTS candidate_skills;

CREATE TABLE IF NOT EXISTS candidate_skills(
     id SERIAL UNIQUE NOT NULL,
     candidate_id INTEGER REFERENCES candidates(candidate_id) ON DELETE CASCADE,
     skill_id INTEGER REFERENCES skills(skill_id) ON DELETE CASCADE
);