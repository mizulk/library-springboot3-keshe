package pers.mizulk.library.config;

import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import pers.mizulk.library.interceptor.JwtTokenInterceptor;

@Configuration
public class WebMvcConfiguration extends WebMvcConfigurationSupport {

	@Value("${static.images.realPath}")
	private String realPath;

	@Resource
	private JwtTokenInterceptor jwtTokenInterceptor;

	@Override
	protected void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(jwtTokenInterceptor)
				.addPathPatterns("/carts/**", "/comments/**", "/follows/**", "/likes/**", "/collections/**")
				.excludePathPatterns("/users/login", "/users/register");
	}

	@Override
	protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//		registry.addResourceHandler("/**").addResourceLocations("classpath:/static/"); // 将文件存储在resources中的static文件夹下
		registry.addResourceHandler("/**").addResourceLocations("file:" + realPath);
	}
}
