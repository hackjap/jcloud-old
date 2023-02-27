package inbox.discount;


import inbox.member.Member;

public interface DiscountPolicy {

    /**
     *
     * @param member
     * @param price
     * @return
     */
    int discount(Member member, int price);
}
