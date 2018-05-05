package qing.springboottest;

import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import mybatis.model.HelloDO;
import mybatis.service.HelloWorldService;

/**
 * Hello world!
 *
 */
@SpringBootApplication(scanBasePackages = "mybatis/service")
@RestController
@MapperScan("mybatis")
//@EnableEurekaClient
public class App {
	Logger logger = LoggerFactory.getLogger(App.class);
	
	@Autowired
	HelloWorldService helloWorldService;

	@RequestMapping("/")
	public String greeting() {
		return "Hello World!";
	}
	
	@RequestMapping("/a")
	public String a() {
		return "Hello a!";
	}
	
	@Value("${server.port}")
	String port;
	@RequestMapping("/hi")
	public String hello(@RequestParam String name) {
		return "Hello "+name+", I'm from port "+port;
	}

	@RequestMapping(value = "/create/hello", method = RequestMethod.POST, consumes = { "text/plain", "application/*" })
	public @ResponseBody long createHello(@RequestBody HelloDO helloDO) {
		final String api = "hello";
		logger.info(api + ": id: " + helloDO.getId() + ", name: "+helloDO.getName());
		helloWorldService.addHello(helloDO);
		return helloDO.getId();
	}

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
		System.out.println("Hello World!");
	}
}
