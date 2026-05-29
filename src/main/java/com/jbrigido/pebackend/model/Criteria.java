package com.jbrigido.pebackend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name = "criterias")
public class Criteria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cr_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "cr_subject", nullable = false)
    private Subject subject;
    @Column(name = "cr_indicator", nullable = false)
    private Indicator  indicator;
    @Column(name = "cr_description", nullable = false)
    private String description;
    @Column(name = "cr_max_score", nullable = false)  
    private Integer maxScore;
    @Column(name = "cr_is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "cr_is_required", nullable = false)
    private Boolean isRequired;
    @Column(name = "cr_created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "cr_updated_at", nullable = false)
    private LocalDate updatedAt;

    private enum Indicator {
        A, B, C, D, F,OB
    }

    @PrePersist
    public void prePersist(){
        if (indicator == null) {
            indicator = Indicator.A;
        }
        if (isActive == null) {
            isActive = false;
        }
        if (isRequired == null) {
            isRequired = false;
        }
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDate.now();
        }
    }
}
