package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
public class Calendario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_Calendario;
    private String descricao;
    private LocalDateTime dataEspecial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_tipoData")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private TipoData tipoData;

    @OneToMany(mappedBy = "calendario", cascade = CascadeType.ALL)
    private List<Movimentacao> movimentacao;

}