package hillel.course;

import hillel.course.spring_data_jpa.entity.Country;
import hillel.course.spring_data_jpa.entity.Region;
import hillel.course.spring_data_jpa.entity.Town;
import hillel.course.spring_data_jpa.exception.ChooseObjectException;
import hillel.course.spring_data_jpa.repository.CountryRepository;
import hillel.course.spring_data_jpa.repository.RegionRepository;
import hillel.course.spring_data_jpa.repository.TownRepository;
import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.logging.Logger;

@Component
public class WorkWithConsole {
    private static final Logger log = Logger.getLogger(WorkWithConsole.class.getName());
    private final CountryRepository countryRepository;
    private final RegionRepository regionRepository;
    private final TownRepository townRepository;
    private final Set<Country> countries = new HashSet<>();
    private final Set<Region> regions = new HashSet<>();
    private final Set<Town> towns = new HashSet<>();


    public WorkWithConsole(CountryRepository countryRepository, RegionRepository regionRepository, TownRepository townRepository) {
        this.countryRepository = countryRepository;
        this.regionRepository = regionRepository;
        this.townRepository = townRepository;
    }

    public Object chooseObject() throws IOException {
        System.out.println("""
                Please enter number of Object you want to save:
                 1. Country
                 2. Region
                 3. Town""");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int a;
        try {
            a = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.err.println("ERROR! Please enter correct variant from list below");
            return chooseObject();
        }
        if (1 > a || a > 3) {
            System.err.println("ERROR! Please enter correct variant from list below");
        }
        return switch (a) {
            case 1 -> new Country();
            case 2 -> new Region();
            case 3 -> new Town();
            default -> chooseObject();
        };
    }

    public void saveObject() throws IOException {
        Object object = chooseObject();

        if (object instanceof Country) saveCountry((Country) object);
        else if (object instanceof Region) saveRegion((Region) object);
        else saveTown((Town) object);

        countryRepository.saveAll(countries);
        regionRepository.saveAll(regions);
        townRepository.saveAll(towns);
    }

    public void saveCountry(Country country) throws IOException {
        System.out.println("Please enter county name");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        country.setName(str);
        countries.add(country);
        country.setRegions(regions);
    }

    public void saveRegion(Region region) throws IOException {
        System.out.println("Please enter region name");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        region.setName(str);

        Country newCountry = new Country();
        saveCountry(newCountry);
        region.setCountry(newCountry);

        regions.add(region);
        countries.add(newCountry);
    }

    public void saveTown(Town town) throws IOException {
        System.out.println("Please enter town name");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        System.out.println("Please enter town phoneCode");
        String code = new BufferedReader(new InputStreamReader(System.in)).readLine();
        town.setPhoneCode(code);


        Region region = new Region();
        saveRegion(region);
        town.setRegion(region);

        town.setName(str);
        towns.add(town);
    }

    public Object getObjectById() throws IOException {
        if (!towns.isEmpty()) {
            System.out.println("Please enter id town to find");
            String id = new BufferedReader(new InputStreamReader(System.in)).readLine();
            int identity = Integer.parseInt(id);

            log.info("Chosen object: " + townRepository.findTownByTownId(identity));
            System.out.println("Chosen object: " + townRepository.findTownByTownId(identity));
            return townRepository.findTownByTownId(identity);
        }
        if (!regions.isEmpty()) {
            System.out.println("Please enter id region to find");
            String id = new BufferedReader(new InputStreamReader(System.in)).readLine();
            int identity = Integer.parseInt(id);

            log.info("Chosen object: " + regionRepository.findRegionByRegionId(identity));
            System.out.println("Chosen object: " + regionRepository.findRegionByRegionId(identity));
            return regionRepository.findRegionByRegionId(identity);
        }
        if (!countries.isEmpty()) {
            System.out.println("Please enter id country to find");
            String id = new BufferedReader(new InputStreamReader(System.in)).readLine();
            int identity = Integer.parseInt(id);

            log.info("Chosen object: " + countryRepository.findCountryByCountryId(identity));
            System.out.println("Chosen object: " + countryRepository.findCountryByCountryId(identity));
            return countryRepository.findCountryByCountryId(identity);
        }
        return new ChooseObjectException("You choose wrong name of object");
    }

    public Object getObjectByName() throws IOException {
        if (!towns.isEmpty()) {
            System.out.println("Please enter town name to find");
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

            log.info("Chosen object: " + townRepository.findTownByName(name));
            System.out.println("Chosen object: " + townRepository.findTownByName(name));
            return townRepository.findTownByName(name);
        }
        if (!regions.isEmpty()) {
            System.out.println("Please enter region name to find");
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

            log.info("Chosen object: " + regionRepository.findRegionByName(name));
            System.out.println("Chosen object: " + regionRepository.findRegionByName(name));
            return regionRepository.findRegionByName(name);
        }
        if (!countries.isEmpty()) {
            System.out.println("Please enter country name to find");
            String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

            log.info("Chosen object: " + countryRepository.findCountryByName(name));
            System.out.println("Chosen object: " + countryRepository.findCountryByName(name));
            return countryRepository.findCountryByName(name);
        }
        return new ChooseObjectException("You choose wrong name of object");
    }

}
