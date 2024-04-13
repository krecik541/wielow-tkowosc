package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        TaskMenager taskMenager = new TaskMenager();
        ResultsCollector resultsCollector = new ResultsCollector();
        int numberOfThread = 4;//args[0]

        ThreadT []threads = new ThreadT[numberOfThread];
        for (int i = 0; i < numberOfThread; i++)
        {
            threads[i] = new ThreadT(taskMenager, resultsCollector);
            threads[i].start();
        }

        Scanner scanner = new Scanner(System.in);
        while(true)
        {
            System.out.println("Podaj następne zadanie lub wpisz 'exit': ");
            String input = scanner.nextLine();
            if(input.equals("exit"))
                break;
            try {
                taskMenager.add(Long.parseLong(input));
            }
            catch (NumberFormatException e) {}
        }

        for (int i = 0; i < numberOfThread; i++)
        {
            threads[i].interrupt();
        }

        System.out.println(resultsCollector);
    }
}