BEGIN TRANSACTION;

DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS breweries;
DROP TABLE IF EXISTS brewery_reviews;
DROP TABLE IF EXISTS beer_reviews;
DROP SEQUENCE IF EXISTS seq_user_id;
DROP SEQUENCE IF EXISTS seq_brewery_id;
DROP SEQUENCE IF EXISTS seq_brewery_review_id;
DROP SEQUENCE IF EXISTS seq_beer_review_id;

CREATE SEQUENCE seq_user_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_brewery_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_brewery_review_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;
  
CREATE SEQUENCE seq_beer_review_id
  INCREMENT BY 1
  NO MAXVALUE
  NO MINVALUE
  CACHE 1;



CREATE TABLE users (
	user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
	username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);

CREATE TABLE breweries (
        brewery_id int DEFAULT nextval('seq_brewery_id'::regclass) NOT NULL,
        brewery_name varchar(50) NOT NULL,
        contact_info varchar(50) NOT NULL,
        brewery_history varchar(1000) NOT NULL,
        operation_time varchar (50) NOT NULL,
        address varchar(50) NOT NULL,
        active boolean,
        user_submitted boolean NOT NULL,
        CONSTRAINT PK_breweries PRIMARY KEY (brewery_id)

);

CREATE TABLE brewery_reviews (
        brewery_review_id int DEFAULT nextval('seq_brewery_review_id'::regclass) NOT NULL,
        brewery_reviewer_name varchar(50) NOT NULL,
        brewery_review_text varchar(1000) NOT NULL,
        brewery_review_stars int NOT NULL
        
);

CREATE TABLE beer_reviews (
        beer_review_id int DEFAULT nextval('seq_beer_review_id'::regclass) NOT NULL,
        beer_reviewer_name varchar(50) NOT NULL,
        beer_review_text varchar(1000) NOT NULL,
        beer_review_stars int NOT NULL
        
);


INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');


COMMIT TRANSACTION;
