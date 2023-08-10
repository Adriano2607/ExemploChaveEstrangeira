package DAO;

import infra.DataSource;
import model.ModelCliente;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class daoCliente {

    public static ModelCliente getClienteById(int clienteId) throws SQLException {
        DataSource dataSource = new DataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = null;
        ResultSet rs = null;
        ModelCliente cliente = null;

            ps = connection.prepareStatement("SELECT id, nome, email FROM Cliente WHERE id = ?");
            ps.setInt(1, clienteId);
            rs = ps.executeQuery();

            if (rs.next()) {
                cliente = new ModelCliente();
                cliente.setId(rs.getInt("id"));
                cliente.setNome(rs.getString("nome"));
                cliente.setEmail(rs.getString("email"));
            }

        return cliente;
    }



    public static void insert(ModelCliente af) throws SQLException {
        DataSource a = new DataSource();
        Connection con = a.getConnection();

        PreparedStatement ps = null;

        ps = con.prepareStatement("INSERT INTO cliente(nome,email) VALUES (?,?)");

        ps.setString(1, af.getNome());
        ps.setString(2, af.getEmail());

        ps.executeUpdate();

    }
}
