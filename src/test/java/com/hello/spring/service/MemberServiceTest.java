package com.hello.spring.service;

import com.hello.spring.domain.Member;
import com.hello.spring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    @BeforeEach
    public void beforeEach() {
        // 같은 MemoryMemberRepository를 사용할 수 있도록 외부에서 넣어준다. = DI
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @Test
    void 회원가입() {
        //given
        Member member = new Member();
        member.setName("hello");

        //when
        Long saveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외() {
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        // try-catch로 예외를 확인하는 게 실무에서 잘 쓰이지 않음.
        // 터져야 하는 Exception, 어떤 메소드를 수행하다가 저 Exception이 터져야 하는지
//        assertThrows(IllegalStateException.class, () -> memberService.join(member2));

        // 아님 이렇게 작성한다.
        IllegalStateException e = assertThrows(IllegalStateException.class, () -> memberService.join(member2));
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try{
//            memberService.join(member2);
//            fail("예외가 발생해야 합니다.");
//        } catch(IllegalStateException e) {
//            // 위에서 예외가 발생해야 한다.
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
        //then
    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}