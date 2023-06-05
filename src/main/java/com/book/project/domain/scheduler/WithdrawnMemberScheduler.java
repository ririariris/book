package com.book.project.domain.scheduler;

import com.book.project.domain.Entity.WithdrawnMember;
import com.book.project.domain.Repository.WithdrawnMemberRepository;
import com.book.project.domain.Service.WithdrawnMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;

@Component
public class WithdrawnMemberScheduler {

    @Autowired
    private WithdrawnMemberService withdrawnMemberService;

    @Scheduled(cron = "0 0 0 * * *")
    public void checkAndProcessWithdrawnMembers() {
        // 현재 날짜와 시간을 가져오는 로직
        LocalDateTime currentDate = LocalDateTime.now();

        // 탈퇴 회원 테이블의 withdrawnDate가 현재 날짜와 같은 경우 삭제 처리
        List<WithdrawnMember> expiredWithdrawnMembers = withdrawnMemberService.getExpiredWithdrawnMembers(currentDate);
        for (WithdrawnMember withdrawnMember : expiredWithdrawnMembers) {
            withdrawnMemberService.deleteWithdrawnMember(withdrawnMember);
        }
    }
}
