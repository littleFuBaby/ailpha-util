package own.test;

import java.util.List;
import java.util.concurrent.locks.LockSupport;

import com.ailpha.service.UserService;
import com.ailpha.common.util.JedisUtil;
import com.ailpha.vo.User;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserService {

	@Autowired
	private UserService userService;
	
	@org.junit.Test
	public void test1() {
		
		System.out.println(JedisUtil.get("newkey"));
		
		
		List<User> users = userService.selectUser("5678");
		System.out.println("----------------" + users);

		for (int x = 0; x < 40; x++) {
			new Thread(() -> {
				int res = userService.updateUser("9");
				System.out.println(Thread.currentThread().getName() + "----" + res);
			}).start();
		}
		
		LockSupport.park();

	}

}
