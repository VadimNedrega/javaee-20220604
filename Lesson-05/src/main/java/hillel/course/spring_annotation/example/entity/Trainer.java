package hillel.course.spring_annotation.example.entity;

public class Trainer {
    private String name;
    private int age;
    private String jobTitle;
    private Team team;
    int count = 1;

    public Trainer() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public int getCount() {
        return count;
    }

    public void printNumber() {
        System.out.println("The current number for trainerBean: " + count);
        count++;
        if (count == 11) {
            count = 1;
        }

    }

    @Override
    public String toString() {
        return "Trainer{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", jobTitle='" + jobTitle + '\'' +
                ", team=" + team +
                '}';
    }
}
