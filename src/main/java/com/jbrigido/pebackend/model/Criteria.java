package com.jbrigido.pebackend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
@Table(name = "criterias")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cr_id", nullable = false)
    private Long id;
    @Column(name = "cr_subject", nullable = false)
    private Long subject;
    @Column(name = "cr_indicator", nullable = false)
    private Indicator  indicator;
    @Column(name = "cr_description", nullable = false)
    private String description;
    @Column(name = "cr_max_score", nullable = false)  
    private Integer maxScore;
    @Column(name = "cr_is_active")
    private Boolean isActive;
    @Column(name = "cr_is_required")
    private Boolean isRequired;
    @Column(name = "cr_created_at")
    private LocalDate createdAt;
    @Column(name = "cr_updated_at")
    private LocalDate updatedAt;

    private enum Indicator {
        A, B, C, D, F,OB
    }
}
