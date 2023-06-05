package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "withdrawn_member")
public class WithdrawnMember {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idx;

    private String id;

    private String pw;

    private String name;

    @Column(name = "like_idx")
    private Integer likeIdx;

    private boolean confirm;

    @Column(name = "withdrawn_date")
    private LocalDateTime withdrawnDate;

}
