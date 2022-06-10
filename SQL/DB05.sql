-- hashtag 테이블 생성 

create table hashtag(
tag_num number not null primary key,
tag_name varchar2(20) not null
);

create sequence hashtag_seq NOCACHE;

insert into hashtag
values(hashtag_seq.nextval, '해변가');
insert into hashtag
values(hashtag_seq.nextval, '최고의뷰');
insert into hashtag
values(hashtag_seq.nextval, '수영장');
insert into hashtag
values(hashtag_seq.nextval, '공원근처');
insert into hashtag
values(hashtag_seq.nextval, '주차가능');
insert into hashtag
values(hashtag_seq.nextval, '조식제공');
insert into hashtag
values(hashtag_seq.nextval, '역세권');

commit;

select * from hashtag;

-- host and hashtag 테이블 
create table hnh (
tag_num number not null,
    constraint hh_tag_num_fk foreign key (tag_num) references hashtag(tag_num),
host_num number not null,
    constraint hh_host_num_fk foreign key (host_num) references host (host_num)
)

insert into hnh values(1,1);
insert into hnh values(2,1);
insert into hnh values(3,1);

commit;

select * from hnh;

select h.host_name, t.tag_name
from host h, hashtag t, hnh n
where h.host_num = n.host_num 
    and n.tag_num = t.tag_num;
