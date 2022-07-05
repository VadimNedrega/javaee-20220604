package hillel.course.spring_annotation.example.entity.service;

import hillel.course.spring_annotation.example.MyConfig;
import hillel.course.spring_annotation.example.entity.Player;
import hillel.course.spring_annotation.example.entity.Team;
import hillel.course.spring_annotation.example.entity.Trainer;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class TeamServiceTest {

    @Test
    void isSingleton() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TeamService teamService1 = context.getBean("teamServiceBean", TeamService.class);
        TeamService teamService2 = context.getBean("teamServiceBean", TeamService.class);

        assertEquals(teamService1, teamService2);
    }

    @Test
    void addPlayer() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TeamService teamService = context.getBean("teamServiceBean", TeamService.class);
        Player player = context.getBean("playerBean", Player.class);
        teamService.addPlayer(player);

        Assertions.assertEquals(1, teamService.getTeam().getPlayerList().size());
    }

    @Test
    void addTrainer() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        TeamService teamService = context.getBean("teamServiceBean", TeamService.class);
        Trainer trainer = context.getBean("trainerBean", Trainer.class);
        teamService.addTrainer(trainer);

        Assertions.assertEquals(1, teamService.getTeam().getTrainers().size());
    }
}