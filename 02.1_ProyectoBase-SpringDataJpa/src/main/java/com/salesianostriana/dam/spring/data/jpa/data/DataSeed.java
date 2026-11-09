package com.salesianostriana.dam.spring.data.jpa.data;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.support.TransactionTemplate;

@Component
public class DataSeed {


    private final TransactionTemplate transactionTemplate;

    public DataSeed(PlatformTransactionManager transactionManager) {
        this.transactionTemplate = new TransactionTemplate(transactionManager);
    }

    @PostConstruct
    public void cargarDatos () {

        transactionTemplate.executeWithoutResult(status ->{

        });
    }
}
