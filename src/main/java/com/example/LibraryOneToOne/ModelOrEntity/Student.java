package com.example.LibraryOneToOne.ModelOrEntity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.transaction.Transactional;

@Entity
@Data
@Getter
@Setter
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "studentid")
    private int studentid;

    @Column(name = "name")
    private String name;

    @Column(name = "city")
    private String city;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "foreignkeybookid")
    private Book foreignkeybookid;

/*    @OneToOne(fetch = FetchType.EAGER,cascade = CascadeType.ALL)
    @JoinColumn(name = "bookid")
    private Book book;*/
}
