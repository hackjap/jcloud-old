package inbox.singleton;

import inbox.AppConfig;
import inbox.member.MemberSerivce;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class SingletonTest {


    @Test
    @DisplayName("pure Container")
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        MemberSerivce memberService1 = appConfig.memberSerivce();

        MemberSerivce memberService2 = appConfig.memberSerivce();

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isNotSameAs(memberService2);

    }

    @Test
    @DisplayName("Singleton Pattern Object")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

        // same ==
        // equal


    }
}
