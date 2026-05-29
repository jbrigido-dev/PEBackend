package com.jbrigido.pebackend.model;

import java.time.LocalDateTime;
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
@Table(name = "ProjectMembers")
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "prm_id", nullable = false)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "prm_us_id", nullable = false)
    private User user;
    @ManyToOne
    @JoinColumn(name = "prm_pro_id", nullable = false)
    private Project project;
    @Column(name = "prm_is_leader", nullable = false)
    private Boolean isLeader;
    @Column(name = "prm_joined_at", nullable = false)
    private LocalDateTime joinedAt;

    @PrePersist
    public void prePersist (){
        if (isLeader == null) {
            isLeader = false;
        }
        if (joinedAt == null) {
            joinedAt = LocalDateTime.now();
        }
    }
}
