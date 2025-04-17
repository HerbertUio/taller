package com.uab.taller.store.domain.dto.request;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AccountRequest {
    public int number;
    public double salary;
    public String type;
}
