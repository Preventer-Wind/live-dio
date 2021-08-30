package com.dio.live.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@IdClass(MovimentacaoId.class)
public class Movimentacao {
    private static final long serialVersionUID = 5978541324789007386L;

    @Id
    @GeneratedValue
    private long id_Movimento;
    @Id
    @GeneratedValue
    private long id_Usuario;

    private LocalDateTime dataEntrada;
    private LocalDateTime dataSaida;
    private BigDecimal periodo;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Ocorrencia")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Ocorrencia ocorrencia;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_Calendario")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private Calendario calendario;
}