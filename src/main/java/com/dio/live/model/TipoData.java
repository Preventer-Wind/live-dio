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
public class TipoData {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_tipoData;
    private String descricao;
    @OneToMany(mappedBy = "tipoData", cascade = CascadeType.ALL)
    private List<Calendario> calendario;
}