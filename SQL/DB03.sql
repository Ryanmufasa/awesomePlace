-- orderinfo 테이블 생성 

create table orderinfo (
order_num	number	not null primary key,
host_num	number	not null,
    constraint o_host_num_fk foreign key (host_num) references host(host_num),
host_name	varchar2(40)	not null,
mem_num	number	not null,
     constraint o_mem_num_fk foreign key (mem_num) references member(mem_num),
mem_name	varchar2(20)	not null,
guest_cnt	number	not null,
order_date	date	not null,
pay_amt	number	not null,
order_sign	varchar2(10)	not null
);

create sequence orderinfo_seq nocache;

insert into orderinfo
values(orderinfo_seq.nextval, 1, 'cozy house', 1, 'test01', 1, '20220610', 100000, 'Wait'); 

commit;

select * from orderinfo;

