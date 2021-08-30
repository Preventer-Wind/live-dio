package com.dio.live.model;

import lombok.*;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class MovimentacaoId implements Serializable {
    private static final long serialVersionUID = -6552133389423304922L;

    private long id_Movimento;
    private long id_Usuario;
}