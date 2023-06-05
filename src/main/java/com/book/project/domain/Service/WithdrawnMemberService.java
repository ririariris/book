package com.book.project.domain.Service;

import com.book.project.domain.Entity.WithdrawnMember;
import com.book.project.domain.Repository.WithdrawnMemberRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class WithdrawnMemberService {
    private final WithdrawnMemberRepository withdrawnMemberRepository;

    public WithdrawnMemberService(WithdrawnMemberRepository withdrawnMemberRepository) {
        this.withdrawnMemberRepository = withdrawnMemberRepository;
    }
    @Transactional
    public WithdrawnMember saveWithdrawnMember(WithdrawnMember withdrawnMember) {
        return withdrawnMemberRepository.save(withdrawnMember);
    }

    public List<WithdrawnMember> getExpiredWithdrawnMembers(LocalDateTime currentDate) {
        return withdrawnMemberRepository.findByWithdrawnDateBeforeOrWithdrawnDateEquals(currentDate, currentDate);
    }


    @Transactional
    public void deleteWithdrawnMember(WithdrawnMember withdrawnMember) {
        withdrawnMemberRepository.deleteById(withdrawnMember.getId());
    }
}
