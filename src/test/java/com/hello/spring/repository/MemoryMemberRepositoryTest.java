//package com.hello.spring.repository;
//
//import com.hello.spring.domain.Member;
//import org.junit.jupiter.api.AfterEach;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//// 다른 곳에 가져다 쓸 것이 아니기 때문에 public일 필요가 없다.
//class MemoryMemberRepositoryTest {
//
//    MemoryMemberRepository repository = new MemoryMemberRepository();
//
//    @AfterEach
//    public void afterEach() {
//        repository.clearStore();
//    }
//
//    @Test
//    public void save() {
//        Member member = new Member();
//        member.setName("spring");
//
//        repository.save(member);
//
//        // 제대로 들어갔나 검증
//        Member result = repository.findById(member.getId()).get();
//
//        // member와 result가 똑같으면 참이다.
//        // System.out.println("result = " + (result == member));
//
//        // 테스트가 성공하면 아무것도 뜨지 않지만 테스트가 실패하면 실패했다고 뜬다.
////        Assertions.assertEquals(member, result);
//
//        // 요새 많이 쓰는 문법
//        assertThat(member).isEqualTo(result);
//    }
//
//    @Test
//    public void findByName() {
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        Member result = repository.findByName("spring1").get();
//
//        assertThat(result).isEqualTo(member1);
//    }
//
//    @Test
//    public void findAll() {
//        Member member1 = new Member();
//        member1.setName("spring1");
//        repository.save(member1);
//
//        Member member2 = new Member();
//        member2.setName("spring2");
//        repository.save(member2);
//
//        List<Member> result = repository.findAll();
//
//        assertThat(result.size()).isEqualTo(2);
//    }
//}
