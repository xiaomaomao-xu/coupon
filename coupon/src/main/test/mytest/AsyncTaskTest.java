package mytest;

import java.util.concurrent.ExecutionException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hsys.coupon.App;
import com.hsys.coupon.task.AsyncTask;

@RunWith(SpringRunner.class)   
@SpringBootTest(classes={App.class})
public class AsyncTaskTest {
	
	@Autowired
    private AsyncTask asyncTask;

	@Test
    public void asyncTaskNativeTest() throws InterruptedException, ExecutionException {

        for (int i = 0; i < 100; i++) {
            asyncTask.doTask2(i);
        }
        System.out.println("All tasks finished.");
    }
}
