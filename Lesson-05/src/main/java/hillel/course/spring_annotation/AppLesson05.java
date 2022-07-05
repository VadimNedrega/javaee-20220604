package hillel.course.spring_annotation;

import hillel.course.spring_annotation.example.MyConfig;
import hillel.course.spring_annotation.example.entity.Player;
import hillel.course.spring_annotation.example.entity.Team;
import hillel.course.spring_annotation.example.entity.Trainer;
import hillel.course.spring_annotation.example.entity.service.TeamService;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

@SpringBootApplication
public class AppLesson05 {
    private static final Logger log = Logger.getLogger(AppLesson05.class.getName());

    public static void main(String[] args) {
        log.info("Start main...");
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);

        TeamService teamService = context.getBean("teamServiceBean", TeamService.class);

        Team team = context.getBean("teamBean", Team.class);
        team.setTeamName("Everton");
        team.setCity("Liverpool");

        Player player1 = context.getBean("playerBean", Player.class);
        player1.setName("Fabian");
        player1.setSurname("Delph");
        player1.setAge(31);
        player1.setPosition("Midfielder");
        player1.setTeam(team);

        Player player2 = context.getBean("playerBean", Player.class);
        player2.setName("Mathew");
        player2.setSurname("Gordon");
        player2.setAge(19);
        player2.setPosition("Midfielder");
        player2.setTeam(team);

        Trainer trainer1 = context.getBean("trainerBean", Trainer.class);
        trainer1.setName("Frank Lampard");
        trainer1.setAge(42);
        trainer1.setJobTitle("Manager");
        trainer1.setTeam(team);

        Trainer trainer2 = context.getBean("trainerBean", Trainer.class);
        trainer2.setName("Duncan Ferguson");
        trainer2.setAge(46);
        trainer2.setJobTitle("Coach assistant");
        trainer2.setTeam(team);

        teamService.addPlayer(player1);
        teamService.addPlayer(player2);
        teamService.addTrainer(trainer1);
        teamService.addTrainer(trainer2);

        System.out.println("Team info: " + team);
        System.out.println("Players in team: " + team.getPlayerList());
        System.out.println("Trainers in team: " + team.getTrainers());
        System.out.println("__________________________________________________");
        System.out.println();

        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();
        player1.printNumber();

        System.out.println("Expected number: 1, actual: " + player1.getCount());
        System.out.println("__________________________________________________");
        System.out.println();

        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();

        System.out.println("Expected number: 4, actual: " + trainer1.getCount());
        System.out.println("__________________________________________________");
        System.out.println();

        team.printNumber();
        team.printNumber();
        team.printNumber();
        team.printNumber();
        team.printNumber();

        System.out.println("Expected number: 6, actual: " + team.getCount());
        System.out.println("__________________________________________________");
        System.out.println();

        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();
        teamService.printNumber();

        System.out.println("Expected number: 7, actual: " + teamService.getCount());

        log.info("Finish main...");
    }
}
