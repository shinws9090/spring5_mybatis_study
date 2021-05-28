select t.name as tutor, ifnull(count(c.name),0) as total
from tutors t left join courses c on t.tutor_id = c.tutor_id
group by t.name;

select t.name as tutor, ifnull(count(c.name),0) as total
from tutors t left join courses c on t.tutor_id = c.tutor_id
where t.tutor_id = 3;

DROP PROCEDURE IF EXISTS course_total;

DELIMITER $$
$$
CREATE PROCEDURE course_total(in t_id int)
begin
	select t.name as tutor, ifnull(count(c.name),0) as total
		from tutors t left join courses c 
		on t.tutor_id = c.tutor_id 
		where t.tutor_id = t_id;
END$$
DELIMITER ;

DROP PROCEDURE IF EXISTS course_total_group;

DELIMITER $$
$$
CREATE PROCEDURE course_total_group()
begin
	select t.name as tutor, ifnull(count(c.name),0) as total
		from tutors t left join courses c 
		on t.tutor_id = c.tutor_id 
		group by t.tutor_id;
END$$
DELIMITER ;


call course_total(1); 
call course_total(2); 
call course_total(3); 

call course_total_group(); 