package teste;

import DAO.daoCliente;
import model.ModelCliente;

import java.sql.SQLException;
import java.util.Scanner;

public class tstCliente {
    public static void main(String[] args) throws SQLException {

        ModelCliente a = new ModelCliente();

        Scanner ler = new Scanner(System.in);
        System.out.println("Informe Seu nome");
        a.setNome(ler.next());

        System.out.println("Informe seu Email");
        a.setEmail(ler.next());

        daoCliente.insert(a);
        System.out.println("Cliente Cadastrado com Sucesso");

    }


}
