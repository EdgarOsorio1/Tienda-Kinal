package com.eosorio.ProyectoTienda_in5bv;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProyectoTiendaIn5bvApplication implements CommandLineRunner {

    public static void main(String[] args) {SpringApplication.run(ProyectoTiendaIn5bvApplication.class, args);

    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Api funcionando correctamente...");
    }
}
