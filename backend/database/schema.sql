BEGIN TRANSACTION;


DROP TABLE IF EXISTS SEQUENCE cascade;
CREATE SEQUENCE seq_user_id
INCREMENT BY 1
NO MAXVALUE
NO MINVALUE
CACHE 1;
DROP TABLE IF EXISTS users CASCADE;
CREATE TABLE users (
user_id int DEFAULT nextval('seq_user_id'::regclass) NOT NULL,
username varchar(50) NOT NULL,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
CONSTRAINT PK_user PRIMARY KEY (user_id)
);

DROP TABLE IF EXISTS food CASCADE;
CREATE TABLE food (
       food_id SERIAL,
       food_name varchar(255) NOT NULL DEFAULT '',
        CONSTRAINT PK_food PRIMARY KEY (food_id)
);

DROP TABLE IF EXISTS breweries CASCADE;
CREATE TABLE breweries (
       brewery_id SERIAL NOT NULL,
       brewery_name varchar(255) NOT NULL,
       contact_info varchar(255) NOT NULL DEFAULT '',
      brewery_history varchar(1000) NOT NULL DEFAULT '',
        operation_time varchar (255) NOT NULL DEFAULT '',
        address varchar(255) NOT NULL DEFAULT '',
        city_state_zip varchar(255) NOT NULL DEFAULT '',
       website varchar(255) NOT NULL DEFAULT '',
        image varchar(1000) NOT NULL DEFAULT '',
        active boolean NOT NULL DEFAULT false,        food_served int NOT NULL DEFAULT 1,
        CONSTRAINT PK_breweries PRIMARY KEY (brewery_id),
       CONSTRAINT FK_breweries_food FOREIGN KEY (food_served) REFERENCES food(food_id)
;

DROP TABLE IF EXISTS user_breweries CASCADE;
CREATE TABLE user_breweries (
        user_id int NOT NULL,
        brewery_id int NOT NULL,
        CONSTRAINT PK_user_breweries PRIMARY KEY (user_id, brewery_id),
        CONSTRAINT FK_user_breweries_users FOREIGN KEY (user_id) REFERENCES users(user_id),
        CONSTRAINT FK_user_breweries_breweries FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id)
);

DROP TABLE IF EXISTS beers CASCADE;
CREATE TABLE beers (
        beer_id SERIAL,
       beer_name varchar(255) NOT NULL,
       beer_type varchar(50) NOT NULL,
       beer_description varchar(255) NOT NULL,
       abv float NOT NULL,
        image varchar(1000) NOT NULL,
        gluten_free boolean DEFAULT FALSE,
        CONSTRAINT PK_beers PRIMARY KEY (beer_id)
);

DROP TABLE IF EXISTS brewery_beers CASCADE;
CREATE TABLE brewery_beers (
       brewery_id int NOT NULL,
       beer_id int NOT NULL,
       CONSTRAINT PK_brewery_beers PRIMARY KEY (brewery_id, beer_id),
       CONSTRAINT FK_brewery_beers_breweries FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id),
       CONSTRAINT FK_brewery_beers_beers FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);

DROP TABLE IF EXISTS reviews CASCADE;
CREATE TABLE reviews (
       review_id SERIAL NOT NULL,
       reviewer_name varchar(50) NOT NULL,
       review_text varchar(1000) NOT NULL,
       review_stars int NOT NULL,
          review_type varchar(10),
        user_id int NOT NULL,
       brewery_id int,
        beer_id int,
        CONSTRAINT PK_reviews PRIMARY KEY (review_id),
        CONSTRAINT FK_reviews_users FOREIGN KEY (user_id) REFERENCES users(user_id)
        CONSTRAINT FK_review_of_breweries FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id),
       CONSTRAINT FK_review_of_beers FOREIGN KEY (beer_id) REFERENCES beers(beer_id)

       foreign key of review_of to revews confusing
);



DROP TABLE IF EXISTS reviews CASCADE;
CREATE TABLE reviews (
       review_id SERIAL NOT NULL,
       reviewer_name varchar(50) NOT NULL,
       review_text varchar(1000) NOT NULL,
       review_stars int NOT NULL,
       review_type varchar(10),
       user_id int NOT NULL,
       CONSTRAINT PK_reviews PRIMARY KEY (review_id),
       CONSTRAINT FK_reviews_users FOREIGN KEY (user_id) REFERENCES users(user_id)
);

DROP TABLE IF EXISTS review_of CASCADE;
CREATE TABLE review_of (
       review_id int NOT NULL,
       brewery_id int,
       beer_id int,
       CONSTRAINT PK_review_of PRIMARY KEY (review_id, brewery_id, beer_id),
        CONSTRAINT FK_review_of_reviews FOREIGN KEY (review_id) REFERENCES reviews(review_id),
       CONSTRAINT FK_review_of_breweries FOREIGN KEY (brewery_id) REFERENCES breweries(brewery_id),        CONSTRAINT FK_review_of_beers FOREIGN KEY (beer_id) REFERENCES beers(beer_id)
);
INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
NSERT INTO users (username,password_hash,role) VALUES ('brewer','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_BREWER');
INSERT INTO food (food_name) VALUES ('N/A'), ('Bar Food'), ('American'), ('Seafood'), ('Italian'), ('Vegan');
COMMIT TRANSACTION;