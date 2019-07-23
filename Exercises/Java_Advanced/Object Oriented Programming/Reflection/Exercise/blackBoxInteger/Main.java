package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);
        Class<BlackBoxInt> blackBoxIntClass=BlackBoxInt.class;
        Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        //blackBoxIntClass.getMethod("BlackBoxInt",null);

        BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
        Method [] methods = blackBoxIntClass.getDeclaredMethods();
        Map<String,Method> methodMap=new LinkedHashMap<>();
        Field field= blackBoxIntClass.getDeclaredField("innerValue");
        field.setAccessible(true);


        for (Method method : methods) {
            methodMap.put(method.getName(),method);
        }
        String command = "";
        while (!"END".equals(command = scanner.nextLine())) {
            String [] commandToken = command.split("_");
            String methodToCall = commandToken[0];
            int valueToPass = Integer.parseInt(commandToken[1]);
            Method method = methodMap.get(methodToCall);
            method.setAccessible(true);
            method.invoke(blackBoxInt,valueToPass);
            System.out.println(field.get(blackBoxInt));
        }
    }
}
