package inbox;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class HelloApplication {
    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
//        MemberSerivce memberService = applicationContext.getBean("memberService", MemberSerivce.class);
//        memberService.join();



    }
}
