CREATE TABLE IF NOT EXISTS candidates (
    candidate_id SERIAL PRIMARY KEY,
    first_name VARCHAR(15),
    last_name VARCHAR(15),
    date_created DATE,
    date_updated DATE DEFAULT NULL
);
CREATE TABLE IF NOT EXISTS urls(
    url_id SERIAL PRIMARY KEY,
    url VARCHAR(150)
);

CREATE TABLE IF NOT EXISTS Addresses (
      address_id SERIAL PRIMARY KEY,
      email VARCHAR(30),
      phone VARCHAR(15),
      street_address DATE,
      fk_candidate_id INTEGER NOT NULL REFERENCES candidates(candidate_id) ON DELETE CASCADE,
      fk_url_id INTEGER REFERENCES urls(url_id)
);

CREATE TABLE IF NOT EXISTS Experiences (
    experience_id SERIAL PRIMARY KEY,

)