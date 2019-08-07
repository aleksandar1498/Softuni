package iteratorsandcomparators.petclinics;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=Integer.parseInt(scanner.nextLine());
        List<Clinic> clinics=new ArrayList<>();
        List<Pet> pets=new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String [] lineToken=scanner.nextLine().split(" ");

            switch (lineToken[0]){
                case "Create":
                    switch (lineToken[1]){

                        case "Pet":
                            String petName=lineToken[2];
                            int petAge=Integer.parseInt(lineToken[3]);
                            String kind=lineToken[4];
                            if(!pets.contains(new Pet(petName,petAge,kind))){
                                pets.add(new Pet(petName,petAge,kind));
                            }
                            break;
                        case "Clinic":
                            int numRooms=Integer.parseInt(lineToken[3]);
                            try{
                                if(!clinics.contains(new Clinic(lineToken[2]))){
                                    clinics.add(new Clinic(lineToken[2],numRooms));
                                }

                            }catch (IllegalArgumentException e){
                                System.out.println(e.getMessage());
                            }
                            break;
                    }
                    break;
                case "Add":
                    if(pets.contains(new Pet(lineToken[1])) && clinics.contains(new Clinic(lineToken[2]))){
                        System.out.println(clinics.get(clinics.indexOf(new Clinic(lineToken[2]))).add(pets.get(pets.indexOf(new Pet(lineToken[1])))));
                    }else{
                        System.out.println("false");
                    }
                    break;
                case "Release":
                    if(clinics.contains(new Clinic(lineToken[1]))){
                        System.out.println(clinics.get(clinics.indexOf(new Clinic(lineToken[1]))).release());
                    }
                    break;
                case "HasEmptyRooms":
                    if(clinics.contains(new Clinic(lineToken[1]))){
                        System.out.println(clinics.get(clinics.indexOf(new Clinic(lineToken[1]))).hasEmptyRooms());
                    }
                    break;
                case "Print":
                    //System.out.println();
                    if(lineToken.length == 2){
                        if(clinics.contains(new Clinic(lineToken[1]))){
                           // System.out.println(clinics.indexOf(new Clinic(lineToken[1])));
                           clinics.get(clinics.indexOf(new Clinic(lineToken[1]))).rooms.forEach(x -> {
                               if(x.isFree()){
                                   System.out.println("Room empty");
                               }else{
                                   System.out.println(x.getPet().toString());
                               }
                           });
                        }
                    }else{
                        if(clinics.contains(new Clinic(lineToken[1]))){
                           Room r=  clinics.get(clinics.indexOf(new Clinic(lineToken[1]))).get(Integer.parseInt(lineToken[2])-1);
                           // System.out.println();
                           if(r != null){
                               if(r.isFree()){
                                   System.out.println("Room empty");
                               }else{
                                   System.out.println(r.getPet().toString());
                               }
                           }
                        }
                    }
                    break;
            }
        }


    }
}
