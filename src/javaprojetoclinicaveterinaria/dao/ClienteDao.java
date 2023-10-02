package javaprojetoclinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.*;
import javaprojetoclinicaveterinaria.model.Cliente;
import javax.swing.JOptionPane;

public class ClienteDao {

    public void cadastraCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "INSERT INTO cliente (nome, cpf, telefone, email, endereco) VALUES (?,?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getCpf());
            pStatement.setString(3, cliente.getTelefone());
            pStatement.setString(4, cliente.getEmail());
            pStatement.setString(5, cliente.getEndereco());
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso!");
        } catch (SQLException e) {
            throw new ExceptionDAO("Error ao cadastrar o cliente: " + e);
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

    public static ArrayList<Cliente> getCliente() throws SQLException {
        ArrayList<Cliente> listaCliente = new ArrayList<>();
        PreparedStatement pStatement = null;
        Connection connection = null;

        String sql = "SELECT id_Cliente,nome,cpf,telefone,email,endereco FROM cliente ORDER BY id_Cliente ";

        connection = new Conexao().getConnection();
        pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String nome = rs.getString(2);
                    String cpf = rs.getString(3);
                    String telefone = rs.getString(4);
                    String email = rs.getString(5);
                    String endereco = rs.getString(6);

                    Cliente cli = new Cliente(nome, cpf, telefone, email, endereco);
                    cli.setId(rs.getInt(1));
                    listaCliente.add(cli);
                }
                return listaCliente;
            } catch (Exception e) {
            }
        }
        return null;

    }

    public void alteraCliente(Cliente cliente) throws ExceptionDAO {
        String sql = "UPDATE cliente SET nome = ?, cpf = ?, telefone = ?, email = ?, endereco = ? WHERE id_Cliente = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, cliente.getNome());
            pStatement.setString(2, cliente.getCpf());
            pStatement.setString(3, cliente.getTelefone());
            pStatement.setString(4, cliente.getEmail());
            pStatement.setString(5, cliente.getEndereco());
            pStatement.setInt(6, cliente.getId());
            pStatement.execute();
            JOptionPane.showMessageDialog(null, "Alteração foi realizado com sucesso!");

        } catch (Exception e) {
            throw new ExceptionDAO("Error ao alterara o cliente: " + e);
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

    public void excluiCliente(int idCliente) throws ExceptionDAO {
        String sql = "DELETE FROM cliente WHERE id_Cliente = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            pStatement.setInt(1, idCliente);
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

}
