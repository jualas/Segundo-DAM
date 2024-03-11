import dao.EquipoImplDao;
import dao.JugadorImplDao;

import java.util.Scanner;

public class MenuApp {
    private static Scanner scanner = new Scanner(System.in);

    public void iniciar() {
        int opcion;
        do {
            opcion = imprimirMenuYObtenerOpcion();
            switch (opcion) {
                case 1: // Crear un nuevo equipo
                    EquipoImplDao equipoDao = new EquipoImplDao();
                    equipoDao.crearEquipo();
                    break;
                case 2: // Añadir un nuevo jugador a un equipo
                    JugadorImplDao jugadorDao = new JugadorImplDao();
                    jugadorDao.crearJugador();
                    break;
                case 3:
                    EquipoImplDao equipoDao3 = new EquipoImplDao();
                    equipoDao3.mostrarNombresEquipos();
                    break;
                case 4:
                    EquipoImplDao equipoDao4 = new EquipoImplDao();
                    equipoDao4.actualizarNombreEquipo();
                    break;
                case 5:
                    JugadorImplDao jugadorDao5 = new JugadorImplDao();
                    jugadorDao5.eliminarJugador();
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elija una opción del menú.");
                    break;
            }
        } while (opcion != 0);
    }

    private int imprimirMenuYObtenerOpcion() {
        System.out.println("\nMenu:");
        System.out.println("1. Crear un nuevo equipo");
        System.out.println("2. Añadir un nuevo jugador a un equipo");
        System.out.println("3. Mostrar el nombre de todos los equipos");
        System.out.println("4. Actualizar el nombre de un equipo");
        System.out.println("5. Borrar un jugador");
        System.out.println("0. Salir");
        System.out.print("Elija una opción: ");
        return scanner.nextInt();
    }
}