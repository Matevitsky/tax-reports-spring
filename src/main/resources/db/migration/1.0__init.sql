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

create table if not exists client
(
    user_id      serial       not null,
    email        varchar(255) not null,
    first_name   varchar(255) not null,
    last_name    varchar(255) not null,
    password     varchar(255) not null,
    company_id   serial       not null,
    inspector_id serial       not null,
    primary key (user_id),
    foreign key (company_id) references company,
    foreign key (inspector_id) references employee

);

create table reports
(
    id               serial       not null,
    content          TEXT         not null,
    reason_to_reject varchar(255),
    status           varchar(255) not null,
    tittle           varchar(255) not null,
    user_id          serial       not null,
    primary key (id),
    foreign key (user_id) references client
);

create table requests
(
    id      serial not null,
    user_id int8   not null,
    primary key (id),
    foreign key (user_id) references client
);

CREATE TABLE user_roles
(
    user_id SERIAL,
    role    varchar(255),
    foreign key (user_id) REFERENCES employee (user_id)
);


