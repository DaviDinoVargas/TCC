package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.TBEscala3;

public class TBEscala3DAO extends GenericDAO<TBEscala3> {

    public TBEscala3DAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(TBEscala3 tbEscala3) {
        try {
            String sql = "INSERT INTO tbescala3 (op3_1, op3_2, op3_3, op3_4, op3_5, op3_6, op3_7, comentario_dm3, soma_dm3, id_escala_avaliacao, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala3.getOp3_1());
                statement.setInt(2, tbEscala3.getOp3_2());
                statement.setInt(3, tbEscala3.getOp3_3());
                statement.setInt(4, tbEscala3.getOp3_4());
                statement.setInt(5, tbEscala3.getOp3_5());
                statement.setInt(6, tbEscala3.getOp3_6());
                statement.setInt(7, tbEscala3.getOp3_7());
                statement.setString(8, tbEscala3.getComentarioDM3());
                statement.setInt(9, tbEscala3.getSomaDM3());
                statement.setInt(10, tbEscala3.getIdEscalaAvaliacao());
                statement.setInt(11, tbEscala3.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TBEscala3 buscar(int idTBEscala3) {
        TBEscala3 tbEscala3 = null;
        try {
            String sql = "SELECT * FROM tbescala3 WHERE id_tbescala3 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala3);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tbEscala3 = new TBEscala3(
                                resultSet.getInt("id_tbescala3"),
                                resultSet.getInt("op3_1"),
                                resultSet.getInt("op3_2"),
                                resultSet.getInt("op3_3"),
                                resultSet.getInt("op3_4"),
                                resultSet.getInt("op3_5"),
                                resultSet.getInt("op3_6"),
                                resultSet.getInt("op3_7"),
                                resultSet.getString("comentario_dm3"),
                                resultSet.getInt("soma_dm3"),
                                resultSet.getInt("id_escala_avaliacao")
                        );
                        // O id_usuario e o usuário associado serão preenchidos posteriormente
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tbEscala3;
    }

    @Override
    public void atualizar(TBEscala3 tbEscala3) {
        try {
            String sql = "UPDATE tbescala3 SET op3_1 = ?, op3_2 = ?, op3_3 = ?, op3_4 = ?, op3_5 = ?, op3_6 = ?, op3_7 = ?, comentario_dm3 = ?, soma_dm3 = ?, id_escala_avaliacao = ?, id_usuario = ? WHERE id_tbescala3 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala3.getOp3_1());
                statement.setInt(2, tbEscala3.getOp3_2());
                statement.setInt(3, tbEscala3.getOp3_3());
                statement.setInt(4, tbEscala3.getOp3_4());
                statement.setInt(5, tbEscala3.getOp3_5());
                statement.setInt(6, tbEscala3.getOp3_6());
                statement.setInt(7, tbEscala3.getOp3_7());
                statement.setString(8, tbEscala3.getComentarioDM3());
                statement.setInt(9, tbEscala3.getSomaDM3());
                statement.setInt(10, tbEscala3.getIdEscalaAvaliacao());
                statement.setInt(11, tbEscala3.getUsuario().getIdUsuario());
                statement.setInt(12, tbEscala3.getIdTBEscala3());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idTBEscala3) {
        try {
            String sql = "DELETE FROM tbescala3 WHERE id_tbescala3 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala3);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
