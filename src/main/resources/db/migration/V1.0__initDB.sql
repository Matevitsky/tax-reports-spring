alter table if exists client
    drop constraint if exists FKbdkhriogfnems0qpgiasmf3x8;
alter table if exists client
    drop constraint if exists FKpkly8cfjrp2vxsmktjm7us7v8;
alter table if exists reports
    drop constraint if exists FKaqkd9n5xa3k1pk7m6y72w8pvt;
alter table if exists requests
    drop constraint if exists FK82kgsd1s07jb50htqmfe3ki9m;
alter table if exists user_roles
    drop constraint if exists FKfe4xkhgeykvrf75jq4i5nv7vl;
drop table if exists client cascade;
drop table if exists company cascade;
drop table if exists employee cascade;
drop table if exists reports cascade;
drop table if exists requests cascade;
drop table if exists user_roles cascade;
create table client
(
    user_id    bigserial not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    company_id int8,
    primary key (user_id)
);
create table company
(
    company_id   bigserial    not null,
    company_name varchar(255) not null,
    primary key (company_id)
);
create table employee
(
    user_id    bigserial not null,
    email      varchar(255),
    first_name varchar(255),
    last_name  varchar(255),
    password   varchar(255),
    primary key (user_id)
);
create table reports
(
    id               bigserial    not null,
    content          varchar(255) not null,
    reason_to_reject varchar(255),
    status           varchar(255) not null,
    tittle           varchar(255),
    user_id          int8         not null,
    primary key (id)
);
create table requests
(
    id      bigserial not null,
    user_id int8      not null,
    primary key (id)
);
create table user_roles
(
    user_id int8 not null,
    role    varchar(255)
);
alter table if exists client
    add constraint FKbdkhriogfnems0qpgiasmf3x8 foreign key (company_id) references company;
alter table if exists client
    add constraint FKpkly8cfjrp2vxsmktjm7us7v8 foreign key (user_id) references employee;
alter table if exists reports
    add constraint FKaqkd9n5xa3k1pk7m6y72w8pvt foreign key (user_id) references client;
alter table if exists requests
    add constraint FK82kgsd1s07jb50htqmfe3ki9m foreign key (user_id) references client;
alter table if exists user_roles
    add constraint FKfe4xkhgeykvrf75jq4i5nv7vl foreign key (user_id) references employee;