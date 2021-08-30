package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.Order;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {

    public static void main(String[] args) {

        //2AppConfig appConfig = new AppConfig();
        //2MemberService memberService = appConfig.memberService();
        //2OrderService orderService = appConfig.orderService();

        //1MemberService memberService = new MemberServiceImpl();
        //1OrderService orderService = new OrderServiceImpl(memberRepository, discountPolicy);

        ApplicationContext ap = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ap.getBean("memberService",MemberService.class);
        OrderService orderService = ap.getBean("orderService",OrderService.class);
        Long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "item1", 20000);

        System.out.println("order = " + order);
        System.out.println("calculatePrice = " + order.calculatePrice());

    }
}
