package com.jbrigido.pebackend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "evaluation_details")
public class EvaluationDetail {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "evde_id")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "evde_eva_id", nullable = false)
    private Evaluation evaluation;
    @ManyToOne
    @JoinColumn(name = "evde_cri_id", nullable = false)
    private Criteria criterion;
    @Column(name = "evde_cri_name", nullable = false)
    private String criterionName;
    @Column(name = "evde_max_score", nullable = false)
    private Integer maxScore;
    @Column(name = "evde_score")
    private Integer score;
    @Column(name = "evde_comment")
    private String comment;
    @Column(name = "evde_created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "evde_updated_at", nullable = false)
    private LocalDate updatedAt;

     @PrePersist
    protected void onCreate() {

        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDate.now();
        }
        if (maxScore == null) {
            maxScore = 10;
        }
        if  (score == null) {
            score = 0;
        }
    }
}
