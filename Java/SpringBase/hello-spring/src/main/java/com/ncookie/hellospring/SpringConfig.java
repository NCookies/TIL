package com.ncookie.hellospring;

import com.ncookie.hellospring.repository.MemberRepository;
import com.ncookie.hellospring.repository.MemoryMemberRepository;
import com.ncookie.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringConfig {

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

}
