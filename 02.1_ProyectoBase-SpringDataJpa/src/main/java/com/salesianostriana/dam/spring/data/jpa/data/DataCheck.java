package com.salesianostriana.dam.spring.data.jpa.data;

import com.salesianostriana.dam.spring.data.jpa.repos.CriticaRepository;
import com.salesianostriana.dam.spring.data.jpa.repos.GeneroRepository;
import com.salesianostriana.dam.spring.data.jpa.repos.PeliculasRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.DependsOn;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
@DependsOn("dataSeed")
public class DataCheck {

    private final GeneroRepository generoRepository;
    private final PeliculasRepository peliculasRepository;
    private final CriticaRepository criticaRepository;


    private final TransactionTemplate transactionTemplate;

    public DataCheck(GeneroRepository generoRepository, PeliculasRepository peliculasRepository, CriticaRepository criticaRepository, PlatformTransactionManager transactionManager) {
        this.generoRepository = generoRepository;
        this.peliculasRepository = peliculasRepository;
        this.criticaRepository = criticaRepository;
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @PostConstruct
    public void comprobarDatos () {

        transactionTemplate.executeWithoutResult(status ->{


        });
    }
}
