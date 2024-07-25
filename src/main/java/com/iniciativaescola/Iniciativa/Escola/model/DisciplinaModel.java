package com.iniciativaescola.Iniciativa.Escola.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "disciplina")
public class DisciplinaModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long disciplina_id;
    @Column(nullable = false, unique = true)
    private String disciplina_nome;
    @Column(nullable = false)
    private String disciplina_turma;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToMany(mappedBy = "disciplinas", fetch = FetchType.LAZY)
    private Set<AlunoModel> alunos = new HashSet<>();


    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
    private Set<QuestaoModel> questaoModels = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "disciplina", fetch = FetchType.LAZY)
    private Set<ProgressoModel> progressoModels = new HashSet<>();


}
