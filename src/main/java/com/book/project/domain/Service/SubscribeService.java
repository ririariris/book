package com.book.project.domain.Service;

import com.book.project.domain.Entity.Subscribe;
import com.book.project.domain.Entity.Member;
import com.book.project.domain.Repository.SubscribeRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@Transactional
public class SubscribeService {
    private final SubscribeRepository subscribeRepository;

    public SubscribeService(SubscribeRepository subscribeRepository) {
        this.subscribeRepository = subscribeRepository;
    }
    @Transactional
    public Subscribe saveSubscription(Subscribe subscribe) {


        // 회원 테이블의 confirm 값을 업데이트
        Member member = subscribe.getMember();
        member.setConfirm(subscribe.getConfirm());

        return subscribeRepository.save(subscribe);
    }


    public List<Subscribe> getExpiredSubscriptions(LocalDateTime currentDate) {
        return subscribeRepository.findByEndDateLessThanEqual(currentDate);
    }

    public Subscribe getSubscriptionByMemberId(Long memberId) {
        return subscribeRepository.findByMemberIdx(memberId);
    }
}

