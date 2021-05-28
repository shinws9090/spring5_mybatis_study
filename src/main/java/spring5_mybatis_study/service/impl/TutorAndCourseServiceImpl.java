package spring5_mybatis_study.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.Tutor;
import spring5_mybatis_study.mapper.CourseMapper;
import spring5_mybatis_study.mapper.TutorMapper;
import spring5_mybatis_study.service.TutorAndCourseService;

public class TutorAndCourseServiceImpl implements TutorAndCourseService {
	
	@Autowired
	private TutorMapper tMapper;
	
	@Autowired
	private CourseMapper cMapper;
	
	@Override
	@Transactional
	public void trJoinTutorAndCourse(Tutor tutor, Course course) {
//		int res = tMapper.

	}

	@Override
	@Transactional
	public void trRemoveTutorAndCourse(int tutorId, int courseId) {
		// TODO Auto-generated method stub

	}

}
