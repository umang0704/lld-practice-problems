package org.lld.utils.scanner;


import lombok.extern.slf4j.Slf4j;

import java.text.MessageFormat;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

@Slf4j
public class ScannerUtils {
    private static ScannerUtils scannerUtils;
    private static final Scanner scanner = new Scanner(System.in);

    private ScannerUtils() {
    }

    public static synchronized ScannerUtils getScannerUtils(){
        if(null == scannerUtils){
            scannerUtils = new ScannerUtils();
        }
        return scannerUtils;
    }

    public synchronized Integer getInt(String message){
        log.info(MessageFormat.format("Enter integer : \n{0}",message));
        return scanner.nextInt();
    }
    public synchronized String getString(String message){
        log.info(MessageFormat.format("Enter String : \n{0}",message));
        String stringObject = scanner.nextLine();
        if(stringObject.isBlank()){
            return null;
        }
        return stringObject;
    }

    public synchronized boolean continueWish(){
        log.info("{0}, Do You wish to continue[y/n]");
        String yesOrNo = scanner.nextLine();
        if(YES.contains(yesOrNo.toLowerCase())){
            return true;
        }
        if(NO.contains(yesOrNo.toLowerCase())){
            return false;
        }
        log.info("Invalid Input");
        return false;
    }
    private static final HashSet<String> YES = new HashSet<>(Set.of("y","yes"));
    private static final HashSet<String> NO = new HashSet<>(Set.of("n","no"));
}
