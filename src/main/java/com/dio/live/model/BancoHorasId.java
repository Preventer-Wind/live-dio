package com.dio.live.model;

import lombok.*;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class BancoHorasId implements Serializable {
    private static final long serialVersionUID = -3094995825673899129L;

    private long idBancoHoras;

    private long idMovimento;

    private long idUsuario;
}