package kr.ac.gwnu.gwnu_newbie.global.config;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
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
    public List<GroupedOpenApi> apis() {
        return List.of(
                createGroupedOpenApi("동아리 API", "/clubs/**"),
                createGroupedOpenApi("학사 일정 API", "/schedules/**")
        );
    }

    private GroupedOpenApi createGroupedOpenApi(String groupName, String... paths) {
        return GroupedOpenApi.builder()
                .group(groupName)
                .pathsToMatch(paths)
                .build();
    }
}
