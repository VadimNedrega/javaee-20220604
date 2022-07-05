package hillel.course.spring_annotation.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Team {
    private String teamName;
    private String city;
    private final List<Player> playerList = new ArrayList<>();
    private final List<Trainer> trainers = new ArrayList<>();
    private int count = 1;

    public Team() {
    }

    public Team(String teamName, String city) {
        this.teamName = teamName;
        this.city = city;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public List<Player> getPlayerList() {
        return playerList;
    }

    public List<Trainer> getTrainers() {
        return trainers;
    }

    public int getCount() {
        return count;
    }

    public void printNumber() {
        System.out.println("The current number for teamBean: " + count);
        count++;
        if (count == 11) {
            count = 1;
        }

    }

    @Override
    public String toString() {
        return "Team{" +
                "teamName='" + teamName + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
