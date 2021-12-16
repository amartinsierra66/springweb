package config;

import javax.naming.NamingException;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jndi.JndiObjectFactoryBean;

@Configuration
public class ConfigData {
	
	@Bean("data1")	
	public DataSource dataSource1(@Value("${jndi-name1}") String jndi) throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean(); 
		bean.setJndiName(jndi);
		bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
	    return (DataSource)bean.getObject();
	}

	@Bean("data2")	
	public DataSource dataSource2(@Value("${jndi-name2}") String jndi2) throws IllegalArgumentException, NamingException {
		JndiObjectFactoryBean bean = new JndiObjectFactoryBean(); 
		bean.setJndiName(jndi2);
		bean.setProxyInterface(DataSource.class);
        bean.setLookupOnStartup(false);
        bean.afterPropertiesSet();
	    return (DataSource)bean.getObject();
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
