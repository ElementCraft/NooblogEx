package com.noobug.Nooblog.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class City {

    @Id
    private Long id;


    @OneToMany
    @JoinColumn(name = "city_id")
    @JsonIgnore
    private Set<User> users = new HashSet<>();
}
