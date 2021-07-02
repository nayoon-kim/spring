package com.hello.spring;

import com.hello.spring.aop.TimeTraceAop;
import com.hello.spring.repository.JdbcTemplateMemberRepository;
import com.hello.spring.repository.JpaMemberRepository;
import com.hello.spring.repository.MemberRepository;
//import com.hello.spring.repository.MemoryMemberRepository;
import com.hello.spring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.persistence.EntityManager;
import javax.sql.DataSource;

@Configuration
public class SpringConfig {

//    JdbcTemplate 사용 시
//    private final DataSource dataSource;
//
//    public SpringConfig(DataSource dataSource) {
//        this.dataSource = dataSource;
//    }

//    JPA 사용 시
//    private EntityManager em;
//    @Autowired
//    public SpringConfig(EntityManager em) {
//        this.em = em;
//    }

//  spring-data-jpa 사용 시
//  스프링 데이터 JPA는 JpaRepository를 보면 자동으로 빈을 생성하기 때문에 따로 생성해줄 필요가 없다.
    private final MemberRepository memberRepository;
    @Autowired
    public SpringConfig(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }
    @Bean
    public MemberService memberService() {
//        return new MemberService(memberRepository());
        return new MemberService(memberRepository);
    }

//    @Bean
//    public MemberRepository memberRepository() {
////        return new MemoryMemberRepository();
////        return new JdbcTemplateMemberRepository(dataSource);
//        return new JpaMemberRepository(em);
//    }

//    @Bean
//    public TimeTraceAop timeTraceAop() {
//        return new TimeTraceAop();
//    }
}
