package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.List;


@Entity
@Table(name = "feed")
@Getter
@Setter
public class Feed {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx",nullable = false)
    private Long idx;

    @Column(name = "content", length = 255)
    private String content;

    @Column(name = "create_date")
    private LocalDateTime createDate;

    @Column(name = "likes")
    private Integer likes;

    @Column(name = "title", length = 255)
    private String title;

    @Column(name = "views")
    private Integer views;

    @Column(name = "writer", length = 255)
    private String writer;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinColumn(name = "bookinfo_idx")
    private List<BookInfo> bookInfo;


}