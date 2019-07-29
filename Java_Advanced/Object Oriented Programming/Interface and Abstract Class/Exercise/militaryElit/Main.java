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
                    PrivateImpl priv = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.add((PrivateImpl)priv);
                    privateIds.put(id, priv);
                    break;
                case "LeutenantGeneral":
                    salary = Double.parseDouble(commands.get(4));
                    LeutenantGeneralImpl leutenantGeneral = new LeutenantGeneralImpl(id, firstName, lastName, salary);
                    System.out.println();
                    commands.stream().skip(5).forEach(privId -> {
                        int currId = Integer.parseInt(privId);
                        if (privateIds.containsKey(currId)) {
                            leutenantGeneral.addPrivate((PrivateImpl) privateIds.get(currId));
                        }
                    });
                    soldiers.add(leutenantGeneral);
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
