package com.jbrigido.pebackend.model;

import java.time.LocalDateTime;

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
@Table(name = "project_evaluators")
public class ProjectEvaluator {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pre_id", nullable = false)
    private Long id;
    @Column(name = "pre_pro_id", nullable = false)
    private Long projectId;
    @Column(name = "pre_us_ev_id", nullable = false)
    private Long projectUser;
    @Column(name = "pre_assigned_at", nullable = false)
    private LocalDateTime assignedAt;
    
    @PrePersist
    public void prePersist(){
        if (assignedAt == null) {
            assignedAt= LocalDateTime.now();
        }
    }
    
}
