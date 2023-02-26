
package br.com.labbeach.apirest.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString @EqualsAndHashCode
@Data
@Entity
@Table (name = "tb_praias")
public class Praia {

    @Id
    @Column (unique = true)
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    private Long id;

    @Column (nullable = false)
    @NotBlank(message = "O nome da praia não pode ficar em branco")
    private String nomePraia;

    @Column (nullable = false)
    @NotBlank (message = "O campo acessibilidade não pode ficar em branco")
    private boolean acessibilidade;

    @Column (nullable = false)
    @NotBlank (message = "O status da praia não pode ficar em branco")
    private String statusPraia;

    @ManyToOne
    @JoinColumn (name = "bairro_id")
    private Bairro bairro;

    public Bairro getBairro() {
        return bairro;
    }
}

