package javaprojetoclinicaveterinaria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javaprojetoclinicaveterinaria.model.Animal;
import javax.swing.JOptionPane;

public class AnimalDao {

    public void cadastraAnimal(Animal animal) throws ExceptionDAO {
        String sql = "INSERT INTO animal (raca,nome,idade,ficha_de_vacinacao,sexo,id_Cliente) VALUES(?,?,?,?,?,?)";
        PreparedStatement pStatement = null;
        Connection connection = null;

        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);

            pStatement.setString(1, animal.getRaca());
            pStatement.setString(2, animal.getNome());
            pStatement.setString(3, String.valueOf(animal.getIdade()));
            pStatement.setString(4, animal.getFicha_de_vacinacao());
            pStatement.setString(5, animal.getSexo());
            pStatement.setString(6, String.valueOf(animal.getId_Cliente()));
            pStatement.execute();

            JOptionPane.showMessageDialog(null, "O cadastro foi realizado com sucesso!!");

        } catch (Exception e) {
            throw new ExceptionDAO("Error ao cadastrar o animal: " + e);
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

    
    
    public void editaAnimal(Animal animal)throws ExceptionDAO{
        String sql = "UPDATE animal set raca = ? ,nome = ? ,idade = ? ,ficha_de_vacinacao = ? ,sexo = ? ,id_Cliente = ? WHERE id_Animal = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            
            pStatement.setString(1,animal.getRaca());
            pStatement.setString(2,animal.getNome());
            pStatement.setString(3, animal.getIdade());
            pStatement.setString(4,animal.getFicha_de_vacinacao());
            pStatement.setString(5,animal.getSexo());
            pStatement.setString(6, String.valueOf(animal.getId_Cliente()));
            pStatement.setString(7, String.valueOf(animal.getId()));
            pStatement.execute();
            
            JOptionPane.showMessageDialog(null, "A alteração foi realizada com sucesso!!");
            
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

    public void excluiAnimal(int idAnimal) throws ExceptionDAO {
        String sql = "DELETE FROM animal WHERE id_Animal = ?";
        PreparedStatement pStatement = null;
        Connection connection = null;
        
        try {
            connection = new Conexao().getConnection();
            pStatement = connection.prepareStatement(sql);
            
            pStatement.setInt(1, idAnimal);
            pStatement.execute();
            
            JOptionPane.showMessageDialog(null, "Excluisao realizada com sucesso!");
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

    public static ArrayList<Animal> getAnimal() throws SQLException {
        ArrayList<Animal> listaAnimal = new ArrayList<>();
        PreparedStatement pStatement = null;
        Connection connection = null;

        String sql = "SELECT id_Animal ,raca,nome,idade,ficha_de_vacinacao,sexo,id_Cliente FROM animal ORDER BY id_Animal";
        connection = new Conexao().getConnection();
        pStatement = connection.prepareStatement(sql);
        ResultSet rs = pStatement.executeQuery(sql);

        if (rs != null) {
            try {
                while (rs.next()) {
                    String raca = rs.getString(2);
                    String nome = rs.getString(3);
                    String idade = rs.getString(4);
                    String ficha_de_vacinacao = rs.getString(5);
                    String sexo = rs.getString(6);
                    int id_Cliente = rs.getInt(7);

                    Animal ani = new Animal(raca, nome, idade, ficha_de_vacinacao, sexo, id_Cliente);
                    ani.setId(rs.getInt(1));

                    listaAnimal.add(ani);
                }
                return listaAnimal;
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Error: " + e);
            }
        }
        return null;
    }

    /*
    
s
     */
}
