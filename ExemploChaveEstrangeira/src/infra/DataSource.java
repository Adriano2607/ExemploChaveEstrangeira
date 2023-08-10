package infra;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {

    private String hostname;
    private int porta;
    private String database;
    private String username;
    private String password;
    private Connection connection;

    public DataSource() {
        try {

            hostname = "127.0.0.1";
            porta = 3306;
            database = "teste";
            username = "root";
            password = "senac";


            // string de conexão
            String url = "jdbc:mysql://" + hostname + ":" + porta + "/" + database + "?useTimezone=true&serverTimezone=UTC";

            // registrar o driver
            DriverManager.registerDriver(new com.mysql.cj.jdbc.Driver());

            // faz a conexão
            connection = DriverManager.getConnection(url, username, password);

            //  System.out.println("Conectou!");
        } catch (SQLException ex) {
            System.err.println("ERRO na conexão " + ex.getMessage());
        } catch (Exception ex) {
            System.err.println("ERRO geral " + ex.getMessage());
        }
    }

    // pega a conexão ativa
    public Connection getConnection() {

        return this.connection;
    }

    // fechamento da conexão
    public void closeDataSource() {
        try {
            connection.close();
        } catch (Exception ex) {
            System.err.println("ERRO ao desconectar " + ex.getMessage());
        }
    }
}
