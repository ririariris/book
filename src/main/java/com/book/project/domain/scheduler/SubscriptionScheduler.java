package com.book.project.domain.scheduler;

import com.book.project.domain.Entity.Subscribe;
import com.book.project.domain.Service.SubscribeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class SubscriptionScheduler {

    @Autowired
    private SubscribeService subscribeService;

    @Scheduled(cron = "0 0 0 * * *") // 매일 자정에 실행
    public void checkAndProcessSubscriptions() {
        // 현재 날짜와 시간을 가져오는 로직
        LocalDateTime currentDate = LocalDateTime.now();

        // 구독 테이블의 end_date가 현재 날짜와 같거나 이전인 경우에만 처리
        List<Subscribe> expiredSubscriptions = subscribeService.getExpiredSubscriptions(currentDate);
        for (Subscribe subscription : expiredSubscriptions) {
            subscription.setConfirm(false); // 구독 테이블의 confirm을 0으로 설정
            subscribeService.saveSubscription(subscription); // 구독 업데이트
        }
    }
}
