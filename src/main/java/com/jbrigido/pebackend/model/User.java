package com.jbrigido.pebackend.model;

import java.time.LocalDate;

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
@Table(name = "users")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "us_id")
    private Long id;
    @Column(name = "us_name", nullable = false, length = 100)
    private String name;
    @Column(name = "us_lastname", nullable = false, length = 100)
    private String lastname;
    @Column(name = "us_username", unique = true, nullable = false, length = 10)
    private String username;
    @Column(name = "us_email", unique = true, nullable = false, length = 100)
    private String email;
    @Column(name = "us_password", nullable = false, length = 100)
    private String password;
    @Column(name = "us_enrollment", unique = true, nullable = false, length = 10)
    private String enrollment;
    @Column(name = "us_is_active", nullable = false)
    private Boolean isActive;
    @Column(name = "us_role", nullable = false)
    private Role role;
    @Column(name = "us_created_at", nullable = false)
    private LocalDate createdAt;
    @Column(name = "us_updated_at", nullable = false)
    private LocalDate updatedAt;

    public enum Role {
        ADMIN,
        STUDENT,
        TEACHER
    }

    @PrePersist
    protected void onCreate() {
        if (role == null) {
            role = Role.STUDENT;
        }
        if (isActive == null) {
            isActive = true;
        }
        if (createdAt == null) {
            createdAt = LocalDate.now();
        }
        if (updatedAt == null) {
            updatedAt = LocalDate.now();
        }
    }

}
