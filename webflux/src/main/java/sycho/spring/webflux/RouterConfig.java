package sycho.spring.webflux;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.server.*;

/**
 * MVC의 Controller 역할 인듯?
 */
@Configuration
public class RouterConfig {
    @Bean
    public RouterFunction<ServerResponse> route(WebfluxHandler handler) {
        return RouterFunctions.route(
                RequestPredicates.GET("/hello").and(RequestPredicates.accept(MediaType.TEXT_PLAIN)), handler::helloWorld
        );
    }
}
