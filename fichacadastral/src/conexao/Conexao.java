/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexao;
 import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author felip
 */
public class Conexao {
   


    // Substitua estes valores pelos detalhes do seu banco de dados
    private static final String URL = "jdbc:mysql://localhost:3306/dbcadastro";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "felipe87";

    public static void main(String[] args) {
        Connection connection = null;

        try {
            // Tenta estabelecer uma conexão com o banco de dados
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);

            // Se a conexão for bem-sucedida, uma mensagem será exibida
            System.out.println("Conexão com o banco de dados estabelecida com sucesso!");

        } catch (SQLException e) {
            // Se ocorrer um erro ao estabelecer a conexão, ele será capturado e exibido
            System.err.println("Erro ao estabelecer conexão com o banco de dados:");
            e.printStackTrace();
        } finally {
            // Feche a conexão, se foi aberta
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexão com o banco de dados fechada com sucesso!");
                } catch (SQLException e) {
                    System.err.println("Erro ao fechar a conexão com o banco de dados:");
                    e.printStackTrace();
                }
            }
        }
    }
}

    
