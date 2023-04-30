package cmm.kubernetes;


import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Map;

@Component
@RequiredArgsConstructor
public class RestApiUtil {

    @Value("${config.kubernetes.clusters.url}")
    private String API_SERVER;

    @Value("${config.kubernetes.clusters.token}")
    private String API_TOKEN;

    private final RestTemplate restTemplate;

    public static  final  String API_URL = "/api/v1/";
//
    public static final String API2_URL = "/apis/apps/v1/";

    public static final String RESOURCE_TYPE_POD = "pods";
    public static final String RESOURCE_TYPE_DEPLOYMENT = "deployments";
    public static final String RESOURCE_TYPE_NODE = "nodes";


    public ResponseEntity execute(HttpMethod httpMethod, String resourceType, String apiUrl) {

        String url = API_SERVER + apiUrl + resourceType;

        HttpHeaders headers = new HttpHeaders();
        headers.setBearerAuth(API_TOKEN);
        headers.setContentType(MediaType.APPLICATION_JSON);

        HttpEntity httpEntity = new HttpEntity(headers);

        return restTemplate.exchange(url, httpMethod, httpEntity, Map.class);
    }

}
