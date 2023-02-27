package inbox.order;

import inbox.AppConfig;
import inbox.member.Grade;
import inbox.member.Member;
import inbox.member.MemberSerivce;
import inbox.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class OrderServiceTest {
    AppConfig appConfig = new AppConfig();

    MemberSerivce memberSerivce = appConfig.memberSerivce();
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