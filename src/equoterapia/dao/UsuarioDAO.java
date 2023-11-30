package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.Usuario;

public class UsuarioDAO extends GenericDAO<Usuario> {

    public UsuarioDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(Usuario usuario) {
        try {
            String sql = "INSERT INTO usuario (usuario, senha, empresa, id_local) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getUsuario());
                statement.setString(2, usuario.getSenha());
                statement.setString(3, usuario.getEmpresa());
                statement.setInt(4, usuario.getLocal().getIdLocal());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Usuario buscar(int idUsuario) {
        Usuario usuario = null;
        try {
            String sql = "SELECT * FROM usuario WHERE idUsuario = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idUsuario);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        usuario = new Usuario(
                                resultSet.getInt("idUsuario"),
                                resultSet.getString("usuario"),
                                resultSet.getString("senha"),
                                null // Local será preenchido posteriormente
                        );
                        // O id_local e o Local associado serão preenchidos posteriormente
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return usuario;
    }

    @Override
    public void atualizar(Usuario usuario) {
        try {
            String sql = "UPDATE usuario SET usuario=?, senha=?, empresa=?, id_local=? WHERE idUsuario=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, usuario.getUsuario());
                statement.setString(2, usuario.getSenha());
                statement.setString(3, usuario.getEmpresa());
                statement.setInt(4, usuario.getLocal().getIdLocal());
                statement.setInt(5, usuario.getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idUsuario) {
        try {
            String sql = "DELETE FROM usuario WHERE idUsuario=?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idUsuario);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
