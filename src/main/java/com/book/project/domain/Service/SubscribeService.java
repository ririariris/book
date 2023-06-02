package com.book.project.domain.Service;

import com.book.project.domain.Entity.Subscribe;
import com.book.project.domain.Entity.Member;
import jakarta.persistence.EntityManager;
import jakarta.persistence.NoResultException;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SubscribeService {
    @PersistenceContext
    private EntityManager entityManager;

    public void saveSubscription(Subscribe subscribe) {
        entityManager.persist(subscribe);

        // 회원 테이블의 confirm 값을 업데이트
        Member member = subscribe.getMember();
        member.setConfirm(subscribe.getConfirm());
        entityManager.merge(member);
    }

    public List<Subscribe> getExpiredSubscriptions(LocalDateTime currentDate) {
        return entityManager.createQuery("SELECT s FROM Subscribe s WHERE s.endDate <= :currentDate", Subscribe.class)
                .setParameter("currentDate", currentDate)
                .getResultList();
    }

    public Subscribe getSubscriptionByMemberId(Long memberId) {
        try {
            return entityManager.createQuery("SELECT s FROM Subscribe s WHERE s.member.idx = :memberId", Subscribe.class)
                    .setParameter("memberId", memberId)
                    .getSingleResult();
        } catch (NoResultException e) {
            return null; // 구독 정보가 없는 경우 null 반환
        }
    }


}
