package SafePlace.Safeplace;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.vendor.Database;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

@Configuration
public class DataConfiguration {
	
	@Bean
	public DataSource dataSource() {
		
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		
		dataSource.setDriverClassName("org.postgresql.Driver");
		
		dataSource.setUrl("jdbc:postgresql://ec2-3-216-221-31.compute-1.amazonaws.com/dp5ju1u9jcl1r"
				+ "");
		dataSource.setUsername("fjhcgulfigzokx");
		dataSource.setPassword("c19302fc85ef058c9c911d036c4ef4571ddd7673d547122aead57530c3cd7d55");
		return  dataSource;
		
		
	}
	
	@Bean
	public JpaVendorAdapter jpaVendorAdapter() {
		
		HibernateJpaVendorAdapter adapter = new HibernateJpaVendorAdapter();
		adapter.setDatabase(Database.POSTGRESQL);
		adapter.setShowSql(true);
		adapter.setGenerateDdl(true);
		adapter.setDatabasePlatform("org.hibernate.dialect.PostgreSQLDialect");
		adapter.setPrepareConnection(true);
		return adapter;
		
	}
	

}
