package br.com.labbeach.apirest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @EqualsAndHashCode @ToString
@Data
@Entity
@Table(name = "tb_bairros")
public class Bairro {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (unique = true)
    private Long id;

    @Column (nullable = false, unique = true)
    @NotBlank (message = "O nome do bairro não pode ficar em branco")
    private String nomeBairro;

    @Column
    private String descricao;

    @Column
    private int populacao;

}
