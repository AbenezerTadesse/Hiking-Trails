CREATE TABLE TRAIL(
    ID INT AUTO_INCREMENT,
    NAME VARCHAR(255),
    LENGTH DOUBLE,
    DIFFICULTY VARCHAR(255),
    LOCATION VARCHAR(255),
    DESCRIPTION VARCHAR(255),
    PRIMARY KEY (ID)
);

INSERT INTO TRAIL (NAME, LENGTH, DIFFICULTY, LOCATION, DESCRIPTION) VALUES
  ('Emerals Lake', '3.1', 'Moderate','Rocky Mountain National Park',
  'Heavily trafficked trail offering views of Glacier Gorge'),

  ('Hanging Lake', '1.2', 'Moderate', 'Glenwood Springs, CO',
  'A natural National Landmark popular for its awe-inspiring beauty and gentle Colorado waterfalls!'),

  ('Royal Arch Trail', '3.5', 'Hard','Rocky Mountain National Park',
  'Not as grand as some of the arches in Utah but still a really a beautiful sight,');