DECLARE
    l_name user_details.first_name%TYPE;
    l_user_id user_details.user_id%TYPE := &user_id;
BEGIN
    -- get the customer
    SELECT first_name INTO l_name
    FROM user_details
    WHERE user_id = l_user_id;
 
    dbms_output.put_line('user name is ' || l_name);
 
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
              dbms_output.put_line('User ' || l_user_id ||  ' does not exist');
END;
/

DECLARE
    l_name user_details.first_name%TYPE;
    l_user_id user_details.user_id%TYPE := &user_id;
BEGIN
    -- get the customer
    SELECT first_name INTO l_name
    FROM user_details
    WHERE user_id > l_user_id;
    
    -- show the customer name   
    dbms_output.put_line('Customer name is ' || l_name);
    EXCEPTION 
        WHEN NO_DATA_FOUND THEN
            dbms_output.put_line('Customer ' || l_user_id ||  ' does not exist');
        WHEN TOO_MANY_ROWS THEN
            dbms_output.put_line('The database returns more than one customer');    
END;
/



DECLARE
    wrong_pwd EXCEPTION;
    PRAGMA exception_init( wrong_pwd, -20001 );
  --  l_max_credit customers.credit_limit%TYPE;
   -- l_customer_id customers.customer_id%TYPE := &customer_id;
    l_pwd user_details.pwd%TYPE := &pwd;
    --len number(3) := pwd;
BEGIN
    if  l_pwd <> 8 then
    raise_application_error(-20001,'Password legth invalid');
    else
         SELECT length(pwd) 
         INTO l_pwd
         FROM user_details;
    
    end if;
END;
/

set SERVEROUTPUT ON
DECLARE
    e_salary EXCEPTION;
    PRAGMA exception_init( e_salary, -20001 );
    l_salary copyemployee.salary%TYPE := &salary;
    l_employee_id copyemployee.employee_id%type := &id;
    l_min jobs.min_salary%type;
    l_max jobs.max_salary%type;
    l_jobid jobs.job_id%type;
BEGIN

    select j.job_id,j.min_salary,j.max_salary into l_jobid, l_min,l_max from copyemployee e,jobs j 
        where e.job_id=j.job_id and e.employee_id=l_employee_id;
    
  --  dbms_output.put_line(l_employee_id ||' - '|| l_salary ||' - '|| l_min ||' - '|| l_max);
  
    IF l_salary < l_min or l_salary > l_max THEN 
     raise e_salary;    
 END IF;
    update copyemployee set salary=l_salary where employee_id=l_employee_id;

    EXCEPTION
         when e_salary then 
         dbms_output.put_line('The salary is invalid');         
END;
/
 
 
set SERVEROUTPUT ON
create or replace
procedure heloo is
begin
    dbms_output.put_line('Hello World!');
end;
/

call heloo();


set SERVEROUTPUT ON
create or replace
procedure dispn (n int) is
begin
     dbms_output.put_line('number  n is '|| n );
end;
/

call dispn(10);


set SERVEROUTPUT ON
declare
    n integer(3) := &n;
begin
    dispn(n*n);
end;
/


set serveroutput on
create or replace 
PROCEDURE details(id int) is

   e_salary EXCEPTION;
        PRAGMA exception_init( e_salary, -20001 );
        l_salary copyemployee.salary%TYPE; 
        l_employee_id copyemployee.employee_id%type := id;
        l_name        copyemployee.first_name%type;
begin

        select first_name,employee_id,salary into l_name, l_employee_id, l_salary from copyemployee
        where id=employee_id; 
        
      IF 
        l_employee_id <> id THEN 
         raise e_salary; 
        end if;
        dbms_output.put_line(l_name ||' - ' || l_employee_id  || ' - ' || l_salary );  
        EXCEPTION
             when e_salary then 
        dbms_output.put_line('Invalid id');         
end;
/
call details(10);

create or replace 
procedure sum_ab (a int, b int, c out int) is
begin c := a+b;
end;
/


set serveroutput on
declare r int;
begin
    sum_ab(10,20,r);
     dbms_output.put_line('sum is '|| r);
end;     
/



set serveroutput on
create or replace 
PROCEDURE det(id int, name out varchar2) is

        l_employee_id copyemployee.employee_id%type := id;
begin

        select first_name into name from copyemployee
        where id=employee_id; 
        
     
        dbms_output.put_line(' for id- ' || l_employee_id  || ' the name is  ' || name );  
     
end;
/

set serveroutput on
declare name copyemployee.first_name%type;
begin
    det(100,name);
   dbms_output.put_line(name);
end;   
/

set serveroutput on
create or replace 
PROCEDURE store(name varchar, salary out number) is

        --l_name         copyemployee.last_name%type := name;
        l_salary       copyemployee.salary%type;
begin
        select salary into salary from copyemployee
        where name=last_name; 
    
        --dbms_output.put_line(l_name || ' gets ' ||  salary );  
end;
/


set serveroutput on
declare salary copyemployee.salary%type;
begin
    store('Popp', salary);
   
end;   
/
commit;


create or replace
function sum_of_salary return int is
sal integer;
begin
    select sum(salary) into sal from employees;
    return sal;
end;
/

begin
    dbms_output.put_line('result: ' || sum_of_salary);
end;
/



create table audits(
    audit_id        number(8) primary key,
    table_name      varchar(225),
    transaction_name      varchar(10),
    by_user         varchar(30),
    transaction_date date
);

CREATE SEQUENCE audit_id_seq
                INCREMENT BY 1
                START WITH 1
                MAXVALUE 9999
                NOCACHE
                NOCYCLE;


CREATE OR REPLACE TRIGGER customers_audit_trg
    AFTER 
    UPDATE OR DELETE 
    ON user_details
    FOR EACH ROW    
DECLARE
   l_transaction VARCHAR2(10);
BEGIN
   -- determine the transaction type
   l_transaction := CASE  
         WHEN UPDATING THEN 'UPDATE'
         WHEN DELETING THEN 'DELETE'
   END;
 
   -- insert a row into the audit table   
   INSERT INTO audits (audit_id,table_name, transaction_name, by_user, transaction_date)
   VALUES(audit_id_seq.nextval,'user_details', l_transaction, user, SYSDATE);
END;
/

update user_details
set pwd='passwors1'
where user_id=111;

select * from audits;

CREATE [OR REPLACE] PACKAGE BODY package_name
   { IS | AS }
 
   [definitions of private TYPEs
   ,declarations of private variables, types, and objects
   ,full definitions of cursors
   ,full definitions of procedures and functions]
[BEGIN
   sequence_of_statements
 
[EXCEPTION
   exception_handlers ] ]
 
END [package_name];
The syntax is similar to the package specification except for the keyword BODYand the implemented code of package specification.

The package body can contain an optional package initialization section that appears at the end of the package body. The package initialization sections start with the BEGINkeyword and end with the EXCEPTIONsection or ENDkeyword of the package. The package initialization section is executed when the application references to the package element at the first time.

The following illustrates package body of the personnelpackage:

/*
  Package personnel body
*/
CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;

    RETURN v_fullname;

  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname

  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;

    RETURN n_salary;

    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;



/*
  Package personnel body
*/
CREATE OR REPLACE PACKAGE BODY personnel AS
  -- get employee's fullname
  FUNCTION get_fullname(n_emp_id NUMBER) RETURN VARCHAR2 IS
      v_fullname VARCHAR2(46);
  BEGIN
    SELECT first_name || ',' ||  last_name
    INTO v_fullname
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN v_fullname;
 
  EXCEPTION
  WHEN NO_DATA_FOUND THEN
    RETURN NULL;
  WHEN TOO_MANY_ROWS THEN
    RETURN NULL;
  END; -- end get_fullname
 
  -- get salary
  FUNCTION get_salary(n_emp_id NUMBER) RETURN NUMBER IS
    n_salary NUMBER(8,2);
  BEGIN
    SELECT salary
    INTO n_salary
    FROM employees
    WHERE employee_id = n_emp_id;
 
    RETURN n_salary;
 
    EXCEPTION
      WHEN NO_DATA_FOUND THEN
        RETURN NULL;
      WHEN TOO_MANY_ROWS THEN
        RETURN NULL;
  END;
END personnel;

SET SERVEROUTPUT ON SIZE 1000000;
DECLARE
  n_salary NUMBER(8,2);
  v_name   VARCHAR2(46);
  n_emp_id NUMBER := &emp_id;
BEGIN
 
  v_name   := personnel.get_fullname(n_emp_id);
  n_salary := personnel.get_salary(n_emp_id);
 
  IF v_name  IS NOT NULL AND
    n_salary IS NOT NULL
  THEN
    dbms_output.put_line('Employee: ' || v_name);
    dbms_output.put_line('Salary:' || n_salary);
  END IF;

END;
/


insert into publisher
values(11, 'Penguin Publishers', 'Mumbai');

insert into publisher
values(12, 'Grapevine Publishers', 'Boston');
commit;

insert into author
values(90, 'Indian', 'Arun Raheja');

insert into author
values(91, 'American', 'Dan Brown');

insert into author
values(92, 'Indian', 'Nikita Singh');
commit;

select b.isbn, b.title, b.pages, a.auth_name, p.pub_name, p.city from book b join author a on b.author_id = a.author_id join publisher p on b.pub_id=p.pub_id;



select a.auth_name, b.title from book b join author a on b.author_id=a.author_id order by a.auth_name, b.title;


commit;

select * from book b, author a, publisher p where b.author_id=a.author_id and b.pub_id=p.pub_id;







INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('111', 'Angels and Demons', '300', '1885', '91', '12');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('222', 'Da vinci code', '250', '1889', '91', '12');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('333', 'Memories', '125', '2005', '90', '11');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('444', 'Urban Classics', '230', '2007', '90', '11');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('555', 'Unfinished Midnight', '155', '2004', '92', '11');
INSERT INTO "HR"."BOOK" (ISBN, TITLE, PAGES, PUB_YEAR, AUTHOR_ID, PUB_ID) VALUES ('666', 'Road less travelled', '210', '2010', '92', '12');
commit;





select * from book
where pub_year>2000 ;





select * from book b, author a, publisher p where b.author_id=a.author_id and b.pub_id=p.pub_id;




set serveroutput on
create or replace 
PROCEDURE bks(auth int) is

        
        l_num       integer;
begin
        select count(author_id) into l_num from book
        where auth=author_id;
        --dbms_output.put_line(l_num || ' gets ' ||  auth );  
end;
/


set serveroutput on
declare salary copyemployee.salary%type;
begin
    bks(91);
   
end;   
/




