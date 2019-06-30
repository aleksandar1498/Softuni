package footballTeamGenerator;

import java.util.Objects;

public class Player {
    private String name;
    private int endurance;
    private int sprint;
    private int dribble;
    private int passing;
    private int shooting;

    public Player(String name, int endurance, int sprint, int dribble, int passing, int shooting) {
       this.setName(name);
        this.seteEndurance(endurance);
        this.setSprint(sprint);
        this.setDribble(dribble);
        this.setPassing(passing);
        this.setShooting(shooting);
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        if (name.isEmpty() || name.matches("\\s+")) {
            System.out.println("A name should not be empty.");
            return;
        }
        this.name = name;
    }

    private void seteEndurance(int endurance) {
        isInvalid("Endurance", endurance);
        this.endurance = endurance;
    }

    private void setSprint(int sprint) {
        isInvalid("Sprint", sprint);
        this.sprint = sprint;
    }

    private void setDribble(int dribble) {
       isInvalid("Dribble", dribble);
        this.dribble = dribble;
    }

    private void setPassing(int passing) {
        isInvalid("Passing", passing);
        this.passing = passing;
    }

    private void setShooting(int shooting) {
        isInvalid("Shooting", shooting);
        this.shooting = shooting;
    }

    private void isInvalid(String name, int val) {
        if (val < 0 || val > 100) {
            throw new IllegalArgumentException(name + " should be between 0 and 100.");

        }


    }

    public double overallSkillLevel() {
        return (this.dribble + this.endurance + this.passing + this.shooting + this.sprint) / 5.0;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Player player = (Player) o;
        return player.name.equals(this.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
