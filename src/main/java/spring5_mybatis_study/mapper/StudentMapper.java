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
	
	/* enum 타입 다루기 */
	int insertEnumStudent(Student student);
	
	/* 여러 개의 입력 파라메터 전달 */
	Student selectStudentByMap(Map<String,String> map);
	List<Student> selectAllStudentByMap(Map<String,String> map);
	
	/* ResultSet 처리방식의 재정의 */
	Map<Integer, Student> selectStudentForMap(Student student);
	
	/* set 조건 */
	int updateSetStudent(Student student);


}
