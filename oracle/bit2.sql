SELECT
    *
FROM
    employees;

DESC employees;

CREATE TABLE t_board (
    no      NUMBER(6) NOT NULL,
    title   VARCHAR2(40)
);

DESC t_board;

INSERT INTO t_board ( title )  -- not null 에러

 VALUES ( '제목' );

SELECT
    salary || '달러' AS 월급,
    salary + 1000 || '원' AS 보너스
FROM
    employees;

-- 7100원

SELECT
    7100 || '원'
FROM
    dual;

desc employees;
-- employees 테이블에서
--   king 사원의 사원번호는 100번이고 월급은 24000원이다
--   Kochhar 사원의 사원번호는 101번이고 월급은 17000원이다
--   ...
SELECT last_name || '사원의 사원번호는 ' || employee_id || '이고 월급은 ' || salary || '원이다' as info
  from employees;
  
-- WHERE 조건절
-- employees 테이블에서 salary가 10000이상인 사원들의 목록 조회
SELECT *
  FROM employees
  WHERE salary >= 10000;

-- employees 테이블에서 salary가 10000이상이거나
-- 부서번호가 90번에 소속된 사원들 목록 조회
SELECT e.salary, e.department_id
  FROM employees e
  WHERE salary >= 10000
     or department_id =90;

-- 부서번호가 90, 100, 101번인 사원정보를 조회
SELECT *
  FROM employees
  WHERE department_id = 90 
     or department_id = 100
     or department_id = 101;

-- IN 연산자
--    : 입력 데이터가 포함된 조건
SELECT *
  FROM employees
  WHERE department_id IN (90, 100, 101);

-- LIKE 연산자
--   % : 여러개의 문자열
--   _ : 하나의 문자

-- 사원이름 중 S로 시작되는 사원목록 조회
SELECT *
  FROM employees
  WHERE first_name LIKE 'S%';

-- 사원이름 중 s로 시작하는 이름이 5글자인 사원 목록
SELECT *
  FROM employees
  WHERE first_name LIKE 'S____';

-- 사원이름 중 두번째 문자가 a인 사원 목록 조회
SELECT *
  FROM employees
  WHERE first_name LIKE '_a%';

-- 사원 중 이름에 A(a)가 있는 사원 목록 조회
SELECT *
  FROM employees
  WHERE first_name LIKE '%a%' 
     or first_name LIKE '%A%';

-- commission_pct가 없는 사원정보 조회
SELECT e.commission_pct, e.*
  FROM employees e
  WHERE commission_pct IS NULL;

-- commission_pct와 salary에 commission_pct를 곱한 값을 조회
SELECT last_name, salary, commission_pct, salary * commission_pct 보너스
  FROM employees;

-- NVL() 함수를 통한 NULL값 처리
--   commission_pct가 NULL이라면 0으로 대체
SELECT last_name, salary, NVL(commission_pct, 0), salary * NVL(commission_pct, 0) 보너스
  FROM employees;

-- NVL() 함수를 활용한 문자데이터 대체
--   manager_id가 NULL이라면 관리자없음 대체
--   AS를 활용 시 공백은 " " 묶어라
SELECT last_name, NVL(TO_CHAR(manager_id), '관리자없음') "관리자 ID"
  FROM employees;

SELECT *
  FROM employees
  WHERE department_id != 90
    and department_id ^= 100
    and department_id <> 101;

-- 위 쿼리의 결과와 같도록 OR연산자를 활용하여 조회
SELECT *
  FROM employees
  WHERE NOT(department_id = 90 or department_id = 100 or department_id = 101);

-- ORDER BY (정렬)
--   ASC : 오름차순 (default)
--   DESC : 내림차순

-- 급여가 많은 사원 순으로 목록 조회
SELECT e.salary, e.*
  FROM employees e
  ORDER BY e.salary DESC;

SELECT e.salary, e.*
  FROM employees e
  ORDER BY e.salary ASC;

-- 급여가 많은 사원순으로 조회하되, 급여가 동일한 경우 last_name을 사전순으로 정렬
SELECT e.salary, e.last_name, e.*
  FROM employees e
  ORDER BY e.salary DESC, e.last_name;

-- TO_CHAR(날짜, '포멧문자')
--   : y(년), m(월), d(일), h(시), mi(분), s(초)
-- TO_CHAR(정수, '포멧문자')
--   : 9(자리수)
--     0(비어있는 자리 0 대체)
--     ,(액수 표현 시 3자리씩 구분)

select e.hire_date, e.*
  from employees e
  where to_char(e.hire_date, 'yyyymmdd') = '20030617';

-- 입사년도가 2005, 2006, 2007년인 사원 목록 조회
select e.hire_date, e.*
  from employees e
  where to_char(e.hire_date, 'yyyy') in ('2005', '2006', '2007')
  order by e.hire_date;

select e.hire_date, e.*
  from employees e
  where e.hire_date between '20050101' and '20071231'
  order by e.hire_date;

CREATE TABLE t_cal(
    year NUMBER(4)
);

insert into t_cal values(2005);
insert into t_cal values(2006);
insert into t_cal values(2007);
desc t_cal;
select year from t_cal; -- t_cal의 조회 결과를 조건으로

select *
  from employees
  where to_char(hire_date, 'yyyy')
     in (select year from t_cal)
  order by hire_date;

-- CRUD : 소프트웨어의 기본 처리 기능
--  INSERT / Create  생성
--  SELECT / Read    읽기
--  UPDATE / Update  갱신
--  DELETE / Delete  삭제

-- 입사년도가 2005, 2006, 2007이면서.
-- 부서번호가 80인 사원 조회
select e.hire_date, e.department_id, e.*
  from employees e
  where to_char(e.hire_date, 'yyyy') in (2005, 2006, 2007)
    and e.department_id = 80;

-- DUAL
--   연산 결과만 출력할때 사용하는 테이블
SELECT 3+4 FROM DUAL;

-- SUBSTR
--   문자 자르기
select SUBSTR('2019년 01월 23일',1,5) from dual;

-- LENGTH : 문자 길이 반환
-- TRIM : 양옆 공백 제거
SELECT LENGTH('12345') FROM dual;
select TRIM('                ddd     ') from dual;

-- REPLACE
select replace('abc', 'a', 'd') from dual;

-- INSTR : 특정 문자의 위치를 반환 (한글 1byte)
-- INSTRB : 특정 문자의 위치를 반환 (한글 2byte)
select INSTR('가나다라마바사', '다') 결과 from dual;
select INSTR('ABCDEFG', 'C') 결과 from dual;
select INSTRB('가나다라마바사', '다') 결과 from dual;
select INSTRB('ABCDEFG', 'C') 결과 from dual;

-- LOWER, UPPER
select LOWER('Hello SQL') 결과 from dual;
select UPPER('Hello SQL') 결과 from dual;

-- INITCAP : 단어의 첫 글자를 대문자로 변환
select INITCAP('hello world') 결과 from dual;

-- LPAD, RPAD
select LPAD('oh', 5, '*') from dual;
select RPAD('yes', 7, '@') from dual;

-- ROUND : 특정 자릿수에서 반올림
select ROUND(123.4567, 2) from dual;

-- ABS : 절대값
select ABS(-3) from dual;

-- POWER : 특정 숫자의 제곱을 반환
select POWER(3, 4) from dual;

-- COS, SIN, TAN
select COS(1), SIN(1), TAN(1) from dual;

-- TRUNC : 해당 자릿수에서 자르기 (음수 소수점)
select TRUNC(123.4567, -1) from dual;

-- MOD : 입력받은 수를 나눈 나머지
select MOD(5,3) from dual;

-- TO_NUMBER
select TO_NUMBER('123')+100 결과 from dual;

-- TO_CHAR
select TO_CHAR(sysdate, 'mm') 월
       , TO_CHAR(LAST_DAY(sysdate), 'dd') "마지막 날"
  from dual;

select ADD_MONTHS(sysdate, 3) from dual;

-- NEXT_DAY : 특정 날짜로부터 다음 요일의 날짜를 반환
-- TO_DATE : 날짜 데이터로 변환
select NEXT_DAY(TO_DATE('20190123', 'yyyymmdd'), '월요일') from dual;

-- MONTHS_BETWEEN : 두 날짜 사이의 개월 수 반환
--   인자1을 기준으로 인자2로부터의 개월 수
select MONTHS_BETWEEN(
         TO_DATE('20180101', 'yyyymmdd'),
         TO_DATE('20190123', 'yyyymmdd'))
  from dual;
  
-- employees 테이블에서 각 직원이 근무한 개월 수를 조회
select trunc(months_between(sysdate, e.hire_date), 0)||'월' 근무개월, e.*
  from employees e
  order by months_between(sysdate, e.hire_date) desc;
  
-- COUNT
select COUNT(*) 총사원수 from employees;
select count(distinct(job_id)) from employees;

-- 부서번호가 80인 사원 수를 조회
select count(*)
  from employees
  where department_id = 80;
  
-- MAX, MIN, AVG
select MAX(salary) 최고급여, MIN(salary) 최저급여, ROUND(AVG(salary), 2) 평균급여
  from employees;

-- salary가 20000이상인 경우  '고액연봉자'
--          10000~20000    '보통연봉자'
--          10000미만인 경우 '노예'
-- CASE WHEN ~ THEN ~ ELSE END
select last_name, salary,
       CASE WHEN salary >= 20000 THEN '귀족'
            WHEN salary >= 10000 THEN '평민'
            ELSE '노예'
            END salary_type
  from employees;

-- SEQUENCE (시퀀스)
--   1. UNIQUE(유일성)한 값을 생성
--   2. 순차적으로 증가하는 값을 생성
create sequence seq_01;

select seq_01.nextval from dual; -- 다음값
select seq_01.currval from dual; -- 현재값

-- 시퀀스 넘버의 시작 값 설정
create sequence seq_02
  start with 2018000000;
select seq_02.nextval from dual;
select seq_02.currval from dual;

-- 시퀀스 넘버 증가 값 설정
create sequence seq_03
  start with 2018000001
  increment by 5;
select seq_03.nextval from dual;
select seq_03.currval from dual;

alter sequence seq_03
  increment by 2;
select seq_03.nextval from dual;

-- employees에서 상위 10개의 데이터 조회
-- ROWNUM
select *
  from employees
  where ROWNUM <= 10;

-- Primary Key(PK) : 기본 키
--   테이블을 유일하게 식별하기 위한 키
--   1. 중복을 허용하지 않는다. (UNIQUE)
--   2. NULL을 허용하지 않는다.

-- Foreign Key(FK) : 외래 키
--   다른 테이블의 기본 키를 참조하기 위한 키

-- GROUP BY
--   : 테이블의 내용 중 원하는 데이터로 그룹을 지어준다
--     부서별 평균급여, 직책별 평균급여...

-- 소속 부서별 평균 급여
SELECT department_id, ROUND(AVG(salary), 2)
  FROM employees
  GROUP BY department_id;

-- 수행 순서 : WHERE -> SELECT -> ORDER BY
SELECT *
  FROM employees
  WHERE ROWNUM <= 20
  ORDER BY salary DESC;

-- 소속 부서별 평균 급여가 5000 이상인 데이터 조회
-- HAVING : 그룹함수를 적용해서 나온 결과값들 중 원하는 조건에 따라 추출
SELECT department_id, round(avg(salary), 0) "평균 급여"
  FROM employees
  GROUP BY department_id
  HAVING avg(salary) >= 5000
  ORDER BY avg(salary) desc;

-- 평균 급여가 5000이상인, 부서별의 "최대급여"와 "최소급여"를 조회
select department_id, MAX(salary) "최대급여", MIN(salary) "최소급여"
  from employees
  group by department_id
  having avg(salary) >= 5000;
  
-- 부서번호를 가지고 부서별 사원 수가 5명 이상인 부서를 조회하되,
-- 부서번호를 오름차순으로 조회
select department_id, count(*) 사원수
  from employees
  where department_id is not null
  group by department_id
  having count(department_id) >= 5
  order by department_id asc;

-- 부서별로 사원 수와 커미션을 받는 사원 수를 조회
select department_id, count(*) "사원 수", count(commission_pct) "커미션 받는 사원 수"
  from employees
  group by department_id
  order by department_id asc;
  
-- JOIN
--   : 두 테이블을 결합하여 원하는 데이터를 조회
--   예를 들어, employees 테이블의 Steven 직원의 부서 번호는 알아도
--            부서 이름은 알 수 없다. 부서 이름은 다른 테이블에 존재!
--            employees 테이블과 departments 테이블의 공통 부분을 활용
select e.last_name, d.department_name
  from employees e, departments d
  where e.department_id = d.department_id;
  
select *
  from employees e, departments d
  where e.department_id = d.department_id
    and e.first_name = 'Steven';

-- Cross Join
--   컬럼수 : employees의 컬럼 수 + departments의 컬럼 수
--   로우수 : employees의 데이터 하나에 대해서 departments 테이블의 로우와 결합 (107 * 27 = 2889의 행 조회)
select *
  from employees e, departments d;
  --ANSI
select *
  from employees cross join departments;

-- Equi Join
--   : 두 테이블의 공통 컬럼의 값이 일치되는 조건
select *
  from employees e, departments d
  where e.department_id = d.department_id;
  --ANSI
select *
  from employees e inner join departments d on e.department_id = d.department_id;;

-- 이름이 Steven인 직원의 전체 이름 직책과 급여를 조회
-- CONCAT : 문자열을 합치는 함수
select concat(e.first_name, ' ' || e.last_name) 이름,  j.job_title 직책, salary 급여
  from employees e, jobs j
  where e.job_id = j.job_id
    and e.first_name = 'Steven';
  --ANSI
select concat(e.first_name, ' ' || e.last_name) 이름,  j.job_title 직책, salary 급여
  from employees e inner join jobs j
    on e.job_id = j.job_id
  where e.first_name = 'Steven';

-- USING
--   : 공통 컬럼의 동등 조건을 부여할 때
select *
  from employees e inner join departments d
  using (department_id)
  where e.first_name = 'Steven';

-- Natural Join
--   : 조건 절을 생략하고, 자동으로 공통 컬럼을 찾아 조인
select *
  from employees e natural join departments d;

-- IT 부서에 소속된 직원의 이름과 입사일, 급여를 조회
select e.first_name || ' ' || e.last_name 이름, e.hire_date 입사일, e.salary 급여
  from employees e, departments d
  where e.department_id = d.department_id
    and d.department_name = 'IT';

-- 직책이 프로그래머인 직원의 최대 급여, 최소 급여, 평균 급여 조회
select max(e.salary) "최대 급여", min(e.salary) "최소 급여", avg(e.salary) "평균 급여"
  from employees e, jobs j
  where e.job_id = j.job_id
  group by j.job_title
  having j.job_title = 'Programmer';


-- Self Join
--   : 하나의 테이블 내에서 조인
-- 각 직원의 매니저를 조회
select e.employee_id 사번,
       e.first_name || ' ' || e.last_name 직원,
       ee.employee_id 사번,
       ee.first_name || ' ' || ee.last_name 매니저
  from employees e, employees ee
  where e.manager_id = ee.employee_id;

-- 매니저가 Steven King인 직원들의 전체 이름과 급여
select e.first_name || ' ' || e.last_name 직원,
       e.salary 급여
  from employees e, employees ee
  where e.manager_id = ee.employee_id
    and ee.first_name || ' ' || ee.last_name = 'Steven King';

-- Steven Markle과 같은 부서에서 일하는 직원의 전체 이름을 조회
select ee.first_name || ' ' || ee.last_name "Steven Markle 직장동료"
  from employees e, employees ee
  where e.department_id = ee.department_id
    and e.first_name || ' ' || e.last_name = 'Steven Markle'
    and ee.first_name || ' ' || ee.last_name != 'Steven Markle';

-- Outer Join
--  : 동등 조건으로 나온 교집합 뿐만 아닌 제외된 데이터까지 표현
select e.employee_id 사번,
       e.first_name || ' ' || e.last_name 직원,
       ee.employee_id 사번,
       ee.first_name || ' ' || ee.last_name 매니저
  from employees e, employees ee
  where e.manager_id = ee.employee_id(+);
  --ANSI
select e.employee_id 사번,
       e.first_name || ' ' || e.last_name 직원,
       ee.employee_id 사번,
       ee.first_name || ' ' || ee.last_name 매니저
  from employees e left outer join employees ee
    on e.manager_id = ee.employee_id;

-- employees와 departments를 조인하여 직원 이름과 부서 번호, 부서 명을 조회
select e.first_name || ' ' || e.last_name 이름,
       e.department_id "부서 번호",
       d.department_name "부서 명"
  from employees e, departments d
  where e.department_id(+) = d.department_id;
  
-- 서브쿼리
--   : 하나의 조회 결과를 가지고, 새로운 조회 결과를 검색

-- 급여가 높은 순서대로 20명의 사원 정보 조회
select *
  from (select *
          from employees
          order by salary desc
        )
  where rownum <= 20;

-- Steven King과 같은 부서에서 일하는 직원의 전체 이름, 부서 번호를 조회
select e.first_name || ' ' || e.last_name "직원 이름",
       e.department_id "부서 번호"
  from employees e
  where e.department_id = (select ee.department_id
                             from employees ee
                             where ee.first_name || ' ' || ee.last_name = 'Steven King')
    and e.first_name || ' ' || e.last_name != 'Steven King';
    
-- Alexander Hunold과 동일한 직책을 가진 직원을 조회
select first_name || ' ' || last_name 이름, job_id
  from employees
  where job_id = (select job_id
                      from employees
                      where first_name || ' ' || last_name = 'Alexander Hunold'
                    )
    and first_name || ' ' || last_name != 'Alexander Hunold';

-- Oliver Tuvault의 급여와 같거나 더 많은 사원의 목록을 조회
select first_name || ' ' || last_name 이름, salary 급여
  from employees
  where salary >= ( select salary
                      from employees
                      where first_name || ' ' || last_name = 'Oliver Tuvault'
                  )
    and first_name || ' ' || last_name != 'Oliver Tuvault'
  order by salary desc;

-- 직업이 Programmer인 사람의 전체 이름, 부서 번호, 급여를 조회
select first_name || ' ' || last_name 이름,
       department_id "부서 번호",
       salary 급여
  from employees
  where job_id = (select job_id
                    from jobs 
                    where job_title = 'Programmer'
                 );

-- 평균 급여보다 많이 받는 직원의 전체 이름과 급여를 조회
select first_name || ' ' || last_name 이름,
       salary 급여
  from employees
  where salary > (select avg(salary)
                    from employees
                 )
  order by salary desc;

-- 급여가 13000 이상인 직원이 속한 부서의 번호를 조회
select distinct department_id
  from employees
  where salary >= 13000;

-- 급여가 13000 이상인 직원이 속한 부서와
-- 동일한 부서의 직원들의 정보(이름, 부서번호, 급여)
select first_name || ' ' || last_name 이름,
       department_id 부서번호,
       salary
  from employees
  where department_id in (select distinct department_id
                            from employees
                            where salary >= 13000
                          );

-- 부서별로 가장 높은 급여를 받는 직원의 사번, 이름, 급여, 부서번호 조회
select employee_id 사번,
       first_name || ' ' || last_name 이름,
       salary 급여,
       department_id 부서번호
  from employees
  where (department_id, salary) in (select department_id, max(salary)
                                      from employees
                                      group by department_id
                                    )
  order by department_id asc;

-- 다중 행 쿼리
-- WHERE 절에 사용되는 다중 행 쿼리 연산자
--   IN        : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중 하나라도 일치
--   ANY, SOME : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중 하나 이상 일치 
--   ALL       : 메인 쿼리의 비교 조건이 서브 쿼리의 결과 중 모두 일치
--   EXISTS    : 메인 쿼리의 비교 조건이 서브 쿼리의 결과에 하나라도 만족

-- IT PROG들 보다 급여를 많이 받는 직원들의 정보 조회
-- 단, IT_PROG들의 정보는 제외
select *
  from employees
  where salary > all(select salary
                      from employees
                      where job_id = 'IT_PROG'
                    );

-- 부서 번호가 80번인 직원의 최저 급여 보다 많은 급여를 받는 직원 정보
select *
  from employees
  where salary > any(select salary
                      from employees
                      where department_id = 80
                    );

-- Transaction (트랜잭션)
--   : 데이터 처리의 단위
-- ACID
--   : 데이터베이스 트랜잭션이 안전하게 수행되는 것을 보장

--     Atomicity (원자성)
--       : 트랜잭션과 관련된 작업이 실행 중 중단되지 않는다는 것을 보장
--       - 계좌이체를 할 때, 내 계좌 출금 -> 상대 계좌 입금 수행
--         내 계좌에서 출금된 후에 작업이 중단된다면?
--     Consistency (일관성)
--       : 트랜잭션 수행이 완료되면, 변하지 않는 데이터베이스의 성질을 보장
--       - 계좌는 잔고를 무조건 가지고 있어야되는 성질
--         계좌에 대한 어떠한 작업을 수행하던 잔고라는 성질은 유지
--     Isolation (독립성)
--       : 트랜잭션 수행 시 다른 트랜잭션이 끼어들지 않는다는 것을 보장
--       - 계좌이체 시 출금 -> 입금을 하나의 단위로 수행하는 중,
--         출금만 이루어지고, 조회를 하는 트랜잭션이 수행될 수 없다
--     Durability (지속성)
--       : 트랜잭션 수행이 완료되면, 수행한 트랜잭션은 영원히 반영된다는 것을 보장
--       - 계좌이체 시 변경된 잔고에 대한 데이터는 변하지 않아야 한다

-- COMMIT
--   1. 트랜잭션 작업 내용을 실제 Database에 저장
--   2. 과거 데이터가 완전히 UPDATE
--   3. 실제 Database에 적용이 되었기에, 모든 유저가 결과를 확인
-- ROLLBACK
--   1. 트랜잭션 작업 내용을 되돌린다
--   2. 복구 시점은 이전 COMMIT된 부분

-- ROLLBACK 테스트
drop table t_table;

create table t_table
as select * from t_cal;

select * from t_table;

delete from t_table;

select * from t_table;

commit;

rollback;