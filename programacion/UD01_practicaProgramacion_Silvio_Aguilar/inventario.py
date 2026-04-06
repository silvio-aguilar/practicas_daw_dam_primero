# Práctica de gestión de inventario UNIDAD 1 Programación I
# Autor: Silvio Aguilar
# Fecha: 27/06/2024
# Descripción: Este script permite gestionar el inventario de una tienda,
# incluyendo registrar productos con su nombre, calcular el precio final con IVA,
# mostrar un listado con los productos, buscar un producto por su nombre e indentificar el producto más caro.


# Función para calcular el IVA
def calcular_iva(precio, tasa_iva=0.21):
    return precio * (1 + tasa_iva)

# Funcion para añadir un producto
def anadir_producto(inventario, nombre, precio):
    precio_con_iva = calcular_iva(precio)
    inventario.append({'nombre': nombre, 'precio': precio_con_iva})

# Función para mostrar el inventario
def mostrar_inventario(inventario):
    print("Inventario de productos:")
    for producto in inventario:
        print(f"Nombre: {producto['nombre']}, Precio con IVA: {producto['precio']:.2f}")

# Función para buscar un producto por nombre
def buscar_producto(inventario, nombre):
    for producto in inventario:
        if producto['nombre'].lower() == nombre.lower():
            return producto
    return None

# Función para encontrar el producto más caro
def producto_mas_caro(inventario):
    if not inventario:
        return None
    return max(inventario, key=lambda x: x['precio'])

# Programa principal
def main():
    inventario = []
    
    while True:
        print("\nOpciones:")
        print("1. Añadir producto")
        print("2. Mostrar inventario")
        print("3. Buscar producto")
        print("4. Producto más caro")
        print("5. Salir")
        
        opcion = input("Seleccione una opción (1-5): ")
        
        if opcion == '1':
            nombre = input("Ingrese el nombre del producto: ")
            precio = float(input("Ingrese el precio del producto (sin IVA): "))
            anadir_producto(inventario, nombre, precio)
            print(f"Producto '{nombre}' añadido con éxito.")
        
        elif opcion == '2':
            mostrar_inventario(inventario)
        
        elif opcion == '3':
            nombre = input("Ingrese el nombre del producto a buscar: ")
            producto = buscar_producto(inventario, nombre)
            if producto:
                print(f"Producto encontrado: Nombre: {producto['nombre']}, Precio con IVA: {producto['precio']:.2f}")
            else:
                print("Producto no encontrado.")
        
        elif opcion == '4':
            producto = producto_mas_caro(inventario)
            if producto:
                print(f"El producto más caro es: Nombre: {producto['nombre']}, Precio con IVA: {producto['precio']:.2f}")
            else:
                print("El inventario está vacío.")
        
        elif opcion == '5':
            print("Saliendo del programa.")
            break
        
        else:
            print("Opción no válida. Por favor, intente de nuevo.")

if __name__ == "__main__":
    main()

