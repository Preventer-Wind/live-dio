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
//@Audited
public class JornadaTrabalho {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Jornada_Trabalho;
    //@Audited
    private String descricao;

    @OneToMany(mappedBy = "jornadaTrabalho", cascade = CascadeType.ALL)
    private List<Usuario> usuario;
}