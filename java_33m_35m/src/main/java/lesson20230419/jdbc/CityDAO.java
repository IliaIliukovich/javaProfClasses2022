package lesson20230419.jdbc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CityDAO implements WorldDAO<City> {

    private static final String GET_ALL = "SELECT * FROM city";
    private static final String GET_BY_ID = "SELECT * FROM city WHERE ID = ?";
    private static final String GET_BY_COUNTRY_MINPOP = "SELECT * FROM city WHERE CountryCode = ? AND Population >= ?";
    private static final String SAVE_CITY = "INSERT INTO city VALUES (0,?,?,?,?)";
    private static final String DELETE_CITY = "DELETE FROM city where id = ?";

    @Override
    public List<City> getAll() {
        List<City> cities = new ArrayList<>();
        try (
            Connection connection = ConnectorDB.getConnection();
            Statement statement = connection.createStatement();
                ){

            ResultSet resultSet = statement.executeQuery(GET_ALL);
            while (resultSet.next()){
                City city = getCity(resultSet);
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    private static City getCity(ResultSet resultSet) throws SQLException {
        City city = new City(resultSet.getInt(1),
                resultSet.getString(2),
                resultSet.getString(3),
                resultSet.getString(4),
                resultSet.getInt(5));
        return city;
    }

    @Override
    public Optional<City> get(int id) {
        try (
            Connection connection = ConnectorDB.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(GET_BY_ID);
        ){
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()){
                City city = getCity(resultSet);
                return Optional.of(city);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public List<City> getCityByCountryAndPopulation(String county, int min) {
        List<City> cities = new ArrayList<>();
        try (
                Connection connection = ConnectorDB.getConnection();
                PreparedStatement statement = connection.prepareStatement(GET_BY_COUNTRY_MINPOP);
        ){
            statement.setString(1, county);
            statement.setInt(2, min);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                City city = getCity(resultSet);
                cities.add(city);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cities;
    }

    @Override
    public void save(City city) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(SAVE_CITY);
        ){
            statement.setString(1, city.getName());
            statement.setString(2, city.getCountryCode());
            statement.setString(3, city.getDistrict());
            statement.setInt(4, city.getPopulation());
            int result = statement.executeUpdate();
            System.out.println("Result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    @Override
    public void delete(int id) {
        try (Connection connection = ConnectorDB.getConnection();
             PreparedStatement statement = connection.prepareStatement(DELETE_CITY);
        ){
            statement.setInt(1, id);
            int result = statement.executeUpdate();
            System.out.println("Result: " + result);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
