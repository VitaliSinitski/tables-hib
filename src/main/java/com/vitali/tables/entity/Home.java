package com.vitali.tables.entity;

import lombok.*;

import javax.lang.model.type.DeclaredType;
import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table
public class Home implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "home_id")
    private Integer homeId;
    private String address;

    @OneToMany(mappedBy = "home")
    private Set<People> peopleSet;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = "home", cascade = CascadeType.ALL)
    private Description description;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Home home = (Home) o;
        return Objects.equals(homeId, home.homeId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeId);
    }
}
