package com.dio.live.repository;

import com.dio.live.model.Movimentacao;
import com.dio.live.model.MovimentacaoId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovimentacaoRepository extends JpaRepository<Movimentacao, MovimentacaoId> {
}