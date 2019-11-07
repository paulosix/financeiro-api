package com.br.financeiro.api.servico;

import com.br.financeiro.api.modelo.Categoria;
import com.br.financeiro.api.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping("/categoria")
    public List<Categoria> categoria(){
        return categoriaRepository.findAll();
    }
}
