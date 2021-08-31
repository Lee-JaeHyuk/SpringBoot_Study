package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {

    //Bean memberService -> new MemoryMemberRepository()
    //Bean orderService -> new MemoryMemberRepository()
    // 이러면 싱글톤이 깨지는게 아닌가? 왜냐면 두번 호출하게 되니까까

   // 우선 메모리멤버를 쓸거면 메모리멤버 레파지토리에 new 부분을 지운다

    // call memberService -> memberRepository , memberRepository, orderService -> memberRepository : memberRepository 는 총 3번 호출되야 한다.
    // 근데 실제로는 call은 3번만 호출된다. why? 이게 바로 스프링 컨테이너

    @Bean
    public MemberRepository memberRepository(){
        System.out.println("Call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy(){
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    @Bean
    public MemberService memberService(){
        System.out.println("Call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public OrderService orderService(){
        System.out.println("Call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }



}
