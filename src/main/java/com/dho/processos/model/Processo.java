package com.dho.processos.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Processo {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;
    
    private String numero;
    
    @JsonManagedReference
    @OneToMany(mappedBy = "processo", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Reu> reus = new ArrayList<>();
}
