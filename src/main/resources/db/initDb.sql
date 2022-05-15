create table label(
    id BIGINT NOT NULL auto_increment comment '序号',
    code VARCHAR(255) NOT NULL,
    name VARCHAR(255) NOT NULL,
    primary key(id)
);

create table label_relation(
     ancestor BIGINT NOT NULL,
     descendent BIGINT NOT NULL
);