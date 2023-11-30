package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.TBEscala1;

public class TBEscala1DAO extends GenericDAO<TBEscala1> {

    public TBEscala1DAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(TBEscala1 tbEscala1) {
        try {
            String sql = "INSERT INTO tbescala1 (op1_1, op1_2, op1_3, op1_4, comentario_dm1, soma_dm1, id_escala_avaliacao, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala1.getOp1_1());
                statement.setInt(2, tbEscala1.getOp1_2());
                statement.setInt(3, tbEscala1.getOp1_3());
                statement.setInt(4, tbEscala1.getOp1_4());
                statement.setString(5, tbEscala1.getComentarioDM1());
                statement.setInt(6, tbEscala1.getSomaDM1());
                statement.setInt(7, tbEscala1.getIdEscalaAvaliacao());
                statement.setInt(8, tbEscala1.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TBEscala1 buscar(int idTBEscala1) {
        TBEscala1 tbEscala1 = null;
        try {
            String sql = "SELECT * FROM tbescala1 WHERE id_tbescala1 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala1);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tbEscala1 = new TBEscala1(
                                resultSet.getInt("id_tbescala1"),
                                resultSet.getInt("op1_1"),
                                resultSet.getInt("op1_2"),
                                resultSet.getInt("op1_3"),
                                resultSet.getInt("op1_4"),
                                resultSet.getString("comentario_dm1"),
                                resultSet.getInt("soma_dm1"),
                                resultSet.getInt("id_escala_avaliacao")
                        );
                        // O id_usuario e o usuário associado serão preenchidos posteriormente
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tbEscala1;
    }

    @Override
    public void atualizar(TBEscala1 tbEscala1) {
        try {
            String sql = "UPDATE tbescala1 SET op1_1 = ?, op1_2 = ?, op1_3 = ?, op1_4 = ?, comentario_dm1 = ?, soma_dm1 = ?, id_escala_avaliacao = ?, id_usuario = ? WHERE id_tbescala1 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala1.getOp1_1());
                statement.setInt(2, tbEscala1.getOp1_2());
                statement.setInt(3, tbEscala1.getOp1_3());
                statement.setInt(4, tbEscala1.getOp1_4());
                statement.setString(5, tbEscala1.getComentarioDM1());
                statement.setInt(6, tbEscala1.getSomaDM1());
                statement.setInt(7, tbEscala1.getIdEscalaAvaliacao());
                statement.setInt(8, tbEscala1.getUsuario().getIdUsuario());
                statement.setInt(9, tbEscala1.getIdTBEscala1());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idTBEscala1) {
        try {
            String sql = "DELETE FROM tbescala1 WHERE id_tbescala1 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala1);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
