package spring5_mybatis_study.mapper;

import java.util.Map;

import spring5_mybatis_study.dto.CourseEnrollment;

public interface CourseEnrollmentMapper {

	CourseEnrollment selectCourseEnrollmentById(CourseEnrollment courseEnrollment);
	int insertCourseEnrollment(CourseEnrollment courseEnrollment);
	int updateCourseEnrollment(Map<String,Integer> map);
	int deleteCourseEnrollment(CourseEnrollment courseEnrollment);
	
	
}
