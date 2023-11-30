package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.Paciente;
import equoterapia.Usuario;

public class PacienteDAO extends GenericDAO<Paciente> {

    public PacienteDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(Paciente paciente) {
        try {
            String sql = "INSERT INTO paciente (id_cadastro, nome, data_nascimento, sexo, cpf, idade, praticante, id_consulta, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, paciente.getIdCadastro());
                statement.setString(2, paciente.getPraticante());
                statement.setDate(3, paciente.getDataNascimento());
                statement.setBoolean(4, paciente.getSexo());
                statement.setString(5, paciente.getCpf());
                statement.setInt(6, paciente.getIdade());
                statement.setString(7, paciente.getPraticante());
                statement.setInt(8, paciente.getConsulta().getIdConsulta());
                statement.setInt(9, paciente.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Paciente buscar(int idCadastro) {
        Paciente paciente = null;
        try {
            String sql = "SELECT * FROM paciente WHERE id_cadastro = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idCadastro);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        paciente = new Paciente(
                                resultSet.getInt("id_cadastro"),
                                resultSet.getString("nome"),
                                resultSet.getDate("data_nascimento"),
                                resultSet.getBoolean("sexo"),
                                resultSet.getString("cpf"),
                                resultSet.getInt("idade"),
                                resultSet.getString("praticante"),
                                resultSet.getInt("id_consulta")
                        );

                        int idUsuarioPaciente = resultSet.getInt("id_usuario");
                        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                        Usuario usuarioPaciente = usuarioDAO.buscar(idUsuarioPaciente);
                        usuarioPaciente.setIdUsuario(idUsuarioPaciente);
                        paciente.setUsuario(usuarioPaciente);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return paciente;
    }

    @Override
    public void atualizar(Paciente paciente) {
        try {
            String sql = "UPDATE paciente SET nome = ?, data_nascimento = ?, sexo = ?, cpf = ?, idade = ?, praticante = ?, id_consulta = ?, id_usuario = ? WHERE id_cadastro = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, paciente.getPraticante());
                statement.setDate(2, paciente.getDataNascimento());
                statement.setBoolean(3, paciente.getSexo());
                statement.setString(4, paciente.getCpf());
                statement.setInt(5, paciente.getIdade());
                statement.setString(6, paciente.getPraticante());
                statement.setInt(7, paciente.getConsulta().getIdConsulta());
                statement.setInt(8, paciente.getUsuario().getIdUsuario());
                statement.setInt(9, paciente.getIdCadastro());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idCadastro) {
        try {
            String sql = "DELETE FROM paciente WHERE id_cadastro = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idCadastro);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
