package truecorp.ensemble.utils;

/**
 * Created by Anukoon on 1/30/2018.
 */

public class JobsStatus {
    private static final String READY = "RD";
    private static final String PROCESSING = "IU";
    private static final String FAIL = "AF";
    private static final String COMPLETE = "CO";
    private static final String HOLD = "HL";
    private static final String SKIP = "SK";
    private static final String KILL = "KL";

    public static boolean isReady(String status){
        return status.equals(READY);
    }

    public static boolean isProcessing(String status){
        return status.equals(PROCESSING);
    }

    public static boolean isFailure(String status){
        return status.equals(FAIL);
    }

    public static boolean isComplete(String status){
        return status.equals(COMPLETE);
    }

    public static boolean isHold(String status){
        return status.equals(HOLD);
    }

    public static boolean isSkip(String status){
        return status.equals(SKIP);
    }

    public static boolean isKill(String status){
        return status.equals(KILL);
    }
}
