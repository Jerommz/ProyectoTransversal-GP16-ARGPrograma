package universidadulp.AccesoADatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import universidadulp.Entidades.Alumno;
import universidadulp.Entidades.Inscripcion;
import universidadulp.Entidades.Materia;

public class InscripcionData {

    private Connection con;

    MateriaData materiaDB = new MateriaData();
    AlumnoData alumnoDB = new AlumnoData();

    public InscripcionData() {

        this.con = Conexion.getConnection();

    }

    public void nuevoInscripcion(Inscripcion inscripcion) {
        String sql = "INSERT INTO inscripcion (nota,IdAlumno,idMateria) VALUES (? , ? , ?)";
        try {
            PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            ps.setDouble(1, inscripcion.getNota());
            ps.setInt(2, inscripcion.getAlumno().getIdAlumno());
            ps.setInt(3, inscripcion.getMateria().getIdMateria());
            ps.executeUpdate();
            ResultSet rs = ps.getGeneratedKeys();
            if (rs.next()) {
                inscripcion.setIdInscripcion(rs.getInt(1));
                JOptionPane.showMessageDialog(null, "Inscripción guardada exitosamente/nuevoInscripcion");
            } else {
                JOptionPane.showMessageDialog(null, "No se pudo guardar la inscripción/nuevoInscripcion");
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al guardar la inscripción/nuevoInscripcion" + ex.getMessage());
        }
    }

    public List<Inscripcion> obtenerInscripciones() {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "select * from inscripcion";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alumno = alumnoDB.buscarAlumno(rs.getInt("idAlumno"));
                Materia materia = materiaDB.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));
                inscripciones.add(inscripcion);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error.");
        }
        return inscripciones;
    }

    public List<Inscripcion> obtenerInscripcionesPorAlumno(int id) {
        List<Inscripcion> inscripciones = new ArrayList<>();
        String sql = "select idInscripto, idMateria, nota from inscripcion where idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Inscripcion inscripcion = new Inscripcion();
                inscripcion.setIdInscripcion(rs.getInt("idInscripto"));
                Alumno alumno = alumnoDB.buscarAlumno(id);
                Materia materia = materiaDB.buscarMateria(rs.getInt("idMateria"));
                inscripcion.setAlumno(alumno);
                inscripcion.setMateria(materia);
                inscripcion.setNota(rs.getDouble("nota"));
                inscripciones.add(inscripcion);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error.");
        }
        return inscripciones;
    }

    public List<Materia> obtenerMateriasCursadas(int id) {
        List<Materia> materiasCursadas = new ArrayList<>();
        String sql = "SELECT inscripcion.idMateria, nombre, año "
                + "FROM inscripcion, materia "
                + "WHERE inscripcion.idMateria = materia.idMateria AND inscripcion.idAlumno = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("inscripcion.idMateria"));
                materia.setNombre(rs.getString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materiasCursadas.add(materia);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias cursadas." + ex.getMessage());
        }
        return materiasCursadas;
    }

    public List<Materia> obtenerMateriasNoCursadas(int id) {
        List<Materia> materiasNoCursadas = new ArrayList<>();
        String sql = "SELECT idMateria, nombre, año "
                + "FROM materia "
                + "WHERE estado = 1 AND idMateria "
                + "NOT IN(SELECT idMateria FROM inscripcion WHERE inscripcion.idAlumno = ?);";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Materia materia = new Materia();
                materia.setIdMateria(rs.getInt("idMateria"));
                materia.setNombre(rs.getNString("nombre"));
                materia.setAnioMateria(rs.getInt("año"));
                materiasNoCursadas.add(materia);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al obtener materias no cursadas.");
        }
        return materiasNoCursadas;
    }

    public void borrarInscripcionMateriaAlumno(int idAlumno, int idMateria) {
        String sql = "delete from inscripcion where idAlumno = ? and idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idAlumno);
            ps.setInt(2, idMateria);

            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Inscripcion eliminada con exito.");
            } else {
                JOptionPane.showMessageDialog(null, "La inscripcion no pudo ser eliminada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al ingresar a la base de datos.");
        }
    }

    public void actualizarNota(int idAlumno, int idMateria, double nota) {
        String sql = "update inscripcion set nota = ? where idAlumno = ? and idMateria = ?";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setDouble(1, nota);
            ps.setInt(2, idAlumno);
            ps.setInt(3, idMateria);
            int exito = ps.executeUpdate();
            if (exito == 1) {
                JOptionPane.showMessageDialog(null, "Nota actualizada.");
            } else {
                JOptionPane.showMessageDialog(null, "La nota no pudo ser actualizada.");
            }
            ps.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al acceder a la base de datos.");
        }
    }

    public List<Alumno> obtenerAlumnosPorMateria(int idMateria) {
        ArrayList<Alumno> alumnosMateria = new ArrayList<>();
        String sql = "SELECT a.idAlumno, dni, apellido,nombre,fechaNacimiento,estado "
                + "FROM inscripcion i, alumno a WHERE i.idAlumno = a.idAlumno AND idMateria=? "
                + "AND estado = 1";
        try {
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, idMateria);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Alumno alu = new Alumno();
                alu.setIdAlumno(rs.getInt("idAlumno"));
                alu.setDni(rs.getInt("dni"));
                alu.setApellido(rs.getString("apellido"));
                alu.setNombre(rs.getString("nombre"));
                alu.setFechaNac(rs.getDate("fechaNacimiento").toLocalDate());
                alu.setActivo(rs.getBoolean("estado"));
                alumnosMateria.add(alu);
            }
            ps.close();
            rs.close();
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "error al obtener alumno x materia");
        }
        return alumnosMateria;
    }
}