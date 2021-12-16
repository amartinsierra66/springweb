package config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;

@Configuration
public class ConfigData {
	@Bean("data1")	
	@ConfigurationProperties(prefix="spring.datasource")
	public DataSource dataSource1() {
	    return DataSourceBuilder.create().build();
	}

	@Bean("data2")
	@ConfigurationProperties(prefix="spring.datasource2")
	public DataSource dataSource2() {
	    return DataSourceBuilder.create().build();
	}
	
	@Bean("template1")
	@Autowired
	public JdbcTemplate template1(@Qualifier("data1") DataSource ds) {
		
		JdbcTemplate tmp=new JdbcTemplate(ds);
		
		return tmp;
	}
	@Bean("template2")
	public JdbcTemplate template2(@Qualifier("data2") DataSource ds) {
		
		JdbcTemplate tmp=new JdbcTemplate(ds);
		
		return tmp;
	}
}
