package tr.iboss;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan("tr")
public class UrbaninfoApplication {

	public static void main(String[] args) {
		SpringApplication.run(UrbaninfoApplication.class, args);
	}
	
    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("urbaninfo")
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("tr"))
                .paths(PathSelectors.any())
                .build()
                .pathMapping("/urbaninfo/v1");
    }
     
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Urban Information System API")
//                .description("Spring REST Sample with Swagger")
                .contact("Ibrahim Saricicek")
                .build();
    }
}
