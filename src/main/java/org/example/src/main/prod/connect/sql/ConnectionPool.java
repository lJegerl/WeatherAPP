package org.example.src.main.prod.connect.sql;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class ConnectionPool {
    private final Properties properties;
    private final List<Connection> connections;

    public ConnectionPool(String propertiesFile, int initialPoolSize) {
        this.properties = loadProperties(propertiesFile);
        this.connections = new ArrayList<>(initialPoolSize);
        initializePool(initialPoolSize);
    }

    private Properties loadProperties(String propertiesFile) {
        Properties properties = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream(propertiesFile)) {
            properties.load(input);
        } catch (IOException e) {
            throw new RuntimeException("ERROR WITH LOADING DATABASE", e);
        }
        return properties;
    }

    private void initializePool(int initialSize) {
        for (int i = 0; i < initialSize; i++) {
            Connection connection = createConnection();
            connections.add(connection);
        }
    }

    private Connection createConnection() {
        try {
            String url = properties.getProperty("db.url");
            String username = properties.getProperty("db.username");
            String password = properties.getProperty("db.password");
            return DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            throw new RuntimeException("ERROR WITH LOADING DATABASE", e);
        }
    }

    public Connection getConnection() throws SQLException {
        if (connections.isEmpty()) {
            Connection newConnection = createConnection();
            connections.add(newConnection);
            return newConnection;
        }
        return connections.remove(connections.size() - 1);
    }

    public void close() throws SQLException {
        for (Connection connection : connections) {
            if (connection != null && !connection.isClosed()) {
                connection.close();
            }
        }
    }
}
