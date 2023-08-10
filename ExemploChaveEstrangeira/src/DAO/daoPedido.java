package DAO;

import infra.DataSource;
import model.ModelPedido;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class daoPedido {
    public static void insert(ModelPedido pedido) throws SQLException {
        DataSource dataSource = new DataSource();
        Connection connection = dataSource.getConnection();
        PreparedStatement ps = null;

            ps = connection.prepareStatement("INSERT INTO pedido(id_cliente, numero) VALUES (?, ?)", PreparedStatement.RETURN_GENERATED_KEYS);
            ps.setInt(1, pedido.getCliente().getId()); // Defina o ID do cliente
            ps.setInt(2, pedido.getNumero());

            // Executa a atualização
            ps.executeUpdate();



    }


}
