package spring5_mybatis_study.mapper;

import static org.junit.Assert.fail;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
import spring5_mybatis_study.dto.UserPic;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ContextRoot.class })
public class UserPicMapperTest {

	private static final Log log = LogFactory.getLog(UserPicMapperTest.class);

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Autowired
	private UserPicMapper mapper;

	@Test
	public void test01InsertUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		//userpic 테이블의 이미지파일을 프로젝트폴더/pics경로에 로드
		
		UserPic userPic = new UserPic();
		userPic.setId(2);
		userPic.setName("아이유");
		userPic.setBio("put some lengthy bio here");
		userPic.setPic(getFile());
		int result = mapper.insertUserPic(userPic);
		Assert.assertSame(1, result);

	}

	private byte[] getFile() {
		byte[] pic = null;
		File file = new File(System.getProperty("user.dir") + "/images/아이유.jpg");
		try (InputStream is = new FileInputStream(file)) {
			pic = new byte[is.available()];
			is.read(pic);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return pic;

	}

	@Test
	public void test02GetUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");

		UserPic userPic = mapper.getUserPic(1);
		log.debug(userPic);
		if (userPic.getPic() != null) {
			File file = getFile(userPic);
			log.debug("file path " + file.getAbsolutePath());
		}
		Assert.assertNotNull(userPic);

	}

	private File getFile(UserPic userPic) {
		File pics = new File(System.getProperty("user.dir") + "\\pics\\");
		if (!pics.exists()) { //폴더있는지 확인
			pics.mkdir(); //폴더만들기
		}
		File file = new File(pics, userPic.getName() + ".jpg");
		try (FileOutputStream output = new FileOutputStream(file)) {
			output.write(userPic.getPic());
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;

	}

	@Test
	public void test03DeleteUserPic() {
		log.debug(Thread.currentThread().getStackTrace()[1].getMethodName() + "()");
		int res = mapper.deleteUserPic(2);
		Assert.assertEquals(1, res);
	}

}
