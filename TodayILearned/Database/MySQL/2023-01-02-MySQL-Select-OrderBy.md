---
layout: single
title: "[DataBase] 1일 차 : select, order by"

categories: DATABASE
tags: [DataBase, MySQL, jekyll]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-01-02
last_modified_at: 2023-07-03

sidebar:
  nav: "docs"
---



# 1. SELECT

> 😎 SELECT절은 MySQL의 가장 기본적인 명령어로 특정 테이블에서 원하는 데이터를 조회해서 가져오는데 사용 된다.



## 1-1. SELECT FROM 활용

- SQL문 실행 단축키
  - 단일 쿼리 실행: `ctrl` +  `enter`
  - 다중 쿼리 실행: 실행하고 싶은 만큼의 쿼리를 `drag` 후 `ctrl` +  `enter`
  - 페이지 전체 쿼리 실행: `ctrl` + `shift` + `enter`

## Sample1

~~~mysql
use mydb;

-- 한줄 주석문

/*
	범위 주석문
    
    SQL - Structured Query Language
			구조적	 질의어
            
	CRUD
	insert, delete, select, update
					 90%
            
    employees : 사원
    departments : 부서
    jobs : 업무
*/

select * from employees;	-- * : 모든 데이터
SELECT * FROM EMPLOYEES;	
-- 소/대문자 신경 안써도 된다.

select employee_id, first_name, salary
from employees;
-- employees 테이블에서 select~ 정보 조회

desc employees; -- desc = column의 정보

/*
	자료형
    
    java		MySQL
    int			int, decimal(5)
    double		double, decimal(5, 1)
    String		varchar
    Date		date
*/



-- table 생성
/*
create table 테이블명(
	컬럼명1	자료형,
    컬럼명2	자료형
		  :
          :
);
*/

-- 테이블정보 조회
select * 
from information_schema.tables
where table_schema='mydb';

-- varchar == string	-- 10 byte (영문자:1byte 한글:3byte)
create table tb_varchar(
	col1 varchar(10),
    col2 varchar(20)
);

select * from tb_varchar;
-- 아직 값이 없음.

insert into tb_varchar(col1, col2)
values('abc', 'ABC');

-- int, double
create table tb_decimal(
	col1 decimal,	-- 정수까지
    col2 decimal(5),	-- 정수 5자리
    col3 decimal(5, 2)	-- 정수 5자리, 소수 2자리
);

insert into tb_decimal(col1, col2, col3)
values(1234.5678, 12345.12, 123.456);
/*
	col1 : 1234.5678
	col2 : 12345
	col3 : 123.45
*/

select * from tb_decimal;

-- 날짜
create table tb_date(
	col1 date,
    col2 date
);

-- 현재 날짜
insert into tb_date(col1, col2)
values(now(), '2022-12-25'); -- (지금 날짜, 설정 날짜)

select * from tb_date;	-- tb_date 테이블 검사

create table board(	-- 테이블, 칼럼 생성
	col1 timestamp,
    col2 timestamp default now()
);

insert into board(col1, col2)	-- column 세팅
values(now(), default);

insert into board(col1, col2)  -- column 세팅
values(now(), now());

select * from board;	-- board 테이블 확인

-- tables 삭제
drop table tb_varchar;
drop table tb_decimal;
drop table tb_date;
drop table board;
~~~





## Select

~~~mysql
use mydb;


/*
	형식 :	select절 -> 검색
		select (값, 컬럼명, 함수, sub query)
        from (테이블명, sub query)
    
*/

select 1 from dual;	-- dual : 임시 테이블, 값 확인 용도
select '한글' from dual;

-- 특정 테이블 대해서 모든 데이터를 취득
select *
from employees;

select *
from departments;

select employee_id, last_name, hire_date
from employees;

select '이름', employee_id, last_name, hire_date	-- 왼쪽 끝에 이름 column이 생성됨.
from employees;

-- 컬럼의 별(alias)
select employee_id AS 사원번호, last_name as "성", salary "월급"
from employees;		-- "" 안 붙여도 가능

select employee_id AS "사원 번호", last_name as "성", salary "월급"
from employees;

-- 산술연산자( +, -, *, / )
select first_name, last_name, salary * 12 as 연봉
from employees;

-- 문자열 합치기 "hello" + "world"
select concat('이름 : ', last_name, ' ', first_name) as 이름 -- concat이 문자열 합치기 
from employees;

-- IFNULL
select ifnull(commission_pct, 0)	-- 다른 프로그램이랑 연동 시 null값이 아닌, 0으로 데이터 전송
from employees						-- 한글 사용 시, "" or '' 필요함. "0"으로 하면 string값.
~~~





## Problem1

~~~mysql
use mydb;

-- 문제1) EMPLOYEES Table의 모든 자료를 출력하여라.
select *
from employees;

-- 문제2) EMPLOYEES Table의 컬럼들을 모두 출력하라.
desc employees;

-- 문제3) EMPLOYEES Table에서 사원 번호, 이름, 급여, 담당업무를 출력하여라.
select employee_id, first_name, salary, job_id
from employees;

-- 문제4) 모든 종업원의 급여를 $300증가 시키기 위해서 덧셈 연산자를 사용하고 
-- 결과에 SALARY+300을 디스플레이 합니다.
select first_name, salary, salary+300
from employees;

-- 문제5) EMPLOYEES 테이블에서 사원번호, 이름, 급여, 보너스, 보너스 금액을 출력하여라. 
-- (참고로 보너스는 월급 + (월급*커미션))
select employee_id, first_name, salary, 
commission_pct, salary * commission_pct as "보너스 금액"
from employees;

-- 문제6) EMPLOYEES 테이블에서 LAST_NAME을 이름으로 SALARY을 "급여"로 출력하여라.
select LAST_NAME as 이름, salary as 급여
from employees;

-- 문제7) EMPLOYEES 테이블에서 LAST_NAME을 Name으로 SALARY *12 를 Annual Salary(연봉)로 출력하여라
select last_name as 'Name', salary * 12 as "Annual Salary(연봉)"	
from employees; 						-- 띄어쓰기 있으므로 "" 필수!

-- 문제9) EMPLOYEES 테이블에서 이름과 업무를 연결하여 출력하여라.
select concat(first_name, '  ', last_name,' / ', job_id) as "이름 / 업무"
from employees;

-- 문제10) EMPLOYEES 테이블에서 이름과 업무를 "KING is a PRESIDENT" 형식으로 출력하여라. 
select concat(first_name, 'is a' , job_id) as "이름 / 업무"
from employees;

-- 문제11) EMPLOYEES 테이블에서 이름과 연봉을 "KING: 1 Year salary = 60000" 형식으로 출력하여라.
select concat(first_name, ': 1 Year salary = ', salary * 12) as 연봉
from employees;


create table tb_date(
	col1 timestamp
);

insert into tb_date(col1)
values(now());

-- 연도, 월, 일, 시, 분, 초 만 각각 나오도록 설정
select * 
from tb_date;
select date_format(col1, "%Y"),
	date_format(col1, "%c"),
    date_format(col1, "%e"),
    date_format(col1, "%k"),
    date_format(col1, "%i"),
    date_format(col1, "%s")
    from tb_date;
~~~



> **다양한 시간 format 형태**

Format  형태  | 설명
--- | ---
%M | Month 월(Janeary, February ...)
%m | Month 월(01, 02, 03 ...)
%W | Day of Week 요일(Sunday, Monday ...)
%D | Month 월(1st, 2dn, 3rd ...)
%Y | Year 연도(1999, 2000, 2020)
%y | Year 연도(99, 00, 20)
%X | Year 연도(1999, 2000, 2020) %V와 같이쓰임
%x | Year 연도(1999, 2000, 2020) %v와 같이쓰임
%a | Day of Week요일(Sun, Mon, Tue ...)
%d | Day 일(00, 01, 02 ...)
%e | Day 일(0, 1, 2 ..)
%c | Month(1, 2, 3 ..)
%b | Month(Jen Feb ...)
%j | n번째 일(100, 365)
%H | Hour 시(00, 01, 24) 24시간 형태 
%h | Hour 시(01, 02, 12) 12시간 형태
%I (대문자 아이) | Hour 시(01, 02 12) 12시간 형태
%l (소문자 엘) | Hour 시(1, 2, 12) 12 시간 형태
%i | Minute 분(00, 01 59)
%r | hh
%T | hh
%S, %s | Second 초
%p | AP, PM
%w | Day Of Week (0, 1, 2) 0부터 일요일
%U | Week 주(시작
%u | Week 주(시작 월요일)
%V | Week 주(시작
%v | Week 주(시작



# 2. ORDER BY

>  😎 ORDER BY절은 select문과 함께 사용하며 결과 집합을 특정 열이나 열들의 값에 따라 정렬하는 데 사용한다.



~~~mysql
SELECT FIELD('A', 'A', 'B', 'C');
~~~

> ```
> 실행결과 1 >> 첫 번째 인자와 같은 문자의 위치를 출력
> ```



## NULL 값 정렬

- null값이 있는 컬럼에 대한 정렬

  - 오름차순 시 NULL 처음으로(DEFAULT)

  ~~~mysql
  SELECT 
      category_code,
      category_name,
      ref_category_code
  FROM
      tbl_category
  ORDER BY 
  --     ref_category_code ASC;
      ref_category_code;    -- ASC 생략 가능
  ~~~
