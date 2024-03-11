package dao;

/**
 * Interfaz para el DAO del equipo.
 */
public interface EquipoDao {

    /**
     * Crea un nuevo equipo.
     */
    void crearEquipo();

    /**
     * Añade un nuevo jugador a un equipo.
     */
    void añadirJugador();

    /**
     * Muestra el nombre de todos los equipos.
     */
    void mostrarNombresEquipos();

    /**
     * Actualiza el nombre de un equipo.
     */
    void actualizarNombreEquipo();

    /**
     * Borra un jugador de un equipo.
     */
    void borrarJugador();
}
