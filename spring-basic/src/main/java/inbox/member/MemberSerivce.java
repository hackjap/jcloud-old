package inbox.member;

public interface MemberSerivce {
    void join(Member member);

    Member findMember(Long memberId);

}
