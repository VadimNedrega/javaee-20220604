package hillel.course.spring_annotation.example.entity.service;

import hillel.course.spring_annotation.example.entity.Player;
import hillel.course.spring_annotation.example.entity.Team;
import hillel.course.spring_annotation.example.entity.Trainer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("teamServiceBean")
public class TeamService {
    private int count = 1;
    @Autowired
    private Team team;

    public void addPlayer(Player player) {
        team.getPlayerList().add(player);
        System.out.println("Player " + player.getName() + " " + player.getSurname() + " was added to team "
                + team.getTeamName());
    }

    public void addTrainer(Trainer trainer) {
        team.getTrainers().add(trainer);
        System.out.println("Trainer " + trainer.getName() + " was added to team " + team.getTeamName());
    }

    public Team getTeam() {
        return team;
    }

    public int getCount() {
        return count;
    }

    public void printNumber() {
        System.out.println("The current number for teamServiceBean: " + count);
        count++;
        if (count == 11) {
            count = 1;
        }

    }

}
