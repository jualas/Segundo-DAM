package util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

// Esta clase proporciona un método estático para obtener un EntityManager.
public class JpaUtil {
    // Declaramos una variable estática para el EntityManagerFactory.
    // Esta es la fábrica que crea los EntityManager, que son los que nos permiten interactuar con la base de datos.
    private static final EntityManagerFactory emFactory;

    // En un bloque estático, inicializamos el EntityManagerFactory.
    // Este bloque se ejecuta una vez cuando la clase se carga en memoria.
    // "default" es el nombre de la unidad de persistencia que hemos definido en el archivo persistence.xml.
    static {
        emFactory = Persistence.createEntityManagerFactory("default");
    }

    // Este método estático nos permite obtener un EntityManager.
    // Cada vez que necesitemos interactuar con la base de datos, podemos llamar a este método para obtener un EntityManager.
    public static EntityManager getEntityManager() {
        return emFactory.createEntityManager();
    }

    // Este método estático nos permite cerrar el EntityManagerFactory.
    // Deberíamos llamar a este método cuando ya no necesitemos interactuar con la base de datos,
    // por ejemplo, cuando nuestra aplicación se esté cerrando.
    public static void close() {
        emFactory.close();
    }
}

