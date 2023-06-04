package lesson20230602;

import java.util.List;

public class BuildingService {

    private BuildingRepository repository;

    public BuildingService(BuildingRepository repository) {
        this.repository = repository;
    }

    public List<Building> getAllBuildings() {
        List<Building> buildings = repository.findAll();
        return buildings;
    }

    public void removeFarm(){
        repository.deleteByName("Farm");
    }

    public void increaseCost(int amount){
        List<Building> buildings = repository.findAll();
        for (Building b : buildings) {
            b.setCost(b.getCost() + amount);
            repository.save(b);
        }
    }

}
