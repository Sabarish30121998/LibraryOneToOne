package com.example.LibraryOneToOne.Controller;

import com.example.LibraryOneToOne.BaseResponse.BaseResponse;
import com.example.LibraryOneToOne.DTO.GeneralDTO;
import com.example.LibraryOneToOne.ModelOrEntity.Student;
import com.example.LibraryOneToOne.Repository.BookRepo;
import com.example.LibraryOneToOne.Repository.StudentRepo;
import com.example.LibraryOneToOne.Service.CRUDservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/onetoone")
public class CRUDcontroller {

    @Autowired
    CRUDservice crudservice;

    @Autowired
    BookRepo bookRepo;

    @Autowired
    StudentRepo studentRepo;



    @PostMapping("/insert")
    public BaseResponse insert(@RequestBody GeneralDTO generalDTO)
    {

        BaseResponse insert = crudservice.insert(generalDTO);
        return insert;
    }
    @GetMapping("/get")
    public Iterable<Student> get()
    {
        List<Student> sabari =studentRepo.findAll();
        return sabari;
    }

    @GetMapping("/getbyid/{studentid}")
    public Optional getbyid(@PathVariable int studentid)
    {
        return crudservice.getbyid(studentid);
    }

    @DeleteMapping("/deletebyid/{studentid}")
    public BaseResponse deletebyid(@PathVariable int studentid)
    {
        return crudservice.deletebyid(studentid);
    }

    @PutMapping("/put")
    public BaseResponse put(@RequestBody GeneralDTO generalDTO)
    {
        return crudservice.put(generalDTO);
    }

}
