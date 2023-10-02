package javaprojetoclinicaveterinaria.dao;

import java.sql.*;
import javax.swing.*;


public class Conexao {
    
    
    public Connection getConnection(){
        Connection conn = null;
        
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/projetointegradorclinicavet", "root","");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return conn;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*
    private static final String URL = "jdbc:mysql://localhost:3306/projetointegradorclinicavet";
    private static final String USER = "root";
    
    private static final String DRIVER = "com.mysql.jdbc.Driver";
    private static final String SENHA = "";
    
    public static void executar(String query){
        try{
            Class.forName(DRIVER);
            
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            Statement st = conn.createStatement();
            st.execute(query);
            conn.close();
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }
        
    public static ResultSet consultar(String query){
        try{
            Class.forName(DRIVER);
            Connection conn = DriverManager.getConnection(URL,USER,SENHA);
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery(query);
            //   conn.close();
            return rs;
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString());
            return null;
        }
    }
*/
    
}
