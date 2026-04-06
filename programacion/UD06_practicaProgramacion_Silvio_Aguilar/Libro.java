package org.example;

public class Libro {
    private String titulo;
    private String autor;
    private String isbn;
    protected boolean disponible;

    // Constructor principal
    public Libro(String titulo,String autor,String isbn){
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.disponible = true;
    }

    // Getters
    public String getTitulo(){
        return titulo;
    }
    public String getAutor(){
        return autor;
    }
    public String getIsbn(){
        return isbn;
    }
    public boolean isDisponible(){
        return disponible;
    }

    // Setters
    public void setTitulo(String titulo){
        this.titulo = titulo;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public void setIsbn(String isbn){
        this.isbn = isbn;
    }

    // Metodos
    public void prestarLibro(){
        if (disponible){
            disponible = false;
            System.out.println("Libro " + getTitulo() + " prestado correctamente.");
        } else {
            System.out.println("El libro no está disponible.");
        }

    }
    public void devolverLibro(){
        if (!disponible){
            disponible = true;
            System.out.println("Libro " + getTitulo() + " devuelto correctamente");
        } else {
            System.out.println("El libro está en la biblioteca.");

        }
    }

    public String mostrarInfo(){
         return "Titulo: " + getTitulo() + "\nAutor: " + getAutor() + "\nISBN: " + getIsbn() + "\nDisponible: " + isDisponible();
    }
}
