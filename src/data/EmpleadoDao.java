package data;

import config.ConnectionConfig;
import model.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoDao {

    Empleado empleado = new Empleado();

    private static final String GET_EMPLEADO = "select * from funcionarios";

    private static final String CREATE_EMPLEADO = "insert into funcionarios (doc_identificacion, nombres, apellidos, telefono, direccion, fecha_nacimiento, estado_civil) "
            + "values (?, ?, ?, ?, ?, ?, ?)";

    private static final String GET_EMPLEADO_BY_ID = "select * from funcionarios where doc_identificacion = ? ";

    private static final String UPDATE_EMPLEADO = "update funcionarios set doc_identificacion = ?, nombres = ?, apellidos = ?, telefono = ?,"
            +" direccion = ?, fecha_nacimiento = ?, estado_civil = ? ";

    private static final String DELETE_EMPLEADO = "delete from funcionarios where doc_identificacion = ? ";


    public void createEmpleado(Empleado empleado) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {

            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareCall(CREATE_EMPLEADO);
            preparedStatement.setInt(1,    empleado.getDoc_identificacion());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getApellido());
            preparedStatement.setString(4, empleado.getTelefono());
            preparedStatement.setString(5, empleado.getDireccion());
            preparedStatement.setDate(6, empleado.getFecha_nacimiento());
            preparedStatement.setString(7, empleado.getEstado_civil());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();

            }
        }
    }

    public List<Empleado> getEmpleados() throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        List<Empleado> empleados = new ArrayList<>();

        try {

            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_EMPLEADO);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {

                Empleado empleado = new Empleado();
                empleado.setDoc_identificacion(resultSet.getInt("doc_identificacion"));
                empleado.setNombre(resultSet.getString("nombres"));
                empleado.setApellido(resultSet.getString("apellidos"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                empleado.setEstado_civil(resultSet.getString("estado_civil"));
                empleados.add(empleado);
            }

            } catch (ClassNotFoundException ex) {
            throw new RuntimeException(ex);

        } finally {

            if (connection != null) {
                connection.close();
            }

            if (preparedStatement != null) {
                preparedStatement.close();
            }

            if (resultSet != null) {
                resultSet.close();
            }
        }    return empleados;
    }

    public Empleado getEmpleadoById(int docIdentificacion) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        Empleado empleado = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(GET_EMPLEADO_BY_ID);
            preparedStatement.setInt(1, docIdentificacion);
            resultSet = preparedStatement.executeQuery();

            if (resultSet.next()) {
                empleado = new Empleado();
                empleado.setDoc_identificacion(resultSet.getInt("doc_identificacion"));
                empleado.setNombre(resultSet.getString("nombres"));
                empleado.setApellido(resultSet.getString("apellidos"));
                empleado.setTelefono(resultSet.getString("telefono"));
                empleado.setDireccion(resultSet.getString("direccion"));
                empleado.setFecha_nacimiento(resultSet.getDate("fecha_nacimiento"));
                empleado.setEstado_civil(resultSet.getString("estado_civil"));
            }
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        }
        return empleado;
    }

    public void updateEmpleado(Empleado empleado) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(UPDATE_EMPLEADO);
            preparedStatement.setInt(1, empleado.getDoc_identificacion());
            preparedStatement.setString(2, empleado.getNombre());
            preparedStatement.setString(3, empleado.getApellido());
            preparedStatement.setString(4, empleado.getTelefono());
            preparedStatement.setString(5, empleado.getDireccion());
            preparedStatement.setDate(6, empleado.getFecha_nacimiento());
            preparedStatement.setString(7, empleado.getEstado_civil());
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }


    public void deleteEmpleado(int docIdentificacion) throws SQLException {

        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            connection = ConnectionConfig.getConnection();
            preparedStatement = connection.prepareStatement(DELETE_EMPLEADO);
            preparedStatement.setInt(1, docIdentificacion);
            preparedStatement.executeUpdate();

        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } finally {
            if (connection != null) {
                connection.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
        }
    }

}
