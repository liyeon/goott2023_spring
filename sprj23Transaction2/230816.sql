-- ajax json 데이터 가져오기
select * from dept;

-- star 별점 리뷰 테이블
create table reviewtb(
reno number,
review varchar2(200),
repoint number
);

select * from reviewtb;

create sequence reviewtb_seq;

commit;
-- ajax json 데이터 가져오기
select * from emp;