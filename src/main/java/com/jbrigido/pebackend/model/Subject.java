package com.jbrigido.pebackend.model;

import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Table(name = "subjects")
public class Subject {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "sub_id", nullable = false)
    private Long id;
    @Column(name = "sub_name", nullable = false)
    private String name;
    @Column(name = "sub_code", nullable = false, unique = true)
    private String code;
    @Column(name = "sub_period", nullable = false)
    private Period period;
    @Column(name = "sub_generation", nullable = false)
    private Integer generation;

    private enum Period{
        JANUARY, AUGUST
    }

    @PrePersist
    public void prePersist() {
        if (period == null) {
            period = Period.JANUARY;
        }
    }

}
