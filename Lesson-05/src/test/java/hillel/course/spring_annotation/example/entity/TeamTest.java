package hillel.course.spring_annotation.example.entity;

import hillel.course.spring_annotation.example.MyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TeamTest {

    @Test
    void isSingleton() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Team team1 = context.getBean("teamBean", Team.class);
        Team team2 = context.getBean("teamBean", Team.class);

        assertEquals(team1, team2);
    }

    @Test
    void setName() {
        Team team = new Team();
        team.setTeamName("Leeds");

        Assertions.assertEquals("Leeds", team.getTeamName());
    }

    @Test
    void setCity() {
        Team team = new Team();
        team.setCity("Norwich");

        Assertions.assertEquals("Norwich", team.getCity());
    }
}