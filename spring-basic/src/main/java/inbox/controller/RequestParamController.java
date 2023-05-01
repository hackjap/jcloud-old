package inbox.controller;


import inbox.HelloData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@Slf4j
@Controller
public class RequestParamController {

    @RequestMapping("/request-param-v1")
    public void requestParamV1(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));
        System.out.println("age = " + age);
        System.out.println("username = " + username);

        response.getWriter().write("ok");
    }

    @ResponseBody
    @RequestMapping("/request-param-v2")
    public String requestParamV2(
            @RequestParam("username") String memberName,
            @RequestParam("age") int memberAge) {

        System.out.println("memberName = " + memberName);
        System.out.println("age = " + memberAge);
        return "OK";
    }

    /**
     * 파라미터 변수명이 같을 경우 생략 가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v3")
    public String requestParamV3(
            @RequestParam String username,
            @RequestParam int age) {

        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "OK";
    }


    /**
     * String,int,Integer 등 단순 타입이면 @RequestParam도 생략가능
     */
    @ResponseBody
    @RequestMapping("/request-param-v4")
    public String requestParamV4(String username, int age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "OK";
    }

    /**
     * required = true가 Default 설정.
     * Null 처리를 위해 int -> Integer
     */
    @ResponseBody
    @RequestMapping("/request-param-required")
    public String requestParamRequired(
            @RequestParam(required = true) String username,
            @RequestParam(required = false) Integer age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/request-param-default")
    public String requestParamDefault(
            @RequestParam(defaultValue = "guest") String username,
            @RequestParam(defaultValue = "-1") Integer age) {
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        return "OK";
    }

    /**
     * Map으로 파라미터 받기 ( MultiValueMap도 가능)
     */
    @ResponseBody
    @RequestMapping("/request-param-map")
    public String requestParamMap(@RequestParam Map<String, Object> paramMap) {

        System.out.println("username = " + paramMap.get("username"));
        System.out.println("age = " + paramMap.get("age"));
        return "OK";
    }

    @ResponseBody
    @RequestMapping("/model-attribute-v0")
    public String modelAttributeV0(@RequestParam String username, @RequestParam int age) {
        HelloData helloData = new HelloData();
        helloData.setUsername(username);
        helloData.setAge(age);

        System.out.println("helloData = " + helloData.toString());
        return "OK";
    }

    // @ModelAttribute 을 통해 객체 생성 자동화
    @ResponseBody
    @RequestMapping("/model-attribute-v1")
    public String modelAttributeV1(@ModelAttribute HelloData helloData) {

        System.out.println("helloData = " + helloData.toString());
        return "OK";
    }

    /**
     * @ModelAttribute 생략 가능
     * String , int , Integer 같은 단순 타입 = @RequestParam
     * 나머지 = @ModelAttribute (argument resolver 로 지정해둔 타입 외)
     */
    @ResponseBody
    @RequestMapping("/model-attribute-v2")
    public String modelAttributeV2(HelloData helloData) {
        System.out.println("helloData = " + helloData.toString());
        return "OK";
    }
}
