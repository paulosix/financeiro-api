package com.br.financeiro.api.repositorio;

import com.br.financeiro.api.modelo.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
}
