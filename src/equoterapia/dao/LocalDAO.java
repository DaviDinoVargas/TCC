package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.Local;
import equoterapia.Usuario;

public class LocalDAO extends GenericDAO<Local> {

    public LocalDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(Local local) {
        try {
            String sql = "INSERT INTO local (uf, cidade, cep, rua, numero, cnpj, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, local.getUf());
                statement.setString(2, local.getCidade());
                statement.setInt(3, local.getCep());
                statement.setString(4, local.getRua());
                statement.setInt(5, local.getNumero());
                statement.setString(6, local.getCnpj());
                statement.setInt(7, local.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Local buscar(int idLocal) {
        Local local = null;
        try {
            String sql = "SELECT * FROM local WHERE id_local = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idLocal);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        local = new Local(
                                idLocal, resultSet.getString("uf"),
                                resultSet.getString("cidade"),
                                resultSet.getInt("cep"),
                                resultSet.getString("rua"),
                                resultSet.getInt("numero"),
                                resultSet.getString("cnpj")
                        );

                        
                        int idUsuarioLocal = resultSet.getInt("id_usuario");

                       
                        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                        Usuario usuarioLocal = usuarioDAO.buscar(idUsuarioLocal);
                        usuarioLocal.setIdUsuario(idUsuarioLocal);

                        
                        local.setUsuario(usuarioLocal);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return local;
    }

    @Override
    public void atualizar(Local local) {
        try {
            String sql = "UPDATE local SET uf = ?, cidade = ?, cep = ?, rua = ?, numero = ?, cnpj = ?, id_usuario = ? WHERE id_local = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setString(1, local.getUf());
                statement.setString(2, local.getCidade());
                statement.setInt(3, local.getCep());
                statement.setString(4, local.getRua());
                statement.setInt(5, local.getNumero());
                statement.setString(6, local.getCnpj());
                statement.setInt(7, local.getUsuario().getIdUsuario());
                statement.setInt(8, local.getIdLocal());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idLocal) {
        try {
            String sql = "DELETE FROM local WHERE id_local = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idLocal);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
