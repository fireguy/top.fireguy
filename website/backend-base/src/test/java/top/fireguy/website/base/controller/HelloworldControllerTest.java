package top.fireguy.website.base.controller;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import junit.framework.TestCase;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
public class HelloworldControllerTest{
	@Resource
	private HelloworldController helloworldController;
	@Test
	public void testHello() {
		TestCase.assertEquals(this.helloworldController.hello(), "Hello world! fireguy.top!!");
	}
}
