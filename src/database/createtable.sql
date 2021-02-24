use jdbc1;
create table users(
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


create table user_role(
	user_id INT NOT NULL,
	role_id INT NOT NULL
);

ALTER TABLE user_role ADD CONSTRAINT fk_user_role1 FOREIGN KEY (user_id) REFERENCES users(id);
ALTER TABLE user_role ADD CONSTRAINT fk_user_role2 FOREIGN KEY (role_id) REFERENCES role(id);
ALTER TABLE users ADD CONSTRAINT fk_users_role FOREIGN KEY (roleid) REFERENCES role(id);

create table product(
   id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(255) NULL,
   thumbnail VARCHAR(150) NULL,
   shortdescription TEXT NULL,
   content TEXT NULL,
   number INT NOT NULL, 
   price DOUBLE NOT NULL,
   sale INT NULL,
   categoryid INT NOT NULL,
   status INT NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

create table category(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NULL,
   parentid INT NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

ALTER TABLE product ADD CONSTRAINT fk_product_category 
FOREIGN KEY (categoryid) REFERENCES category(id);

create table post(
   id INT NOT NULL AUTO_INCREMENT,
   title VARCHAR(255) NULL,
   thumbnail VARCHAR(150) NULL,
   shortdescription TEXT NULL,
   content TEXT NULL,
   topicid INT NOT NULL, 
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )
);

create table topic(
   id INT NOT NULL AUTO_INCREMENT,
   name VARCHAR(255) NULL,
   parentid INT NOT NULL,
   createdate TIMESTAMP NULL,
   modifieddate TIMESTAMP NULL,
   createby  VARCHAR(255) NULL,
   modifiedby  VARCHAR(255) NULL,
   PRIMARY KEY ( id )	
);
ALTER TABLE post ADD CONSTRAINT fk_post_topic 
FOREIGN KEY (topicid) REFERENCES topic(id);
