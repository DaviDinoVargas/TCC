package equoterapia;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.text.ParseException;

import equoterapia.dao.PacienteDAO;

public class Main {
    public static void main(String[] args) {
        // Estabelecer conexão
        try (Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/seu_banco_de_dados", "seu_usuario", "sua_senha")) {

            //objetos aleatórios
            Local local = new Local(1, "SP", "Sao Paulo", 123456, "Rua A", 123, "123456789");
            Usuario usuario = new Usuario(1, "nomeusuario", "senhasegura", local);
            Consulta consulta = new Consulta(1, new java.sql.Date(System.currentTimeMillis()), "Boa", "Mediador", "Guia", "Encilhamento", local);

            Paciente paciente = new Paciente(1, "NomePaciente", "01/01/2000", true, "123.456.789-01", 25, "Praticante", consulta);


            // Exemplo de interação com o banco de dados usando PacienteDAO
            PacienteDAO pacienteDAO = new PacienteDAO(connection);

            // Adicionar paciente ao banco de dados
            pacienteDAO.adicionar(paciente);

            // Buscar paciente do banco de dados
            Paciente pacienteDoBanco = pacienteDAO.buscar(1);
            System.out.println("Paciente do Banco: " + pacienteDoBanco);

            // Atualizar paciente no banco de dados
            pacienteDoBanco.setPraticante("Novo Praticante");
            pacienteDAO.atualizar(pacienteDoBanco);

            // Excluir paciente do banco de dados
            pacienteDAO.excluir(1);

        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
    }
}
//realizar todas as buscar filtrando pelo id_usuário