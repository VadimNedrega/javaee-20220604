package hillel.course.spring_annotation.example;

import hillel.course.spring_annotation.example.entity.Team;
import hillel.course.spring_annotation.example.entity.Trainer;
import hillel.course.spring_annotation.example.entity.service.TeamService;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
@ComponentScan(value = "hillel.course.spring_annotation")
public class MyConfig {
    int count = 1;

    @Bean("teamBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public Team getTeam() {
        return new Team();
    }

    @Bean("trainerBean")
    @Scope(value = ConfigurableBeanFactory.SCOPE_PROTOTYPE)
    public Trainer getTrainer() {
        return new Trainer();
    }

    @Bean
    @Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
    public TeamService getTeamService() {
        return new TeamService();
    }

    public void printNumber() {
        System.out.println("The curren number for myConfigBean: " + count);
        count++;
        if (count == 11) {
            count = 1;
        }

    }
}
