package com.br.financeiro.api.repositorio;

import com.br.financeiro.api.modelo.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
