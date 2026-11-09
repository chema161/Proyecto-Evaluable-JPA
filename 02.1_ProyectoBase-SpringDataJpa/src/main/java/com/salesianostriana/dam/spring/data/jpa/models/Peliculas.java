package com.salesianostriana.dam.spring.data.jpa.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.OneToMany;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Peliculas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;

    private int anioEstreno;

    @OneToMany(mappedBy = "pelicula", cascade = CascadeType.ALL)
    private List<Critica> criticas = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "pelicula_genero",
            joinColumns = @JoinColumn(name = "pelicula_id"),
            inverseJoinColumns = @JoinColumn(name = "genero_id"))
    private Set<Genero> generos = new HashSet<>();

    public Peliculas(String titulo, int anioEstreno) {
        this.titulo = titulo;
        this.anioEstreno = anioEstreno;
    }

    public void addCritica(Critica critica) {
        criticas.add(critica);
        critica.setPelicula(this);
    }

    public void removeCritica(Critica critica) {
        criticas.remove(critica);
        critica.setTexto(null);
    }

    public void addGenero(Genero genero) {
        generos.add(genero);
    }

    public void removeGenero(Genero genero) {
        generos.remove(genero);
    }

    @Override
    public String toString() {
        return "Pelicula{id=" + id + ", titulo='" + titulo + "', anioEstreno=" + anioEstreno + "}";
    }
}
