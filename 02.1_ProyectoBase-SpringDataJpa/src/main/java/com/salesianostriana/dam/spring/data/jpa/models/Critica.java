package com.salesianostriana.dam.spring.data.jpa.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Critica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String autor;

    @Column(length = 2000)
    private String texto;

    private int puntuacion;

    @ManyToOne
    @JoinColumn(name = "pelicula_id")
    private Peliculas pelicula;

    public Critica(String autor, String texto, int puntuacion) {
        this.autor = autor;
        this.texto = texto;
        this.puntuacion = puntuacion;
    }

    @Override
    public String toString() {
        return "Critica{id=" + id + ", autor='" + autor + "', puntuacion=" + puntuacion + "}";
    }
}
