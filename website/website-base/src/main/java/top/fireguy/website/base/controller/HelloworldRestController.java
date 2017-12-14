package top.fireguy.website.base.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class HelloworldRestController {
	/**
	 * 访问路径：http://localhost:8080/hello
	 * @return
	 */
	@RequestMapping("/hello")
	public String helloRest() {
		return "Hello world! fireguy.top!!";
	}
	
	/**
	 * 访问路径：http://localhost:8080/echo?msg=hello
	 * @param msg
	 * @return
	 */
	@RequestMapping("/echo")
	public String echo(String msg) {
		return "[ECHO]"+msg;
	}
	
	/**
	 * 访问路径：http://localhost:8080/echo2/hello
	 * @param msg
	 * @return
	 */
	@RequestMapping(value="/echo2/{message}", method=RequestMethod.GET)
	public String echo2(@PathVariable("message") String msg) {
		return "[ECHO2]"+msg;
	}
	
	//http://localhost:8080/mul?num=10
	@RequestMapping("/mul")
	public Object mul(int num) {
		return num * 3;
	}
	
	/**
	 * 获取内置对象
	 * 访问路径：http://localhost:8080/object
	 * @param httpServletRequest
	 * @param httpServletResponse
	 * @return
	 */
	@RequestMapping("/object")
	public String object(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) {
		System.out.println("[IP]"+httpServletRequest.getRemoteAddr());
		System.out.println("[Encoding]"+ httpServletResponse.getCharacterEncoding());
		System.out.println("[SessionID]"+ httpServletRequest.getSession().getId());
		System.out.println("[Path]"+ httpServletRequest.getServletContext().getRealPath("/upload"));
		
		return "Hello world!";
	}

}
