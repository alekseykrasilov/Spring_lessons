package ru.mpei.demo.model;

import lombok.Data;

import java.util.List;

@Data
public class Substation {

    private long id;

    private String name;

    private List<Equipment> equipment;
}
