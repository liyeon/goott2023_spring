-- replyboard 테이블
create table replyboard(
bid number(4) primary key,
bname varchar2(20),
btitle varchar2(100),
bcontent varchar2(300),
bdate Date default sysdate,
bhit number(4) default 0,
bgroup number(4),
bstep  number(4),
bindent  number(4)
);

select * from replyboard order by bid desc;

update replyboard set bhit=(bhit+1) where bid=10;

create sequence replyboard_seq;
drop sequence replyboard_seq;
insert into replyboard values(replyboard_seq.nextval,'liyeon','자바란무엇인가','내용내용0',sysdate,0,replyboard_seq.currval,0,0);
delete from replyboard;
commit;

-- 댓글 작성
-- replyboard_seq.currval  bgroup : 전달받은 번호
-- bstep 18번에 대한 step보다 1 커지게
-- bindent 18번에 대한 indent 보다 1 커지게
insert into replyboard(bid,bname,btitle,bcontent,bgroup,bstep,bindent)
values(replyboard_seq.nextval,'liyeon','피자에대한 고찰에 대한 답변','내용내용0',18,1,1);

-- 댓글 후 수정
select
bid,bname,btitle,bcontent,bdate,bhit,bgroup,bstep,bindent
from replyboard order by bgroup desc,bstep asc;

-- 스텝을 1증가 시키는 쿼리
update replyboard
set bstep=bstep+1
where bgroup=33 and bstep>2;
-- 미션 테이블
create table pz_board(
pzid number(4) primary key,
pzname varchar2(20),
pzsubj varchar2(100),
pzcontent varchar2(300),
pzdate Date default sysdate,
pzhit number(4) default 0,
pzgroup number(4),
pzstep number(4),
pzintent number(4));
insert into pz_board values(pz_board_seq.nextval,'이름이름','제목제목','내용내용',sysdate,0,pz_board_seq.currval,0,0);
select * from pz_board;
create sequence pz_board_seq;


---- 230807 미션
create table replyboard2(
brd_id number(4) primary key,
brd_name varchar2(20),
brd_title varchar2(100),
brd_content varchar2(300),
brd_date Date default sysdate,
brd_hit number(4) default 0,
brd_group number(4),
brd_step number(4),
brd_indent number(4));
select * from replyboard2;
insert into replyboard2 values(replyboard2_seq.nextval,'liyeon','자바란무엇인가','내용내용0',sysdate,0,replyboard2_seq.currval,0,0);
create sequence replyboard2_seq;