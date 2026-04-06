package org.example;

public class Productos {
    private String nombre;
    private double precio = 0;
    private int cantidad = 0;

    // Constructor vacío
    public Productos() {}

    // Constructor completo
    public Productos(String nombre, double precio, int cantidad) {
        this.nombre = nombre;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        if (precio <= 0) {
            System.out.println("Precio inválido, debe ser mayor a 0.");
            return;
        }
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        if (cantidad <= 0) {
            System.out.println("Cantidad inválida, debe ser mayor a 0.");
            return;
        }
        this.cantidad = cantidad;
    }

    // Subtotal con descuento si cantidad >= 5
    public double calcularSubtotal() {
        double subtotal = precio * cantidad;

        if (cantidad >= 5) {
            subtotal *= 0.90; // descuento 10%
        }

        return subtotal;
    }
}
