package com.date.DesignPattern.行为型模式.责任链模式;

/**
 * to do
 *  //责任链路封装errorLogger--->fileLogger--->consoleLogger ,在判断级别选择打印
 * @author Hj
 * @date 2022/5/29
 */
public class MainClass {


    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger(AbstractLogger.ERROR);
        AbstractLogger fileLogger = new FileLogger(AbstractLogger.DEBUG);
        AbstractLogger consoleLogger = new ConsoleLogger(AbstractLogger.INFO);


        errorLogger.setNextLogger(fileLogger);
        fileLogger.setNextLogger(consoleLogger);

        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an information.");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.DEBUG,
                "This is a debug level information.");
        System.out.println();
        loggerChain.logMessage(AbstractLogger.ERROR,
                "This is an error information.");
    }
}


