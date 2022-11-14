package com.luyenlaptrinh.templateproject.payload.request;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;


@Getter
@Setter
public class CreateEmployeeReq {
    @NotBlank
    private String name;

    @NotBlank
    private String email;

    @NotBlank
    private String gender;
}
