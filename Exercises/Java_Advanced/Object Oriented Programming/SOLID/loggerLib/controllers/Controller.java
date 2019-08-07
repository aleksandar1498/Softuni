package controllers;

import appenders.interfaces.Appender;
import enums.Report;
import layouts.SimpleLayout;
import layouts.XmlLayout;
import layouts.interfaces.Layout;
import loggers.MessageLogger;
import loggers.interfaces.Logger;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Controller {
    private Scanner scanner;
    private Logger logger;



    public Controller() throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {
        this.logger = new MessageLogger();
        this.scanner = new Scanner(System.in);
        this.setLogger();
    }
    public void setLogger() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        List<Appender> appenders = this.readAppenders();
        Appender [] app = new Appender[appenders.size()];
        for (int i = 0; i < app.length; i++) {
            app[i] = appenders.get(i);
        }
        this.logger = new MessageLogger(app);
    }
    public void parseInput(){
        String command="";
        while (!"END".equals(command = scanner.nextLine())){
            this.parseCommand(command.split("\\|"));
        }
        System.out.println(this.logger);
    }

    private void parseCommand(String[] split) {
        logger.log(split[1],Report.valueOf(split[0]),split[2]);
    }

    public List<Appender> readAppenders() throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        int n = Integer.parseInt(scanner.nextLine());
        List<Appender> appenderList= new ArrayList<>();
        for (int i = 0; i < n; i++) {
            String [] appenderInfo = scanner.nextLine().split("\\s+");
            Layout layout = (Layout) Class.forName("layouts."+appenderInfo[1]).getConstructor().newInstance();
            Appender appender = (Appender) Class.forName("appenders."+appenderInfo[0]).getConstructor(Layout.class).newInstance(layout);
            if(appenderInfo.length == 3){
               appender.setReportLevel(Report.valueOf(appenderInfo[2]));
            }
            appenderList.add(appender);
        }
       return appenderList;
    }
}
