package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * 描述：Swagger2构建RESTful API文档<br>
 * 作者：dolojia <br>
 * 修改日期：2017年6月11日上午10:33:50 <br>
 * E-mail: dolojia@gmail.com<br>
 */
@Configuration
@EnableSwagger2
public class Swagger2 {
	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("com.example.demo")).paths(PathSelectors.any()).build()
				.host("localhost:8011");// swagger环境配置host
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("spring-boot-demo").description("使用Swagger2构建RESTful风格API文档").version("1.0")
				.build();
	}
}
