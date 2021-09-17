package com.example.LibraryOneToOne.Repository;

import com.example.LibraryOneToOne.ModelOrEntity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepo extends JpaRepository<Student,Integer> {
}
