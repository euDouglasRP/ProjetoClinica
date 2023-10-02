package javaprojetoclinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.model.Medico;
import javax.swing.JOptionPane;

public class MedicoDao {

    public void cadastraMedico(Medico medico) throws ExceptionDAO {
        String sql = "INSERT INTO medico (nome,cpf,crmv,especializacao,endereco) VALUES (?,?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, medico.getNome());
            pStatement.setString(2, medico.getCpf());
            pStatement.setString(3, medico.getCrmv());
            pStatement.setString(4, medico.getEspecializacao());
            pStatement.setString(5, medico.getEndereco());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Cadastro realizado com sucesso!");

        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao cadastrar o medico: " + e);
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

    public static ArrayList<Medico> getMedico() throws SQLException {
        ArrayList<Medico> listaMedico = new ArrayList<>();
        PreparedStatement pStatement = null;
        Connection connection = null;
        String sql = "SELECT id_Veterinario,nome,cpf,crmv,especializacao,endereco FROM medico ORDER BY id_Veterinario;";

        connection = new Conexao().getConnection();
        pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString(2);
                    String cpf = rs.getString(3);
                    String crmv = rs.getString(4);
                    String especializacao = rs.getString(5);
                    String endereco = rs.getString(6);

                    Medico med = new Medico(nome, cpf, crmv, especializacao, endereco);
                    med.setId(rs.getInt(1));
                    listaMedico.add(med);

                }
                return listaMedico;
            } catch (Exception e) {
            }
        }
        return null;
    }

    public void alteraMedico(Medico medico) throws ExceptionDAO {
        String sql = "UPDATE medico set nome = ?, cpf = ?,crmv = ?,especializacao = ?,endereco =? WHERE id_Veterinario = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, medico.getNome());
            pStatement.setString(2, medico.getCpf());
            pStatement.setString(3, medico.getCrmv());
            pStatement.setString(4, medico.getEspecializacao());
            pStatement.setString(5, medico.getEndereco());
            pStatement.setInt(6, medico.getId());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Aleteração realizado com sucesso!");

        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao alterar o medico: " + e);
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

    public void excluiMedico(int idMedico) throws ExceptionDAO {
        String sql = "DELETE FROM medico WHERE id_Veterinario = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, idMedico);
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "Exclusão realizada com sucesso !");
        } catch (Exception e) {
            throw new ExceptionDAO("Error ao excluir o medico: " + e);
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

}
