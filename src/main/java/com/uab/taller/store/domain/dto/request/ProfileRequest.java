package com.uab.taller.store.domain.dto.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.Date;

@Getter
@Setter
public class ProfileRequest {
    String name;
    String lastName;
    @JsonFormat(pattern = "yyyy-MM-dd")
    Date birthDate;
    boolean gender;
}
