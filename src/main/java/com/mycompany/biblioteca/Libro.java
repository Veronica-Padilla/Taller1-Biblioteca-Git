package com.mycompany.biblioteca;

public class Libro exdends Material {
    private String autor;
    private boolean disponible;

    public Libro(String codigo, String titulo, String anioPublicacion) {
        super(codigo, titulo, anioPublicacion);
        this.autor = autor;
        this.disponible = true;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public boolean isDisponible() {
        //is es como el get para los booleanos
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        //El set sí va normal
        this.disponible = disponible;
    }

    @Override
    public String toString() {
        return super.toString() + ", autor= " + autor + ", disponible= " + disponible;
    }

}
