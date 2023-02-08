package com.example.springday14.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.MapsId;
import jakarta.persistence.OneToOne;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    @Id
    private Integer id;
    @NonNull
    private Integer building_number;
    @NotEmpty
    private String street;
    @NotEmpty
    private String area;

    @OneToOne
    @MapsId
    @JsonIgnore
    private Teacher teacher;
}
