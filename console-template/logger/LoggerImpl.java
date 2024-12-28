package org.lld.utils.logger;

public class LoggerImpl implements Logger{

    @Override
    public void info(String message) {
        System.out.println(message);
    }

    @Override
    public void error(String message) {
        System.out.println(message);
    }
}
