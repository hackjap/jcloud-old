1. DI(Dependency Injection)
'''
private final MemberRepository memberRepository = new MemoryMemberRepository();
//    private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
'''

- OrderServiceImpl의 소스를 고쳐야함 ->  DiscountPolicy(인터페이스) 뿐만 아니라 FixDiscountPolicy(구현체)까지 의존
- DIP 위반
- OCP 위반


인터페이스
 카드  
구현체 
 신분증
 운전면혀증

[ 스프링 컨테이너 ]
ApplicationContext = 스프링 컨테이너 
스프링 컨테이너에 등록된 객체를 "스프링 빈" 이라고 힘