package org.lld.utils.logger;

public class Logger{
    private static Logger logger;
    private Logger() {
    }
    public static synchronized Logger getLogger() {
        if(null == logger){
            logger = new Logger();
        }
        return logger;
    }
    public void info(String message) {
        System.out.println(message);
    }
    public void error(String message) {
        System.out.println(message);
    }
}
