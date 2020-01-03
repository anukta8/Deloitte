
    
DECLARE 
    i NUMBER := 1;
BEGIN
    LOOP
        INSERT INTO T1 VALUES(i,i);
        i := i+1;
        EXIT WHEN i>100;
    END LOOP;
END;
/

SELECT * FROM T1;

    
DECLARE 
    i NUMBER := 1;
BEGIN
    while i>100 loop
        INSERT INTO T1 VALUES(i,i);
        i := i+10;
    END LOOP;
END;
/
 select * from t1;


DECLARE 
    k NUMBER := 1;
BEGIN
    for i in 1..100 loop
        INSERT INTO T1 VALUES(i,i);
        k := i+2;
    END LOOP;
END;
/
 select * from t1;
 
 
 set SERVEROUTPUT on size 10000000;
 declare
    n_pct employees.comission_pct%type;
    v_eval varchar2(10);
    n_emp_id employyes.employee_id%type := 145;
begin
    --get commission percentage---
select comission_pct
into n_pct
from employees
where employee_id = n_emp_id;

--evaluate comission percantage---
case n_pct
    when 0 then
        v_eval := 'N/A';
    when 0.1 then
        v_eval := 'LoW';    
    when 0.4 then
        v_eval := 'High';
    else
        v.eval := 'Fair';
end case;
    
dbms_output.put_line('Employee' || n_emp_id || 'comission' || to_char(n_pct) || 'which is' || v_eval);

end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_pct    employees.commission_pct%TYPE;
  v_eval   varchar2(10);
  n_emp_id employees.employee_id%TYPE := 145;
BEGIN
  -- get commission percentage
  SELECT commission_pct
  INTO n_pct
  FROM employees
  WHERE employee_id = n_emp_id;
 
  -- evalutate commission percentage
  CASE n_pct
    WHEN 0 THEN
      v_eval := 'N/A';
    WHEN 0.1 THEN
      v_eval := 'Low';
    WHEN 0.4 THEN
      v_eval := 'High';
    ELSE
      v_eval := 'Fair';
  END CASE;
  -- print commission evaluation----
  DBMS_OUTPUT.PUT_LINE('Employee ' || n_emp_id || 
                       ' commission ' || TO_CHAR(n_pct) ||
                      ' which is '   || v_eval);

END;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  e_name    user_details.first_name%TYPE := 'anu';
  e_role_id    user_details.role_id%type;
  e_role_name   varchar2(10);
  
BEGIN
  -- get commission percentage
  SELECT role_id
  INTO e_role_id
  FROM user_details
  WHERE first_name=e_name;
 
  -- evalutate commission percentage
  CASE e_role_id
    WHEN 1 THEN
      e_role_name := 'admin';
    WHEN 2 THEN
      e_role_name := 'manager';
    WHEN 3 THEN
      e_role_name := 'manager';
    ELSE
      e_role_name := 'user';
  END CASE;
  -- print commission evaluation
  DBMS_OUTPUT.PUT_LINE('user ' || e_name || ' role is ' || e_role_name );
END;
/


insert into employee_salary
values(2,'Anukta',15000,4000,1000,5000,15000,20000);

insert into employee_salary
values(1,'Anu',31000,8000,1000,5000,35000,40000);

insert into employee_salary
values(3,'Vikash',14000,4000,1000,5000,15000,19000);

insert into employee_salary
values(4,'Sasha',14000,4000,1000,5000,15000,19000);

insert into employee_salary
values(5,'vik',13000,4000,1000,5000,15000,18000);


select * from employee_salary;



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  e_name    employee_salary.emp_name%TYPE := 'vik';
  e_salary  employee_salary.gross_salary%type;
  e_tax     INTEGER;
   
BEGIN

  SELECT gross_salary
  INTO e_salary
  FROM employee_salary
  WHERE e_name=emp_name;
 
 CASE 
        when e_salary<=20000 then
            e_tax:=10*e_salary/100;
        when e_salary>20000 and e_salary<=30000 then
            e_tax:=15*e_salary/100;
       when e_salary>30000 and e_salary<=40000 then
            e_tax:=20*e_salary/100; 
        else
            e_tax:=25*e_salary/100;
    end case;

  DBMS_OUTPUT.PUT_LINE('user ' || e_name || ' has to pay ' || e_tax || 'rs tax' );
end;

/

SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
  n_emp_id EMPLOYEES.EMPLOYEE_ID%TYPE := &emp_id1;
BEGIN
    <<child>>
  DECLARE
    n_emp_id employees.employee_id%TYPE := &emp_id2;
    v_name   employees.first_name%TYPE;
      BEGIN
        SELECT first_name
        INTO v_name
        FROM employees
        WHERE employee_id = n_emp_id;
     
        DBMS_OUTPUT.PUT_LINE('First name of employee ' || parent.n_emp_id || ' is ' || v_name);
        EXCEPTION
          WHEN no_data_found THEN
            DBMS_OUTPUT.PUT_LINE('Employee ' || parent.n_emp_id || ' not found');
      END;
END;
/



SET SERVEROUTPUT ON SIZE 1000000;
<<parent>>
DECLARE
    n_emp_no    employee_salary.emp_no%TYPE := &emp_id1;
    n_emp_name   employee_salary.emp_name%TYPE := '&emp_name1';
    n_basic      employee_salary.basic%type := &emp_basic1;
    n_hra        employee_salary.hra%type := &emp_hra1;
    n_da         employee_salary.da%type := &emp_da1;
    n_totalded        employee_salary.total_deduction%type := &emp_totalded1;
    n_netsal       employee_salary.net_salary%type := &emp_netsal1;
    n_gross       employee_salary.gross_salary%type := &emp_gross1; 

BEGIN
     INSERT into employee_salary
    VALUES (n_emp_no,n_emp_name,n_basic,n_hra,n_da,n_totalded,n_netsal,n_gross);
    
<<child>>
        DECLARE
          e_salary  employee_salary.gross_salary%type;
          e_tax     INTEGER;
           
        BEGIN
        
          SELECT gross_salary
          INTO e_salary
          FROM employee_salary
          WHERE emp_name=parent.n_emp_name;
         
         CASE 
                when e_salary<=20000 then
                    e_tax:=10*e_salary/100;
                when e_salary>20000 and e_salary<=30000 then
                    e_tax:=15*e_salary/100;
               when e_salary>30000 and e_salary<=40000 then
                    e_tax:=20*e_salary/100; 
                else
                    e_tax:=25*e_salary/100;
            end case;
        
          DBMS_OUTPUT.PUT_LINE('Employee ' || parent.n_emp_name || ' has to pay ' || e_tax || 'rs tax' );
        END;

end;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT u.first_name, r.role_name
      FROM user_details u
      INNER JOIN role_table r ON r.role_id = u.role_id;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
 
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.first_name || ' - ' ||
                         r_chief.role_name);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/


 select * from t1;


DECLARE 
    k NUMBER := 1;
BEGIN
    for i in 1..100 loop
        INSERT INTO T1 VALUES(i,i+1);
        k := i+1;
    END LOOP;
END;
/

select * from t1;


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  -- declare a cursor
  CURSOR cur_chief IS
      SELECT a,b
      FROM t1;
 
  r_chief cur_chief%ROWTYPE;
BEGIN
  OPEN cur_chief;
  LOOP
    -- fetch information from cursor into record
    FETCH cur_chief INTO r_chief;
    if (r_chief.a<r_chief.b) then
        r_chief.a := r_chief.a + r_chief.b;
        r_chief.b := r_chief.a - r_chief.b;
        r_chief.a := r_chief.a - r_chief.b;
    end if;
    EXIT WHEN cur_chief%NOTFOUND;
 
    -- print department - chief
    DBMS_OUTPUT.PUT_LINE(r_chief.a || ' - ' ||
                         r_chief.b);
  END LOOP;
  -- close cursor cur_chief
  CLOSE cur_chief;
END;
/


declare
    a1 t1.a%type;
    b1 t1.b%type;

    cursor t1cursor is
    select a,b from t1 where a < b
    for update;
t1_cur t1cursor%rowtype;

begin
    open t1cursor;
        loop
            fetch t1cursor into a1,b1;
            
            exit when t1cursor%notfound;
        
            delete from t1 where current of t1cursor;
            
            insert into t1 values(b1,a1);
             DBMS_OUTPUT.PUT_LINE('done' );
         end loop;
     
     close t1cursor;
end;
/

select * from t1;

DECLARE 
    k NUMBER := 1;
BEGIN
    for i in 1..100 loop
        INSERT INTO T1 VALUES(i,i+1);
        k := i+1;
    END LOOP;
END;
/

select * from t1;


declare
    name copyemployee.last_name%type;
    sal  copyemployee.salary%type;
   -- new_sal number(8);

    cursor ecursor is
    select last_name, salary, hire_date from copyemployee where hire_date > '31-DEC-05'
    for update;
    
e_cur ecursor%rowtype;

begin
    open ecursor;
        loop
            fetch ecursor into e_cur;
               sal := sal+ 0.1*sal;
             DBMS_OUTPUT.PUT_LINE(e_cur.last_name  || ' - ' || e_cur.salary);
            exit when ecursor%notfound;
         end loop;
     
     close ecursor;
end;
/

declare

    cursor ecursor is
    select last_name, first_name, hire_date from copyemployee where hire_date = (select min(hire_date) from copyemployee);
   
e_cur ecursor%rowtype;

begin
    open ecursor;
        loop
            fetch ecursor into e_cur;
             
            exit when ;
            
            DBMS_OUTPUT.PUT_LINE(e_cur.last_name  || ' - ' || e_cur.first_name || ' - ' || e_cur.hire_date);
         end loop;
     
     close ecursor;
end;
/


SET SERVEROUTPUT ON SIZE 1000000;
declare
    count INTEGER :=0;
    
    cursor ecursor is
    select first_name, last_name from copyemployee;
   
e_cur ecursor%rowtype;

begin
    open ecursor;
        loop
            fetch ecursor into e_cur;
            --count :=count+1;
            exit when ecursor%ROWCOUNT=12;
            
            DBMS_OUTPUT.PUT_LINE(e_cur.first_name  || ' - ' || e_cur.last_name);
         end loop;
     
     close ecursor;
end;
/

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  r_emp employees%ROWTYPE;
  n_emp_id  employees.employee_id%TYPE := 200;
BEGIN
  SELECT *
  INTO r_emp
  FROM employees
  WHERE employee_id = n_emp_id;
  -- print out the employee's first name
  DBMS_OUTPUT.PUT_LINE(r_emp.first_name);
END;
/


SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
     first_name user_details.first_name%TYPE,
     role_name  role_table.role_name%TYPE
  );
  u_name   t_name; -- name record
  n_user_id user_details.user_id%TYPE := 111;
BEGIN
  SELECT u.first_name, r.role_name
  INTO u_name
  FROM user_details u
  join role_table r
  on u.role_id = r.role_id
  where user_id = n_user_id;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(u_name.first_name || ',' || u_name.role_name );
END;
/



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
     first_name user_details.first_name%TYPE,
     role_name  role_table.role_name%TYPE
  );
  u_name   t_name; -- name record
  
  cursor ecursor is
   SELECT u.first_name, r.role_name
      FROM user_details u
      INNER JOIN role_table r ON r.role_id = u.role_id;

begin
    open ecursor;
        loop
            fetch ecursor into u_name;
    
             DBMS_OUTPUT.PUT_LINE(u_name.first_name  || ' - ' || u_name.role_name);
            exit when ecursor%notfound;
         end loop;
     
     close ecursor;
END;
/

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  CURSOR cur_emp IS
    SELECT *
    FROM user_details
    WHERE user_id = 111;
 
  emp_rec cur_emp%ROWTYPE;
BEGIN
  NULL;
  DBMS_OUTPUT.PUT_LINE(emp_rec.first_name  || ' - ' || emp_rec.username);
  
END;
/


SET serveroutput ON SIZE 1000000;
DECLARE
  TYPE t_name IS RECORD(
    first_name employees.first_name%TYPE,
    last_name employees.last_name%TYPE
  );
  r_name      t_name;
  r_name2     t_name;
  r_name_null t_name;
  n_emp_id employees.employee_id%TYPE := 200;
BEGIN
  -- assign employee's infomation to record
  SELECT first_name,
         last_name
  INTO r_name
  FROM employees
  WHERE employee_id = n_emp_id;
 
  -- assign record to another record
  r_name2 := r_name;
  -- print out the employee's name
  DBMS_OUTPUT.PUT_LINE(r_name2.first_name || ',' || r_name2.last_name);
 
  -- assign record to NULL
  r_name2 := r_name_null; 
 
  -- check NULL for each individual field
  IF r_name2.first_name IS NULL AND
     r_name2.last_name IS NULL THEN
    DBMS_OUTPUT.PUT_LINE('Record r_name2 is NULL');
  END IF;
 
END;
/



SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
CURSOR cur_emp IS
  SELECT e.employee_id,e.first_name,e.salary,d.department_name,l.location_id
  FROM employees e, departments d, locations l
  where e.department_id = d.department_id and d.location_id = l.location_id;

emp_rec cur_emp%ROWTYPE;

  TYPE e_name IS RECORD(
     employee_id employees.employee_id%TYPE,
     first_name  employees.first_name%TYPE,
     salary      employees.salary%type
  );
 -- emp_name   e_name; 
  
 TYPE d_name IS RECORD(
     department_name  departments.department_name%TYPE,
     location_id         departments.location_id%type
  );
 -- dep_name   d_name; 
  
   TYPE l_name IS RECORD(
    location_id     locations.location_id%type,
    location_name   locations.city%type
  );

    TYPE d_detail IS RECORD(
    emp e_name,
    dep d_name,
    loc l_name
  );
BEGIN
detail d_detail;
 -- WHERE employee_id = n_emp_id;
  -- print out the employee's name
  
  open cur_emp;
        loop
            fetch cur_emp into emp_rec;
    
              DBMS_OUTPUT.PUT_LINE( detail.emp.e_name );
            exit when cur_emp%notfound;
         end loop;

     close cur_emp;
END;
/
  
  