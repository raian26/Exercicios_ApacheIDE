/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Projeto;
import util.ConnectionFactory;


/**
 *
 * @author raian
 */
public class ProjetoController {
    
     public void save(Projeto projeto) {
        String sql = "INSERT INTO projetos(nome ,descricao,"
                + "criacaodata ,atualizacaodata) VALUES(?,?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;
        
          try {
            //Criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            // preparando a query
            statement = connection.prepareStatement(sql);
           
            statement.setString(1, projeto.getNome());
            statement.setString(2, projeto.getDescricao());
            statement.setDate(3, new Date(projeto.getCriacaodata().getTime()));// aqui eu preciso utilzar o Date do sql que é diferente do java.util
            statement.setDate(4, new Date(projeto.getAtualizacaodata().getTime()));
            statement.execute();

        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao salvar a projeto!"
                    + ex.getMessage(), ex);
        } finally {

            // Fecha o conexão ao final da execução 
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void update(Projeto projeto) throws Exception {

        String sql = "UPDATE projetos SET nome = ?,"
                + "descricao=?,"
                + "criacaodata =?,"
                + "atualizacaodata =?,"
                + "WHERE id = ?"; // utilizo como filtro do uptade o id do produto, ele busca pelo id e atualiza os atributos setados

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setString(1, projeto.getNome());
            statement.setString(2, projeto.getDescricao());
            statement.setDate(3, new Date(projeto.getCriacaodata().getTime()));// aqui eu preciso utilzar o Date do sql que é diferente do java.util
            statement.setDate(4, new Date(projeto.getAtualizacaodata().getTime()));
            statement.setInt(5, projeto.getId());
            statement.execute();
        } catch (SQLException ex) {throw new 
        Exception ("Erro ao atualizar o projeto!");
        }
    }
    // não usamos parametros dentro porque não precisamos filtrar, buscaremos todos os projetos
    public List<Projeto> getAll() throws java.lang.Exception  {
        
        // Montagem da QuerySQL, para buscar a tarefa com base no projeto ao qual a tarefa pertence
        String sql = "SELECT * FROM projetos";
        
        List<Projeto> projetos = new ArrayList<>();
        
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;  // objeto que representa o retorno(resposta) do banco de dados, ou seja guarda a resp do banco de dados
        
       try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            resultSet = statement.executeQuery();
        
            while(resultSet.next()){
            
                Projeto projeto = new Projeto();
                
                projeto.setId(resultSet.getInt("id"));
                projeto.setNome(resultSet.getString("nome"));
                projeto.setDescricao(resultSet.getString("descricao"));
                projeto.setCriacaodata(resultSet.getDate("criacaodata"));
                projeto.setAtualizacaodata(resultSet.getDate("atualizacaodata"));
        
                projetos.add(projeto);
        }
         } catch(SQLException ex){
            throw  Exception("Erro !");
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);   
        }
        // Devolve a lista de tarefas que foi criada e carregada do banco de dados
        return projetos;
    }
    

    public void removeById(int id) {

        String sql = "DELETE FROM projects WHERE id = ?";

        Connection conn = null;
        PreparedStatement statement = null;

        try {
            conn = ConnectionFactory.getConnection();
            statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.execute();
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao deletar o projeto", ex);
        } finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex);
            }
        }

    }

    private Exception Exception(String erro_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}

    

