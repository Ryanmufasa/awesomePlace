--고객센터 문의게시판

create table QNA(
qna_num number not null primary key,
mem_num number not null,
constraint mem_num_fk foreign key (mem_num) references member(mem_num),
mem_id varchar2(20) not null,
qna_title varchar2(40) not null,
qna_content varchar2(1000) not null,
qna_date date not null,
qna_sign varchar2(10) not null,
qna_answer varchar2(1000)
);

create sequence QNA_seq nocache;

insert into QNA values(QNA_seq.nextval, 1, 'test01', '문의글 제목', '문의글 내애애애애애요용요요용', sysdate, 'Wait', '');

commit;


