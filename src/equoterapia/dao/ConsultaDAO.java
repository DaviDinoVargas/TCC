package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.Consulta;
import equoterapia.Local;
import equoterapia.Usuario;

public class ConsultaDAO extends GenericDAO<Consulta> {

    public ConsultaDAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(Consulta consulta) {
        try {
            String sql = "INSERT INTO consulta (id_consulta, data_avaliacao, condicao_saude, mediador, guia, encilhamento, id_local, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, consulta.getIdConsulta());
                statement.setDate(2, consulta.getDataAvaliacao());
                statement.setString(3, consulta.getCondicaoSaude());
                statement.setString(4, consulta.getMediador());
                statement.setString(5, consulta.getGuia());
                statement.setString(6, consulta.getEncilhamento());
                statement.setInt(7, consulta.getLocal().getIdLocal());
                statement.setInt(8, consulta.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Consulta buscar(int idConsulta) {
        Consulta consulta = null;
        try {
            String sql = "SELECT * FROM consulta WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idConsulta);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        consulta = new Consulta(
                                resultSet.getInt("id_consulta"),
                                resultSet.getDate("data_avaliacao"),
                                resultSet.getString("condicao_saude"),
                                resultSet.getString("mediador"),
                                resultSet.getString("guia"),
                                resultSet.getString("encilhamento"),
                                null 
                        );

                        int idLocal = resultSet.getInt("id_local");
                        LocalDAO localDAO = new LocalDAO(connection);
                        Local local = localDAO.buscar(idLocal);
                        consulta.setLocal(local);

                        int idUsuario = resultSet.getInt("id_usuario");
                        UsuarioDAO usuarioDAO = new UsuarioDAO(connection);
                        Usuario usuario = usuarioDAO.buscar(idUsuario);
                        consulta.setUsuario(usuario);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return consulta;
    }

    @Override
    public void atualizar(Consulta consulta) {
        try {
            String sql = "UPDATE consulta SET data_avaliacao = ?, condicao_saude = ?, mediador = ?, guia = ?, encilhamento = ?, id_local = ?, id_usuario = ? WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setDate(1, consulta.getDataAvaliacao());
                statement.setString(2, consulta.getCondicaoSaude());
                statement.setString(3, consulta.getMediador());
                statement.setString(4, consulta.getGuia());
                statement.setString(5, consulta.getEncilhamento());
                statement.setInt(6, consulta.getLocal().getIdLocal());
                statement.setInt(7, consulta.getUsuario().getIdUsuario());
                statement.setInt(8, consulta.getIdConsulta());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idConsulta) {
        try {
            String sql = "DELETE FROM consulta WHERE id_consulta = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idConsulta);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
