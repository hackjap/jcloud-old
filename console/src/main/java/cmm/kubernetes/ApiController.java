//package cmm.kubernetes;
//
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequiredArgsConstructor
//@CrossOrigin("*")
//public class ApiController {
//
//    private final ApiService apiService;
//
//    @GetMapping("/pods")
//    public List<PodDto> getPods() {
//        return apiService.getPodResource(RestApiUtil.RESOURCE_TYPE_POD,RestApiUtil.API_URL);
//    }
//
//    @GetMapping("/deployments")
//    public List<DeploymentDto> getDeployments(){
//        return apiService.getDeployResource(RestApiUtil.RESOURCE_TYPE_DEPLOYMENT,RestApiUtil.API2_URL);
//    }
//
//    @GetMapping("/nodes")
//    public List<NodeDto> getNodes(){
//        return apiService.getNodeResource(RestApiUtil.RESOURCE_TYPE_NODE, RestApiUtil.API_URL);
//    }
//}
