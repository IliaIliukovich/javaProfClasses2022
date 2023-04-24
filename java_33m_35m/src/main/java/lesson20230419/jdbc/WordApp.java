package lesson20230419.jdbc;

import java.util.List;

public class WordApp {

    public static void main(String[] args) {

        CityDAO cityDAO = new CityDAO();

        cityDAO.saveSpecialCity();

        List<City> cities = cityDAO.getAll();
        cities.forEach(System.out::println);

//        System.out.println("Get by id: " + 4079 + " : " + cityDAO.get(4079));
//
//        cityDAO.getCityByCountryAndPopulation("USA", 1_000_000).forEach(System.out::println);

//        cityDAO.save(new City(999, "Dream City", "USA", "", 1));
//        cityDAO.delete(4087);
    }
}