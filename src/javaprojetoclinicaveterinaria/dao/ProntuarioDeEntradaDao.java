package javaprojetoclinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.model.ProntuarioDeEntrada;
import javax.swing.JOptionPane;

public class ProntuarioDeEntradaDao {

    public void cadastrarProntuarioDeEntrada(ProntuarioDeEntrada prontuarioDeEntrada) throws ExceptionDAO {
        String sql = "INSERT INTO prontuariodeentrada (descricao,data_de_entrada,id_Animal,id_Veterinario) VALUES (?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, prontuarioDeEntrada.getDescricao());
            pStatement.setString(2, prontuarioDeEntrada.getData_de_entrada());
            pStatement.setInt(3, prontuarioDeEntrada.getId_Animal());
            pStatement.setInt(4, prontuarioDeEntrada.getId_Veterinario());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");
        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao cadastrar o Prontuario de Entrada: " + e);
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

    public void editarProntuarioDeEntrada(ProntuarioDeEntrada prontuarioDeEntrada) throws ExceptionDAO {
        String sql = "UPDATE prontuariodeentrada SET descricao = ?,data_de_entrada = ?,id_Animal = ?,id_Veterinario = ? WHERE id_ProntuariaDeEntrada = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, prontuarioDeEntrada.getDescricao());
            pStatement.setString(2, prontuarioDeEntrada.getData_de_entrada());
            pStatement.setInt(3, prontuarioDeEntrada.getId_Animal());
            pStatement.setInt(4, prontuarioDeEntrada.getId_Veterinario());
            pStatement.setInt(5, prontuarioDeEntrada.getId());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Alteração foi realizado com sucesso!");
        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao editar o Prontuario de Entrada: " + e);
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

    public void excluirProntuarioDeEntrada(int idProntuarioDeEntrada) throws ExceptionDAO {
        String sql = "DELETE FROM prontuariodeentrada WHERE id_ProntuariaDeEntrada = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setInt(1, idProntuarioDeEntrada);
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

    public static ArrayList<ProntuarioDeEntrada> getProntuariodeEntrada() throws SQLException {
        ArrayList<ProntuarioDeEntrada> listaProntuarioDeEntrada = new ArrayList<>();
        PreparedStatement pStatement = null;
        Connection connection = null;

        String sql = "SELECT id_ProntuariaDeEntrada,descricao,data_de_entrada,id_Animal,id_Veterinario FROM prontuariodeentrada ORDER BY id_ProntuariaDeEntrada";

        connection = new Conexao().getConnection();
        pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String descricao = rs.getString(2);
                    String data_de_entrada = rs.getString(3);
                    int id_Animal = rs.getInt(4);
                    int id_Veterinario = rs.getInt(5);

                    ProntuarioDeEntrada prtEntrada = new ProntuarioDeEntrada(descricao, data_de_entrada, id_Animal, id_Veterinario);
                    prtEntrada.setId(rs.getInt(1));
                    listaProntuarioDeEntrada.add(prtEntrada);
                }
                return listaProntuarioDeEntrada;
            } catch (Exception e) {
            }
        }
        return null;
    }
}
