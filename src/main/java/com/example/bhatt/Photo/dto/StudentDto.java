package com.example.bhatt.Photo.dto;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Data
@AllArgsConstructor
public class StudentDto {
    private long id;
    private  String name;
    private byte age;
    private String email;

    public StudentDto(){}
}
