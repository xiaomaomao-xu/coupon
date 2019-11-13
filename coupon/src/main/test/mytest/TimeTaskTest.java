//package mytest;
//
//import java.util.concurrent.ExecutionException;
//
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import com.hsys.coupon.App;
//import com.hsys.coupon.task.MyTestTimeTask;
//
//@RunWith(SpringRunner.class)   
//@SpringBootTest(classes={App.class})
//public class TimeTaskTest {
//	
//	@Autowired
//    private MyTestTimeTask timeTask;
//
//	@Test
//    public void TimeTaskNativeTest() throws InterruptedException, ExecutionException {
//
//		timeTask.executeRepaymentTask();
//		timeTask.executeUpdateYqTask();
//    }
//}
