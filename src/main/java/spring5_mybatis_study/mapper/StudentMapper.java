package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Student;

public interface StudentMapper { //DAO랑 같은것
	Student selectStudentById(Student student);
	Student selectStudentByNoWithResultMap(Student student);
	List<Student> selectStudentByAll();
	int insertStudent(Student student);
	int updateStudent(Student student);
	int deleteStudent(int id);
	
	//list에 map을 담긴 검색
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	//일대일매핑 검색
	Student selectStudentByNoAssociation(Student student);
}
