package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
        Class<RichSoilLand> richSoilLandClass= RichSoilLand.class;
		Field[] fields =richSoilLandClass.getDeclaredFields();


		String command="";
		while(!"HARVEST".equals(command = scanner.nextLine())){
			switch (command){
				case "private":
					Arrays.stream(fields).filter(m -> Modifier.isPrivate(m.getModifiers())).forEach(dM -> Main.printField("private",dM.getType().getSimpleName(),dM.getName()));
					break;
				case "protected":
					Arrays.stream(fields).filter(m -> Modifier.isProtected(m.getModifiers())).forEach(dM -> Main.printField("protected",dM.getType().getSimpleName(),dM.getName()));
					break;
				case "public":
					Arrays.stream(fields).filter(m -> Modifier.isPublic(m.getModifiers())).forEach(dM -> Main.printField("public",dM.getType().getSimpleName(),dM.getName()));
					break;
				case "all":
					Arrays.stream(fields).forEach(dM -> {
						if(Modifier.isPublic(dM.getModifiers())){
							Main.printField("public",dM.getType().getSimpleName(),dM.getName());
						}else if(Modifier.isPrivate(dM.getModifiers())){
							Main.printField("private",dM.getType().getSimpleName(),dM.getName());

						}else if(Modifier.isProtected(dM.getModifiers())){
							Main.printField("protected",dM.getType().getSimpleName(),dM.getName());

						}


					});
					break;
			}

		}
	}
	public static void printField(String accessModifier, String returnType, String name){

		System.out.printf("%s %s %s%n",accessModifier,returnType,name);
	}
}
