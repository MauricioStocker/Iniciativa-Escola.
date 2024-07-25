package com.iniciativaescola.Iniciativa.Escola.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import jakarta.persistence.FetchType;
@Getter
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "aluno")
public class AlunoModel implements Serializable {
    private static final long serialVersionUID = 1L; // responsavel pela serialização que ocorrera dentro dessa classe,
                                                     // que será tbm uma tabela

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long aluno_id;// que são identificadorses proprios
    @Column(nullable = false, unique = true)
    private String aluno_nome;
    @Column(nullable = false, unique = true)
    private String aluno_senha;
    @Column(nullable = false, unique = true)
    private String aluno_serie;

    @ManyToMany
    @JoinTable(name = "aluno_disciplina", joinColumns = @JoinColumn(name = "aluno_id"),
     inverseJoinColumns = @JoinColumn(name = "disciplina_id"))
    private Set<DisciplinaModel> disciplinas = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<RespostaModel> respostaModels = new HashSet<>();

    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @OneToMany(mappedBy = "aluno", fetch = FetchType.LAZY)
    private Set<ProgressoModel> progressoModels = new HashSet<>();

}
