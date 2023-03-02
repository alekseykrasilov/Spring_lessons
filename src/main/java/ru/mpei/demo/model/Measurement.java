package ru.mpei.demo.model;

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

}
