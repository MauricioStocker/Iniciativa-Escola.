package com.iniciativaescola.Iniciativa.Escola.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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
@Table(name = "questao")
public class QuestaoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long questao_id;

    @Column(nullable = false)
    private String texto;

    @Column(nullable = false)
    private int nivel;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @ManyToOne
    @JoinColumn(name = "disciplina_id", nullable = false)
    private DisciplinaModel disciplina;

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "questao", fetch = FetchType.LAZY)
    private Set<RespostaModel> respostas = new HashSet<>();

}
