package hillel.course;

import hillel.course.spring_data_jpa.entity.Country;
import hillel.course.spring_data_jpa.entity.Region;
import hillel.course.spring_data_jpa.entity.Town;
import hillel.course.spring_data_jpa.repository.CountryRepository;
import hillel.course.spring_data_jpa.repository.RegionRepository;
import hillel.course.spring_data_jpa.repository.TownRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.logging.Logger;

@SpringBootTest
class WorkWithConsoleTest {
    private static final Logger LOG = Logger.getLogger(MainTest.class.getName());
    @Autowired
    private TownRepository townRepository;
    @Autowired
    private CountryRepository countryRepository;
    @Autowired
    private RegionRepository regionRepository;

    @MockBean
    ApplicationRunner applicationRunner;

    @Test
    void saveCountry() {
        LOG.info("Start saveCountry test...");

        Country country = new Country("China");
        countryRepository.save(country);

        Assertions.assertEquals(country, countryRepository.findCountryByName("China").get(0));

        countryRepository.deleteAll();
        LOG.info("Finish saveCountry test...");
    }

    @Test
    void saveRegion() {
        LOG.info("Start saveRegion test...");

        Region region = new Region("District 13");
        regionRepository.save(region);

        Assertions.assertEquals(region, regionRepository.findRegionByName("District 13").get(0));

        regionRepository.deleteAll();
        LOG.info("Finish saveRegion test...");
    }

    @Test
    void saveTownAndFindTownById() {
        LOG.info("Start saveTown test...");

        Town town = new Town("Blackpool", "+13546");
        townRepository.save(town);

        Assertions.assertEquals(town, townRepository.findTownByTownId(1).get(0));

        townRepository.deleteAll();
        LOG.info("Finish saveTown test...");
    }

    @Test
    void getObjectByName() {
        LOG.info("Start getObjectByName test...");

        Town town = new Town("Norwich", "+1648");
        townRepository.save(town);

        Assertions.assertEquals(town, townRepository.findTownByName("Norwich").get(0));

        townRepository.deleteAll();
        LOG.info("Finish getObjectByName test...");
    }

    @Test
    void chooseObject() {
        LOG.info("Start chooseObject test...");

        Country country = new Country("China");
        countryRepository.save(country);

        Assertions.assertInstanceOf(countryRepository.findCountryByCountryId(1).get(0).getClass(), country);

        countryRepository.deleteAll();
        LOG.info("Finish chooseObject test...");
    }
}