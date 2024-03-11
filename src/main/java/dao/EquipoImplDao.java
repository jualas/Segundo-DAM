package dao;

import entidad.Equipo;
import util.JpaUtil;

import javax.persistence.EntityManager;
import java.util.List;
import java.util.Scanner;


public class EquipoImplDao implements EquipoDao {

    @Override
    public void crearEquipo() {
        EntityManager em = null;
        try {
            // Mostrar los nombres de los equipos actuales
            mostrarNombresEquipos();

            // Pedir al usuario que introduzca el nombre del nuevo equipo
            Scanner scanner = new Scanner(System.in);
            System.out.print("Introduce el nombre del nuevo equipo: ");
            String nombreEquipo = scanner.nextLine();

            // Crear una nueva instancia de Equipo y establecer su nombre
            Equipo nuevoEquipo = new Equipo();
            nuevoEquipo.setNombre(nombreEquipo);

            // Iniciar una transacción, persistir el nuevo equipo en la base de datos y confirmar la transacción
            em = JpaUtil.getEntityManager();
            em.getTransaction().begin();
            em.persist(nuevoEquipo);
            em.getTransaction().commit();

            // Mostrar un mensaje de éxito
            System.out.println("El equipo " + nombreEquipo + " ha sido creado con éxito.");
        } catch (Exception e) {
            // Capturar cualquier excepción y mostrar un mensaje de error
            System.out.println("Ha ocurrido un error al crear el equipo: " + e.getMessage());
        } finally {
            // Cerrar el EntityManager
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
    public void añadirJugador() {
        // Aquí va el código para añadir un jugador a un equipo
    }

    @Override
    public void mostrarNombresEquipos() {
        EntityManager em = null;
        try {
            em = JpaUtil.getEntityManager();
            List<Equipo> equipos = em.createQuery("SELECT e FROM equipo e", Equipo.class).getResultList();
            if (equipos.isEmpty()) {
                System.out.println("No hay equipos registrados en la base de datos.");
            } else {
                System.out.println("Nombres de los equipos:");
                for (Equipo equipo : equipos) {
                    System.out.println(equipo.getNombre());
                }
            }
        } catch (Exception e) {
            System.out.println("Ha ocurrido un error al mostrar los nombres de los equipos: " + e.getMessage());
        } finally {
            if (em != null) {
                em.close();
            }
        }
    }

    @Override
public void actualizarNombreEquipo() {
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
        System.out.print("Introduzca el Id del equipo cuyo nombre quiere actualizar: ");
        Integer idEquipo = scanner.nextInt();
        scanner.nextLine(); // consume the newline

        // Buscar el equipo en la base de datos utilizando el ID proporcionado por el usuario
        Equipo equipo = em.find(Equipo.class, idEquipo);
        if (equipo == null) {
            System.out.println("No se ha encontrado ningún equipo con el ID " + idEquipo);
            return;
        }

        // Pedir al usuario que introduzca el nuevo nombre del equipo
        System.out.print("Introduce el nuevo nombre del equipo: ");
        String nuevoNombre = scanner.nextLine();

        // Actualizar el nombre del equipo con el nuevo nombre proporcionado por el usuario
        equipo.setNombre(nuevoNombre);

        // Confirmar la transacción
        em.getTransaction().commit();

        // Mostrar un mensaje de éxito
        System.out.println("El nombre del equipo ha sido actualizado con éxito a " + nuevoNombre);
    } catch (Exception e) {
        // Capturar cualquier excepción y mostrar un mensaje de error
        System.out.println("Ha ocurrido un error al actualizar el nombre del equipo: " + e.getMessage());
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
    public void borrarJugador() {
        // Aquí va el código para borrar un jugador de un equipo
    }
}