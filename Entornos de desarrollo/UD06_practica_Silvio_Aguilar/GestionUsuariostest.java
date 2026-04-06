package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GestionUsuariostest {

    @BeforeEach
    public void setUp() {
        // Se ejecuta antes de cada test - limpia la base de datos
        GestionUsuarios.limpiarBaseDatos();
    }

    // ========== PRUEBAS PARA ACTUALIZAR EMAIL ==========

    @Test
    @DisplayName("Prueba 1: Actualizar email con datos válidos")
    public void testActualizarEmailValido() {
        // Preparar: registrar un usuario
        GestionUsuarios.registrarUsuario("Test User", "old@test.com", "Pass1234");

        // Ejecutar: actualizar el email
        boolean resultado = GestionUsuarios.actualizarEmailUsuario(1, "new@test.com");

        // Verificar: que devuelva true y que el email se haya actualizado
        assertTrue(resultado);
        assertEquals("new@test.com", GestionUsuarios.getUsuarios().get(0).getEmail());
    }

    @Test
    @DisplayName("Prueba 2: Error al actualizar email de usuario inexistente")
    public void testActualizarEmailUsuarioNoExiste() {
        // Preparar: base de datos vacía (ya hecho en setUp)

        // Ejecutar y verificar: debe lanzar IllegalArgumentException
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GestionUsuarios.actualizarEmailUsuario(999, "nuevo@test.com");
        });

        // Verificar el mensaje de error
        assertTrue(exception.getMessage().contains("no encontrado"));
    }

    // ========== CASOS DE PRUEBA FORMALES (CP-01, CP-02, CP-03) ==========

    @Test
    @DisplayName("P01: Registro exitoso con datos válidos (caja negra)")
    public void testRegistroExitosoDatosValidos() {
        // Ejecutar
        boolean resultado = GestionUsuarios.registrarUsuario(
                "Silvio Aguilar",
                "silviocreate@gmail.com",
                "pass1234"
        );

        // Verificar
        assertTrue(resultado);
        assertEquals(1, GestionUsuarios.getUsuarios().size());
        assertEquals("Silvio Aguilar", GestionUsuarios.getUsuarios().get(0).getNombre());
    }

    @Test
    @DisplayName("P02: Email inválido (clase de equivalencia)")
    public void testEmailInvalido() {
        // Ejecutar y verificar
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            GestionUsuarios.registrarUsuario("Silvio Aguilar", "silvio.com", "pass1234");
        });

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    @DisplayName("P03: Contraseña con longitud mínima (valor límite)")
    public void testContraseñaLongitudMinima() {
        // Ejecutar: contraseña de exactamente 8 caracteres
        boolean resultado = GestionUsuarios.registrarUsuario(
                "Silvio Aguilar",
                "silvocreate@gmail.com",
                "pass1234"
        );

        // Verificar
        assertTrue(resultado);
        assertEquals(1, GestionUsuarios.getUsuarios().size());
    }

    // ========== PRUEBAS PARA ELIMINAR USUARIO (BUG CORREGIDO) ==========

    @Test
    @DisplayName("Eliminar usuario correcto por su ID")
    public void testEliminarUsuarioCorrecto() {
        // Preparar: registrar 3 usuarios
        GestionUsuarios.registrarUsuario("Usuario 1", "user1@test.com", "pass1234");
        GestionUsuarios.registrarUsuario("Usuario 2", "user2@test.com", "pass5678");
        GestionUsuarios.registrarUsuario("Usuario 3", "user3@test.com", "pass9012");

        // Ejecutar: eliminar el usuario con id 2
        boolean resultado = GestionUsuarios.eliminarUsuario(2);

        // Verificar
        assertTrue(resultado);
        assertEquals(2, GestionUsuarios.getUsuarios().size());

        // Verificar que se eliminó el correcto
        assertFalse(GestionUsuarios.getUsuarios().stream()
                .anyMatch(u -> u.getId() == 2));
        assertTrue(GestionUsuarios.getUsuarios().stream()
                .anyMatch(u -> u.getId() == 1));
        assertTrue(GestionUsuarios.getUsuarios().stream()
                .anyMatch(u -> u.getId() == 3));
    }

    @Test
    @DisplayName("Error al eliminar usuario inexistente")
    public void testEliminarUsuarioInexistente() {
        // Verificar que lanza excepción
        assertThrows(IllegalArgumentException.class, () -> {
            GestionUsuarios.eliminarUsuario(999);
        });
    }
}