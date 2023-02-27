package inbox;

import inbox.discount.DiscountPolicy;
import inbox.discount.FixDiscountPolicy;
import inbox.discount.RateDiscountPolicy;
import inbox.member.MemberRepository;
import inbox.member.MemberSerivce;
import inbox.member.MemberServiceImpl;
import inbox.member.MemoryMemberRepository;
import inbox.order.OrderService;
import inbox.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    @Bean
    public MemberSerivce memberSerivce() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
//        return new FixDiscountPolicy();
    }
}
