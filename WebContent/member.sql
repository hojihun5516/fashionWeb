CREATE TABLE member(
num number(5) PRIMARY KEY,
id varchar2(30),
pwd varchar2(30),
name varchar2(30),
nick varchar2(30),
phone char(13),
age number(3),
gender char(6),
email varchar2(50),
admin number(1) default 0,
points number(5) default 0
);

insert into member(num, id, pwd, name, nick, age, admin, points) values (member_seq.nextval, '1234','1234','영수','영수',20,0,0);
insert into member(num, id, pwd, name, nick, age, admin, points) values (member_seq.nextval, '12345','12345','영희','영희',35,1,20);
insert into member(num, id, pwd, name, nick, age, admin, points) values (member_seq.nextval, '1234567','1234567','철수','철수',42,2,40);
insert into member(num, id, pwd, name, nick, age, admin, points) values (member_seq.nextval, '12345678','12345678','관리자','관리자',20,3,150);


CREATE TABLE board(
	num number(5) PRIMARY KEY,
	fr_num number(5),
	f_category varchar2(30),
	nick varchar2(30),
	age number(5),
	title varchar2(100),
	content varchar2(2000),
	image varchar2(1000),
	writedate date default sysdate,
	good number(5) default 0,
	readcount number(4) default 0,
	category varchar2(20),
	link varchar2(50),
	titlecolor varchar2(30)
);

CREATE TABLE answer(
	num number(5) PRIMARY KEY,
	fr_num number(5) CONSTRAINTS fr_board_num REFERENCES board(num),
	content varchar2(1000),
	nick varchar2(30),
	writedate date default sysdate
);


create sequence answer_seq start with 1 increment by 1;
create sequence member_seq start with 1 increment by 1;
create sequence board_seq start with 1 increment by 1;





----------------------------- 테스트 --------------------------------

alter table member rename column point to points;

alter table board add(link varchar2(50));
alter table board add(titlecolor varchar2(30));
alter table board modify(link varchar2(50) default '정보가 없습니다.');

update MEMBER set points=5+(select points from member where num= 44) where num = 44;

update member set admin = 
case
when points >= 0 and points < 20 then 0
when points >= 20 and points < 40 then 1
when points >= 40 and points < 100 then 2
when points >=100 then 3
end where num = 62; 

update member set points= 15 where num = 44;

select num, fr_num, content, writedate, nick from answer where fr_num=186 order by num desc;

select * from answer, board where board.num=162 order by answer.num desc;

select num, nick, category, title, content, readcount, writedate from BOARD where category='notice' order by num desc;


select * from (select * from BOARD where category='snap' order by readcount desc ) where rownum <= 6;

select * from board where nick='민자라' and num='163';


select board.num, nick, title, writedate, good, readcount from board, member where board.fr_num = member.num 
order by 1 desc;






 