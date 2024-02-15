package org.example.src.main.demo;

import org.example.src.main.prod.builders.PopulationTypeBuilder;
import org.example.src.main.prod.builders.RegionBuilder;
import org.example.src.main.prod.builders.WeatherBuilder;
import org.example.src.main.prod.component.PopulationType;
import org.example.src.main.prod.component.Region;
import org.example.src.main.prod.component.Weather;
import org.example.src.main.prod.connect.sql.ConnectionPool;
import org.example.src.main.prod.connect.sql.PopulationTypeDAO;
import org.example.src.main.prod.connect.sql.RegionDAO;
import org.example.src.main.prod.connect.sql.WeatherDAO;

import java.sql.Connection;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectionPool connectionPool = new ConnectionPool("database.properties", 10);
        Scanner scanner = new Scanner(System.in);
        try (Connection connection = connectionPool.getConnection()) {
            showMenu();
            System.out.println("Enter command: ");
            PopulationTypeDAO populationTypeDAO = new PopulationTypeDAO(connection);
            RegionDAO regionDAO = new RegionDAO(connection);
            WeatherDAO weatherDAO = new WeatherDAO(connection);
            boolean agreem = true;
            while(agreem) {
                int choice = scanner.nextInt();
                switch (choice) {
                    case (1):
                        System.out.println("Enter NAME, LANGUAGE, COUNT");
                        String name = scanner.nextLine();
                        String language = scanner.nextLine();
                        int count = scanner.nextInt();

                        PopulationType newPopulationType = new PopulationTypeBuilder()
                                .setName(name)
                                .setLanguage(language)
                                .setCount(count)
                                .getPopulationType();
                        populationTypeDAO.createPopulationType(newPopulationType);

                        System.out.println("Enter NAME, SQUARE");
                        String nameRegion = scanner.nextLine();
                        int square = scanner.nextInt();

                        Region newRegion = new RegionBuilder()
                                .setName("Minsk")
                                .setSquare(100500)
                                .setType(newPopulationType)
                                .getRegion();

                        System.out.println("Enter DATE, Precipitation, Temperature");
                        LocalDate date = LocalDate.parse(scanner.nextLine());
                        String precip = scanner.nextLine();
                        Double temp = scanner.nextDouble();

                        Weather newWeather = new WeatherBuilder()
                                .setDate(LocalDate.parse("2017-01-13"))
                                .setPrecipitation("Snow")
                                .setTemperature(-14.2)
                                .setRegion(newRegion)
                                .getWeather();
                        break;

                    case (2):
                        System.out.println(populationTypeDAO.getAllPopulationTypes());
                        break;

                    case (3):
                        System.out.println(regionDAO.getAllRegions());
                        break;

                    case (4):
                        System.out.println(weatherDAO.getAllWeather());
                        break;

                    case (9):
                        showMenu();
                        break;

                    case (0):
                        agreem = false;
                        break;
                }
                System.out.println("Enter command: ");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connectionPool.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public static void showMenu() {
        System.out.println("Menu:" + '\n' +
                "1)Add to sql" + '\n' +
                "2)Show all population types" + '\n' +
                "3)Show all regions" + '\n' +
                "4)Show all weathers" + '\n' +
                "9)show menu" + '\n' +
                "0)Exit" + '\n');
    }
}