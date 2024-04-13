package org.example;

public class ThreadT extends Thread {
    private final TaskMenager taskManager;
    private final ResultsCollector resultCollector;

    public ThreadT(TaskMenager taskManager, ResultsCollector resultCollector)
    {
        this.taskManager = taskManager;
        this.resultCollector = resultCollector;
    }
    public boolean calculate(long c)
    {
        if(c <= 1)
            return false;
        for(long i = 2; i * i <= c; i++)
        {
            if(c % i == 0)
                return false;
        }
        return true;
    }
    @Override
    public void run()
    {
        while(!Thread.currentThread().isInterrupted())
            try
            {
                long number = taskManager.getTask();
                Thread.sleep(5000);
                boolean isPrime = calculate(number);
                if(isPrime) {
                    resultCollector.add(number);
                    System.out.println(number + " is prime");
                }
                else
                    System.out.println(number + " is NOT prime");
            }
            catch(InterruptedException e)
            {
                Thread.currentThread().interrupt();
            }
    }

}
