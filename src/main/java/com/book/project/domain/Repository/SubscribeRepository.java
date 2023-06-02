package com.book.project.domain.Repository;


import com.book.project.domain.Entity.Subscribe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface SubscribeRepository extends JpaRepository<Subscribe, Long> {
    List<Subscribe> findByEndDateLessThanEqual(LocalDateTime currentDate);
    Subscribe findByMemberIdx(Long memberId);

    Subscribe save(Subscribe subscribe);
}