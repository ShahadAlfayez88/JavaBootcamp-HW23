package com.example.springday14.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class AddressDTO {
    private Integer teacher_id;
    private Integer building_number;
    private String street;
    private String area;


}
