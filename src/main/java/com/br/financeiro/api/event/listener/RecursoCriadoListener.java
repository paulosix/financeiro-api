package com.br.financeiro.api.event.listener;

import com.br.financeiro.api.event.RecursoCriadoEnvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.servlet.http.HttpServletResponse;
import java.net.URI;

@Component
public class RecursoCriadoListener implements ApplicationListener<RecursoCriadoEnvent> {

    @Override
    public void onApplicationEvent(RecursoCriadoEnvent recursoCriadoEnvent) {
        HttpServletResponse response = recursoCriadoEnvent.getResponse();
        Long codigo = recursoCriadoEnvent.getCodigo();

        adicionarHealderLocation(response, codigo);

    }

    private void adicionarHealderLocation(HttpServletResponse response, Long codigo) {
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{codigo}")
                .buildAndExpand(codigo).toUri();
        response.setHeader("Location", uri.toASCIIString());
    }
}
