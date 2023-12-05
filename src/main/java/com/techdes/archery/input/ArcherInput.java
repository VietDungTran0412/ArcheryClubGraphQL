package com.techdes.archery.input;
import com.techdes.archery.entity.enumeration.Gender;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
@Getter
@Setter
public class ArcherInput {
    @NotBlank
    private String firstname;
    @NotBlank
    private String lastname;
    @NotNull
    private Integer age;
    private Gender gender;
    @NotBlank
    private String phone;
    @NotBlank
    private String email;
    @NotBlank
    private String password;
}
