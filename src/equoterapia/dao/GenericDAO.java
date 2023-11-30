package equoterapia.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public abstract class GenericDAO<T> {
    protected Connection connection;

    public GenericDAO(Connection connection) {
        this.connection = connection;
    }

    public abstract void adicionar(T objeto);

    public abstract T buscar(int id);

    public abstract void atualizar(T objeto);

    public abstract void excluir(int id);

    protected void fecharRecursos(PreparedStatement statement, ResultSet resultSet) {
        try {
            if (statement != null) {
                statement.close();
            }
            if (resultSet != null) {
                resultSet.close();
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}