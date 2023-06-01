package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "subscribe")
public class Subscribe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name="idx",nullable = false)
    private Long idx;

    @Column(name = "confirm")
    private Boolean confirm;

    @Column(name="endDate")
    private LocalDateTime endDate;

    @Column(name="startDate")
    private LocalDateTime startDate;


    @OneToOne
    @JoinColumn(name = "member_idx")
    private Member member;

    //Subscribe table, idx의 confirm 값을 변경할시 member idx, confirm도 같이수정
    public void setConfirm(Boolean confirm) {
        this.confirm = confirm;
        if (member != null) {
            try {
                member.setConfirm(confirm ? 1 : 0);
            } catch (Exception e) {
                // 예외 처리 로직 작성
                e.printStackTrace();
            }
        }
    }
}