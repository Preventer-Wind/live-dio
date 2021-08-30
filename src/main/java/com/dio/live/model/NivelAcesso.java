package com.dio.live.model;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class NivelAcesso {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id_NivelAcesso;
    private String descricao;
    @OneToMany(mappedBy = "nivelAcesso", cascade = CascadeType.ALL)
    private List<Localidade> localidade;

    @OneToMany(mappedBy = "nivelAcesso", cascade = CascadeType.ALL)
    private List<Usuario> usuario;
}