--DB 세팅 작업--
alter session set"_ORACLE_SCRIPT"=true;

create user awesomeplace identified by awesomeplace;

grant connect, resource to awesomeplace;

alter user awesomeplace default tablespace users quota unlimited on users;



--회원 테이블 생성
drop table member CASCADE CONSTRAINTS;
drop table member; 
drop sequence seq_member;
purge RECYCLEBIN;

create table member(
mem_num number not null,
mem_name varchar2(20) not null,
mem_id varchar2(20) not null unique,
mem_pw varchar2(20) not null,
mem_tel varchar2(20),
mem_email varchar2(50) unique,
constraint PK_member primary key(mem_num)
);

create sequence seq_member nocache;

insert into member(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email)
values(seq_member.nextval, 'test01', 'test01', '0000', '010-0000-0000', 'test01@naver.com');
insert into member(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email)
values(seq_member.nextval, 'test02', 'test02', '1111', '010-1111-1111', 'test02@naver.com');
insert into member(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email)
values(seq_member.nextval, 'test03', 'test03', '2222', '010-2222-2222', 'test03@naver.com');
insert into member(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email)
values(seq_member.nextval, 'test04', 'test04', '3333', '010-3333-3333', 'test04@naver.com');
insert into member(mem_num, mem_name, mem_id, mem_pw, mem_tel, mem_email)
values(seq_member.nextval, 'test05', 'test05', '4444', '010-4444-4444', 'test05@naver.com');

select * from member;
commit;