package com.book.project.domain.Repository;

import com.book.project.domain.Entity.WithdrawnMember;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface WithdrawnMemberRepository extends JpaRepository<WithdrawnMember, Long> {
    WithdrawnMember save(WithdrawnMember withdrawnMember);

    List<WithdrawnMember> findByWithdrawnDateBeforeOrWithdrawnDateEquals(LocalDateTime currentDate, LocalDateTime currentDate2);


    void deleteById(String withdrawnMember);
}

