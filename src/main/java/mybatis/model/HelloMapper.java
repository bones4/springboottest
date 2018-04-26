package mybatis.model;

import org.springframework.stereotype.Repository;

@Repository(value="helloMapper")
public interface HelloMapper {
	public void insert(HelloDO hello);
}
