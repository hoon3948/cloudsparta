package kr.spartaclub.cloudsparta.member.repository;

import kr.spartaclub.cloudsparta.member.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
    Optional<Member> findById(Long id);
    boolean existsById(Long id);
}
