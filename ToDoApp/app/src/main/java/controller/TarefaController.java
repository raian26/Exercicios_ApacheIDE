/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import model.Tarefa;
import util.ConnectionFactory;

/**
 *
 * @author raian
 */
public class TarefaController {
    // classe de controle de acesso ao banco de dados que buscam as informações e trazem para a aplicação
    // criamos 4 metodos para as operações básicas para recebermos as informações do banco e enviarmos 

    public void save(Tarefa tarefa) {
        String sql = "INSERT INTO tarefas(idprojeto ,nome ,descricao,"
                + "observacao ,prazo, iscompleted,  criacaodata ,atualizacaodata) VALUES(?,?,?,?,?,"
                + "?,?,?)";
        Connection connection = null;
        PreparedStatement statement = null;

        try {
            //Criação da conexão com o banco de dados
            connection = ConnectionFactory.getConnection();
            // preparando a query
            statement = connection.prepareStatement(sql);
           
             statement.setInt(1, tarefa.getIdprojeto());
            statement.setString(2, tarefa.getNome());
            statement.setString(3, tarefa.getDescricao());
            statement.setString(4, tarefa.getObservacao());
            statement.setDate(5, new Date(tarefa.getPrazo().getTime())); // aqui eu preciso utilzar o Date do sql que é diferente do java.util
            statement.setBoolean(6, tarefa.isIscompleted());
            statement.setDate(7, new Date(tarefa.getCriacaodata().getTime()));// nesse caso é como se fosse uma conversão 
            statement.setDate(8, new Date(tarefa.getAtualizacaodata().getTime()));
            statement.execute();

        } catch (Exception ex) {
            throw new RuntimeException("Erro ao salvar a tarefa!"
                    + ex.getMessage(), ex);
        } finally {

            // Fecha o conexão ao final da execução 
            ConnectionFactory.closeConnection(connection, statement);

        }

    }

    public void update(Tarefa tarefa) throws Exception {

        String sql = "UPDATE tarefas SET idprojeto =?, nome =?, descricao =?,"
                + "observacao =?, prazo =?, iscompleted=?, criacaodata =?,"
                + "atualizacaodata =? WHERE id =?";
               
                

        Connection connection = null;
        PreparedStatement statement = null;

        try {
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            
            statement.setInt(1, tarefa.getIdprojeto());
            statement.setString(2, tarefa.getNome());
            statement.setString(3, tarefa.getDescricao());
            statement.setString(4, tarefa.getObservacao());
            statement.setDate(5, new Date(tarefa.getPrazo().getTime())); // aqui eu preciso utilzar o Date do sql que é diferente do java.util
            statement.setBoolean(6, tarefa.isIscompleted());
            statement.setDate(7, new Date(tarefa.getCriacaodata().getTime()));// nesse caso é como se fosse uma conversão 
            statement.setDate(8, new Date(tarefa.getAtualizacaodata().getTime()));
            statement.setInt(9, tarefa.getId());

            statement.execute();
        } 
        catch (SQLException ex) {throw new 
        Exception ("Erro ao atualizar a tarefa!"
                +  ex.getMessage(), ex);
        }
        finally {
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexÃo", ex);
            }
        }
    }

    public void removeByID(int tarefaId) throws Exception  {
        String sql = "DELETE FROM tarefas WHERE id = ?";
        Connection conn = null;
        PreparedStatement statement = null;
        try {
            //Criação da conexão com o banco de dados 
            conn = ConnectionFactory.getConnection();  // variavel estabele a conexão com o banco de dados
            
            //Preparando a query
            statement = conn.prepareStatement(sql);   // objeto do tipo statement, ele ajuda preparar o comando sql que será executado do DB
            
            //Setando os valores 
            statement.setInt(1, tarefaId); // troca o paramentro 1 que é o ?, e muda para o valor que vier quando o metodo for chamado
            
            statement.execute();
            
        } catch (SQLException e) {
            throw new Exception ("Erro ao deletar a tarefa!");
        }  try {
                if (statement != null) {
                    statement.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexão", ex); // fecha a conexão independente do try catch
        }
    }
    //pega todas as tarefas de um projeto

    public List<Tarefa> getAll(int idprojetos) {
        
        // Montagem da QuerySQL, para buscar a tarefa com base no projeto ao qual a tarefa pertence
        String sql = "SELECT * FROM tarefas";
        List<Tarefa> tarefas = new ArrayList<Tarefa>(); //Lista de tarefas que será devolvida quando a chamada do metodo acontecer
        Connection connection = null;
        PreparedStatement statement = null;
        ResultSet resultSet = null;       // objeto que representa o retorno(resposta) do banco de dados, ou seja guarda a resp do banco de dados

        try{
            connection = ConnectionFactory.getConnection();
            statement = connection.prepareStatement(sql);
            //statement.setInt(1, idprojetos); //aqui eu seto o id do projeto ao qual a tarefa pertence//
            resultSet = statement.executeQuery();
            // Aqui eu coloco uma condição que para ele adicionar a tarefa em uma lista que eu crie/*i na linhas 113*/
            while(resultSet.next()){
                Tarefa tarefa = new Tarefa();
                tarefa.setId(resultSet.getInt("id"));
                tarefa.setIdprojeto(resultSet.getInt("idprojeto"));
                tarefa.setNome(resultSet.getString("nome"));
                tarefa.setDescricao(resultSet.getString("descricao"));
                tarefa.setIscompleted(resultSet.getBoolean("iscompleted"));
                tarefa.setObservacao(resultSet.getString("observacao"));
                tarefa.setPrazo(resultSet.getDate("prazo"));
                tarefa.setCriacaodata(resultSet.getDate("criacaodata"));
                tarefa.setAtualizacaodata(resultSet.getDate("atualizacaodata"));
                
                tarefas.add(tarefa);
                
            }
            
            
        } catch(SQLException ex){
            throw new RuntimeException(ex.getMessage()
                    + "Erro !", ex);
        } finally{
            ConnectionFactory.closeConnection(connection, statement, resultSet);
            
            
        }
        // Devolve a lista de tarefas que foi criada e carregada do banco de dados
        return tarefas;
    }
    
    public List<Tarefa> getByProjetoId(int id) {
        String sql = "SELECT * FROM tarefas where idprojeto = ?";

        List<Tarefa> tarefas = new ArrayList<>();

        Connection conn = null;
        PreparedStatement stmt = null;

        //Classe que vai recuperar os dados do banco de dados
        ResultSet rset = null;

        try {
            conn = ConnectionFactory.getConnection();
            stmt = conn.prepareStatement(sql);

            stmt.setInt(1, id);

            rset = stmt.executeQuery();

            //Enquanto existir dados no banco de dados, faï¿½a
            while (rset.next()) {

                Tarefa tarefa = new Tarefa();

                tarefa.setId(rset.getInt("id"));
                tarefa.setIdprojeto(rset.getInt("idProjeto"));
                tarefa.setNome(rset.getString("nome"));
                tarefa.setDescricao(rset.getString("descricao"));
                tarefa.setObservacao(rset.getString("observacao"));
                tarefa.setPrazo(rset.getDate("deadline"));
                tarefa.setIscompleted(rset.getBoolean("iscompleted"));
                tarefa.setCriacaodata(rset.getDate("criacaodata"));
                tarefa.setAtualizacaodata(rset.getDate("atualizacaodata"));

                //Adiciono o contato recuperado, a lista de contatos
                tarefas.add(tarefa);
            }
        } catch (SQLException ex) {
            throw new RuntimeException("Erro ao buscar as tarefas", ex);
        } finally {
            try {
                if (rset != null) {
                    rset.close();
                }
                if (stmt != null) {
                    stmt.close();
                }
                if (conn != null) {
                    conn.close();
                }
            } catch (SQLException ex) {
                throw new RuntimeException("Erro ao fechar a conexÃo", ex);
            }
        }
        return tarefas;
    }

}
