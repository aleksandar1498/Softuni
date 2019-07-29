package object_classes;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.function.Predicate;

public class TeamworkProjects {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Team> teams = new ArrayList<>();
        ArrayList<Team> teamsToDisband = new ArrayList<>();
        ArrayList<Team> filteredTeams = new ArrayList<>();
        int numTeams = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < numTeams; i++) {
            String[] action = scanner.nextLine().split("-");
            String creatorName = action[0];
            String teamName = action[1];
            if (teams.stream().anyMatch(team -> team.name.equals(teamName))) {
                System.out.printf("Team %s was already created!\n", teamName);
                continue;
            }

            if (teams.stream().anyMatch(team -> team.creatorName.equals(creatorName))) {
                System.out.printf("%s cannot create another team!\n", creatorName);
                continue;
            }
            Team t = new Team(teamName, creatorName);
            t.members.add(new User(creatorName));
            teams.add(t);
            System.out.printf("Team %s has been created by %s!\n", teamName, creatorName);


        }
        String[] addUser = scanner.nextLine().split("->");
        while (!addUser[0].equals("end of assignment")) {
            String nameUser = addUser[0];
            String teamName = addUser[1];

            if (teams.stream().noneMatch(team -> team.name.equals(teamName))){
                System.out.println("Team " + teamName + " does not exist!");
                addUser = scanner.nextLine().split("->");
                continue;
            }
            if (teams.stream().anyMatch(new Predicate<Team>() {
                @Override
                public boolean test(Team team) {
                    if (team.members.stream().anyMatch(new Predicate<User>() {
                        @Override
                        public boolean test(User user) {
                            if (user.name.equals(nameUser)) {
                                return true;
                            }
                            return false;
                        }
                    })) {
                        return true;
                    }
                    return false;
                }
            })) {

                System.out.println("Member " + nameUser + " cannot join team " + teamName + "!");
                addUser = scanner.nextLine().split("->");
                continue;

            } else {
                for (Team t : teams
                ) {
                    if (t.name.equals(teamName)) {
                        t.members.add(new User(nameUser));
                    }
                }
            }

            addUser = scanner.nextLine().split("->");
        }
        teams.stream().filter(team -> team.members.size() == 1).forEach(teamsToDisband::add);
        teams.stream().filter(team -> team.members.size() > 1).forEach(filteredTeams::add);
        teams = filteredTeams;

        Collections.sort(filteredTeams, new Comparator<Team>() {
            @Override
            public int compare(Team c1, Team c2) {
                if (c1.members.size() > c2.members.size()) {
                    return -1;
                } else if (c1.members.size() < c2.members.size()) {
                    return 1;
                }
                if (c1.name.compareTo(c2.name) < 0) return -1;
                if (c1.name.compareTo(c2.name) > 0) return 1;


                return 0;
            }
        });



        for (int i = 0; i < teams.size(); i++) {

            System.out.println(teams.get(i).name);

            System.out.println("- " + teams.get(i).members.get(0).name);
            Collections.sort(teams.get(i).members.subList(1, teams.get(i).members.size()), new Comparator<User>() {
                @Override
                public int compare(User o1, User o2) {
                    if (o1.name.compareTo(o2.name) < 0) return -1;
                    if (o1.name.compareTo(o2.name) > 0) return 1;
                    return 0;
                }
            });

            for (int j = 1; j < teams.get(i).members.size(); j++) {
                System.out.println("-- " + teams.get(i).members.get(j).name);


            }

        }
        System.out.println("Teams to disband:");

        if (teamsToDisband.size() > 0) {
            Collections.sort(teamsToDisband, new Comparator<Team>() {
                @Override
                public int compare(Team o1, Team o2) {
                    if (o1.name.compareTo(o2.name) > 0) return 1;
                    if (o1.name.compareTo(o2.name) < 0) return -1;
                    return 0;
                }
            });
            for (int j = 0; j < teamsToDisband.size(); j++) {
                System.out.println(teamsToDisband.get(j).name);
            }
        }

    }

    static class Team {
        String name = "";
        String creatorName = "";
        ArrayList<User> members = new ArrayList<>();

        public Team(String n, String cN) {
            this.name = n;
            this.creatorName = cN;
        }


    }

    static class User {
        String name = "";

        User(String name) {
            this.name = name;
        }

    }

}
