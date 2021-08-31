package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


@Component
public class OrderServiceImpl implements OrderService{

    /*
    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 금액
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();  // 비율 할인 금액
    // 이부분이 DIP 와 OCP 위반 그래서
    private DiscountPolicy discountPolicy;
    // 이 부분에 누군가 대신 구현 객체를 생성하고 주입해주어야 한다.
     */
    private final MemberRepository memberRepository;

    private final DiscountPolicy discountPolicy;


    @Autowired
    public OrderServiceImpl(MemberRepository memberRepository, DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member,itemPrice);

        return new Order(memberId,itemName,itemPrice,discountPrice);
    }

    // 테스트 용도

    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
