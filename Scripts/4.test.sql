select * from addresses;
select * from course_enrollment;
select * from courses;
select * from students;
select * from tutors;
select * from user_pics;
desc user_pics;


select stud_id, name, email, phone, dob
	from students
	where stud_id =1;
	
select stud_id, name, email, dob, 
	substring(phone, 1, 3) as f, 
	substring(phone, 5, 3) as m, 
	substring(phone, 9, 4) as l
	from students where stud_id=1;
	
insert into students(stud_id, name, email, phone, dob) 
	values(3,"토마스","shis@naver.com","010-000-0000",now());

update students 
	set name="우하하" ,email="나나나난@naver.com" ,phone="010-1111-1111" , dob=now() 
	where stud_id = 3;

delete 
	from students
	where stud_id = 3;

select stud_id, name, email, phone, dob, bio, pic, s.addr_id, a.addr_id, street, city, state, zip, country
	from students s join addresses a on s.addr_id =a.addr_id ;

select t.tutor_id, t.name as tutor_name, email, c.course_id, c.name, description, start_date, end_date
from tutors t left outer join courses c on t.tutor_id=c.tutor_id
where t.tutor_id=4;

select id, name, pic, bio from user_pics where id=1;

select course_id, name, description, start_date, tutor_id from courses
where name like '%java%';
where tutor_id = 1;

select course_id, name, description, start_date, end_data, tutor_id from courses WHERE tutor_id = 1;

select 	ce.stud_id, s.name as s_name, email, phone, dob, bio, pic, addr_id, gender, 
		ce.course_id, c2.name as c_name, description, start_date, end_date, tutor_id
from course_enrollment ce 
join students s ON s.stud_id = ce.stud_id 
join courses c2 on c2.course_id = ce.course_id
where ce.course_id = 1 and ce.stud_id = 1;

select * from course_enrollment ce ;

insert into course_enrollment values (2,1);

update course_enrollment set course_id = 2 , stud_id = 1
	where course_id = 2 and stud_id = 1;

delete from course_enrollment where course_id = 2 and stud_id = 1;


