package net.codejava.config;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import net.codejava.dao.ClothingDAO;
import net.codejava.dao.ClothingDAOImpl;
import net.codejava.dao.ProductDAO;
import net.codejava.dao.ProductDAOImpl;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "net.codejava")

public class SpringMvcConfig implements WebMvcConfigurer {

	@Bean

	public DataSource getDataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost:3306/database1");
		dataSource.setUsername("root");
		dataSource.setPassword("rootpass");

		return dataSource;

	}

	@Bean

	public ViewResolver getViewResolver() {
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("WEB-INF/views/");
		resolver.setSuffix(".jsp");

		return resolver;
	}

	@Bean

	public ProductDAO getProductDAO() {
		return new ProductDAOImpl(getDataSource());

	}

	@Bean

	public ClothingDAO getClothingDAO() {
		return new ClothingDAOImpl(getDataSource());

	}

}
