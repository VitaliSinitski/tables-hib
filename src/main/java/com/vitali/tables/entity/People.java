package com.vitali.tables.entity;

import lombok.*;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table
public class People implements Serializable {
    @Id
    @Column(name = "people_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer peopleId;
    private String name;
    private Integer age;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "home_id")
    private Home home;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "people_car", joinColumns = {@JoinColumn(name = "people_id")},
            inverseJoinColumns = {@JoinColumn(name = "car_id")})
    private Set<Car> carSet = new HashSet<>();
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        People people = (People) o;
        return Objects.equals(peopleId, people.peopleId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(peopleId);
    }
}
