drop table if exists student;

create table student
(
    id      bigint      not null auto_increment,
    name    varchar(20) not null,
    primary key (id)
);