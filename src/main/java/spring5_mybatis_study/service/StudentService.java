package spring5_mybatis_study.service;

import java.util.Map;

import spring5_mybatis_study.dto.Member;

public interface StudentService {
	Map<Integer, Member> selectStudentForMap();
	
	Map<Integer, String> selectStudentForMap(int studId);
	Map<Integer, Member> selectStudentForMap2(int studId);
}
