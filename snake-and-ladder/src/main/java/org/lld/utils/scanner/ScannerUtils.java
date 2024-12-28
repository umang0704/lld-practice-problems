package org.lld.utils.scanner;

import org.lld.utils.logger.Logger;

import java.text.MessageFormat;
import java.util.Scanner;

public class ScannerUtils {
    private static ScannerUtils scannerUtils;
    private static final Scanner scanner = new Scanner(System.in);
    private static final Logger log = Logger.getLogger();

    private ScannerUtils() {
    }

    public static synchronized ScannerUtils getScannerUtils(){
        if(null == scannerUtils){
            scannerUtils = new ScannerUtils();
        }
        return scannerUtils;
    }

    public synchronized Integer getInt(String message){
        log.info(MessageFormat.format(GET_INTEGER_LOG,message));
        Object intValue = scanner.nextInt();
        if(!(intValue instanceof Integer)){
            return null;
        }
        return (Integer)(intValue);
    }

    private final String GET_INTEGER_LOG = "Enter {0} in integer : ";
}
