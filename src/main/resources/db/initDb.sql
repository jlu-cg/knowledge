create table Comments(
    commment_id BIGINT  NOT NULL auto_increment comment '序号',
    bug_id BIGINT NOT NULL,
    author BIGINT NOT NULL,
    commment_date TIMESTAMP,
    commment TEXT,
    primary key(commment_id)
);

create table Comments(
     ancestor BIGINT NOT NULL,
     descendent BIGINT NOT NULL
);