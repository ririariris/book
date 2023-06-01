package com.book.project.domain.Entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "bookinfo")
public class BookInfo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="idx",nullable = false)
    private int idx;

    @Column(name="title",nullable = false)
    private String title;

    @Column(name="writer",nullable = false)
    private String writer;

    @Column(name="genre",nullable = false)
    private String genre;

    @Column(name="publisher" , nullable = false)
    private String publisher;

    @Column(name = "publication_date", nullable = false)
    private LocalDate publicationDate;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String poster;

    @Column(nullable = false, columnDefinition = "LONGTEXT")
    private String summary;

}