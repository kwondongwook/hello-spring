package com.example.demo.repository;

import com.example.demo.domain.Member;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    void beforeEach() {
        memoryMemberRepository = new MemoryMemberRepository();
    }

    @AfterEach
    void afterEach() {
        memoryMemberRepository.clearStore();
    }

    @Test
    void save() {
        Member member = new Member();

        memoryMemberRepository.save(member);

        Member result = memoryMemberRepository.findById(member.getId()).get();
        assertThat(result).isEqualTo(member);
    }

    @Test
    void findByName() {
        Member member1 = new Member();
        member1.setName("member1");
        memoryMemberRepository.save(member1);

        Member member2 = new Member();
        member2.setName("member2");
        memoryMemberRepository.save(member2);

        Member result = memoryMemberRepository.findByName(member1.getName()).get();

        assertThat(result).isEqualTo(member1);
    }

    @Test
    void findAll() {
        memoryMemberRepository.save(new Member());
        memoryMemberRepository.save(new Member());

        List<Member> result = memoryMemberRepository.findAll();

        assertThat(result.size()).isEqualTo(2);
    }
}
