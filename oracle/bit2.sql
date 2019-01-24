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

INSERT INTO t_board ( title )  -- not null ����

 VALUES ( '����' );

SELECT
    salary || '�޷�' AS ����,
    salary + 1000 || '��' AS ���ʽ�
FROM
    employees;

-- 7100��

SELECT
    7100 || '��'
FROM
    dual;

desc employees;
-- employees ���̺���
--   king ����� �����ȣ�� 100���̰� ������ 24000���̴�
--   Kochhar ����� �����ȣ�� 101���̰� ������ 17000���̴�
--   ...
SELECT last_name || '����� �����ȣ�� ' || employee_id || '�̰� ������ ' || salary || '���̴�' as info
  from employees;
  
-- WHERE ������
-- employees ���̺��� salary�� 10000�̻��� ������� ��� ��ȸ
SELECT *
  FROM employees
  WHERE salary >= 10000;

-- employees ���̺��� salary�� 10000�̻��̰ų�
-- �μ���ȣ�� 90���� �Ҽӵ� ����� ��� ��ȸ
SELECT e.salary, e.department_id
  FROM employees e
  WHERE salary >= 10000
     or department_id =90;

-- �μ���ȣ�� 90, 100, 101���� ��������� ��ȸ
SELECT *
  FROM employees
  WHERE department_id = 90 
     or department_id = 100
     or department_id = 101;

-- IN ������
--    : �Է� �����Ͱ� ���Ե� ����
SELECT *
  FROM employees
  WHERE department_id IN (90, 100, 101);

-- LIKE ������
--   % : �������� ���ڿ�
--   _ : �ϳ��� ����

-- ����̸� �� S�� ���۵Ǵ� ������ ��ȸ
SELECT *
  FROM employees
  WHERE first_name LIKE 'S%';

-- ����̸� �� s�� �����ϴ� �̸��� 5������ ��� ���
SELECT *
  FROM employees
  WHERE first_name LIKE 'S____';

-- ����̸� �� �ι�° ���ڰ� a�� ��� ��� ��ȸ
SELECT *
  FROM employees
  WHERE first_name LIKE '_a%';

-- ��� �� �̸��� A(a)�� �ִ� ��� ��� ��ȸ
SELECT *
  FROM employees
  WHERE first_name LIKE '%a%' 
     or first_name LIKE '%A%';

-- commission_pct�� ���� ������� ��ȸ
SELECT e.commission_pct, e.*
  FROM employees e
  WHERE commission_pct IS NULL;

-- commission_pct�� salary�� commission_pct�� ���� ���� ��ȸ
SELECT last_name, salary, commission_pct, salary * commission_pct ���ʽ�
  FROM employees;

-- NVL() �Լ��� ���� NULL�� ó��
--   commission_pct�� NULL�̶�� 0���� ��ü
SELECT last_name, salary, NVL(commission_pct, 0), salary * NVL(commission_pct, 0) ���ʽ�
  FROM employees;

-- NVL() �Լ��� Ȱ���� ���ڵ����� ��ü
--   manager_id�� NULL�̶�� �����ھ��� ��ü
--   AS�� Ȱ�� �� ������ " " �����
SELECT last_name, NVL(TO_CHAR(manager_id), '�����ھ���') "������ ID"
  FROM employees;

SELECT *
  FROM employees
  WHERE department_id != 90
    and department_id ^= 100
    and department_id <> 101;

-- �� ������ ����� ������ OR�����ڸ� Ȱ���Ͽ� ��ȸ
SELECT *
  FROM employees
  WHERE NOT(department_id = 90 or department_id = 100 or department_id = 101);

-- ORDER BY (����)
--   ASC : �������� (default)
--   DESC : ��������

-- �޿��� ���� ��� ������ ��� ��ȸ
SELECT e.salary, e.*
  FROM employees e
  ORDER BY e.salary DESC;

SELECT e.salary, e.*
  FROM employees e
  ORDER BY e.salary ASC;

-- �޿��� ���� ��������� ��ȸ�ϵ�, �޿��� ������ ��� last_name�� ���������� ����
SELECT e.salary, e.last_name, e.*
  FROM employees e
  ORDER BY e.salary DESC, e.last_name;

-- TO_CHAR(��¥, '���乮��')
--   : y(��), m(��), d(��), h(��), mi(��), s(��)
-- TO_CHAR(����, '���乮��')
--   : 9(�ڸ���)
--     0(����ִ� �ڸ� 0 ��ü)
--     ,(�׼� ǥ�� �� 3�ڸ��� ����)

select e.hire_date, e.*
  from employees e
  where to_char(e.hire_date, 'yyyymmdd') = '20030617';

-- �Ի�⵵�� 2005, 2006, 2007���� ��� ��� ��ȸ
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
select year from t_cal; -- t_cal�� ��ȸ ����� ��������

select *
  from employees
  where to_char(hire_date, 'yyyy')
     in (select year from t_cal)
  order by hire_date;

-- CRUD : ����Ʈ������ �⺻ ó�� ���
--  INSERT / Create  ����
--  SELECT / Read    �б�
--  UPDATE / Update  ����
--  DELETE / Delete  ����

-- �Ի�⵵�� 2005, 2006, 2007�̸鼭.
-- �μ���ȣ�� 80�� ��� ��ȸ
select e.hire_date, e.department_id, e.*
  from employees e
  where to_char(e.hire_date, 'yyyy') in (2005, 2006, 2007)
    and e.department_id = 80;

-- DUAL
--   ���� ����� ����Ҷ� ����ϴ� ���̺�
SELECT 3+4 FROM DUAL;

-- SUBSTR
--   ���� �ڸ���
select SUBSTR('2019�� 01�� 23��',1,5) from dual;

-- LENGTH : ���� ���� ��ȯ
-- TRIM : �翷 ���� ����
SELECT LENGTH('12345') FROM dual;
select TRIM('                ddd     ') from dual;

-- REPLACE
select replace('abc', 'a', 'd') from dual;

-- INSTR : Ư�� ������ ��ġ�� ��ȯ (�ѱ� 1byte)
-- INSTRB : Ư�� ������ ��ġ�� ��ȯ (�ѱ� 2byte)
select INSTR('�����ٶ󸶹ٻ�', '��') ��� from dual;
select INSTR('ABCDEFG', 'C') ��� from dual;
select INSTRB('�����ٶ󸶹ٻ�', '��') ��� from dual;
select INSTRB('ABCDEFG', 'C') ��� from dual;

-- LOWER, UPPER
select LOWER('Hello SQL') ��� from dual;
select UPPER('Hello SQL') ��� from dual;

-- INITCAP : �ܾ��� ù ���ڸ� �빮�ڷ� ��ȯ
select INITCAP('hello world') ��� from dual;

-- LPAD, RPAD
select LPAD('oh', 5, '*') from dual;
select RPAD('yes', 7, '@') from dual;

-- ROUND : Ư�� �ڸ������� �ݿø�
select ROUND(123.4567, 2) from dual;

-- ABS : ���밪
select ABS(-3) from dual;

-- POWER : Ư�� ������ ������ ��ȯ
select POWER(3, 4) from dual;

-- COS, SIN, TAN
select COS(1), SIN(1), TAN(1) from dual;

-- TRUNC : �ش� �ڸ������� �ڸ��� (���� �Ҽ���)
select TRUNC(123.4567, -1) from dual;

-- MOD : �Է¹��� ���� ���� ������
select MOD(5,3) from dual;

-- TO_NUMBER
select TO_NUMBER('123')+100 ��� from dual;

-- TO_CHAR
select TO_CHAR(sysdate, 'mm') ��
       , TO_CHAR(LAST_DAY(sysdate), 'dd') "������ ��"
  from dual;

select ADD_MONTHS(sysdate, 3) from dual;

-- NEXT_DAY : Ư�� ��¥�κ��� ���� ������ ��¥�� ��ȯ
-- TO_DATE : ��¥ �����ͷ� ��ȯ
select NEXT_DAY(TO_DATE('20190123', 'yyyymmdd'), '������') from dual;

-- MONTHS_BETWEEN : �� ��¥ ������ ���� �� ��ȯ
--   ����1�� �������� ����2�κ����� ���� ��
select MONTHS_BETWEEN(
         TO_DATE('20180101', 'yyyymmdd'),
         TO_DATE('20190123', 'yyyymmdd'))
  from dual;
  
-- employees ���̺��� �� ������ �ٹ��� ���� ���� ��ȸ
select trunc(months_between(sysdate, e.hire_date), 0)||'��' �ٹ�����, e.*
  from employees e
  order by months_between(sysdate, e.hire_date) desc;
  
-- COUNT
select COUNT(*) �ѻ���� from employees;
select count(distinct(job_id)) from employees;

-- �μ���ȣ�� 80�� ��� ���� ��ȸ
select count(*)
  from employees
  where department_id = 80;
  
-- MAX, MIN, AVG
select MAX(salary) �ְ�޿�, MIN(salary) �����޿�, ROUND(AVG(salary), 2) ��ձ޿�
  from employees;

-- salary�� 20000�̻��� ���  '��׿�����'
--          10000~20000    '���뿬����'
--          10000�̸��� ��� '�뿹'
-- CASE WHEN ~ THEN ~ ELSE END
select last_name, salary,
       CASE WHEN salary >= 20000 THEN '����'
            WHEN salary >= 10000 THEN '���'
            ELSE '�뿹'
            END salary_type
  from employees;

-- SEQUENCE (������)
--   1. UNIQUE(���ϼ�)�� ���� ����
--   2. ���������� �����ϴ� ���� ����
create sequence seq_01;

select seq_01.nextval from dual; -- ������
select seq_01.currval from dual; -- ���簪

-- ������ �ѹ��� ���� �� ����
create sequence seq_02
  start with 2018000000;
select seq_02.nextval from dual;
select seq_02.currval from dual;

-- ������ �ѹ� ���� �� ����
create sequence seq_03
  start with 2018000001
  increment by 5;
select seq_03.nextval from dual;
select seq_03.currval from dual;

alter sequence seq_03
  increment by 2;
select seq_03.nextval from dual;

-- employees���� ���� 10���� ������ ��ȸ
-- ROWNUM
select *
  from employees
  where ROWNUM <= 10;

-- Primary Key(PK) : �⺻ Ű
--   ���̺��� �����ϰ� �ĺ��ϱ� ���� Ű
--   1. �ߺ��� ������� �ʴ´�. (UNIQUE)
--   2. NULL�� ������� �ʴ´�.

-- Foreign Key(FK) : �ܷ� Ű
--   �ٸ� ���̺��� �⺻ Ű�� �����ϱ� ���� Ű

-- GROUP BY
--   : ���̺��� ���� �� ���ϴ� �����ͷ� �׷��� �����ش�
--     �μ��� ��ձ޿�, ��å�� ��ձ޿�...

-- �Ҽ� �μ��� ��� �޿�
SELECT department_id, ROUND(AVG(salary), 2)
  FROM employees
  GROUP BY department_id;

-- ���� ���� : WHERE -> SELECT -> ORDER BY
SELECT *
  FROM employees
  WHERE ROWNUM <= 20
  ORDER BY salary DESC;

-- �Ҽ� �μ��� ��� �޿��� 5000 �̻��� ������ ��ȸ
-- HAVING : �׷��Լ��� �����ؼ� ���� ������� �� ���ϴ� ���ǿ� ���� ����
SELECT department_id, round(avg(salary), 0) "��� �޿�"
  FROM employees
  GROUP BY department_id
  HAVING avg(salary) >= 5000
  ORDER BY avg(salary) desc;

-- ��� �޿��� 5000�̻���, �μ����� "�ִ�޿�"�� "�ּұ޿�"�� ��ȸ
select department_id, MAX(salary) "�ִ�޿�", MIN(salary) "�ּұ޿�"
  from employees
  group by department_id
  having avg(salary) >= 5000;
  
-- �μ���ȣ�� ������ �μ��� ��� ���� 5�� �̻��� �μ��� ��ȸ�ϵ�,
-- �μ���ȣ�� ������������ ��ȸ
select department_id, count(*) �����
  from employees
  where department_id is not null
  group by department_id
  having count(department_id) >= 5
  order by department_id asc;

-- �μ����� ��� ���� Ŀ�̼��� �޴� ��� ���� ��ȸ
select department_id, count(*) "��� ��", count(commission_pct) "Ŀ�̼� �޴� ��� ��"
  from employees
  group by department_id
  order by department_id asc;
  
-- JOIN
--   : �� ���̺��� �����Ͽ� ���ϴ� �����͸� ��ȸ
--   ���� ���, employees ���̺��� Steven ������ �μ� ��ȣ�� �˾Ƶ�
--            �μ� �̸��� �� �� ����. �μ� �̸��� �ٸ� ���̺� ����!
--            employees ���̺�� departments ���̺��� ���� �κ��� Ȱ��
select e.last_name, d.department_name
  from employees e, departments d
  where e.department_id = d.department_id;
  
select *
  from employees e, departments d
  where e.department_id = d.department_id
    and e.first_name = 'Steven';

-- Cross Join
--   �÷��� : employees�� �÷� �� + departments�� �÷� ��
--   �ο�� : employees�� ������ �ϳ��� ���ؼ� departments ���̺��� �ο�� ���� (107 * 27 = 2889�� �� ��ȸ)
select *
  from employees e, departments d;
  --ANSI
select *
  from employees cross join departments;

-- Equi Join
--   : �� ���̺��� ���� �÷��� ���� ��ġ�Ǵ� ����
select *
  from employees e, departments d
  where e.department_id = d.department_id;
  --ANSI
select *
  from employees e inner join departments d on e.department_id = d.department_id;;

-- �̸��� Steven�� ������ ��ü �̸� ��å�� �޿��� ��ȸ
-- CONCAT : ���ڿ��� ��ġ�� �Լ�
select concat(e.first_name, ' ' || e.last_name) �̸�,  j.job_title ��å, salary �޿�
  from employees e, jobs j
  where e.job_id = j.job_id
    and e.first_name = 'Steven';
  --ANSI
select concat(e.first_name, ' ' || e.last_name) �̸�,  j.job_title ��å, salary �޿�
  from employees e inner join jobs j
    on e.job_id = j.job_id
  where e.first_name = 'Steven';

-- USING
--   : ���� �÷��� ���� ������ �ο��� ��
select *
  from employees e inner join departments d
  using (department_id)
  where e.first_name = 'Steven';

-- Natural Join
--   : ���� ���� �����ϰ�, �ڵ����� ���� �÷��� ã�� ����
select *
  from employees e natural join departments d;

-- IT �μ��� �Ҽӵ� ������ �̸��� �Ի���, �޿��� ��ȸ
select e.first_name || ' ' || e.last_name �̸�, e.hire_date �Ի���, e.salary �޿�
  from employees e, departments d
  where e.department_id = d.department_id
    and d.department_name = 'IT';

-- ��å�� ���α׷����� ������ �ִ� �޿�, �ּ� �޿�, ��� �޿� ��ȸ
select max(e.salary) "�ִ� �޿�", min(e.salary) "�ּ� �޿�", avg(e.salary) "��� �޿�"
  from employees e, jobs j
  where e.job_id = j.job_id
  group by j.job_title
  having j.job_title = 'Programmer';


-- Self Join
--   : �ϳ��� ���̺� ������ ����
-- �� ������ �Ŵ����� ��ȸ
select e.employee_id ���,
       e.first_name || ' ' || e.last_name ����,
       ee.employee_id ���,
       ee.first_name || ' ' || ee.last_name �Ŵ���
  from employees e, employees ee
  where e.manager_id = ee.employee_id;

-- �Ŵ����� Steven King�� �������� ��ü �̸��� �޿�
select e.first_name || ' ' || e.last_name ����,
       e.salary �޿�
  from employees e, employees ee
  where e.manager_id = ee.employee_id
    and ee.first_name || ' ' || ee.last_name = 'Steven King';

-- Steven Markle�� ���� �μ����� ���ϴ� ������ ��ü �̸��� ��ȸ
select ee.first_name || ' ' || ee.last_name "Steven Markle ���嵿��"
  from employees e, employees ee
  where e.department_id = ee.department_id
    and e.first_name || ' ' || e.last_name = 'Steven Markle'
    and ee.first_name || ' ' || ee.last_name != 'Steven Markle';

-- Outer Join
--  : ���� �������� ���� ������ �Ӹ� �ƴ� ���ܵ� �����ͱ��� ǥ��
select e.employee_id ���,
       e.first_name || ' ' || e.last_name ����,
       ee.employee_id ���,
       ee.first_name || ' ' || ee.last_name �Ŵ���
  from employees e, employees ee
  where e.manager_id = ee.employee_id(+);
  --ANSI
select e.employee_id ���,
       e.first_name || ' ' || e.last_name ����,
       ee.employee_id ���,
       ee.first_name || ' ' || ee.last_name �Ŵ���
  from employees e left outer join employees ee
    on e.manager_id = ee.employee_id;

-- employees�� departments�� �����Ͽ� ���� �̸��� �μ� ��ȣ, �μ� ���� ��ȸ
select e.first_name || ' ' || e.last_name �̸�,
       e.department_id "�μ� ��ȣ",
       d.department_name "�μ� ��"
  from employees e, departments d
  where e.department_id(+) = d.department_id;
  
-- ��������
--   : �ϳ��� ��ȸ ����� ������, ���ο� ��ȸ ����� �˻�

-- �޿��� ���� ������� 20���� ��� ���� ��ȸ
select *
  from (select *
          from employees
          order by salary desc
        )
  where rownum <= 20;

-- Steven King�� ���� �μ����� ���ϴ� ������ ��ü �̸�, �μ� ��ȣ�� ��ȸ
select e.first_name || ' ' || e.last_name "���� �̸�",
       e.department_id "�μ� ��ȣ"
  from employees e
  where e.department_id = (select ee.department_id
                             from employees ee
                             where ee.first_name || ' ' || ee.last_name = 'Steven King')
    and e.first_name || ' ' || e.last_name != 'Steven King';
    
-- Alexander Hunold�� ������ ��å�� ���� ������ ��ȸ
select first_name || ' ' || last_name �̸�, job_id
  from employees
  where job_id = (select job_id
                      from employees
                      where first_name || ' ' || last_name = 'Alexander Hunold'
                    )
    and first_name || ' ' || last_name != 'Alexander Hunold';

-- Oliver Tuvault�� �޿��� ���ų� �� ���� ����� ����� ��ȸ
select first_name || ' ' || last_name �̸�, salary �޿�
  from employees
  where salary >= ( select salary
                      from employees
                      where first_name || ' ' || last_name = 'Oliver Tuvault'
                  )
    and first_name || ' ' || last_name != 'Oliver Tuvault'
  order by salary desc;

-- ������ Programmer�� ����� ��ü �̸�, �μ� ��ȣ, �޿��� ��ȸ
select first_name || ' ' || last_name �̸�,
       department_id "�μ� ��ȣ",
       salary �޿�
  from employees
  where job_id = (select job_id
                    from jobs 
                    where job_title = 'Programmer'
                 );

-- ��� �޿����� ���� �޴� ������ ��ü �̸��� �޿��� ��ȸ
select first_name || ' ' || last_name �̸�,
       salary �޿�
  from employees
  where salary > (select avg(salary)
                    from employees
                 )
  order by salary desc;

-- �޿��� 13000 �̻��� ������ ���� �μ��� ��ȣ�� ��ȸ
select distinct department_id
  from employees
  where salary >= 13000;

-- �޿��� 13000 �̻��� ������ ���� �μ���
-- ������ �μ��� �������� ����(�̸�, �μ���ȣ, �޿�)
select first_name || ' ' || last_name �̸�,
       department_id �μ���ȣ,
       salary
  from employees
  where department_id in (select distinct department_id
                            from employees
                            where salary >= 13000
                          );

-- �μ����� ���� ���� �޿��� �޴� ������ ���, �̸�, �޿�, �μ���ȣ ��ȸ
select employee_id ���,
       first_name || ' ' || last_name �̸�,
       salary �޿�,
       department_id �μ���ȣ
  from employees
  where (department_id, salary) in (select department_id, max(salary)
                                      from employees
                                      group by department_id
                                    )
  order by department_id asc;

-- ���� �� ����
-- WHERE ���� ���Ǵ� ���� �� ���� ������
--   IN        : ���� ������ �� ������ ���� ������ ��� �� �ϳ��� ��ġ
--   ANY, SOME : ���� ������ �� ������ ���� ������ ��� �� �ϳ� �̻� ��ġ 
--   ALL       : ���� ������ �� ������ ���� ������ ��� �� ��� ��ġ
--   EXISTS    : ���� ������ �� ������ ���� ������ ����� �ϳ��� ����

-- IT PROG�� ���� �޿��� ���� �޴� �������� ���� ��ȸ
-- ��, IT_PROG���� ������ ����
select *
  from employees
  where salary > all(select salary
                      from employees
                      where job_id = 'IT_PROG'
                    );

-- �μ� ��ȣ�� 80���� ������ ���� �޿� ���� ���� �޿��� �޴� ���� ����
select *
  from employees
  where salary > any(select salary
                      from employees
                      where department_id = 80
                    );

-- Transaction (Ʈ�����)
--   : ������ ó���� ����
-- ACID
--   : �����ͺ��̽� Ʈ������� �����ϰ� ����Ǵ� ���� ����

--     Atomicity (���ڼ�)
--       : Ʈ����ǰ� ���õ� �۾��� ���� �� �ߴܵ��� �ʴ´ٴ� ���� ����
--       - ������ü�� �� ��, �� ���� ��� -> ��� ���� �Ա� ����
--         �� ���¿��� ��ݵ� �Ŀ� �۾��� �ߴܵȴٸ�?
--     Consistency (�ϰ���)
--       : Ʈ����� ������ �Ϸ�Ǹ�, ������ �ʴ� �����ͺ��̽��� ������ ����
--       - ���´� �ܰ� ������ ������ �־�ߵǴ� ����
--         ���¿� ���� ��� �۾��� �����ϴ� �ܰ��� ������ ����
--     Isolation (������)
--       : Ʈ����� ���� �� �ٸ� Ʈ������� ������� �ʴ´ٴ� ���� ����
--       - ������ü �� ��� -> �Ա��� �ϳ��� ������ �����ϴ� ��,
--         ��ݸ� �̷������, ��ȸ�� �ϴ� Ʈ������� ����� �� ����
--     Durability (���Ӽ�)
--       : Ʈ����� ������ �Ϸ�Ǹ�, ������ Ʈ������� ������ �ݿ��ȴٴ� ���� ����
--       - ������ü �� ����� �ܰ� ���� �����ʹ� ������ �ʾƾ� �Ѵ�

-- COMMIT
--   1. Ʈ����� �۾� ������ ���� Database�� ����
--   2. ���� �����Ͱ� ������ UPDATE
--   3. ���� Database�� ������ �Ǿ��⿡, ��� ������ ����� Ȯ��
-- ROLLBACK
--   1. Ʈ����� �۾� ������ �ǵ�����
--   2. ���� ������ ���� COMMIT�� �κ�

-- ROLLBACK �׽�Ʈ
drop table t_table;

create table t_table
as select * from t_cal;

select * from t_table;

delete from t_table;

select * from t_table;

commit;

rollback;