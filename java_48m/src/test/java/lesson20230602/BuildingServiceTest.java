package lesson20230602;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BuildingServiceTest {

    private static BuildingService service;
    private static BuildingRepository repository;

    @BeforeAll
    public static void init() {
//        service = new BuildingService(new BuildingRepositoryImpl());
        repository = Mockito.mock(BuildingRepository.class);
        Building building1 = new Building("Farm", 1000);
        Building building2 = new Building("Library", 2000);
        Mockito.when(repository.findAll()).thenReturn(Arrays.asList(building1, building2));
        service = new BuildingService(repository);
    }


    @Test
    public void getAllBuildings() {
        List<Building> result = service.getAllBuildings();
        assertEquals(2, result.size());
        assertEquals("Farm", result.get(0).getName());
        assertEquals("Library", result.get(1).getName());
    }

    @Test
    public void removeFarm(){
        service.removeFarm();
        Mockito.verify(repository).deleteByName("Farm");
//        Mockito.verify(repository).deleteByName(any());
    }


    @Test
    void increaseCost() {
        // TODO
    }
}