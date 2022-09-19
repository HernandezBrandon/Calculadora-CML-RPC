package controller;

import MySQLConnection.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DaoCalculadora {

    Connection con;
    PreparedStatement pstm;
    String registro_nuevo = "INSERT INTO historial("+
            "id,operacion,numero1,numero2,resultado,fecha) VALUE(?,?,?,?,?,?)";

    public BeanCalculadora insertar(int id,String operacion,double numero1,double numero2,double resultado,String fecha) throws SQLException {
        BeanCalculadora bean = new BeanCalculadora();

        try{
            con= MySQLConnection.getConnection();
            pstm=con.prepareStatement(registro_nuevo);
            pstm.setInt(1,id);
            pstm.setString(2,operacion);
            pstm.setDouble(3,numero1);
            pstm.setDouble(4,numero2);
            pstm.setDouble(5,resultado);
            pstm.setString(6,fecha);
            int r=pstm.executeUpdate();
            if (r==1){
                bean.setId(id);
                bean.setOperacion(operacion);
                bean.setNumero1(numero1);
                bean.setNumero2(numero2);
                bean.setResultado(resultado);
                bean.setFecha(fecha);
            }else
                bean=null;
        }catch (SQLException e){
            System.out.println("Error en el metodo de insertar  "+e.getMessage());
        }finally {
            try{
                pstm.close();
                con.close();
            }catch (SQLException e){
                System.out.println("Error al cerrar las conexiones " +e.getMessage());
            }

        }
        return bean;

    }

}
