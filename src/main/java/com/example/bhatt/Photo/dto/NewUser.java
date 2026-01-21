package com.example.bhatt.Photo.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Data

public class NewUser {
    private  String name;
    private byte age;
    @Email
    @NotBlank(message = "email cannot be null")
    private String email;
}
