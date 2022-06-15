-- host 테이블 생성 

create table host(
host_num number not null primary key,
mem_num number not null,
    constraint mem_num_fk foreign key (mem_num) references member(mem_num),
host_name varchar2(40) not null,
host_addr varchar2(80)	not null,
host_post_num number	not null,
host_tel	varchar2(20)	not null,
room_type	varchar2(5)	not null,
room_name	varchar2(20)	not null,
room_cnt	number	not null,
guest_cnt	number	not null,
weekday_amt	number	not null,
weekdend_amt	number	not null,
host_content	varchar2(1000)	not null,
host_file	varchar2(100),
host_date	date	not null
);

create sequence host_seq nocache;

insert into host values(host_seq.nextval, 1, 'cozy house', '서울 동작구 장승배기로 171', '06928', '02-866-9357', 'R', '201호',
1, 10, 100000, 200000, '테스트','none' ,sysdate);

commit;

alter table host rename column weekdend_amt to weekend_amt;
