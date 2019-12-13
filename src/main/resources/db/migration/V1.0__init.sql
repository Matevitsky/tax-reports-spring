create table if not exists client
(
    user_id    serial       not null,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    company_id serial       not null,
    primary key (user_id)
);

create table company
(
    company_id   serial       not null,
    company_name varchar(255) not null,
    primary key (company_id)
);

create table employee
(
    user_id    serial       not null,
    email      varchar(255) not null,
    first_name varchar(255) not null,
    last_name  varchar(255) not null,
    password   varchar(255) not null,
    primary key (user_id)
);

create table reports
(
    id               serial       not null,
    content          varchar(255) not null,
    reason_to_reject varchar(255),
    status           varchar(255) not null,
    tittle           varchar(255) not null,
    user_id          serial       not null,
    primary key (id)
);

create table requests
(
    id      serial not null,
    user_id int8   not null,
    primary key (id)
);
create table user_roles
(
    user_id int8         not null,
    role    varchar(255) not null
);

alter table if exists client
    add constraint FKbdkhriogfnems0qpgiasmf3x8 foreign key (company_id) references company;
alter table if exists reports
    add constraint FKaqkd9n5xa3k1pk7m6y72w8pvt foreign key (user_id) references client;
alter table if exists requests
    add constraint FK82kgsd1s07jb50htqmfe3ki9m foreign key (user_id) references client;
alter table if exists user_roles
    add constraint FKs2g5i4d6eotfcwvibs3gaji7p foreign key (user_id) references client;
