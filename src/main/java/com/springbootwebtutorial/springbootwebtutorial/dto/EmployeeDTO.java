package com.springbootwebtutorial.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.springbootwebtutorial.springbootwebtutorial.anotation.EmployeeRoleValidation;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeDTO {
    private Long id;

    @NotBlank(message = "Name can not be Blank")
    @Size(min = 2,max = 10, message = "Name should be in Range of 2 to 10 character")
    private String name;

    @NotBlank(message = "Email can not be Blank")
    @Email(message = "Email is not valid")
    private String email;

    @NotNull(message = "Can not be Blank")
    @Max(value = 60, message = "Bro You are Oldie")
    @Min(value = 20, message = "Bete tum abhi bache ho")
    private Integer age;

    @NotBlank(message = "Role can not be Blank")
//    @Pattern(regexp = "^(ADMIN|USER)&", message = "USER or ADMIN")
//    Custom Anotation
    @EmployeeRoleValidation
    private String role;

    @NotNull(message = "Cannot be Null")
    @PositiveOrZero(message = "Cannot be 0 or Negative")
    private Double salary;

    @NotNull
    @PastOrPresent(message = "Cannot be Future Date")
    private LocalDate dateOfJoining;

    @JsonProperty("isActive")
    private Boolean isActive;
}
