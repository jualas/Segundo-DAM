package entidad;

import javax.persistence.*;

@Entity (name = "jugador") // Esta anotación indica que esta clase es una entidad en la base de datos.
@Table(name = "jugador")  // Esta anotación se utiliza para especificar el nombre de la tabla en la base de datos (Podriamos omitirla al tener la @Entity con el nombre de la tabla, pero es buena práctica especificarla siempre.)
public class Jugador {
    @Basic  // Esta anotación indica que este campo es una columna básica en la base de datos (no es una clave primaria ni una clave foránea).
    @Column(name = "id_equipo")  // Esta anotación se utiliza para especificar el nombre de la columna en la base de datos.
    private int idEquipo;

    @GeneratedValue(strategy = GenerationType.IDENTITY)  // Esta anotación indica que el valor de este campo se genera automáticamente.
    @Id  // Esta anotación indica que este campo es la clave primaria de la entidad.
    @Column(name = "id_jugador")  // Esta anotación se utiliza para especificar el nombre de la columna en la base de datos.
    private int idJugador;

    @Basic  // Esta anotación indica que este campo es una columna básica en la base de datos (no es una clave primaria ni una clave foránea).
    @Column(name = "nombre_jugador")  // Esta anotación se utiliza para especificar el nombre de la columna en la base de datos.
    private String nombreJugador;

    @ManyToOne  // Esta anotación indica que existe una relación de muchos a uno con la entidad Equipo.
    @JoinColumn(name = "id_equipo", insertable = false, updatable = false)  // Esta anotación se utiliza para especificar la columna que se utilizará para unir las entidades.
    private Equipo equipoByIdEquipo;  // Esta referencia representa al equipo al que pertenece este jugador.

    // Los siguientes son los métodos getter y setter para los campos de la entidad.

    public int getIdEquipo() {
        return idEquipo;
    }

    public void setIdEquipo(int idEquipo) {
        this.idEquipo = idEquipo;
    }

    public int getIdJugador() {
        return idJugador;
    }

    public void setIdJugador(int idJugador) {
        this.idJugador = idJugador;
    }

    public String getNombreJugador() {
        return nombreJugador;
    }

    public void setNombreJugador(String nombreJugador) {
        this.nombreJugador = nombreJugador;
    }

    public Equipo getEquipoByIdEquipo() {
        return equipoByIdEquipo;
    }

    public void setEquipoByIdEquipo(Equipo equipoByIdEquipo) {
        this.equipoByIdEquipo = equipoByIdEquipo;
    }

    // Los siguientes son los métodos equals y hashCode que se utilizan para comparar objetos de la entidad.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Jugador jugador = (Jugador) o;

        if (idEquipo != jugador.idEquipo) return false;
        if (idJugador != jugador.idJugador) return false;
        if (nombreJugador != null ? !nombreJugador.equals(jugador.nombreJugador) : jugador.nombreJugador != null)
            return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idEquipo;
        result = 31 * result + idJugador;
        result = 31 * result + (nombreJugador != null ? nombreJugador.hashCode() : 0);
        return result;
    }
}