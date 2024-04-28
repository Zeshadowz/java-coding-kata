package com.qburry.web.model;

import lombok.*;

@Getter
@Setter
@Builder(toBuilder = true)
@AllArgsConstructor
@RequiredArgsConstructor
public class Customer {
    private Long id;
    private PersonType personType;
    private String gender;
    private String firstname;
    private String lastname;
    private String email;
    private String phone;
}
