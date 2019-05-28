package com.etoos.study.config;

import java.io.IOException;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.io.FileSystemResource;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@EnableWebMvc
@ComponentScan(basePackages= {"com.etoos.study.controller", "com.etoos.study.exception"})
public class ServletConfig implements WebMvcConfigurer{
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		
		InternalResourceViewResolver bean = new InternalResourceViewResolver();
			bean.setViewClass(JstlView.class);
			bean.setPrefix("/WEB-INF/views/");
			bean.setSuffix(".jsp");
			registry.viewResolver(bean);
	}
	
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
	}
	
	@Bean(name = "multipartResolver")
	public CommonsMultipartResolver getResolver() throws IOException {
		CommonsMultipartResolver resolver = new CommonsMultipartResolver();
		
		//10MB - Request로 전달될 수 있는 최대의 크기
		resolver.setMaxUploadSize(1024 * 1024* 10);
		
		//2MB - 하나의 파일 최대 크기
		resolver.setMaxUploadSizePerFile(1024 * 1024 * 2);
		
		//1MB - 메모리상에서 유지하는 최대 크기
		resolver.setMaxInMemorySize(1024 * 1024);
		
		//temp upload - 임시 File의 형태로 보관
		resolver.setUploadTempDir(new FileSystemResource("C:\\upload\\tmp"));
		
		//한글깨지는것 방지
		resolver.setDefaultEncoding("UTF-8");
		
		return resolver;
		
	}
}
