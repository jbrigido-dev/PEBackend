package com.jbrigido.pebackend.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
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
@Table(name = "projects")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pro_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "pro_event", nullable = false)
    private Event event;
    @OneToOne
    @JoinColumn(name = "pro_subject", nullable = false)
    private Subject subject;
    @ManyToOne
    @JoinColumn(name = "pro_author", nullable = false)
    private User author;
    @Column(name = "pro_title", nullable = false)
    private String title;
    @Column(name = "pro_description", nullable = false)
    private String description;
    @Column(name = "pro_status", nullable = false)
    private Boolean status;
    @Column(name = "pro_created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "pro_updated_at", nullable = false)
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
            status = false;
        }
    }

}
