CREATE TABLE IF NOT EXISTS candidates (
    CandidateID SERIAL PRIMARY KEY,
    FirstName VARCHAR(15),
    LastName VARCHAR(15),
    DateCreated DATE,
    DateUpdated DATE DEFAULT NULL
)