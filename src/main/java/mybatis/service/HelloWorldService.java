package mybatis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import mybatis.model.HelloDO;
import mybatis.model.HelloMapper;

@Service("helloWorldService")
public class HelloWorldService {
	@Autowired
	private HelloMapper helloMapper;
	
	public void addHello(HelloDO helloDO) {
		// TODO Auto-generated method stub
		helloMapper.insert(helloDO);
	}
}
