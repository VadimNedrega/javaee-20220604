package hillel.course.hibernate.repository;

import hillel.course.hibernate.db.ClearTableCities;
import hillel.course.hibernate.entity.City;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CityRepositoryTest {
    CityRepository repository = new CityRepository();
    City city1 = new City("Panama");
    City city2 = new City("Tmutarakan");
    City city3 = new City("Zadripinsk");
    List<City> cities = repository.getCities();

    @Before
    public void setUp() {
        ClearTableCities.clearTableInDB();
    }

    @Test
    public void saveCityToDB() {
        System.out.println("Task 1.b from homework_03:\n");
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.saveCityToRepo(city3);

        cities = repository.getCities();

        Assert.assertEquals(3, cities.size());
        Assert.assertEquals("Panama", cities.get(0).getName());
        Assert.assertEquals("Tmutarakan", cities.get(1).getName());
        Assert.assertEquals("Zadripinsk", cities.get(2).getName());
    }

    @Test
    public void getCityById() {
        System.out.println("Task 1.c from homework_03:\n");
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.saveCityToRepo(city3);

        cities = repository.getCities();

        Assert.assertEquals((long) cities.get(0).getId(), (long) repository.getCityById(city1.getId()).getId());
    }

    @Test
    public void getCityByName() {
        System.out.println("Task 1.d from homework_03:\n");
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.saveCityToRepo(city3);

        Assert.assertEquals("Panama", repository.getCityByName("Panama").getName());
    }

    @Test
    public void deleteCityByName() {
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.saveCityToRepo(city3);
        repository.deleteCityByName("Panama");

        cities = repository.getCities();

        Assert.assertEquals(2, cities.size());
        Assert.assertNotEquals(cities.get(0).getName(), "Panama");
    }

    @Test
    public void ifCityPresentInDB() {
        repository.saveCityToRepo(city1);
        cities = repository.getCities();
        Assert.assertTrue(repository.ifCityPresentsInRepo("Panama"));
    }

    @Test
    public void getCities() {
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.saveCityToRepo(city3);

        cities = repository.getCities();
        System.out.println("Task 1.a from homework_03:\n" + cities);

        Assert.assertEquals("Panama", cities.get(0).getName());
        Assert.assertEquals("Tmutarakan", cities.get(1).getName());
        Assert.assertEquals("Zadripinsk", cities.get(2).getName());
    }

    @Test
    public void ifRepoIsEmpty() {
        repository.saveCityToRepo(city1);
        repository.saveCityToRepo(city2);
        repository.deleteCityByName("Panama");
        repository.deleteCityByName("Tmutarakan");

        Assert.assertTrue(repository.ifRepoIsEmpty());
    }
}
