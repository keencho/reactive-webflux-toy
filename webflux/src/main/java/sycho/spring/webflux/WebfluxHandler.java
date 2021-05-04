package sycho.spring.webflux;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.*;

/**
 * MVC의 Service 역할 인듯?
 */
@Component
public class WebfluxHandler {

    private HashMap<Object, Object> result = new HashMap<>();
    private Mono<HashMap<Object, Object>> mapper = Mono.just(result);

    public Mono<ServerResponse> helloWorld(ServerRequest serverRequest) {
        result.put("number", 22123);
        result.put("text","nothing");
        mapper.subscribe(m -> {
            System.out.println(m.get("text"));
        });

        return ServerResponse
                .ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(BodyInserters.fromProducer(mapper, HashMap.class));
    }

}
