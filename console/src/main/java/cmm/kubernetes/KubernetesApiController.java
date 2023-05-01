package cmm.kubernetes;

import freemarker.template.Template;
import freemarker.template.TemplateException;
import io.kubernetes.client.openapi.ApiClient;
import io.kubernetes.client.openapi.ApiException;
import io.kubernetes.client.openapi.Configuration;

import io.kubernetes.client.openapi.apis.AppsV1Api;
import io.kubernetes.client.openapi.models.V1Deployment;
import io.kubernetes.client.util.Config;
import io.kubernetes.client.util.KubeConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.Yaml;

import java.io.IOException;
import java.io.StringWriter;
import java.util.HashMap;

@RestController
public class KubernetesApiController {

    @Autowired
    private DeploymentRepository deploymentRepository;

    @GetMapping("/deployments")
    public String getDeployments() throws ApiException, IOException {
//        Iterable<Deployment>
        // 인증 정보 설정
        ApiClient client = Config.defaultClient();
        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjbk9iUnJFRVRmWHM2S0NneEdQM1p0ZlYzNEh0TTFxdFI4cE9TdHExbjQifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImRlZmF1bHQtdG9rZW4tcjl2c3oiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZGVmYXVsdCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6Ijg3YzJhOTFiLTMwN2QtNDE1Ny1hMGEwLTcxY2I1YTdjYzVjYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmRlZmF1bHQifQ.uKoa2lXxRAW88Meo2U3atMlcnbmE7ijqpM_jn-TnTHrwkT6RCH8ydHtFHoTODjb7Bs4utq_rjUZ6vk0Zk4kgF0FyA8Hj4QcOHG76uHom2F19WKwL9-7P5Y9wTYNInhX9jO2C6vfktmtouHe0AcjgUfjcgv0AZo0qdxZe2rAKgOusIl_4MROYh7kbSf1mMrqdTLHbisuivMsPYaKvTjrIsesm5a0Lm3_QNwwqWATnMsdo8Mg3OcAhUFA-4POJ6Op1rUhmX6Qsnb1jy0-pHzrrOJak9AUZ5tg8KbRVjCnVHk-M759QFpX23dTBikmIVw04fF6ms1u5Hexhk5PByN_q0Q";

        client.addDefaultHeader("Authorization", "Bearer " + token);
        Configuration.setDefaultApiClient(client);


        // 네임스페이스와 API 경로 설정
        String deploymentName = "scm-manager";
        String namespace = "default";
//        String apiPath = "/apis/apps/v1/namespaces" + namespace + "deployments";

        // API 경로를 사용하여 API 호출
        AppsV1Api api = new AppsV1Api();
        V1Deployment deployment = api.readNamespacedDeployment(deploymentName, namespace, null, null, null);

        Yaml yaml = new Yaml();
        String deploymentYaml = yaml.dump(deployment);

        System.out.println("*******YAML**********");
        System.out.println(deploymentYaml);

//        return deploymentRepository.findAll();
        return deploymentYaml;
    }

    @PostMapping("/deployments")
    public V1Deployment createDeployment(@RequestBody CreateDeploymentVo createDeploymentVo) throws IOException, TemplateException, ApiException {

        // Auth
        ApiClient client = Config.defaultClient();
        String token = "eyJhbGciOiJSUzI1NiIsImtpZCI6IjRjbk9iUnJFRVRmWHM2S0NneEdQM1p0ZlYzNEh0TTFxdFI4cE9TdHExbjQifQ.eyJpc3MiOiJrdWJlcm5ldGVzL3NlcnZpY2VhY2NvdW50Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9uYW1lc3BhY2UiOiJkZWZhdWx0Iiwia3ViZXJuZXRlcy5pby9zZXJ2aWNlYWNjb3VudC9zZWNyZXQubmFtZSI6ImRlZmF1bHQtdG9rZW4tcjl2c3oiLCJrdWJlcm5ldGVzLmlvL3NlcnZpY2VhY2NvdW50L3NlcnZpY2UtYWNjb3VudC5uYW1lIjoiZGVmYXVsdCIsImt1YmVybmV0ZXMuaW8vc2VydmljZWFjY291bnQvc2VydmljZS1hY2NvdW50LnVpZCI6Ijg3YzJhOTFiLTMwN2QtNDE1Ny1hMGEwLTcxY2I1YTdjYzVjYSIsInN1YiI6InN5c3RlbTpzZXJ2aWNlYWNjb3VudDpkZWZhdWx0OmRlZmF1bHQifQ.uKoa2lXxRAW88Meo2U3atMlcnbmE7ijqpM_jn-TnTHrwkT6RCH8ydHtFHoTODjb7Bs4utq_rjUZ6vk0Zk4kgF0FyA8Hj4QcOHG76uHom2F19WKwL9-7P5Y9wTYNInhX9jO2C6vfktmtouHe0AcjgUfjcgv0AZo0qdxZe2rAKgOusIl_4MROYh7kbSf1mMrqdTLHbisuivMsPYaKvTjrIsesm5a0Lm3_QNwwqWATnMsdo8Mg3OcAhUFA-4POJ6Op1rUhmX6Qsnb1jy0-pHzrrOJak9AUZ5tg8KbRVjCnVHk-M759QFpX23dTBikmIVw04fF6ms1u5Hexhk5PByN_q0Q";
        client.addDefaultHeader("Authorization", "Bearer " + token);
        Configuration.setDefaultApiClient(client);


        // Load freemarker template
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template.Configuration.VERSION_2_3_31);
        cfg.setClassForTemplateLoading(getClass(),"/templates");

        Template template = cfg.getTemplate("sample-deployment.ftlh");

        // Set Deployment parameters
        HashMap<String, Object> input = new HashMap<>();
        input.put("deploymentName", createDeploymentVo.getName());
        input.put("imageName", createDeploymentVo.getImageName());
        input.put("namespace", createDeploymentVo.getNamespace());
//        input.put("replicas", createDeploymentVo.getReplicas());

        StringWriter writer = new StringWriter();
        template.process(input, writer);
        String yamlString = writer.toString();

        // Create Deployment
        AppsV1Api appsV1Api = new AppsV1Api();
        Yaml yaml = new Yaml();


        V1Deployment deployment = appsV1Api.createNamespacedDeployment(
                createDeploymentVo.getNamespace(),
                yaml.loadAs(yamlString, V1Deployment.class),
                null,
                null,
                null
        );

        return deployment;

    }


}
