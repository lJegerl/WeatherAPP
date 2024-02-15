package org.example.src.main.prod.connect.sql;


import org.example.src.main.prod.component.PopulationType;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PopulationTypeDAO {
    private Connection connection;

    private final String addSql = "INSERT INTO PopulationType (name, language, count) VALUES (?, ?, ?)";
    private final String deleteSql =  "DELETE FROM PopulationType WHERE population_type_id = ?";
    private final String getSqlById = "SELECT * FROM PopulationType WHERE population_type_id = ?";
    private final String getSqlAll = "SELECT * FROM PopulationType";
    private final String updateSql = "UPDATE PopulationType SET name = ?, language = ?, count = ? WHERE population_type_id = ?";

    public PopulationTypeDAO(Connection connection) {
        this.connection = connection;
    }

    public void createPopulationType(PopulationType populationType) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(addSql)) {
            preparedStatement.setString(1, populationType.getName());
            preparedStatement.setString(2, populationType.getLanguage());
            preparedStatement.setInt(3, populationType.getCount());
            preparedStatement.executeUpdate();
        }
    }

    public PopulationType getPopulationTypeById(int populationTypeId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSqlById)) {
            preparedStatement.setInt(1, populationTypeId);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    return extractPopulationTypeFromResultSet(resultSet);
                }
            }
        }
        return null;
    }

    public List<PopulationType> getAllPopulationTypes() throws SQLException {
        List<PopulationType> populationTypes = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(getSqlAll);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                PopulationType type = extractPopulationTypeFromResultSet(resultSet);
                System.out.println("Type ID: " + type.getId());
                populationTypes.add(type);
            }
        }
        return populationTypes;
    }

    public void updatePopulationType(PopulationType populationType) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(updateSql)) {
            preparedStatement.setString(1, populationType.getName());
            preparedStatement.setString(2, populationType.getLanguage());
            preparedStatement.setInt(3, populationType.getCount());
            preparedStatement.setInt(4, populationType.getId());
            preparedStatement.executeUpdate();
        }
    }

    public void deletePopulationType(int populationTypeId) throws SQLException {
        try (PreparedStatement preparedStatement = connection.prepareStatement(deleteSql)) {
            preparedStatement.setInt(1, populationTypeId);
            preparedStatement.executeUpdate();
        }
    }

    private PopulationType extractPopulationTypeFromResultSet(ResultSet resultSet) throws SQLException {
        return new PopulationType(
                resultSet.getInt("population_type_id"),
                resultSet.getString("name"),
                resultSet.getString("language"),
                resultSet.getInt("count")
        );
    }
}
