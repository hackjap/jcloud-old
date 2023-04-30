package cmm.kubernetes;


import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpMethod;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
@Transactional
@RequiredArgsConstructor
public class ApiService {

    private final  RestApiUtil restApiUtil;

    public List getPodResource(String resourceType,String API_URI) {
        Map response = (Map) restApiUtil.execute(HttpMethod.GET, resourceType,API_URI).getBody();

        List<Map> items = (List) response.get("items");

        return items.stream()
                .map(item -> {
                    Map metadata = (Map) item.get("metadata");
                    String name = (String) metadata.get("name");
                    String namespace =  (String) metadata.get("namespace");
                    Map status = (Map) item.get("status");
                    String phase = (String) status.get("phase");

                    return PodDto.builder()
                            .name(name)
                            .status(phase)
                            .namespace(namespace)
                            .build();

                })
                .collect(Collectors.toList());
    }
    public List getDeployResource(String resourceType,String API_URI) {
        Map response = (Map) restApiUtil.execute(HttpMethod.GET, resourceType,API_URI).getBody();

        List<Map> items = (List) response.get("items");

        return items.stream()
                .map(item -> {
                    Map metadata = (Map) item.get("metadata");
                    String name = (String) metadata.get("name");
                    String namespace =  (String) metadata.get("namespace");
                    Map status = (Map) item.get("status");
                    int replicas = (int) status.get("replicas");

                    return DeploymentDto.builder()
                            .name(name)
                            .replicas(replicas)
                            .namespace(namespace)
                            .build();

                })
                .collect(Collectors.toList());
    }
    public List getNodeResource(String resourceType,String API_URI) {
        Map response = (Map) restApiUtil.execute(HttpMethod.GET, resourceType,API_URI).getBody();

        List<Map> items = (List) response.get("items");

        return items.stream()
                .map(item -> {
                    Map metadata = (Map) item.get("metadata");
                    String name = (String) metadata.get("name");
                    Map status = (Map) item.get("status");
                    // Node Address

                    List<Map> addresses = (List) status.get("addresses");

//                    ArrayList addresses =  (ArrayList) status.get("addresses");
                    String address = (String) addresses.get(0).get("address");


                    List<Map> conditions =  (List) status.get("conditions");
                    String type = (String) conditions.get(4).get("type");

                    return NodeDto.builder()
                            .name(name)
                            .status(type)
                            .address(address)
                            .build();

                })
                .collect(Collectors.toList());
    }
}
