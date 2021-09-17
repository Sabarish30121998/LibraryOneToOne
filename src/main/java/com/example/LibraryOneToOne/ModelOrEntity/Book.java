package com.example.LibraryOneToOne.ModelOrEntity;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity

@Getter
@Setter
@Data
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "bookid")
    private int bookid;

    @Column(name = "bookname")
    private String bookname;

    @Column(name = "authorname")
    private String authorname;

    @Column(name = "pages")
    private int pages;

/*    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "book")
    //@JoinColumn(name = "studentid")
    private Student student;*/
}
