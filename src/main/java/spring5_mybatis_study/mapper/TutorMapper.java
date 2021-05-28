package spring5_mybatis_study.mapper;

import spring5_mybatis_study.dto.Tutor;

public interface TutorMapper { //DAO랑 같은것
	
	Tutor selectTutorById(Tutor tutor);
	
	/* Transaction */
	int insertTutor(Tutor tutor);
	int deleteTutor(int tutorId);
}
