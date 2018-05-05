package com.zhan.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 *  http://localhost:8080/swagger-ui.html
 * Created by zhanyanjun on 2018/5/4.
 */
@Configuration
@EnableSwagger2
public class Swagger2 {

    /**
     * 创建API应用
     * apiInfo() 增加API相关信息
     * 通过select()函数返回一个ApiSelectorBuilder实例,用来控制哪些接口暴露给Swagger来展现，
     *
     * @return
     */
    @Bean
    public Docket config() {
        /*ApiInfo apiInfo = new ApiInfo("sample of springboot", "sample of springboot", null,
                null, null, null, null);*/
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .useDefaultResponseMessages(false)
                .select()
//                .paths(regex("/user/.*")).build()
                .apis(RequestHandlerSelectors.basePackage("com.zhan.swagger.controllers"))
                .build();
        return docket;
    }

    /**
     * 创建该API的基本信
     * 访问地址：http://项目实际地址/swagger-ui.html
     * @return
     */
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("swagger 测试")
                .description("swagger 测试")
//                .termsOfServiceUrl("")
                .contact("zhan")
                .version("1.0")
                .build();
    }

}
