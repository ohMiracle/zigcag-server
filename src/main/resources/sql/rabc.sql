drop table if exists sys_user;
create table if not exists sys_user
(
    dbid int(32) primary key auto_increment not null,
    uid int(32) unique key not null,
    nickname varchar(32)  not null,
    name varchar(64) null,
    avatar char(36) null,
    set_question_num int(32) default 0,
    answer_question_num int(32) default 0,
    phone varchar(32) unique key null,
    email varchar(32) unique key null,
    role_id varchar(36) not null,
    salt varchar(36),
    password varchar(36),
    sex int(2) null,
    create_time datetime                       not null,
    update_time datetime                       not null

);

drop table if exists sys_uid;
create table if not exists sys_uid
(
    dbid int(32) primary key auto_increment not null,
    uid  int(32) unique key                 not null comment '用户ID',
    index uid_index (uid)

);
drop table if exists sys_uid_special;
create table if not exists sys_uid_special
(
    dbid int(32) primary key auto_increment not null,
    uid  int(32) unique key                 not null comment '用户ID',
    index uid_special_index (uid)
);


drop table if exists sys_role;

create table if not exists sys_role
(
    dbid int(32) primary key auto_increment not null,
    id char(36)   unique key  not null,
    name varchar(36) unique key not null,
    description      varchar(255) default null,
    create_time datetime  not null,
    update_time datetime  not null
);
drop table if exists sys_permission;

create table if not exists sys_permission
(
    dbid        int(32) primary key auto_increment not null,
    id          char(36) unique key                not null,
    name        varchar(36)                        not null,
    description varchar(255)                       null,
    parent_id   varchar(36) default null,
    create_time datetime                       not null,
    update_time datetime                       not null
);


drop table if exists sys_operation;

create table if not exists sys_operation
(
    dbid int(32) primary key auto_increment not null,
    id char(36)   unique key  not null,
    name varchar(36) unique key not null,
    description      varchar(255) default null,
    create_time datetime  not null,
    update_time datetime  not null
);

drop table if exists sys_menu;
create table if not exists sys_menu
(
    dbid int(32) primary key auto_increment not null,
    id char(36)   unique key  not null,
    parent_id char(36)  default null ,
    name varchar(36) not null,
    description      varchar(255) default null,
    create_time datetime  not null,
    update_time datetime  not null
);

drop table if exists sys_role_permission;
create table sys_role_permission
(
    dbid int(32) primary key auto_increment not null,
    id char(36)   unique key  not null,
    role_id char(36)  not null,
    permission_id char(36) not null
);
drop table if exists sys_permission_menu;

create table sys_permission_menu
(
    dbid int(32) primary key auto_increment not null,
    id   char(36) unique key                not null,
    permission_id char(36) not null,
    menu_id char(36) not null
);

drop table if exists sys_permission_operation;
create table sys_permission_operation
(
    dbid int(32) primary key auto_increment not null,
    id char(36)   unique key  not null,
    permission_id char(36) not null,
    operation_id  char(36) not null
);

