package ru.mpei.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "measurements")
@NoArgsConstructor
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

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
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

    public Measurement(double ua, double ub, double uc, double ia, double ib, double ic) {
        this.ua = ua;
        this.ub = ub;
        this.uc = uc;
        this.ia = ia;
        this.ib = ib;
        this.ic = ic;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Measurement that = (Measurement) o;
        return id == that.id && Double.compare(that.ua, ua) == 0 && Double.compare(that.ub, ub) == 0 && Double.compare(that.uc, uc) == 0 && Double.compare(that.ia, ia) == 0 && Double.compare(that.ib, ib) == 0 && Double.compare(that.ic, ic) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, ua, ub, uc, ia, ib, ic);
    }
}
