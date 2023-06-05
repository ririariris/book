package com.book.project.domain.Repository;

import com.book.project.domain.Entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
@Repository
public interface UserRepository extends JpaRepository<Member, Integer> {
    Member findById(String id);
    Member save(Member member);
    boolean existsById(String id);
    void deleteById(String id);
}
