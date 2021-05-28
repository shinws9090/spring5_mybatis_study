package spring5_mybatis_study.resulthandlers;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.ResultContext;
import org.apache.ibatis.session.ResultHandler;

import spring5_mybatis_study.dto.Member;

public class StudentResultHandler implements ResultHandler<Member> {
	private Map<Integer, String> map = new HashMap<>();

	
	public StudentResultHandler() {
		// TODO Auto-generated constructor stub
	}

	public StudentResultHandler(Map<Integer, String> map) {
		this.map = map;
	}

	@Override
	public void handleResult(ResultContext<? extends Member> resultContext) {
		Member student = resultContext.getResultObject();
		map.put(student.getStudId(),student.getName());
	}

}
