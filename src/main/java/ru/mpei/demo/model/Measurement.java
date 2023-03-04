package ru.mpei.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name = "measurements")
public class Measurement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private double ua;

    @Column
    private double ub;

    @Column
    private double uc;

    @Column
    private double ia;

    @Column
    private double ib;

    @Column
    private double ic;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "equipment_id")
    @JsonIgnore
    private Equipment equipment;

    @Override
    public String toString() {
        return "Measurement{" +
                "id=" + id +
                ", ua=" + ua +
                ", ub=" + ub +
                ", uc=" + uc +
                ", ia=" + ia +
                ", ib=" + ib +
                ", ic=" + ic +
                ", equipmentId" + equipment.getId() +
                '}';
    }
}
