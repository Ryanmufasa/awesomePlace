-- 뉴 테이블 구조에 따른 기존 테이블 변경 sql 문입니다
-- 전체 실행하지 마시고 내용 확인하면서 실행해주세요
-- 누락된 내용이 있다면 알려주세요

-- ######## member 테이블 #############

-- 컬럼 추가 

-- 회원 활성화 (가입시 Y, 회원 탈퇴 신청시 N) 
alter table member add mem_sign varchar2(10) default 'Y' not null;
-- 회원 호스팅 개수 (가입시 default 0, 호스트 등록시 값 변경.
alter table member add mem_hostcnt number default 0 not null;

-- 변경이 제대로 되었는지 확인합니다. 
desc member;

-- ######### host 테이블 #############

-- 방 이름 컬럼 삭제
alter table host drop column room_name;

-- 호스트 회원 번호 컬럼 위치 변경
alter table host modify mem_num invisible;
alter table host modify mem_num visible;

-- 호스트 회원 아이디 컬럼 추가 
alter table host add mem_id varchar2(20) not null;  
-- 기존 테스트 데이터가 있을 경우 not null 입력이 안되므로  테스트 데이터를 삭제해야 합니다.
delete host; 
-- 제약 조건 위배로 삭제가 안되는 경우 제약조건 목록을 확인해봅니다
select * from user_constraints;
-- 제약조건 위배 에러 문구에서 나온대로 해당 테이블의 제약조건을 목록에서 확인후 삭제합니다. 
alter table orderinfo drop constraint oi_mem_num_fk;
alter table orderinfo drop constraint oi_host_num_fk;
-- host 테이블을 참조하는 연관 테이블의 테스트 데이터가 삭제 되었다면 
-- delete host; 명령어를 실행하고
-- 호스트 회원 아이디 컬럼 추가 sql문을 다시 실행합니다.

-- 변경이 제대로 되었는지 확인합니다. 
desc host;

-- ########### hostfile 테이블 ############
-- 새로 추가된 신규 테이블입니다
create table hostfile(
file_num number not null primary key,
origin_file_name varchar2(50) not null,
file_path_name varchar2(200) not null,
host_num number not null,
    constraint hf_host_num foreign key (host_num) references host
);


-- ########## orderinfo 예약 목록 정보 테이블 ##########
-- 독립테이블로 참조 조건 없습니다 

-- 기존 테스트 데이터를 전부 삭제합니다
delete orderinfo;

-- 컬럼 삭제
alter table orderinfo drop column mem_num;

-- 컬럼명 변경
alter table orderinfo rename column order_num to oi_num;
alter table orderinfo rename column guest_cnt to oi_guest_cnt;
alter table orderinfo rename column order_date to pay_date;
alter table orderinfo rename column host_num to oi_host_num;
alter table orderinfo rename column order_sign to oi_sign;

-- 컬럼 위치 정리
alter table orderinfo modify oi_host_num invisible;
alter table orderinfo modify pay_date invisible;
alter table orderinfo modify pay_amt invisible;
alter table orderinfo modify oi_sign invisible;

-- 컬럼 추가
alter table orderinfo add checkin_date date not null;
alter table orderinfo add checkout_date date not null;

-- 위치정리
alter table orderinfo modify pay_date visible;
alter table orderinfo modify pay_amt visible;
alter table orderinfo modify oi_sign visible;

-- default 값 변경
alter table orderinfo modify pay_date not null;
alter table orderinfo modify oi_sign default 'wait' not null;
-- oi_sign은 예약 대기(wait), 예약 완료(confirm), 예약 취소(cancle) 만 입력


-- 위치 정리
alter table orderinfo modify oi_host_num visible;

-- 호스트 정보 컬럼 추가
alter table orderinfo add oi_host_name varchar2(40) not null;
alter table orderinfo add oi_host_addr varchar2(80) not null;
alter table orderinfo add oi_host_post_num varchar2(10) not null;
alter table orderinfo add oi_host_tel varchar2(20) not null;

-- 회원 정보 컬럼 추가
alter table orderinfo add oi_mem_id varchar2(20) not null;
alter table orderinfo add oi_mem_tel varchar2(20) not null;

desc orderinfo;


--- ######### QNA 테이블 ##########
-- 컬럼추가
alter table qna add qna_redate date;

-- 컬럼 default 값 추가
alter table qna modify qna_date default sysdate;
alter table qna modify qna_sign default 'Wait';


desc qna;


--- 찜 테이블 추가 


create table jjim(
mem_num number not null,
    constraint jjim_mem_num_fk foreign key (mem_num) references member,
host_num number not null,
    constraint jjim_host_num_fk foreign key (host_num) references host
);


commit;
