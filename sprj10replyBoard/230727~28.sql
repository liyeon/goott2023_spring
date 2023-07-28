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

select * from replyboard;
create sequence replyboard_seq;

insert into replyboard values(replyboard_seq.nextval,'liyeon','자바란무엇인가','내용내용0',sysdate,0,replyboard_seq.currval,0,0);

commit;

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