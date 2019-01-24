-- �⺻

-- 1. ����� 133�� ����� ��ü �̸�
select first_name || ' ' || last_name
  from employees
  where employee_id = 133;
  
-- 2. ��ü������ ���� ������ ��ȸ
--    ����� �̸�, �Ի��� �����̰� "�̸�", "�Ի���"�� �÷� �̸��� ��ü
select first_name �̸�, hire_date �Ի���
  from employees;
  
-- 3. Ŀ�̼��� �޴� �ο�
select count(*)
  from employees
  where commission_pct is not null;

-- 4. ���� �ٹ��ϰ� �ִ� ���� ��
select count(*)
 from employees;

-- 5. �μ��� �� �� ��
select count(distinct department_id)
  from departments
  where department_id is not null;

-- 6.�μ� ���̵� 60�� �ο�
select count(*)
  from employees
  where department_id = 60;

-- 7. ��ü �μ��� ���, ������ �μ��̸��� �� ������� ���
select distinct department_name
  from departments
  order by length(department_name) desc;

-- 8. ���� �޿��� 3000�̻� �޴� ����� ��
select count(*)
  from employees
  where salary >= 3000;

-- 9. ��å �ߺ����� �̸��� �� ������� ���
select distinct job_title
  from jobs
  order by length(job_title) desc;

-- 10. ���� Marketing Manager ��å�� ��� ��
select count(*)
  from employees e inner join jobs j on e.job_id = j.job_id
  where j.job_title = 'Marketing Manager';

-- 11. ����� 126�� ������ ������� �ٹ��� ����
select trunc(MONTHS_BETWEEN(SYSDATE, hire_date), 0) || '����' "�ٹ� ����"
  from employees
  where employee_id = 126;
--------------------------------------------------------------------------
-- ����

-- 1. �ְ��ӱݰ� �����ӱ��� "�ְ��ӱ�", "�����ӱ�" �������� Ÿ��Ʋ�� �Բ� ���
--    �� �ӱ��� ���� ���
select max(salary) �ְ��ӱ�, min(salary) �����ӱ�, (max(salary) - min(salary)) "�ְ��ӱ� - �����ӱ�"
  from employees;

-- 2. ���������� ���Ի���� ���� ���� ���� �Դϱ�? ���� �������� ������ּ��� - 0000�� 00�� 00��
select to_char(max(hire_date), 'yyyy') || '�� ' || to_char(max(hire_date), 'mm') || '�� ' || to_char(max(hire_date), 'dd') || '��'
  from employees;

-- 3. ���� ���� �ټ��� ������ �Ի����� ���� �Դϱ�?
select to_char(min(hire_date), 'yyyy') || '�� ' || to_char(min(hire_date), 'mm') || '�� ' || to_char(min(hire_date), 'dd') || '��'
  from employees;

-- 4. ���� �� ȸ���� ��� ����
select round(avg(salary), 2)
  from employees;

-- 5. ���� �� ȸ���� �ְ�/���� ����
select max(salary), min(salary)
  from employees;

--6. �ְ� �ټ� ������ ���� �ټ� ������ �ټ� ����
select trunc(MONTHS_BETWEEN(max(hire_date), min(hire_date)), 0) "�ְ� �ټ� - ���� �ټ�"
  from employees;
---------------------------------------------------------------------------
-- ����

-- 1. ���� �޿��� ���� �������� ������ ���, �̸�, �׸��� ������ ���
select employee_id ���, first_name || ' ' || last_name �̸�, salary*12 ����
  from employees
  order by salary desc;

-- 2. ��ü ����� ���, �̸�, ���� ��å�� �̸� ������ ���
select e.employee_id ���, e.first_name || ' ' || e.last_name �̸�, j.job_title ��å
  from employees e inner join jobs j on e.job_id = j.job_id
  order by e.first_name || ' ' || e.last_name asc;

-- 3. ��ü ����� ���, �̸� ���� �μ��� �̸� ������ ���
select e.employee_id ���, e.first_name || ' ' || e.last_name �̸�, d.department_name �μ�
  from employees e inner join departments d on e.department_id = d.department_id
  order by e.first_name || ' ' || e.last_name asc;

-- 4. ��ü ����� ���, �̸�, ����, ��å, �μ��� ��� �̸� ������ ���
select  e.employee_id ���, 
        e.first_name || ' ' || e.last_name �̸�, 
        e.salary*12 ����,
        j.job_title ��å,
        d.department_name �μ�
  from employees e inner join jobs j on e.job_id = j.job_id
                   inner join departments d on e.department_id = d.department_id
  order by e.first_name || ' ' || e.last_name asc;

-- 5. ���� �̸�(last_name) �߿��� S(�빮��)�� �����ϴ� �������� �̸�, �μ���, ��å�� ��ȸ
select  e.first_name || ' ' || e.last_name �̸�, 
        d.department_name �μ�,
        j.job_title ��å
  from employees e inner join jobs j on e.job_id = j.job_id
                   inner join departments d on e.department_id = d.department_id
  where e.last_name like 'S%';

-- 6. ���� ��å�� Stock Clerk�� ��� �߿��� ���� �޿��� 2500 �̻��� ����� �޿��� ū ������� ���
select e.*
  from employees e inner join jobs j on e.job_id = j.job_id
  where j.job_title = 'Stock Clerk'
  order by salary desc;

-- 7. ���� �޿��� 8000�� �Ѵ� ��å�� ��å, �޿��� �޿��� ū ������� ���
select j.job_title ��å, e.salary �޿�
  from employees e inner join jobs j on e.job_id = j.job_id
  where salary > 8000
  order by salary desc;
  
-- 8. ���� �μ��� ��� ������ ������ ū �μ� ������� ���
select d.department_name �μ���, round(avg(e.salary), 2) "��� ����"
  from employees e inner join departments d on e.department_id = d.department_id
  group by d.department_name
  order by avg(e.salary) desc;

-- 9. ���� ��å�� ��� ������ ������ ū ��å ������� ���
select j.job_title ��å, round(avg(e.salary), 2) "��� ����"
  from employees e inner join jobs j on e.job_id = j.job_id
  group by j.job_title
  order by avg(e.salary) desc;
---------------------------------------------------------------------------------
-- ��������

-- 1. ���� ��� �������� ���� ������ �޴� ������ ��
select count(*)
  from employees
  where salary > (select avg(salary)
                    from employees);

-- 2. ���� �� �μ����� �ְ��� �޿��� �޴� ����� ���, �̸�, �μ� ������ ��ȸ
--    ��, ��ȸ ����� ������ ������������ ���ĵǾ� ��Ÿ���� �մϴ�
select e.employee_id ���, 
       e.first_name || ' ' || e.last_name �̸�,
       d.department_name �μ�,
       e.salary * 12 ����
  from employees e inner join departments d on e.department_id = d.department_id
  where (e.department_id, e.salary) in (select department_id, max(salary)
                                          from employees
                                          group by department_id
                                      )
  order by e.salary desc;

-- 3. ���� �ڽ��� �μ� ��� �޿����� ������ ���� ����� ���, �̸��� ������ ��ȸ
select e.employee_id ���, 
       e.first_name || ' ' || e.last_name �̸�,
       e.salary * 12 ����
  from employees e
  where e.salary > (select avg(salary)
                      from employees
                      where department_id = e.department_id
                      group by department_id
                   );

-- 4. ���� ������� ���, �̸�, �Ŵ��� �̸�, �μ� �̸����� ���
select e.employee_id ���, 
       e.first_name || ' ' || e.last_name �̸�,
       (select first_name || ' ' || last_name
          from employees
          where employee_id = e.manager_id
       ) "�Ŵ��� �̸�",
       (select department_name
          from departments
          where department_id = e.department_id
       ) "�μ� �̸�"
  from employees e;

-- 5. ���� ��տ����� ���� ���� �μ��� ������� ���, �̸�, ��å, ������ ��ȸ�ϰ� ���������� ���
select e.employee_id ���, 
       e.first_name || ' ' || e.last_name �̸�,
       j.job_title ��å,
       salary * 12 ����
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

-- 6. ��� ������ ���� ���� �μ�
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

-- 7. ��� ������ ���� ���� ��å
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

-- 8. ���� �ڽ��� �Ŵ������� ���� ������ �ް� �ִ� ������?
--    �μ��̸�, ����̸�, ����, �Ŵ��� �̸�, �Ŵ��� ���� ������ ���
select d.department_name "�μ� �̸�",
       e.first_name || ' ' || e.last_name �̸�,
       e.salary * 12 ����,
       m.first_name || ' ' || m.last_name "�Ŵ��� �̸�",
       m.salary * 12 "�Ŵ��� ����"
  from employees e inner join departments d on e.department_id = d.department_id
                   inner join employees m on e.manager_id = m.employee_id
  where e.salary > m.salary;