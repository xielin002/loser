--1.建表
create table sys_user(
id INT NOT NULL AUTO_INCREMENT,
user_code VARCHAR(100) NOT NULL,
user_name VARCHAR(100) NOT NULL,
login_ip VARCHAR(100),
user_psd VARCHAR(100) NOT NULL,
age INT,
sex int NOT NULL default 1,
adress varchar(100),
createdBy varchar(100) default 'admin',
createdTime timestamp not null default now(),
updatedBy varchar(100) default 'admin',
updatedTime timestamp not null default now(),
PRIMARY KEY ( id )
);

--2.插入数据(需要修改mysql配置文件里的编码格式，才能存中文)
insert into sys_user (user_code, user_name, user_psd) value ('zhangsan', '张三', 123);
insert into sys_user (user_code, user_name, user_psd) value ('lisi', '李四', 123);
insert into sys_user (user_code, user_name, user_psd) value ('xielin', 'xielin', 123);
insert into sys_user (user_code, user_name, user_psd) value ('wangwu', '王五', 123);


