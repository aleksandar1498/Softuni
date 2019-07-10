package militaryElit;

import militaryElit.common.Repair;
import militaryElit.enums.Corps;
import militaryElit.enums.State;
import militaryElit.common.Mission;
import militaryElit.interfaces.*;
import militaryElit.model.*;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Soldier> soldiers = new ArrayList<>();
        Map<Integer, Soldier> privateIds = new LinkedHashMap<>();
        Scanner scanner = new Scanner(System.in);
        String command = "";
        while (!"End".equals(command = scanner.nextLine())) {
            List<String> commands = Arrays.asList(command.split("\\s+"));
            String typeSoldier = commands.get(0);
            int id = Integer.parseInt(commands.get(1));
            String firstName = commands.get(2);
            String lastName = commands.get(3);
            double salary = 0;
            switch (typeSoldier) {
                case "Private":
                    salary = Double.parseDouble(commands.get(4));
                    System.out.println(id);
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add(priv);
                    privateIds.put(id, priv);
                    break;
                case "LieutenantGeneral":
                    salary = Double.parseDouble(commands.get(4));
                    LieutenantGeneralImpl lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);
                    commands.stream().skip(5).forEach(privId -> {
                        int currId = Integer.parseInt(privId);
                        if (privateIds.containsKey(currId)) {
                            lieutenantGeneral.addPrivate((PrivateImpl) privateIds.get(currId));
                        }
                    });
                    soldiers.add(lieutenantGeneral);
                    break;
                case "Engineer":
                    salary = Double.parseDouble(commands.get(4));
                    try {
                        Corps corps = Corps.valueOf(commands.get(5));
                        EngineerImpl engineer = new EngineerImpl(id, firstName, lastName, salary,corps);
                        List<String> parts= commands.stream().skip(6).collect(Collectors.toList());
                        for (int i = 0; i < parts.size(); i+=2) {
                            engineer.addRepair(new Repair(parts.get(i),Integer.parseInt(parts.get(i+1))));
                        }
                        soldiers.add(engineer);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Illegal corp");
                    }

                    break;
                case "Commando":
                    salary = Double.parseDouble(commands.get(4));
                    try {
                        Corps corps = Corps.valueOf(commands.get(5));
                        CommandoImpl commando = new CommandoImpl(id, firstName, lastName, salary,corps);
                        List<String> missions= commands.stream().skip(6).collect(Collectors.toList());
                        for (int i = 0; i < missions.size(); i+=2) {
                            try{
                               State state=State.valueOf(missions.get(i+1));
                               commando.addMission(new Mission(missions.get(i),state));
                            }catch(IllegalArgumentException exc){

                            }
                        }
                        soldiers.add(commando);
                    } catch (IllegalArgumentException e) {
                        System.out.println("Illegal corp");
                    }
                    break;
                case "Spy":
                    String codeNumber=commands.get(4);
                    soldiers.add(new SpyImpl(id,firstName,lastName,codeNumber));
                    break;
            }

        }
        soldiers.forEach(System.out::println);
    }
}
