DROP TABLE IF EXISTS 'user_details';
CREATE TABLE 'user_details'(
   'name' varchar(50) PRIMARY KEY NOT NULL,
   'password' varchar(50) NOT NULL,
);

DROP TABLE IF EXISTS 'lucky_number';
CREATE TABLE 'lucky_number'(
   'date' varchar(50) PRIMARY KEY NOT NULL,
   'number' varchar(50) NOT NULL,
);