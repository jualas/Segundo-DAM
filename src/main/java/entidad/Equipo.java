package entidad;

import javax.persistence.*;
import java.util.List;

@Entity (name = "equipo") // Esta anotación indica que esta clase es una entidad en la base de datos.
@Table(name = "equipo")  // Esta anotación se utiliza para especificar el nombre de la tabla en la base de datos (Podriamos omitirla al tener la @Entity con el nombre de la tabla, pero es buena práctica especificarla siempre.)
public class Equipo {
    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esta anotación indica que el valor de este campo se genera automáticamente.
    @Id  // Esta anotación indica que este campo es la clave primaria de la entidad.
    @Column(name = "id_equipo")  // Esta anotación se utiliza para especificar el nombre de la columna en la base de datos.
    private int idEquipo;

    @Basic  // Esta anotación indica que este campo es una columna básica en la base de datos (no es una clave primaria ni una clave foránea).
    @Column(name = "nombre")  // Esta anotación se utiliza para especificar el nombre de la columna en la base de datos.
    private String nombre;

    @OneToMany(mappedBy = "equipoByIdEquipo")  // Esta anotación indica que existe una relación de uno a muchos con la entidad Jugador. El campo "equipoByIdEquipo" en la entidad Jugador es el propietario de la relación.
    private List<Jugador> jugadores;  // Esta lista representa a los jugadores que pertenecen a este equipo.

    // Los siguientes son los métodos getter y setter para los campos de la entidad.

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Jugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<Jugador> jugadores) {
        this.jugadores = jugadores;
    }

    // Los siguientes son los métodos equals y hashCode que se utilizan para comparar objetos de la entidad.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Equipo equipo = (Equipo) o;

        if (idEquipo != equipo.idEquipo) return false;
        if (nombre != null ? !nombre.equals(equipo.nombre) : equipo.nombre != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        return result;
    }
}