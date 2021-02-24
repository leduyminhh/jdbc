use jdbc;
create table user(
   id INT NOT NULL AUTO_INCREMENT,
   username VARCHAR(150) NOT NULL,
   password VARCHAR(150) NOT NULL,
   fullname VARCHAR(255) NOT NULL,
   status INT NOT NULL,
   roleid INT NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

create table role(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NOT NULL,
   code VARCHAR(255) NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

ALTER TABLE user
ADD CONSTRAINT fk_user_role
FOREIGN KEY (roleid) REFERENCES role(id);

create table news(
   id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(255) NULL,
   thumbnail VARCHAR(150) NULL,
   shortdescription TEXT NULL,
   content TEXT NULL,
   categoryid INT NOT NULL, 
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

create table category(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NULL,
   code VARCHAR(150) NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

ALTER TABLE news ADD CONSTRAINT fk_news_category 
FOREIGN KEY (categoryid) REFERENCES category(id);

create table comment(
   id INT NOT NULL AUTO_INCREMENT,
   content TEXT NULL,
   userid INT NOT NULL,
   newsid INT NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

ALTER TABLE comment ADD CONSTRAINT fk_cm_user 
FOREIGN KEY (userid) REFERENCES category(id);

ALTER TABLE comment ADD CONSTRAINT fk_cm_news
FOREIGN KEY (newsid) REFERENCES category(id);
