package com.jbrigido.pebackend.model;

import java.time.LocalDate;
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
@Table(name = "events")
public class Event {
    

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ev_id")
    private Long id;
    @Column(name = "ev_name", nullable = false , length = 100)
    private String name;
    @Column(name = "ev_description", nullable = true , length = 200)
    private String description;
    @Column(name = "ev_start_date", nullable = false)
    private LocalDate starDate;
    @Column(name = "ev_end_date", nullable = true)
    private LocalDateTime endDate;
    @Column(name = "ev_status", nullable = false)
    private Boolean status;
    @Column(name = "ev_created_at", nullable = false)
    private LocalDate createdAt;

    @PrePersist
    public void prePersist(){
        if (starDate == null) {
            starDate = LocalDate.now();
        }
        if (endDate == null) {
            endDate = LocalDateTime.now();
        }
        if (createdAt == null) {
                createdAt= LocalDate.now();
        }
        if (status == null) {
            status = true;
        }
    }
    
}
