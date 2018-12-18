CREATE TABLE OUTPUT_ENTITY (
  id             INTEGER IDENTITY PRIMARY KEY,
  fecha     		 			 VARCHAR(50),
  winner1  		 			 INTEGER,
  winner2  		 			 INTEGER,
  winner3  		 			 INTEGER,
  winner4  		 			 INTEGER,
  winner5  		 			 INTEGER,
  star1  		 			 INTEGER,
  star2  		 			 INTEGER,
  frequency		 			 FLOAT
);

CREATE TABLE WINNERS (
	id INTEGER IDENTITY PRIMARY KEY,
	winner INTEGER,
	frequency FLOAT
);

CREATE TABLE STARS (
	id INTEGER IDENTITY PRIMARY KEY,
	star INTEGER,
	frequency FLOAT
);