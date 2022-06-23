package hillel.course.hibernate.repository;

import hillel.course.hibernate.db.HibernateUtil;
import hillel.course.hibernate.entity.City;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.sql.SQLDataException;
import java.util.List;
import java.util.Locale;

public class CityRepository {

    public void saveCityToRepo(City city) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(city);
        session.getTransaction().commit();
    }

    public City getCityById(int id) {
        String hql = "From City where id = :targetId";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<City> query = session.createQuery(hql, City.class);
            query.setParameter("targetId", id);
            return query.getSingleResult();
        }
    }

    public City getCityByName(String cityName) {
        String hql = "From City where name = :targetName";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            Query<City> query = session.createQuery(hql, City.class);
            query.setParameter("targetName", cityName);
            return query.getSingleResult();
        }
    }

    public void deleteCityByName(String cityName) {
        String hqlDelete = "delete from City where name = :targetName";
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            if (ifRepoIsEmpty()) System.out.println("The Repo is empty");

            //Verify object before deleting
            if (ifCityPresentsInRepo(cityName) && !ifRepoIsEmpty()) {

                //Need transaction to be open for delete objects from DB
                Transaction transaction = session.beginTransaction();

                //Deleting object
                var queryDelete = session.createQuery(hqlDelete);
                queryDelete.setParameter("targetName", cityName);
                queryDelete.executeUpdate();

                //Save deleting object in DB
                transaction.commit();

            } else throw new SQLDataException("There is no city " + cityName.toUpperCase(Locale.ROOT) +
                    " was found in DB");
        } catch (SQLDataException throwables) {
            throwables.printStackTrace();
        }
    }

    public boolean ifCityPresentsInRepo(String cityName) {
        List<City> cities = getCities();
        for (City city : cities) {
            if (city.getName().equals(cityName)) {
                return true;
            }
        }
        return false;
    }

    public List<City> getCities() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            return session.createQuery("from City", City.class).list();
        }
    }

    public boolean ifRepoIsEmpty() {
        return getCities().isEmpty();
    }

    public void printCities() {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            List<City> students = session.createQuery(" from City ", City.class).list();
            students.forEach(s -> System.out.printf("City[id=%d;name=%s]\n", s.getId(), s.getName()));
        }
    }
}
