package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "review")
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idx",nullable = false)
    private Long idx;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookinfo_idx")
    private List<BookInfo> bookInfo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_idx")
    private Feed feed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "writer_idx")
    private Member member;

    // Getter and Setter methods
}