package hillel.course.spring_annotation.example.entity;

import hillel.course.spring_annotation.example.MyConfig;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.junit.jupiter.api.Assertions.*;

class TrainerTest {

    @Test
    void isPrototype() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Trainer trainer1 = context.getBean("trainerBean", Trainer.class);
        Trainer trainer2 = context.getBean("trainerBean", Trainer.class);

        assertNotEquals(trainer1, trainer2);
    }

    @Test
    void setTeam() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Trainer trainer1 = context.getBean("trainerBean", Trainer.class);

        Team team = new Team("Leeds", "Leeds");
        trainer1.setTeam(team);

        Assertions.assertEquals("Leeds", trainer1.getTeam().getTeamName());
    }

    @Test
    void printNumber() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConfig.class);
        Trainer trainer1 = context.getBean("trainerBean", Trainer.class);

        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();
        trainer1.printNumber();

        Assertions.assertEquals(6, trainer1.count);
    }
}