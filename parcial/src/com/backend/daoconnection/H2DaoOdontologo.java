package com.backend.daoconnection;

import com.backend.Odontologo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class H2DaoOdontologo implements IDao <Odontologo> {
    private final Logger LOGGER = Logger.getLogger(String.valueOf(H2DaoOdontologo.class));


    @Override
    public Odontologo registrar(Odontologo odontologo) {
        Connection connection = null;
        Odontologo odontologoRegistrado = null;

        try {
            connection = H2Connection.getConnection();


            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO ODONTOLOGO (NOMBRE, APELLIDO, NUMEROMATRICULA) VALUES (?,?,?)", Statement.RETURN_GENERATED_KEYS);
            preparedStatement.setString(1, odontologo.getNombre());
            preparedStatement.setString(2, odontologo.getApellido());
            preparedStatement.setInt(3, odontologo.getNumeroMatricula());
            preparedStatement.execute();

            ResultSet resultSet = preparedStatement.getGeneratedKeys();
            odontologoRegistrado = new Odontologo(odontologo.getNombre(), odontologo.getApellido(), odontologo.getNumeroMatricula());

            while (resultSet.next()) {
                odontologoRegistrado.setId(resultSet.getInt("id"));
            }

        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            if (connection != null) {

                try {
                    connection.rollback();
                    e.printStackTrace();
                    LOGGER.info("Hubo un problema");
                    LOGGER.warning(e.getMessage());

                } catch (SQLException exception) {
                    LOGGER.warning(e.getMessage());
                }
            }


        } finally {
            try {

                connection.close();
            } catch (Exception exception) {
                LOGGER.warning("Tuvimos un problema" + exception.getMessage());
            }


        }
        return odontologoRegistrado;
    }


    @Override
    public Odontologo guardar(int odontologo) {
        Connection connection = null;

        Odontologo odontologoGuardado = null;

        try {
            connection = H2Connection.getConnection();






        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            if (connection != null) {

                try {
                    connection.rollback();
                    e.printStackTrace();
                    LOGGER.info("No se guardo");
                    LOGGER.warning(e.getMessage());

                } catch (SQLException exception) {
                    LOGGER.warning(exception.getMessage());
                }
            }


        } finally {
            try {

                connection.close();
            } catch (Exception exception) {
                LOGGER.warning("Tuvimos un problema" + exception.getMessage());
            }


        }
        return odontologoGuardado;
    }




    @Override
    public List<Odontologo> listarTodos() {
        Connection connection = null;

        try {
        } catch (Exception e) {
            LOGGER.warning(e.getMessage());
            e.printStackTrace();


        } finally {
            try {
                connection.close();
            } catch (Exception e) {
                LOGGER.warning("Ocurrio un error" + e.getMessage());
                e.printStackTrace();

            }
        }
        return null;
    }

    private Odontologo crearObjetoOdontologo(ResultSet resultSet) throws SQLException {


        return new Odontologo(resultSet.getString("nombre"), resultSet.getString("apellido"), resultSet.getInt("numeroMatricula"));
    }
    private List<Odontologo> odontologos;
    public H2DaoOdontologo(){
        odontologos = new ArrayList<>();
    }
    public void
    guardarOdontologo(Odontologo odontologo){
        odontologos.add(odontologo);
    }
    public List<Odontologo> listarOdontologos(){
        return odontologos;
    }

}


