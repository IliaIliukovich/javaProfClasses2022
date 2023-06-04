package lesson20230602;

import java.util.List;

public interface BuildingRepository {

    public List<Building> findAll();

    public void deleteByName(String name);

    public void save(Building building);


}
