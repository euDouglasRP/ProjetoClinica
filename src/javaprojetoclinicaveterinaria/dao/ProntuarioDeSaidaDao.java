package javaprojetoclinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.model.ProntuarioDeEntrada;
import javaprojetoclinicaveterinaria.model.ProntuarioDeSaida;
import javax.swing.JOptionPane;


public class ProntuarioDeSaidaDao {
    
    public void cadastrarProntuarioDeSaida(ProntuarioDeSaida prontuarioDeSaida) throws ExceptionDAO {
        String sql = "INSERT INTO prontuariodesaida (id_ProntuarioDeEntrada,descricao,data_de_saida) VALUES (?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, prontuarioDeSaida.getIdProntuarioDeEntrada());
            pStatement.setString(2,prontuarioDeSaida.getDescicao() );
            pStatement.setString(3, prontuarioDeSaida.getData_de_saida());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao cadastrar o Prontuario de Saida: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statment: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }

    }
    
    public void editarProntuarioDeSaida(ProntuarioDeSaida prontuarioDeSaida) throws ExceptionDAO{
        String sql = "UPDATE prontuariodesaida set id_ProntuarioDeEntrada = ? descricao = ? data_de_saida = ? WHERE = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, prontuarioDeSaida.getIdProntuarioDeEntrada());
            pStatement.setString(2,prontuarioDeSaida.getDescicao() );
            pStatement.setString(3, prontuarioDeSaida.getData_de_saida());
            pStatement.setInt(4,prontuarioDeSaida.getId());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Alteraçao realizado com sucesso!");
        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao Editar o Prontuario de Saida: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statment: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }
    
    public void excluirProntuarioDeSaida(int idProntuarioDeSaida) throws ExceptionDAO {
        String sql = "DELETE FROM prontuariodesaida WHERE id_ProntuarioDeSaida = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setInt(1, idProntuarioDeSaida);
            pStatement.execute();
            JOptionPane.showMessageDialog(null, "A excluisao foi realizado com sucesso!");
        } catch (Exception e) {
            throw new ExceptionDAO("Error ao excluir o cliente: " + e);
        } finally {
            try {
                if (pStatement != null) {
                    pStatement.close();
                }

            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar o Statment: " + e);
            }
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                throw new ExceptionDAO("Erro ao fechar a conexão: " + e);
            }
        }
    }

    public static ArrayList<ProntuarioDeSaida> getProntuarioDeSaida() throws SQLException {
        ArrayList<ProntuarioDeSaida> listaProntuarioDeSaida = new ArrayList<>();
        PreparedStatement pStatement = null;
        Connection connection = null;

        String sql = "SELECT id_ProntuarioDeSaida,id_ProntuarioDeEntrada,descricao,data_de_saida FROM prontuariodesaida ORDER BY id_ProntuarioDeSaida";

        connection = new Conexao().getConnection();
        pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    int id_ProntuarioDeEntrada = rs.getInt(2);
                    String descricao = rs.getString(3);
                    String data_de_saida = rs.getString(4);
                       
                    
                    ProntuarioDeSaida prtSaida = new ProntuarioDeSaida(id_ProntuarioDeEntrada, descricao, data_de_saida);
                    prtSaida.setId(rs.getInt(1));
                    listaProntuarioDeSaida.add(prtSaida);
                }
                return listaProntuarioDeSaida;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
