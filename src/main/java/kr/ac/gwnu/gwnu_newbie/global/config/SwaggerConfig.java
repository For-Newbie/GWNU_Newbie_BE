package kr.ac.gwnu.gwnu_newbie.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.models.Components;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.security.SecurityRequirement;
import io.swagger.v3.oas.models.security.SecurityScheme;
import org.springdoc.core.models.GroupedOpenApi;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

@OpenAPIDefinition(
        info = @Info(title = "GWNU Newbie",
                description = "GWNU Newbie API 문서",
                version = "0.0.1"))
@Configuration
public class SwaggerConfig {

    @Bean
    public OpenAPI openAPI() {
        SecurityRequirement securityRequirement = new SecurityRequirement().addList("JWT");
        Components component = new Components().addSecuritySchemes("JWT", new SecurityScheme()
                .name("JWT")
                .type(SecurityScheme.Type.HTTP)
                .scheme("Bearer")
                .bearerFormat("JWT")
                .description("토큰의 Bearer 제외한 내용 입력")
        );

        return new OpenAPI()
                .components(new Components())
                .addSecurityItem(securityRequirement)
                .components(component);
    }

    @Bean
    public List<GroupedOpenApi> apis() {
        return List.of(
                createGroupedOpenApi("동아리 API", "/clubs/**"),
                createGroupedOpenApi("학사 일정 API", "/schedules/**"),
                createGroupedOpenApi("졸업 이수 API", "/graduates/**"),
                createGroupedOpenApi("게시글 API", "/posts/**"),
                createGroupedOpenApi("댓글 API", "/comments/**"),
                createGroupedOpenApi("유저 API", "/users/**")
        );
    }

    private GroupedOpenApi createGroupedOpenApi(String groupName, String... paths) {
        return GroupedOpenApi.builder()
                .group(groupName)
                .pathsToMatch(paths)
                .build();
    }
}
