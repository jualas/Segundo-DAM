package dao;

import entidad.Equipo;
import entidad.Jugador;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;


public class JugadorImplDao implements JugadorDao {

    @Override
    public void crearJugador() {
        // Crear una nueva instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Iniciar una nueva transacción
            em.getTransaction().begin();

            // Crear una nueva instancia de Scanner para recoger los datos del usuario
            Scanner scanner = new Scanner(System.in);

            // Mostrar un listado de los equipos disponibles en la base de datos
            List<Equipo> equipos = em.createQuery("SELECT e FROM equipo e", Equipo.class).getResultList();
            if (equipos.isEmpty()) {
                System.out.println("No hay equipos registrados en la base de datos.");
            } else {
                System.out.println("Equipos disponibles:");
                for (Equipo equipo : equipos) {
                    System.out.println("ID: " + equipo.getIdEquipo() + ", Nombre: " + equipo.getNombre());
                }
            }

            // Pedir al usuario que introduzca el ID del equipo
            System.out.print("Introduzca el Id del equipo donde quiere añadir un nuevo jugador: ");
            Integer idEquipo = scanner.nextInt();
            scanner.nextLine(); // consume the newline

            // Crear una nueva instancia de Jugador
            Jugador nuevoJugador = new Jugador();

            // Pedir al usuario que introduzca el nombre del jugador
            System.out.print("Introduce el nombre del jugador: ");
            String nombre = scanner.nextLine();
            nuevoJugador.setNombreJugador(nombre);
            nuevoJugador.setIdEquipo(idEquipo);

            // Persistir el objeto Jugador en la base de datos
            em.persist(nuevoJugador);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar un mensaje de éxito
            System.out.println("El jugador " + nombre + " ha sido creado con éxito.");
        } catch (Exception e) {
            // Capturar cualquier excepción y mostrar un mensaje de error
            System.out.println("Ha ocurrido un error al crear el jugador: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void insertarJugador() {
        // Crear una nueva instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Iniciar una nueva transacción
            em.getTransaction().begin();

            // Crear una nueva instancia de Scanner para recoger los datos del usuario
            Scanner scanner = new Scanner(System.in);

            // Mostrar un listado de los equipos disponibles en la base de datos
            List<Equipo> equipos = em.createQuery("SELECT e FROM equipo e", Equipo.class).getResultList();
            if (equipos.isEmpty()) {
                System.out.println("No hay equipos registrados en la base de datos.");
            } else {
                System.out.println("Equipos disponibles:");
                for (Equipo equipo : equipos) {
                    System.out.println("ID: " + equipo.getIdEquipo() + ", Nombre: " + equipo.getNombre());
                }
            }

            // Pedir al usuario que introduzca el ID del equipo
            System.out.print("Introduzca el Id del equipo donde quiere añadir un nuevo jugador: ");
            Long idEquipo = scanner.nextLong();

            // Crear una nueva instancia de Jugador
            Jugador nuevoJugador = new Jugador();

            // Pedir al usuario que introduzca el nombre del jugador
            System.out.print("Introduce el nombre del jugador: ");
            String nombre = scanner.nextLine();
            nuevoJugador.setNombreJugador(nombre);

            // Persistir el objeto Jugador en la base de datos
            em.persist(nuevoJugador);

            // Confirmar la transacción
            em.getTransaction().commit();

            // Mostrar un mensaje de éxito
            System.out.println("El jugador " + nombre + " ha sido creado con éxito.");
        } catch (Exception e) {
            // Capturar cualquier excepción y mostrar un mensaje de error
            System.out.println("Ha ocurrido un error al crear el jugador: " + e.getMessage());
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void actualizarJugador() {
        // Aquí va el código para actualizar un jugador
    }

    @Override
public void eliminarJugador() {
    // Crear una nueva instancia de EntityManager
    EntityManager em = JpaUtil.getEntityManager();

    try {
        // Iniciar una nueva transacción
        em.getTransaction().begin();

        // Crear una nueva instancia de Scanner para recoger los datos del usuario
        Scanner scanner = new Scanner(System.in);

        // Mostrar un listado de los jugadores disponibles en la base de datos
        List<Jugador> jugadores = em.createQuery("SELECT j FROM jugador j", Jugador.class).getResultList();
        if (jugadores.isEmpty()) {
            System.out.println("No hay jugadores registrados en la base de datos.");
        } else {
            System.out.println("Jugadores disponibles:");
            for (Jugador jugador : jugadores) {
                System.out.println("ID: " + jugador.getIdJugador() + ", Nombre: " + jugador.getNombreJugador());
            }
        }

        // Pedir al usuario que introduzca el ID del jugador
        System.out.print("Introduzca el Id del jugador que quiere eliminar: ");
        Integer idJugador = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Buscar el jugador en la base de datos utilizando el ID proporcionado por el usuario
        Jugador jugador = em.find(Jugador.class, idJugador);
        if (jugador == null) {
            System.out.println("No se ha encontrado ningún jugador con el ID " + idJugador);
            return;
        }

        // Eliminar el jugador de la base de datos
        em.remove(jugador);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Mostrar un mensaje de éxito
        System.out.println("El jugador con ID " + idJugador + " ha sido eliminado con éxito.");
    } catch (Exception e) {
        // Capturar cualquier excepción y mostrar un mensaje de error
        System.out.println("Ha ocurrido un error al eliminar el jugador: " + e.getMessage());
        if (em.getTransaction().isActive()) {
            em.getTransaction().rollback();
        }
    } finally {
        // Cerrar el EntityManager
        if (em != null) {
            em.close();
        }
    }
}

    @Override
    public void buscarJugador() {
        // Aquí va el código para buscar un jugador
    }

    @Override
    public void listarJugadores() {
        // Crear una nueva instancia de EntityManager
        EntityManager em = JpaUtil.getEntityManager();

        try {
            // Crear una nueva instancia de Scanner para recoger los datos del usuario
            Scanner scanner = new Scanner(System.in);

            // Mostrar un listado de los equipos disponibles en la base de datos
            List<Equipo> equipos = em.createQuery("SELECT e FROM equipo e", Equipo.class).getResultList();
            if (equipos.isEmpty()) {
                System.out.println("No hay equipos registrados en la base de datos.");
            } else {
                System.out.println("Equipos disponibles:");
                for (Equipo equipo : equipos) {
                    System.out.println("ID: " + equipo.getIdEquipo() + ", Nombre: " + equipo.getNombre());
                }
            }

            // Pedir al usuario que introduzca el ID del equipo
            System.out.print("Introduce el ID del equipo: ");
            Long idEquipo = scanner.nextLong();

            // Ejecutar una consulta en la base de datos para obtener los jugadores del equipo especificado
            List<Jugador> jugadores = em.createQuery("SELECT j FROM jugador j WHERE j.idEquipo = :idEquipo", Jugador.class)
                    .setParameter("idEquipo", idEquipo)
                    .getResultList();

            // Imprimir los nombres de los jugadores obtenidos
            if (jugadores.isEmpty()) {
                System.out.println("No hay jugadores en el equipo con ID " + idEquipo);
            } else {
                System.out.println("Jugadores del equipo con ID " + idEquipo + ":");
                for (Jugador jugador : jugadores) {
                    System.out.println(jugador.getNombreJugador());
                }
            }
        } catch (Exception e) {
            // Capturar cualquier excepción y mostrar un mensaje de error
            System.out.println("Ha ocurrido un error al listar los jugadores: " + e.getMessage());
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }
}
