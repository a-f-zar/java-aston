package com.aston;

import com.aston.service.impl.AlternatingPrintStrategy;
import com.aston.service.impl.DeadLockStrategy;
import com.aston.service.impl.LiveLockStrategy;
import com.aston.service.LockScenarioStrategy;
import com.aston.doman.enums.ScenarioType;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class App {

    public static void main(String[] args) {
        Map<ScenarioType, LockScenarioStrategy> strategies = new HashMap<>();
        strategies.put(ScenarioType.DEADLOCK, new DeadLockStrategy());
        strategies.put(ScenarioType.LIVELOCK, new LiveLockStrategy());
        strategies.put(ScenarioType.ALTERNATE, new AlternatingPrintStrategy());

        Scanner scanner = new Scanner(System.in);
        ScenarioType scenarioType = readScenarioType(scanner);

        LockScenarioStrategy strategy = strategies.get(scenarioType);
        strategy.run();
    }

    private static ScenarioType readScenarioType(Scanner scanner) {
        while (true) {
            printUsage();
            String scenarioNumber = scanner.nextLine();
            ScenarioType scenarioType = ScenarioType.fromNumber(scenarioNumber);

            if (scenarioType != null) {
                return scenarioType;
            }

            System.out.println("Incorrect input. Try again.");
        }
    }

    private static void printUsage() {
        System.out.println("Choose scenario:");
        System.out.println(ScenarioType.DEADLOCK.getNumber() + " - " + ScenarioType.DEADLOCK.getTitle());
        System.out.println(ScenarioType.LIVELOCK.getNumber() + " - " + ScenarioType.LIVELOCK.getTitle());
        System.out.println(ScenarioType.ALTERNATE.getNumber() + " - " + ScenarioType.ALTERNATE.getTitle());
    }
}
