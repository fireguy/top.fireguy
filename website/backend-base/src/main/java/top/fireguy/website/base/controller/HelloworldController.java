package top.fireguy.website.base.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@EnableAutoConfiguration
public class HelloworldController {
	@RequestMapping("/")
	@ResponseBody
	public String hello() {
		return "Hello world! fireguy.top!!";
	}
}
