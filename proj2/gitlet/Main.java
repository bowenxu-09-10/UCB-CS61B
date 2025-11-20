package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Bowen
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
//        if (args.length == 0) {
//            System.out.println("Please enter a command.");
//            System.exit(0);
//        }
        String firstArg = "commit";
        switch(firstArg) {
            case "init":
                Repository.initCommend();
                break;
            case "add":
                Repository.addCommend("test2");
                break;
            case "commit":
                Repository.makeCommit("add test1 remove test1");
                break;
            case "rm":
                Repository.rmCommend("test1");
                break;
            case "log":
                Repository.logCommend();
                break;
            case "global-log":
                Repository.globalLogCommend();
                break;
            case "find":
                Repository.findCommend("initial commit");
                break;
            case "status":
                Repository.printStatus();
                break;
        }
    }
}
