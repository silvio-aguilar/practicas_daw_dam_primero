package org.example;

import java.util.*;

public class Inventario {
    private ArrayList<Libro> libros;
    private Queue<String> colaPrestados;
    private Stack<String> pilaUltimosAnadidos;



    // Constructor
    public Inventario(){
        libros = new ArrayList<>();
        colaPrestados = new LinkedList<>();
        pilaUltimosAnadidos = new Stack<>();

        // Iniciamos tres libros
        libros.add(new Libro("1984", "George Orwell", "ISBN1", 3));
        libros.add(new Libro("El Quijote", "Cervantes", "ISBN2", 2));
        libros.add(new Libro("Harry Potter", "This is my rolling", "ISBN3", 5));

    }


    // Métodos

    // Registrar nuevo libro
    public void registrarLibro(String titulo, String autor, String isbn, int stock){

        for (Libro l : libros){
            if(l.getIsbn().equals(isbn)){
                l.setStock(l.getStock() + stock);
                return;
            }
        }
        libros.add(new Libro(titulo,autor,isbn,stock));
        pilaUltimosAnadidos.push(isbn);
    }

    // Vender libro
    public boolean venderLibro(String isbn) {
        for (Libro l : libros) {
            if (l.getIsbn().equals(isbn)) {
                if (l.getStock() > 0) {
                    l.setStock(l.getStock() - 1);
                    colaPrestados.add(isbn);
                    return true;
                }
                return false;
            }
        }
        return false;
    }


    // Devolver libros
    public String devolverLibro(){
        if (!colaPrestados.isEmpty()){
            return colaPrestados.poll();
        }
        return null;
    }

    // Listar libros
    public ArrayList<Libro> listarLibros(){
        return libros;
    }

    // Buscar libros
    public Libro buscarLibros(String texto){
        for (Libro l : libros){
            if (l.getIsbn().equals(texto)
                || l.getTitulo().toLowerCase().contains(texto.toLowerCase())){
                return l;
                }
            }
            return null;

    }

    // Mostrar último libro añadido
    public Libro mostrarUltimoLibro(){
        if(pilaUltimosAnadidos.isEmpty()){
            return null;
        }
        String isbn = pilaUltimosAnadidos.peek();
        return buscarLibros(isbn);
    }

    // Deshacer último añadido
    public void deshacerUltimoAnadido(){
        if (!pilaUltimosAnadidos.isEmpty()){
            String isbn = pilaUltimosAnadidos.pop();
            libros.removeIf(l -> l.getIsbn().equals(isbn));
        }
    }


}
