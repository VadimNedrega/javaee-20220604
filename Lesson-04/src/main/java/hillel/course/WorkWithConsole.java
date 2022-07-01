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

        if (saveAnotherObject()) {
            saveObject();
        } else {
            countryRepository.saveAll(countries);
            regionRepository.saveAll(regions);
            townRepository.saveAll(towns);
        }
    }

    public boolean saveAnotherObject() throws IOException {
        System.out.println("Do you want to save another object? \n 1. Yes \n 2. No");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine().toUpperCase();
        try {
            if (Integer.parseInt(str) == 1) {
                return true;
            } else if (Integer.parseInt(str) == 2) {
                System.out.println("All objects were saved");
                return false;
            }
        } catch (NumberFormatException e) {
            System.err.println("ERROR! Please enter correct variant from list below");
            saveAnotherObject();
        }
        return false;
    }

    public void saveCountry(Country country) throws IOException {
        System.out.println("Please enter county name");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();

        for (Country name : countries) {
            if (name.getName().equals(str)) {
                System.err.println("ERROR! This country has already added in DB");
                saveCountry(new Country());
            }
        }
        country.setName(str);
        countries.add(country);
        country.setRegions(regions);
    }

    public void saveRegion(Region region) throws IOException {
        System.out.println("Please enter region name");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        region.setName(str);


        for (Region regionName : regions) {
            if (regionName.getName().equals(str)) {
                System.err.println("ERROR! This region has already added in DB");
                saveRegion(new Region());
            }
        }

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

        for (Town name : towns) {
            if (name.getName().equals(str)) {
                System.err.println("ERROR! This town has already added in DB");
                saveTown(new Town());
            }
        }

        town.setName(str);
        towns.add(town);
    }

    public Object getObjectById() throws IOException {
        System.out.println("""
                Please enter number of Object you want to find in DB by id:
                 1. Country
                 2. Region
                 3. Town""");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int number;

        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            System.err.println("ERROR! Please enter correct variant from list below");
            return getObjectById();
        }
        if (1 > number || number > 3) {
            System.err.println("ERROR! Please enter correct variant from list below");
        }

        System.out.println("Please enter id object to find");
        String id = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int identity = Integer.parseInt(id);

        switch (number) {
            case 1 -> {
                log.info("Chosen object: " + countryRepository.findCountryByCountryId(identity));
                return countryRepository.findCountryByCountryId(number);
            }
            case 2 -> {
                log.info("Chosen object: " + regionRepository.findRegionByRegionId(identity));
                return regionRepository.findRegionByRegionId(number);
            }
            case 3 -> {
                log.info("Chosen object: " + townRepository.findTownByTownId(identity));
                return townRepository.findTownByTownId(identity);
            }
            default -> throw new ChooseObjectException("You choose wrong id of object");
        }
    }

    public Object getObjectByName() throws IOException {
        System.out.println("""
                Please enter number of Object you want to find in DB by name:
                 1. Country
                 2. Region
                 3. Town""");
        String str = new BufferedReader(new InputStreamReader(System.in)).readLine();
        int a;

        System.out.println("Please enter name of object to find");
        String name = new BufferedReader(new InputStreamReader(System.in)).readLine();

        try {
            a = Integer.parseInt(str);
            if (1 > a || a > 3) {
                System.err.println("ERROR! Please enter correct variant from list below");
            }
            switch (a) {
                case 1 -> {
                    log.info("Chosen object: " + countryRepository.findCountryByName(name));
                    return countryRepository.findCountryByName(name);
                }
                case 2 -> {
                    log.info("Chosen object: " + regionRepository.findRegionByName(name));
                    return regionRepository.findRegionByName(name);
                }
                case 3 -> {
                    log.info("Chosen object: " + townRepository.findTownByName(name));
                    return townRepository.findTownByName(name);
                }
                default -> throw new ChooseObjectException("You choose wrong name of object");
            }
        } catch (NumberFormatException e) {
            System.err.println("ERROR! Please enter correct variant from list below");
            return getObjectById();
        }


    }

}
