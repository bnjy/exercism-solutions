public class LogLevels {

    // main for local tests
    public static void main(String[] args) {
        LogLevels.reformat("[ERROR]: \t Corrupt disk\t \t \r\n");
    }
    
    /**
     * Implement the (static) LogLevels.message() method to return a log line's message
     * @param logLine
     * @return log line's message
     */
    public static String message(String logLine) {        
        String[] splitLogLine = logLine.split("]:");
        return splitLogLine[1].trim();
    }

    public static String logLevel(String logLine) {        
        String newLogLine = logLine.replace("[", "");
        String[] splitLogLine = newLogLine.split("]:");
        return splitLogLine[0].trim().toLowerCase();
    }

    public static String reformat(String logLine) {
        String message = LogLevels.message(logLine);
        String level = LogLevels.logLevel(logLine);
        return message + " " + "(" + level + ")";
    }
}
