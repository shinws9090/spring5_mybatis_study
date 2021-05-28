package spring5_mybatis_study.mapper;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.After;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import spring5_mybatis_study.config.ContextRoot;
import spring5_mybatis_study.dto.CourseStat;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class CourseStatMapperTest {

	private static final Log log = LogFactory.getLog(CourseStatMapperTest.class);
	
	@After
	public void tearDown() throws Exception {
		System.out.println("===========================================================================================================================");
		System.out.println();
	}
	private CourseStatMapper mapper;
	@Test
	public void testGetCourseCountByTutor() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName()+"()");
		CourseStat stat = mapper.getCourseCountByTutor(1);
		Assert.assertNotNull(stat);
	}

}
