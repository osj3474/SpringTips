package me.sangjin.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableSwagger2
@Configuration
public class SwaggerConfig {     // URL/swagger-ui 으로 접근

    public static final String BASE_PACKAGE = "me.sangjin.swagger.api";

    public static final String HOME = "홈화면 API";
    public static final String HOME_DESCRIPTION = "메인기능, 메뉴관리 기능들";

    @Bean
    public Docket api() {   // swagger 설정 Bean (함수명은 마음대로 가능)
        return new Docket(DocumentationType.SWAGGER_2)
                .select()   // builder 생성
                .apis(RequestHandlerSelectors.basePackage(BASE_PACKAGE))  // Controller가 존재하는 패키지를 설정
                .paths(PathSelectors.any())  // PathSelectors로 RequestHandlers 선택. any()는 가능한 모든 API를 의미.
                .build()
                .apiInfo(metadata())   // 문서 정보를 입력할 수 있음. 지금은 아래 메서드 만든거 호출해서 사용.
                .tags(new Tag(HOME, HOME_DESCRIPTION));   // Tag(이름, 설명) 으로 생성하는 거고, Controller에 Tag이름을 설정할 수 있음. (여러개 가능)
    }

    private ApiInfo metadata() {
        return new ApiInfoBuilder()
                .title("Sangjin SERVER API")
                .description("백엔드 API 서버 설명~~~")
                .version("1.2.0")
                .build();
    }
}
