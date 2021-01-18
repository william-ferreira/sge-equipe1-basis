package com.basis.sge.sge;

import com.basis.sge.sge.dominio.Evento;
import com.basis.sge.sge.dominio.TipoEvento;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

@SpringBootApplication
public class SgeApplication {

    public static void main(String[] args) {
        SpringApplication.run(SgeApplication.class, args);


    }
}