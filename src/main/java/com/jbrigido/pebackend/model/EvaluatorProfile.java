package com.jbrigido.pebackend.model;

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
@Table(name = "evaluator_profiles")
public class EvaluatorProfile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "evp_institution", length = 100)
    private String institution;
    @Column (name = "evp_specialty", length = 100)
    private String specialty;
    @Column(name = "evp_is_external", nullable = false)
    private Boolean isExternal;
    
    @PrePersist
    public void prePersist(){
        if (isExternal == null) {
            isExternal =  false;
        }
    }

}
