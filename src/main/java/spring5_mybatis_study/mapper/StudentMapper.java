package spring5_mybatis_study.mapper;

import java.util.List;
import java.util.Map;

import spring5_mybatis_study.dto.Member;

public interface StudentMapper { //DAO랑 같은것
	Member selectStudentById(Member student);
	Member selectStudentByNoWithResultMap(Member student);
	List<Member> selectStudentByAll();
	int insertStudent(Member student);
	int updateStudent(Member student);
	int deleteStudent(int id);
	
	//list에 map을 담긴 검색
	List<Map<String, Object>> selectStudentByAllForHashMap();
	
	//일대일매핑 검색
	Member selectStudentByNoAssociation(Member student);
	
	/* enum 타입 다루기 */
	int insertEnumStudent(Member student);
	
	/* 여러 개의 입력 파라메터 전달 */
	Member selectStudentByMap(Map<String,String> map);
	List<Member> selectAllStudentByMap(Map<String,String> map);
	
	/* ResultSet 처리방식의 재정의 */
	Map<Integer, Member> selectStudentForMap(Member student);
	
	/* set 조건 */
	int updateSetStudent(Member student);


}
