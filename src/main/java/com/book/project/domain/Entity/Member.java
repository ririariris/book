package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Entity
@Table(name = "member")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx",nullable = false)
    private Long idx;

    @Column(name="id")
    private String id;

    @Column(name="pw")
    private String pw;

    @Column(name="name")
    private String name;

    @Column(name="likeIdx")
    private Integer likeIdx;

    @Column(name="confirm")
    private Boolean confirm;

    @OneToOne(mappedBy = "member", cascade = CascadeType.ALL)
    private Subscribe subscribe;

    public boolean isConfirm() {
        return Boolean.TRUE.equals(confirm);
    }

}