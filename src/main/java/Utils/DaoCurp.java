package Utils;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DaoCurp {
    Connection conn;
    PreparedStatement pstm;
    ResultSet rs;

    private final String INSERT_OPERATION = "insert into persona(nombre, apellido_P, apellido_M, sexo, estado, fechaN, curp) "
            + "values(?,?,?,?,?,?,?)";
    private final String GET_OPERATIONS = "select * from persona where curp = ?";

    public boolean saveInformacion(String nombre, String apellido_P, String apellido_M, String sexo, String estado, Date fechaN, String curp){
        try{
            conn = new MySQLConnection().getConnection();
            String query = INSERT_OPERATION;
            pstm = conn.prepareStatement(query);
            pstm.setString(1, nombre);
            pstm.setString(2, apellido_P);
            pstm.setString(3, apellido_M);
            pstm.setString(4, sexo);
            pstm.setString(5, estado);
            pstm.setDate(6, fechaN);
            pstm.setString(7, curp);

            return pstm.executeUpdate()==1;
        }catch(SQLException e){
            Logger.getLogger(DaoCurp.class.getName())
                    .log(Level.SEVERE, "Error saveOperation ->", e);
            return false;
        }
    }

    public ArrayList<BeanCurp> showInformacion (String curp){
        ArrayList<BeanCurp> curpList = new ArrayList<>();
        BeanCurp informacion = null;
        try{
            conn = new MySQLConnection().getConnection();
            String query = GET_OPERATIONS;
            pstm = conn.prepareStatement(query);
            pstm.setString(1,curp);
            rs = pstm.executeQuery();
            while(rs.next()){
                informacion = new BeanCurp();
                informacion.setNombre(rs.getString("nombre"));
                informacion.setApellido_P(rs.getString("apellido_P"));
                informacion.setApellido_M(rs.getString("apellido_M"));
                informacion.setSexo(rs.getString("sexo"));
                informacion.setEstado(rs.getString("estado"));
                informacion.setFechaN(rs.getDate("fechaN"));
                informacion.setCurp(rs.getString("curp"));

                curpList.add(informacion);
            }
        }catch(SQLException e){
        }finally{
            closeConnections();
        }
        return curpList;
    }

    public void  closeConnections(){
        try{
            if(conn != null){
                conn.close();
            }
            if(pstm != null){
                pstm.close();
            }
            if(rs != null){
                rs.close();
            }
        }catch(Exception e){
            System.out.println(e);
        }
    }
}
