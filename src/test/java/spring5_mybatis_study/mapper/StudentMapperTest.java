package spring5_mybatis_study.mapper;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.Gender;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class StudentMapperTest {

	private static final Log log = LogFactory.getLog(StudentMapperTest.class);

	@Autowired
	private StudentMapper mapper;

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void testSelectStudentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Student std = new Student();
		std.setStudId(1);
		Student selectStd = mapper.selectStudentById(std);
		log.debug(selectStd.toString());
		Assert.assertNotNull(selectStd);
	}

	@Test
	public void testSelectStudentByNoWithResultMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Student std = new Student();
		std.setStudId(1);
		Student selectStd = mapper.selectStudentByNoWithResultMap(std);
		log.debug(selectStd.toString());
		Assert.assertNotNull(selectStd);
	}

	@Test
	public void testSelectStudentByAll() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Student> list = mapper.selectStudentByAll();
		Assert.assertNotNull(list);
		list.stream().forEach(System.out::println);
	}

	@Test
	public void test01InsertStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Student std = new Student(3, "토마스", "shis@naver.com", new PhoneNumber("010-000-0000"), new Date());

		int res = mapper.insertStudent(std);
		Assert.assertEquals(1, res);
		System.out.println(mapper.selectStudentById(std));
	}

	@Test
	public void test03DeleteStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		int res = mapper.deleteStudent(3);
		Assert.assertEquals(1, res);

	}

	@Test
	public void test02UpdateStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Student std = new Student(3, "으나나나", "홀로로롤@naver.com", new PhoneNumber("010-111-1111"), new Date());

		int res = mapper.updateStudent(std);
		Assert.assertEquals(1, res);
		System.out.println(mapper.selectStudentById(std));

	}

	@Test
	public void testSelectStudentByAllForHashMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Map<String, Object>> list = mapper.selectStudentByAllForHashMap();
		Assert.assertNotNull(list);
		for (Map<String, Object> map : list) {
			for (Entry<String, Object> e : map.entrySet()) {
				System.out.printf("%s >>>> %s%n", e.getKey(), e.getValue());
			}
			System.out.println("----------------------------------");
		}
	}

	@Test
	public void testSelectStudentByNoAssociation() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		Student std = new Student();
		std.setStudId(1);
		Student selectStd = mapper.selectStudentByNoAssociation(std);
		Assert.assertNotNull(selectStd);
		log.debug(selectStd.toString());
	}

	@Test
	public void test11InsertEnumStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Calendar newDate = GregorianCalendar.getInstance();
		newDate.set(1990, 2, 28);
		Student student = new Student();
		student.setStudId(3);
		student.setName("test");
		student.setEmail("test@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.FEMALE);
		int res = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res);
		
		student.setStudId(4);
		student.setName("test4");
		student.setEmail("test4@test.co.kr");
		student.setDob(newDate.getTime());
		student.setPhone(new PhoneNumber("010-1234-1234"));
		student.setGender(Gender.MALE);
		int res1 = mapper.insertEnumStudent(student);
		Assert.assertEquals(1, res1);
		
		mapper.deleteStudent(3);
		mapper.deleteStudent(4);
	}
	@Test
	public void test12SelectStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "Timothy");
		map.put("email", "timothy@gmail.com");
		
		Student std = mapper.selectStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
		
		map.remove("email");
		std = mapper.selectStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
		
		map.clear();
		map.put("email", "timothy@gmail.com");
		std = mapper.selectStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
	}
	@Test
	public void test13SelectAllStudentByMap() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Map<String,String> map = new HashMap<String, String>();
		map.put("name", "Timothy");
		map.put("email", "timothy@gmail.com");
		
		List<Student> std = mapper.selectAllStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
		
		map.remove("email");
		std = mapper.selectAllStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
		
		map.clear();
		map.put("email", "timothy@gmail.com");
		std = mapper.selectAllStudentByMap(map);
		Assert.assertNotNull(std);
		log.debug(std.toString());
		
		map.clear();
		std = mapper.selectAllStudentByMap(map);
		Assert.assertNotNull(std);
		std.stream().forEach(System.out::println);
	}
	@Test
	public void test14updateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Student student = new Student(1, "홍홍홍", "dmmskdk@dndn.com", new PhoneNumber("010-000-0000"), new Date());
		int res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
		student = new Student();
		student.setStudId(1);
		
		student.setPhone(new PhoneNumber("010-111-1111"));
		res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
		student.setName("Timothy");
		res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
		student.setEmail("timothy@gmail.com");
		res = mapper.updateSetStudent(student);
		Assert.assertEquals(1, res);
		
	}
	
}
