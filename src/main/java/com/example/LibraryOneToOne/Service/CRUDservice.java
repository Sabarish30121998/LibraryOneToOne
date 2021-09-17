package com.example.LibraryOneToOne.Service;

import com.example.LibraryOneToOne.BaseResponse.BaseResponse;
import com.example.LibraryOneToOne.DTO.BookDTO;
import com.example.LibraryOneToOne.DTO.GeneralDTO;
import com.example.LibraryOneToOne.DTO.StudentDTO;
import com.example.LibraryOneToOne.ModelOrEntity.Book;
import com.example.LibraryOneToOne.ModelOrEntity.Student;
import com.example.LibraryOneToOne.Repository.BookRepo;
import com.example.LibraryOneToOne.Repository.StudentRepo;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@Service

public class CRUDservice {

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;

    public  BaseResponse insert(@RequestBody GeneralDTO generalDTO)
    {
        BaseResponse baseResponse= new BaseResponse();
        Book book = new Book();
        Student student = new Student();
        book.setBookname(generalDTO.getBookname());
        book.setAuthorname(generalDTO.getAuthorname());
        book.setPages(generalDTO.getPages());
        bookRepo.save(book);
        student.setName(generalDTO.getName());
        student.setCity(generalDTO.getCity());
        //        employee.setAddressId(address);
        student.setForeignkeybookid(book);
        studentRepo.save(student);
        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("Succesfully inserted the data in both Book Table and Student Table");
        baseResponse.setData(student);
       // baseResponse.setData(book);
        return baseResponse;
    }

    public Optional getbyid(int studentid) {
        BaseResponse baseResponse= new BaseResponse();
        Optional<Student> sabari = studentRepo.findById(studentid);
        return sabari;
    }

    public BaseResponse deletebyid(int studentid) {
        BaseResponse baseResponse= new BaseResponse();
        studentRepo.deleteById(studentid);

        baseResponse.setStatuscode("200");
        baseResponse.setStatusmessage("succesfully is deleted");
        return baseResponse;
    }


    public BaseResponse put(GeneralDTO generalDTO) {

        BaseResponse baseResponse = new BaseResponse();
        Book book= new Book();
        Student student = new Student();

        Optional<Student> sabari = studentRepo.findById(generalDTO.getStudentid());
        if(sabari.isPresent()) {
               // studentRepo.getById(generalDTO.getStudentid());

                sabari.get().setName(generalDTO.getName());
                sabari.get().setCity(generalDTO.getCity());
                sabari.get().setForeignkeybookid(book);

                student = studentRepo.save(student);

                book.setBookname(generalDTO.getBookname());
                book.setAuthorname(generalDTO.getAuthorname());
                book.setPages(generalDTO.getPages());
                book = bookRepo.save(book);

                baseResponse.setStatuscode("200");
                baseResponse.setStatusmessage("Updating  the data in both Book Table and Student Table using put operation");
                baseResponse.setData(student);
                // baseResponse.setData(book);
        }
        else {
            baseResponse.setStatuscode("100");
            baseResponse.setStatusmessage("DATA Not found");
        }

            return baseResponse;

    }
}
