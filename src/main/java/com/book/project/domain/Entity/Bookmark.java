package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
@Entity
@Table(name = "bookmark")
public class Bookmark {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx",nullable = false)
    private Long idx;

    @Column(name = "bookinfo")
    private Integer bookinfo;

    @ManyToOne
    @JoinColumn(name = "member_id") // Replace "member_id" with the actual foreign key column name
    private Member member;

}