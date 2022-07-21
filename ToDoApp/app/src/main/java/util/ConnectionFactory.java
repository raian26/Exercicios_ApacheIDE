/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


/**
 *
 * @author raian
 */
public class ConnectionFactory {
    // atributo indicando que iremos utilizar o jbdc conectanto a aplicação com o SQL
    public static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // endereço de conexão da aplicação com o banco dde dados
    public static final String URL = "jdbc:mysql://localhost:3306/projetoapp";
    // usuario que pode ser informado, por padrão o user é o root    
    public static final String USER = "root";
    // senha do DB, padrão é vazio 
    public static final String PASS = "";
    
    
    
    public static Connection getConnection(){
        try{
            Class.forName(DRIVER);
            return DriverManager.getConnection(URL,USER,PASS);
        }catch(ClassNotFoundException | SQLException ex){
            throw new RuntimeException("Erro na conexão com o banco de dados!", ex);
        }
    }
        public static void closeConnection(Connection connection){
            try{
                if(connection != null){
                    connection.close();   
                }
            }catch(SQLException ex){ 
               throw new RuntimeException("Erro ao fechar a conexão com o "
                       + "banco de dados!", ex);
            }
            
        }
        
        public static void closeConnection(Connection connection,PreparedStatement statement){
            try{
                if(connection != null){
                    connection.close();   
                }
                if (statement != null){
                    statement.close();
                }
            }catch(SQLException ex){ 
               throw new RuntimeException("Erro ao fechar a conexão com o "
                       + "banco de dados!", ex);
            }
            
        }
       
        public static void closeConnection(Connection connection,PreparedStatement statement, ResultSet resultSet){
            try{
                if(connection != null){
                    connection.close();   
                }
                if (statement != null){
                    statement.close();
                }
                if (resultSet != null){
                    resultSet.close();
                }
            }catch(SQLException ex){ 
               throw new RuntimeException("Erro ao fechar a conexão com o "
                       + "banco de dados!", ex);
            }
            
        }
    
}
