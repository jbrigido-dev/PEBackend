package com.jbrigido.pebackend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
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
@Table(name = "evaluations")
public class Evaluation {
    @Id
    @GeneratedValue(strategy = jakarta.persistence.GenerationType.IDENTITY)
    @Column(name = "eva_id")
    private Long id;
    @Column(name = "eva_pro_id", nullable = false)
    private Long project;
    @Column(name = "eva_user_id", nullable = false)
    private Long user;
    @Column(name = "eva_comment")
    private String comment;
    @Column(name = "eva_status", nullable = false)
    private Boolean status;
    @Column(name = "eva_created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "eva_updated_at", nullable = false)
    private LocalDate updatedAt;

     @PrePersist
    protected void onCreate() {

        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDate.now();
        }
        if (status == null) {
            status = true;
        }
    }
}
