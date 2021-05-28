package spring5_mybatis_study.service;

import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.Tutor;

public interface TutorAndCourseService {

	void trJoinTutorAndCourse(Tutor tutor, Course course);

	void trRemoveTutorAndCourse(int tutorId, int courseId);
}
