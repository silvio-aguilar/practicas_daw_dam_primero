package org.example;

import java.util.ArrayList;

public class Biblioteca {
    private String nombre;
    protected ArrayList<Libro> catalogoLibros;
    protected ArrayList<Socio> listaSocios;

    // Constructor
    public Biblioteca(String nombre){
        this.nombre = nombre;
        catalogoLibros = new ArrayList<>();
        listaSocios = new ArrayList<>();
    }

    // Getter
    public String getNombre(){
        return nombre;
    }

    // Setter
    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    // Metodos
    public void agregarLibro(Libro libro){
        catalogoLibros.add(libro);
    }
    public void registrarSocio(Socio socio){
        listaSocios.add(socio);
    }

    public Libro buscarLibro(String isbn){
        for (Libro libro : catalogoLibros){
            if (libro.getIsbn().equals(isbn)) {
                return libro;
            }
        }
        return null;
    }

    public Socio buscarSocio(String idSocio){
        for (Socio socio : listaSocios){
            if (socio.getIdSocio().equals(idSocio)){
                return socio;
            }
        }
        return null;
    }

    public void realizarPrestamo(String idSocio, String isbn){
        Socio socio = buscarSocio(idSocio);
        Libro libro = buscarLibro(isbn);

        if (socio == null){
            System.out.println("Socio no encontrado");
            return;

        }
        if (libro == null){
            System.out.println("Libro no encontrado");
            return;
        }
        if (!libro.isDisponible()){
            System.out.println("El libro no está disponible");
            return;
        }

        libro.prestarLibro();
        socio.pedirLibro(libro);
        System.out.println("Préstamo realizado correctamente!");

    }

    public void realizarDevolucion(String idSocio, String isbn){
       Socio socio = buscarSocio(idSocio);
       Libro libro = buscarLibro(isbn);

       if (socio == null){
           System.out.println("Socio no encontrado");
           return;
       }
       if (libro == null){
           System.out.println("Libro no encontrado");
           return;
       }
      if (!socio.getLibrosPrestados().contains(libro)){
          System.out.println("El socio no tiene este libro");
          return;
      }

       libro.devolverLibro();
       socio.devolucionLibro(libro);
        System.out.println("Libro devuelto correctamente");

    }

    // Metodo extra para mostrar el catalogo de libros sin liarla con protected heheh
    public void mostrarCatalogo(){
        for (Libro libro : catalogoLibros){
            System.out.println(libro.mostrarInfo());
            System.out.println("\n");
        }
    }

}
