package teste;

import DAO.daoCliente;
import DAO.daoPedido;
import model.ModelCliente;
import model.ModelPedido;

import java.sql.SQLException;
import java.util.Scanner;

public class tstPedido {
    public static void main(String[] args) throws SQLException {

        Scanner ler = new Scanner(System.in);

        ModelPedido pedido = new ModelPedido();
        ModelCliente cliente;

        System.out.println("Informe o ID do Cliente");
        int clienteId = ler.nextInt();

        cliente = daoCliente.getClienteById(clienteId);


        if (cliente != null) {
            pedido.setCliente(cliente);

            System.out.println("Informe o numero do pedido");
            pedido.setNumero(ler.nextInt());

            daoPedido.insert(pedido);
        } else {
            System.err.println("Cliente não encontrado.");
        }

        //EA SPORTS FC

    }


}
