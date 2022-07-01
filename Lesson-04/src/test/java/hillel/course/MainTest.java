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

import java.util.Set;
import java.util.logging.Logger;

@SpringBootTest
class MainTest {
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
    void main() {
        LOG.info("Start application...");

        Country country = new Country("Burgundia");
        Region region = new Region("New region");
        Town town1 = new Town("London", "+13546");
        Town town2 = new Town("Blackpool", "+3166");
        Set<Town> towns = Set.of(town1, town2);

        townRepository.saveAll(towns);

        Set<Region> regions = Set.of(region);
        region.setTowns(towns);
        regionRepository.save(region);

        countryRepository.save(country);
        country.setRegions(regions);

        townRepository.findTownByName("Blackpool");

        LOG.info("Countries: " + countryRepository.findAll());
        LOG.info("Regions: " + regionRepository.findAll());
        LOG.info("Towns: " + townRepository.findAll());
        LOG.info("Country by ID 1: " + countryRepository.findCountryByCountryId(1));
        LOG.info("Region by ID 1: " + regionRepository.findRegionByRegionId(1));
        LOG.info("Town by ID 1: " + townRepository.findTownByTownId(1));

        Assertions.assertEquals("Blackpool", townRepository.findTownByName("Blackpool").get(0).getName());
        Assertions.assertEquals("New region", regionRepository.findRegionByName("New region").get(0).getName());
        Assertions.assertEquals("Burgundia", countryRepository.findCountryByName("Burgundia").get(0).getName());
    }

}