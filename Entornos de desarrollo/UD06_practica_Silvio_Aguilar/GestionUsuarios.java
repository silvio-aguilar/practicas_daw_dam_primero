package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class GestionUsuarios {

    private static final List<Usuario> usuarios = new ArrayList<>();
    private static int siguienteId = 1;

    /**
     * Valida que el email tenga un formato correcto
     */
    private static boolean validarEmail(String email) {
        String patron = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        return Pattern.matches(patron, email);
    }

    /**
     * Registra un nuevo usuario en el sistema
     *
     * @param nombre Nombre del usuario
     * @param email Email del usuario (debe ser válido)
     * @param contraseña Contraseña (mínimo 8 caracteres)
     * @return true si el registro fue exitoso
     * @throws IllegalArgumentException Si los datos no son válidos
     */
    public static boolean registrarUsuario(String nombre, String email, String contraseña) {
        // Validar email
        if (!validarEmail(email)) {
            throw new IllegalArgumentException("Email inválido");
        }

        // Validar contraseña
        if (contraseña.length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }

        // Verificar email duplicado
        for (Usuario usuario : usuarios) {
            if (usuario.getEmail().equals(email)) {
                throw new IllegalArgumentException("Email ya registrado");
            }
        }

        // Registrar usuario
        Usuario nuevoUsuario = new Usuario(siguienteId, nombre, email, contraseña);
        usuarios.add(nuevoUsuario);
        siguienteId++;

        return true;
    }

    /**
     * Actualiza el email de un usuario existente
     *
     * @param idUsuario ID del usuario a actualizar
     * @param nuevoEmail Nuevo email del usuario
     * @return true si la actualización fue exitosa
     * @throws IllegalArgumentException Si el usuario no existe o el email es inválido
     */
    public static boolean actualizarEmailUsuario(int idUsuario, String nuevoEmail) {
        // Validar email
        if (!validarEmail(nuevoEmail)) {
            throw new IllegalArgumentException("Email inválido");
        }

        // Buscar usuario
        for (Usuario usuario : usuarios) {
            if (usuario.getId() == idUsuario) {
                usuario.setEmail(nuevoEmail);
                return true;
            }
        }

        throw new IllegalArgumentException("Usuario con id " + idUsuario + " no encontrado");
    }

    /**
     * Elimina un usuario del sistema
     *
     * @param idUsuario ID del usuario a eliminar
     * @return true si la eliminación fue exitosa
     * @throws IllegalArgumentException Si el usuario no existe
     */
    public static boolean eliminarUsuario(int idUsuario) {
        // Buscar y eliminar usuario
        for (int i = 0; i < usuarios.size(); i++) {
            if (usuarios.get(i).getId() == idUsuario) {
                usuarios.remove(i);
                return true;
            }
        }

        throw new IllegalArgumentException("Usuario con id " + idUsuario + " no encontrado");
    }

    /**
     * Busca usuarios por nombre o email
     *
     * @param criterio Texto a buscar en nombre o email
     * @return Lista de usuarios que coinciden con el criterio
     */
    public static List<Usuario> buscarUsuario(String criterio) {
        List<Usuario> resultados = new ArrayList<>();
        String criterioLower = criterio.toLowerCase();

        for (Usuario usuario : usuarios) {
            if (usuario.getNombre().toLowerCase().contains(criterioLower) ||
                    usuario.getEmail().toLowerCase().contains(criterioLower)) {
                resultados.add(usuario);
            }
        }

        return resultados;
    }

    /**
     * Limpia todos los usuarios (útil para pruebas)
     */
    public static void limpiarBaseDatos() {
        usuarios.clear();
        siguienteId = 1;
    }

    /**
     * Obtiene la lista de usuarios (para pruebas)
     */
    public static List<Usuario> getUsuarios() {
        return usuarios;
    }
}