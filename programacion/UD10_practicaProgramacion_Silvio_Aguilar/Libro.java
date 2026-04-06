package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    private int stock;


    // Constructor principal
    public Libro(String titulo, String autor, String isbn, int stock){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.stock = stock;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }


    // Métodos

    // Mostrar libros con el toString
    @Override
    public String toString(){
        return "Título: " + titulo +
                ", Autor: " + autor +
                ", ISBN: " + isbn +
                ", Stock: " + stock +
                "\n";

    }


}

