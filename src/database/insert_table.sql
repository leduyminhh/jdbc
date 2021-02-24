use jdbc;
insert into role (code, name) values ('ADMIN','Quản trị');
insert into role (code, name) values ('USER','Người dùng');

insert into user (username, password, fullname, status, roleid) values ('admin','12345','admin',1,1);
insert into user (username, password, fullname, status, roleid) values ('minh','12345','minh',1,2);
insert into user (username, password, fullname, status, roleid) values ('minh1','12345','minh1',1,2);
