package spring5_mybatis_study.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
import spring5_mybatis_study.dto.Course;
import spring5_mybatis_study.dto.PhoneNumber;
import spring5_mybatis_study.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class CourseMapperTest {

	private static final Log log = LogFactory.getLog(CourseMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println("===========================================================================================================================");
		System.out.println();
	}

	@Autowired
	private CourseMapper mapper;

	@Test
	public void test01SelectCoursesByCondition() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("tutorId", 1);
		List<Course> res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		map.put("courseName", "%java%");
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		map.put("startDate", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		cal.set(2013, 7, 1);
		map.put("endData", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

	}

	@Test
	public void test02selectCaseCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 8, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		map.put("serchby","tutor");
		map.put("tutorId", 1);
		List<Course> res = mapper.selectCaseCourses(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.clear();
		map.put("serchby","courseName");
		map.put("courseName", "%java%");
		res = mapper.selectCaseCourses(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.clear();
		res = mapper.selectCaseCourses(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
	}
	@Test
	public void test03selectWhereCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Course> res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.put("tutorId", 1);
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		map.put("courseName", "%java%");
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		map.put("startDate", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);

		map.clear();
		cal.set(2013, 7, 1);
		map.put("endData", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
	}
	@Test
	public void test04selectTrimCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		GregorianCalendar cal = new GregorianCalendar(2013, 1, 1);
		Map<String, Object> map = new HashMap<String, Object>();
		
		List<Course> res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.put("tutorId", 1);
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.clear();
		map.put("courseName", "%java%");
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.clear();
		map.put("startDate", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
		
		map.clear();
		cal.set(2013, 7, 1);
		map.put("endData", cal.getTime());
		res = mapper.selectCoursesByCondition(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
	}
	@Test
	public void test05selectCoursesForeachByTutors() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(2);
		Map<String,Object> map = new HashMap<String, Object>();
		
		map.put("tutorIds", list);
		
		List<Course> res = mapper.selectCoursesForeachByTutors(map);
		Assert.assertNotNull(res);
		res.stream().forEach(System.out::println);
	}
	@Test
	public void test06InsertCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		List<Course> list = new ArrayList<Course>();
		list.add(new Course(4, "과모모모몸ㄱ1", "이거뭐드라1", new Date(),  new Date(), 1));
		list.add(new Course(5, "과모모모몸ㄱ2", "이거뭐드라2", new Date(),  new Date(), 2));
		list.add(new Course(6, "과모모모몸ㄱ3", "이거뭐드라3", new Date(),  new Date(), 2));
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("course", list);
		
		int res = mapper.insertCourses(map);
		Assert.assertEquals(3, res);
	}
	@Test
	public void test07DeleteCourses() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		List<Integer> list = new ArrayList<Integer>();
		list.add(4);
		list.add(5);
		list.add(6);
		
		Map<String,Object> map = new HashMap<String, Object>();
		map.put("couresIds", list);
		
		int res = mapper.deleteCourses(map);
		Assert.assertNotNull(res);
	}
	
	@Test
	public void test14updateSetStudent() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		
		Course course = new Course(1, "호호호", "뭐였드라",new Date() , new Date(), 3);
		int res = mapper.updateSetCourses(course);
		Assert.assertEquals(1, res);
		
		course = new Course();
		course.setCourseId(1);
		
		course.setDescription("이거뭐였지");
		res = mapper.updateSetCourses(course);
		Assert.assertEquals(1, res);
		
		course.setName("홍길동");
		res = mapper.updateSetCourses(course);
		Assert.assertEquals(1, res);
		
		course.setTutorId(2);
		res = mapper.updateSetCourses(course);
		Assert.assertEquals(1, res);
		
	}

}
