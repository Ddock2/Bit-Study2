-- 기본

-- 1. 사번이 133인 사원의 전체 이름
select first_name || ' ' || last_name
  from employees
  where employee_id = 133;
  
-- 2. 전체직원의 다음 정보를 조회
--    출력은 이름, 입사일 순서이고 "이름", "입사일"로 컬럼 이름을 대체
select first_name 이름, hire_date 입사일
  from employees;
  
-- 3. 커미션을 받는 인원
select count(*)
  from employees
  where commission_pct is not null;

-- 4. 현재 근무하고 있는 직원 수
select count(*)
 from employees;

-- 5. 부서는 총 몇 개
select count(distinct department_id)
  from departments
  where department_id is not null;

-- 6.부서 아이디가 60인 인원
select count(*)
  from employees
  where department_id = 60;

-- 7. 전체 부서를 출력, 순서는 부서이름이 긴 순서대로 출력
select distinct department_name
  from departments
  order by length(department_name) desc;

-- 8. 현재 급여가 3000이상 받는 사원의 수
select count(*)
  from employees
  where salary >= 3000;

-- 9. 직책 중복없이 이름이 긴 순서대로 출력
select distinct job_title
  from jobs
  order by length(job_title) desc;

-- 10. 현재 Marketing Manager 직책의 사원 수
select count(*)
  from employees e inner join jobs j on e.job_id = j.job_id
  where j.job_title = 'Marketing Manager';

-- 11. 사번이 126인 직원의 현재까지 근무한 개월
select trunc(MONTHS_BETWEEN(SYSDATE, hire_date), 0) || '개월' "근무 개월"
  from employees
  where employee_id = 126;
--------------------------------------------------------------------------
-- 집계

-- 1. 최고임금과 최저임금을 "최고임금", "최저임금" 프로젝션 타이틀로 함께 출력
--    두 임금의 차이 출력
select max(salary) 최고임금, min(salary) 최저임금, (max(salary) - min(salary)) "최고임금 - 최저임금"
  from employees;

-- 2. 마지막으로 신입사원이 들어온 날은 언제 입니까? 다음 형식으로 출력해주세요 - 0000년 00월 00일
select to_char(max(hire_date), 'yyyy') || '년 ' || to_char(max(hire_date), 'mm') || '월 ' || to_char(max(hire_date), 'dd') || '일'
  from employees;

-- 3. 가장 오래 근속한 직원의 입사일은 언제 입니까?
select to_char(min(hire_date), 'yyyy') || '년 ' || to_char(min(hire_date), 'mm') || '월 ' || to_char(min(hire_date), 'dd') || '일'
  from employees;

-- 4. 현재 이 회사의 평균 연봉
select round(avg(salary), 2)
  from employees;

-- 5. 현재 이 회사의 최고/최저 연봉
select max(salary), min(salary)
  from employees;

--6. 최고 근속 직원과 최저 근속 직원의 근속 차이
select trunc(MONTHS_BETWEEN(max(hire_date), min(hire_date)), 0) "최고 근속 - 최저 근속"
  from employees;
---------------------------------------------------------------------------
-- 조인

-- 1. 현재 급여가 많은 직원부터 직원의 사번, 이름, 그리고 연봉을 출력
select employee_id 사번, first_name || ' ' || last_name 이름, salary*12 연봉
  from employees
  order by salary desc;

-- 2. 전체 사원의 사번, 이름, 현재 직책을 이름 순서로 출력
select e.employee_id 사번, e.first_name || ' ' || e.last_name 이름, j.job_title 직책
  from employees e inner join jobs j on e.job_id = j.job_id
  order by e.first_name || ' ' || e.last_name asc;

-- 3. 전체 사원의 사번, 이름 현재 부서를 이름 순서로 출력
select e.employee_id 사번, e.first_name || ' ' || e.last_name 이름, d.department_name 부서
  from employees e inner join departments d on e.department_id = d.department_id
  order by e.first_name || ' ' || e.last_name asc;

-- 4. 전체 사원의 사번, 이름, 연봉, 직책, 부서를 모두 이름 순서로 출력
select  e.employee_id 사번, 
        e.first_name || ' ' || e.last_name 이름, 
        e.salary*12 연봉,
        j.job_title 직책,
        d.department_name 부서
  from employees e inner join jobs j on e.job_id = j.job_id
                   inner join departments d on e.department_id = d.department_id
  order by e.first_name || ' ' || e.last_name asc;

-- 5. 직원 이름(last_name) 중에서 S(대문자)로 시작하는 직원들의 이름, 부서명, 직책을 조회
select  e.first_name || ' ' || e.last_name 이름, 
        d.department_name 부서,
        j.job_title 직책
  from employees e inner join jobs j on e.job_id = j.job_id
                   inner join departments d on e.department_id = d.department_id
  where e.last_name like 'S%';

-- 6. 현재 직책이 Stock Clerk인 사원 중에서 현재 급여가 2500 이상인 사원을 급여가 큰 순서대로 출력
select e.*
  from employees e inner join jobs j on e.job_id = j.job_id
  where j.job_title = 'Stock Clerk'
  order by salary desc;

-- 7. 현재 급여가 8000이 넘는 직책을 직책, 급여로 급여가 큰 순서대로 출력
select j.job_title 직책, e.salary 급여
  from employees e inner join jobs j on e.job_id = j.job_id
  where salary > 8000
  order by salary desc;
  
-- 8. 현재 부서별 평균 연봉을 연봉이 큰 부서 순서대로 출력
select d.department_name 부서명, round(avg(e.salary), 2) "평균 연봉"
  from employees e inner join departments d on e.department_id = d.department_id
  group by d.department_name
  order by avg(e.salary) desc;

-- 9. 현재 직책별 평균 연봉을 연봉이 큰 직책 순서대로 출력
select j.job_title 직책, round(avg(e.salary), 2) "평균 연봉"
  from employees e inner join jobs j on e.job_id = j.job_id
  group by j.job_title
  order by avg(e.salary) desc;
---------------------------------------------------------------------------------
-- 서브쿼리

-- 1. 현재 평균 연봉보다 많은 월급을 받는 직원의 수
select count(*)
  from employees
  where salary > (select avg(salary)
                    from employees);

-- 2. 현재 각 부서별로 최고의 급여를 받는 사원의 사번, 이름, 부서 연봉을 조회
--    단, 조회 결과는 연봉의 내림차순으로 정렬되어 나타나야 합니다
select e.employee_id 사번, 
       e.first_name || ' ' || e.last_name 이름,
       d.department_name 부서,
       e.salary * 12 연봉
  from employees e inner join departments d on e.department_id = d.department_id
  where (e.department_id, e.salary) in (select department_id, max(salary)
                                          from employees
                                          group by department_id
                                      )
  order by e.salary desc;

-- 3. 현재 자신의 부서 평균 급여보다 연봉이 많은 사원의 사번, 이름과 연봉을 조회
select e.employee_id 사번, 
       e.first_name || ' ' || e.last_name 이름,
       e.salary * 12 연봉
  from employees e
  where e.salary > (select avg(salary)
                      from employees
                      where department_id = e.department_id
                      group by department_id
                   );

-- 4. 현재 사원들의 사번, 이름, 매니저 이름, 부서 이름으로 출력
select e.employee_id 사번, 
       e.first_name || ' ' || e.last_name 이름,
       (select first_name || ' ' || last_name
          from employees
          where employee_id = e.manager_id
       ) "매니저 이름",
       (select department_name
          from departments
          where department_id = e.department_id
       ) "부서 이름"
  from employees e;

-- 5. 현재 평균연봉이 가장 높은 부서의 사원들의 사번, 이름, 직책, 연봉을 조회하고 연봉순으로 출력
select e.employee_id 사번, 
       e.first_name || ' ' || e.last_name 이름,
       j.job_title 직책,
       salary * 12 연봉
  from employees e inner join jobs j on e.job_id = j.job_id 
  where department_id = (select department_id
                           from employees
                           group by department_id
                           having avg(salary) >= all(select avg(salary)
                                                       from employees
                                                       group by department_id
                                                    )
                         )
  order by salary desc;

-- 6. 평균 연봉이 가장 높은 부서
select department_name
  from departments
  where department_id = (select department_id
                           from employees
                           group by department_id
                           having avg(salary) >= all(select avg(salary)
                                                       from employees
                                                       group by department_id
                                                    )
                         );

-- 7. 평균 연봉이 가장 높은 직책
select job_title
  from jobs
  where job_id = (select job_id
                           from employees
                           group by job_id
                           having avg(salary) >= all(select avg(salary)
                                                       from employees
                                                       group by job_id
                                                    )
                         );

-- 8. 현재 자신의 매니저보다 높은 연봉을 받고 있는 지원은?
--    부서이름, 사원이름, 연봉, 매니저 이름, 매니저 연봉 순으로 출력
select d.department_name "부서 이름",
       e.first_name || ' ' || e.last_name 이름,
       e.salary * 12 연봉,
       m.first_name || ' ' || m.last_name "매니저 이름",
       m.salary * 12 "매니저 연봉"
  from employees e inner join departments d on e.department_id = d.department_id
                   inner join employees m on e.manager_id = m.employee_id
  where e.salary > m.salary;