package ru.mpei.demo.model;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table
public class Equipment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 300)
    private String name;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "equipment")
    private List<Measurement> measurements = new ArrayList<>();

    @Override
    public String toString() {
        return "Equipment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", measurements=" + measurements.size() +
                '}';
    }
}
