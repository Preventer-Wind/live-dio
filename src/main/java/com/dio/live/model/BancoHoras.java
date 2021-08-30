package com.dio.live.model;

import lombok.*;
import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
@Entity
@IdClass(BancoHorasId.class)
public class BancoHoras implements Serializable {
    private static final long serialVersionUID = 5999236902534007386L;

    @Id
    @GeneratedValue
    private long idBancoHoras;
    @Id
    @GeneratedValue
    private long idMovimento;
    @Id
    @GeneratedValue
    private long idUsuario;

    private LocalDateTime dataTrabalhada;
    private BigDecimal quantidadeHoras;
    private BigDecimal saldoHoras;
}