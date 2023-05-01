package inbox.controller;

import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
public class MappingController {


    @RequestMapping(value = "/mapping-get-v1", method = RequestMethod.GET)
    public String mappingGetV1() {
        return "OK";
    }

    @GetMapping("/mapping-get-v2")
    public String mappingGetV2() {
        return "OK";
    }

    /**
     * PathVariable 사용
     * 변수명이 같으면 생략 가능
     * @PathVariable("userId) Stirng userId -> @PathVariable userId
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable("userId") String userId,@PathVariable Long orderId) {
        System.out.println("data = " + userId + " "+  orderId);
        return " OK";
    }
}
