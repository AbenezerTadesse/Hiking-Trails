package com.Hiking.Trails;

import com.Hiking.Trails.controller.HomeController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TrailsApplicationTests {

	@Test
	public void testTrailsApp() {
        HomeController testHomeCtr = new HomeController();
        String result = testHomeCtr.home();
        assertEquals(result, "Colorado Hiking Trails Full Stack Project");
	}

}
