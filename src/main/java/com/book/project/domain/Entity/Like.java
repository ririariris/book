package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Setter
@Table(name = "like")
public class Like {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx",nullable = false)
    private Long idx;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_idx")
    private Feed feed;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_idx")
    private Member member;

    // Constructors, getters, and setters
}