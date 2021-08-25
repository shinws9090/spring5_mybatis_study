package spring5_mybatis_study.mapper;

import java.util.HashMap;
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
import spring5_mybatis_study.dto.CourseEnrollment;
import spring5_mybatis_study.dto.Student;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class CourseEnrollmentMapperTest {
	
	private static final Log log = LogFactory.getLog(CourseEnrollmentMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println();
	}
	
	@Autowired
	private CourseEnrollmentMapper mapper;
	
	@Test
	public void test01SelectCourseEnrollmentById() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		CourseEnrollment courseEnrollment = new CourseEnrollment();
		courseEnrollment.setCourse(new Course(1));
		courseEnrollment.setStudent(new Student(2));
		CourseEnrollment selectCe = mapper.selectCourseEnrollmentById(courseEnrollment);
		Assert.assertNotNull(selectCe);
		log.debug(selectCe.toString());
	}

	@Test
	public void test02InsertCourseEnrollment() {
		CourseEnrollment courseEnrollment = new CourseEnrollment();
		courseEnrollment.setCourse(new Course(2));
		courseEnrollment.setStudent(new Student(1));
		int res = mapper.insertCourseEnrollment(courseEnrollment);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateCourseEnrollment() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("oldCourseId", 2);
		map.put("oldStudId", 1);
		map.put("newCourseId", 3);
		map.put("newStudId", 1);
		int res = mapper.updateCourseEnrollment(map);
		Assert.assertEquals(1, res);
	}

	@Test
	public void test04DeleteCourseEnrollment() {
		CourseEnrollment courseEnrollment = new CourseEnrollment();
		courseEnrollment.setCourse(new Course(3));
		courseEnrollment.setStudent(new Student(1));
		int res = mapper.deleteCourseEnrollment(courseEnrollment);
		Assert.assertEquals(1, res);
	}

}
