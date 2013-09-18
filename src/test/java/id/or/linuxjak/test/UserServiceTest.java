package id.or.linuxjak.test;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import id.or.linuxjak.dao.GenericDao;
import id.or.linuxjak.domain.User;
import id.or.linuxjak.domain.UserInfo;
import id.or.linuxjak.service.UserInfoService;
import id.or.linuxjak.service.UserService;

public class UserServiceTest extends BaseTest {

	@Autowired
	UserService userService;

	@Autowired
	UserInfoService userInfoService;

	@Test
	public void testAddUser() {
		// TODO Auto-generated method stub
		User user = new User();
		UserInfo ui = new UserInfo();

		ui.setAddress("tangerang");
		ui.setJob("programmer");
		ui.setLastName("gepeng");
		ui.setListedDate(new Date());
		ui.setName("tirta");
		ui.setUser(user);

		user.setUsername("tirta");
		user.setPassword("gepeng");
		user.setUserInfo(ui);

		// userInfoService.create(ui);
		userService.create(user);

		List<UserInfo> list = userInfoService.getAll(UserInfo.class);
		System.out.println(list.get(0).getAddress());
		assertNotNull(list);

	}

}
