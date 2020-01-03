select last_name, department_name, city
from departments
natural join locations
where city = 'Seattle';

select employees.employee_id, employees.last_name,
departments.location_id, department_id
from employees join departments
using (department_id);

select e.employee_id, e.last_name,  e.department_id,
d.department_id, d.location_id
from employees e join departments d
on (e.department_id = d.department_id)
and e.manager_id = 149;

select employee_id, city, department_name
from employees e
join departments d
on d.department_id=e.department_id
join locations l
on d.location_id = l.location_id
where city = 'Seattle';

select * from jobs;


select e.last_name, e.department_id, d.department_name
from employees e full outer join departments d
on (e.department_id = d.department_id);

select last_name, department_name
from employees
cross join department;


select last_name
from employees
where salary >(select salary from employees where last_name = 'Abel');

select last_name, job_id,salary
from employees
where salary < (select avg(salary) from employees);

select employee_id, last_name, job_id, salary
from employees 
where salary <any(select salary from employees where job_id = 'IT_PROG')
and job_id <>'IT_PROG';

select count(*)
from employees
where manager_id is not null;

select emp.last_name
from employees emp
where emp.employee_id not in (select mgr.manager_id from employees mgr);


select last_name, department_id
from employees
where department_id in(20,50) 
order by last_name;

select last_name, hire_date
from employees
where hire_date like '%04';



select last_name, salary, commission_pct
from employees where manager_id is null;

select last_name, salary, commission_pct
from employees 
where commission_pct is not null
order by salary, commission_pct*salary desc;

select last_name
from employees
where last_name like '__a%';

select last_name
from employees
where last_name like '%a%' and  last_name like '%e%' ;

select last_name, job_ID, salary
from employees
where job_id IN ('SA_REP','ST_CLERK') and salary NOT IN (2500, 3500, 7000);


SELECT INITCAP(last_name),
decode(last_name, 'J%', length(last_name),
                  'A%', length(last_name),
                  'M%', length(last_name),
    0) length_name
from employees;

select last_name, (hire_date-sysdate) 'months_worked'
from employees ;

select last_name, department_id
from employees
WHERE DEPARTMENT_ID=(SELECT DEPARTMENT_ID FROM EMPLOYEES WHERE LAST_NAME LIKE 'Abel');

select last_name, hire_date
from employees
where hire_date > (select hire_date from employees where last_name = 'Davies');

select e.last_name, e.hire_date, m.last_name, m.hire_date
from employees e, employees m
where e.manager_id = m.employee_id and e.hire_date<m.hire_date;

select e.last_name, e.employee_id, d.department_id, l.city
from employees e 
inner join  departments d
on e.department_id = d.department_id 
inner join locations l on d.location_id= l.location_id 
where l.city like 'T%';


select employee_id, last_name
from employees e
where not exists (select manager_id from employees d  where e.employee_id = d.manager_id);

select e.last_name, e.employee_id, d.department_name
from employees e
inner join departments d
on e.department_id = d.department_id;



select  last_name,employee_id, (SELECT department_name FROM departments d where e.department_id = d.department_id) department
from employees e
order by department;



WITH summary AS ( SELECT d.department_name, SUM(e.salary) AS dept_total FROM employees e, departments d WHERE e.department_id = d.department_id GROUP BY d.department_name) 
 SELECT department_name, dept_total 
 FROM summary 
 WHERE dept_total > ( SELECT SUM(dept_total) * 1/8 FROM summary ) 
 ORDER BY dept_total DESC;























 