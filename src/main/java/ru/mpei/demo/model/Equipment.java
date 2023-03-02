package ru.mpei.demo.model;

import lombok.Data;

import java.util.List;
@Data
public class Equipment {

    private long id;

    private String name;

    private List<Measurement> measurements;
}
