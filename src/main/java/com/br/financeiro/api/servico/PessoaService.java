package com.br.financeiro.api.servico;

import com.br.financeiro.api.event.RecursoCriadoEnvent;
import com.br.financeiro.api.modelo.Pessoa;
import com.br.financeiro.api.repositorio.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaService {

    @Autowired
    private PessoaRepository pessoaRepository;

    @GetMapping
    public List<Pessoa> pessoa(){
        return pessoaRepository.findAll();
    }

    @Autowired
    private ApplicationEventPublisher publisher;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Pessoa> criar(@Valid @RequestBody Pessoa pessoa, HttpServletResponse response){
        Pessoa pessoa1 = pessoaRepository.save(pessoa);

//        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
//                .buildAndExpand(pessoa.getCodigo()).toUri();
//        response.setHeader("Location", uri.toASCIIString());
        publisher.publishEvent(new RecursoCriadoEnvent(this, response, pessoa1.getCodigo()));
        return ResponseEntity.status(HttpStatus.CREATED).body(pessoa1);
    }

    @GetMapping("/{codigo}")
    public Optional<Pessoa> buscarPeloCodigo(@PathVariable Long codigo){

        Optional<Pessoa> pessoa = pessoaRepository.findById(codigo);

        return pessoa;
    }

}
