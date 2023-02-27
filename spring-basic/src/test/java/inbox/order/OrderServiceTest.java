package inbox.order;

import inbox.AppConfig;
import inbox.member.Grade;
import inbox.member.Member;
import inbox.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();

    MemberService memberSerivce = appConfig.memberService();
    OrderService orderService = appConfig.orderService();

    @Test
    void createOrder() {
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberSerivce.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(10000);

    }



}