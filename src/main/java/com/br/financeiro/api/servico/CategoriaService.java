package com.br.financeiro.api.servico;

import com.br.financeiro.api.event.RecursoCriadoEnvent;
import com.br.financeiro.api.modelo.Categoria;
import com.br.financeiro.api.repositorio.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    @GetMapping
    public List<Categoria> categoria(){
        return categoriaRepository.findAll();
    }

    @Autowired
    private ApplicationEventPublisher publisher;


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Categoria> criar(@Valid @RequestBody Categoria categoria, HttpServletResponse response){
        Categoria categoria1 = categoriaRepository.save(categoria);

//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//                .buildAndExpand(categoria.getId()).toUri();
//        response.setHeader("Location", uri.toASCIIString());
//
//        return ResponseEntity.created(uri).body(categoria1);

        publisher.publishEvent(new RecursoCriadoEnvent(this, response, categoria1.getId()));
        return ResponseEntity.status(HttpStatus.CREATED).body(categoria1);
    }

    @GetMapping("/{codigo}")
    public Optional<Categoria> buscarPeloCodigo(@PathVariable Long codigo){

        Optional<Categoria> categoria = categoriaRepository.findById(codigo);

        return categoria;
   }

}
