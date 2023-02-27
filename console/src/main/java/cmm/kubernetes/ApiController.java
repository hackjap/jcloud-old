package cmm.kubernetes;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class ApiController {

    private final ApiService apiService;

    @GetMapping("/pods")
    public List<PodDto> getPods() {
        return apiService.getResource(RestApiUtil.RESOURCE_TYPE_POD);
    }
}
