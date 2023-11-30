package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.Endereco;
import equoterapia.Usuario;

public class EnderecoDAO extends GenericDAO<Endereco> {

    public EnderecoDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(Endereco endereco) {
        try {
            String sql = "INSERT INTO endereco (uf, cidade, cep, rua, numero, cnpj, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, endereco.getUf());
                statement.setString(2, endereco.getCidade());
                statement.setInt(3, endereco.getCep());
                statement.setString(4, endereco.getRua());
                statement.setInt(5, endereco.getNumero());
                statement.setString(6, endereco.getCnpj());
                statement.setInt(7, endereco.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Endereco buscar(int idEndereco) {
        Endereco endereco = null;
        try {
            String sql = "SELECT * FROM endereco WHERE id_endereco = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idEndereco);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        endereco = new Endereco(
                                resultSet.getInt("id_endereco"),
                                resultSet.getString("uf"),
                                resultSet.getString("cidade"),
                                resultSet.getInt("cep"),
                                resultSet.getString("rua"),
                                resultSet.getInt("numero"),
                                resultSet.getString("cnpj")
                        );

                        int idUsuario = resultSet.getInt("id_usuario");
                        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                        Usuario usuario = usuarioDAO.buscar(idUsuario);
                        endereco.setUsuario(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return endereco;
    }

    @Override
    public void atualizar(Endereco endereco) {
        try {
            String sql = "UPDATE endereco SET uf = ?, cidade = ?, cep = ?, rua = ?, numero = ?, cnpj = ?, id_usuario = ? WHERE id_endereco = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, endereco.getUf());
                statement.setString(2, endereco.getCidade());
                statement.setInt(3, endereco.getCep());
                statement.setString(4, endereco.getRua());
                statement.setInt(5, endereco.getNumero());
                statement.setString(6, endereco.getCnpj());
                statement.setInt(7, endereco.getUsuario().getIdUsuario());
                statement.setInt(8, endereco.getIdEndereco());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idEndereco) {
        try {
            String sql = "DELETE FROM endereco WHERE id_endereco = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idEndereco);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
