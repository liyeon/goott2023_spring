create table jmember(
id varchar2(10) primary key,
pw varchar2(10),
nickname varchar2(20),
email varchar2(30),
shpwd varchar2(90),
bcpwd varchar2(90),
mailcheck number default 0);

drop table jmember purge;
insert into jmember values('a1','111','cj','tb@n.com','111','222',0);
commit;
select * from jmember;
select email from jmember where id='tbasic';