package equoterapia.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import equoterapia.TBEscala2;

public class TBEscala2DAO extends GenericDAO<TBEscala2> {

    public TBEscala2DAO(Connection connection) {
        super(connection);
    }

    @Override
    public void adicionar(TBEscala2 tbEscala2) {
        try {
            String sql = "INSERT INTO tbescala2 (op2_1, op2_2, op2_3, op2_4, op2_5, op2_6, op2_7, op2_8, comentario_dm2, soma_dm2, id_escala_avaliacao, id_usuario) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala2.getOp2_1());
                statement.setInt(2, tbEscala2.getOp2_2());
                statement.setInt(3, tbEscala2.getOp2_3());
                statement.setInt(4, tbEscala2.getOp2_4());
                statement.setInt(5, tbEscala2.getOp2_5());
                statement.setInt(6, tbEscala2.getOp2_6());
                statement.setInt(7, tbEscala2.getOp2_7());
                statement.setInt(8, tbEscala2.getOp2_8());
                statement.setString(9, tbEscala2.getComentarioDM2());
                statement.setInt(10, tbEscala2.getSomaDM2());
                statement.setInt(11, tbEscala2.getIdEscalaAvaliacao());
                statement.setInt(12, tbEscala2.getUsuario().getIdUsuario());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public TBEscala2 buscar(int idTBEscala2) {
        TBEscala2 tbEscala2 = null;
        try {
            String sql = "SELECT * FROM tbescala2 WHERE id_tbescala2 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala2);

                try (ResultSet resultSet = statement.executeQuery()) {
                    if (resultSet.next()) {
                        tbEscala2 = new TBEscala2(
                                resultSet.getInt("id_tbescala2"),
                                resultSet.getInt("op2_1"),
                                resultSet.getInt("op2_2"),
                                resultSet.getInt("op2_3"),
                                resultSet.getInt("op2_4"),
                                resultSet.getInt("op2_5"),
                                resultSet.getInt("op2_6"),
                                resultSet.getInt("op2_7"),
                                resultSet.getInt("op2_8"),
                                resultSet.getString("comentario_dm2"),
                                resultSet.getInt("soma_dm2"),
                                resultSet.getInt("id_escala_avaliacao")
                        );
                        // O id_usuario e o usuário associado serão preenchidos posteriormente
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tbEscala2;
    }

    @Override
    public void atualizar(TBEscala2 tbEscala2) {
        try {
            String sql = "UPDATE tbescala2 SET op2_1 = ?, op2_2 = ?, op2_3 = ?, op2_4 = ?, op2_5 = ?, op2_6 = ?, op2_7 = ?, op2_8 = ?, comentario_dm2 = ?, soma_dm2 = ?, id_escala_avaliacao = ?, id_usuario = ? WHERE id_tbescala2 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, tbEscala2.getOp2_1());
                statement.setInt(2, tbEscala2.getOp2_2());
                statement.setInt(3, tbEscala2.getOp2_3());
                statement.setInt(4, tbEscala2.getOp2_4());
                statement.setInt(5, tbEscala2.getOp2_5());
                statement.setInt(6, tbEscala2.getOp2_6());
                statement.setInt(7, tbEscala2.getOp2_7());
                statement.setInt(8, tbEscala2.getOp2_8());
                statement.setString(9, tbEscala2.getComentarioDM2());
                statement.setInt(10, tbEscala2.getSomaDM2());
                statement.setInt(11, tbEscala2.getIdEscalaAvaliacao());
                statement.setInt(12, tbEscala2.getUsuario().getIdUsuario());
                statement.setInt(13, tbEscala2.getIdTBEscala2());

                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void excluir(int idTBEscala2) {
        try {
            String sql = "DELETE FROM tbescala2 WHERE id_tbescala2 = ?";
            try (PreparedStatement statement = connection.prepareStatement(sql)) {
                statement.setInt(1, idTBEscala2);
                statement.executeUpdate();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
