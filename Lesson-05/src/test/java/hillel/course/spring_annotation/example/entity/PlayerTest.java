package hillel.course.spring_annotation.example.entity;

import hillel.course.spring_annotation.example.MyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class PlayerTest {

    @Test
    void isPrototype() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Player player1 = context.getBean("playerBean", Player.class);
        Player player2 = context.getBean("playerBean", Player.class);

        assertNotEquals(player2, player1);
    }

    @Test
    void setAge() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Player player = context.getBean("playerBean", Player.class);
        player.setAge(25);

        Assertions.assertEquals(25, player.getAge());
    }

    @Test
    void setTeam() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Player player = context.getBean("playerBean", Player.class);
        Team team = context.getBean("teamBean", Team.class);
        team.setTeamName("Newcastle");
        player.setTeam(team);

        Assertions.assertEquals("Newcastle", player.getTeam().getTeamName());
    }

    @Test
    void setPosition() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Player player = context.getBean("playerBean", Player.class);
        player.setPosition("Striker");

        Assertions.assertEquals("Striker", player.getPosition());
    }
}