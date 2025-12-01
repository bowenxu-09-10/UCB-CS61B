package gitlet;

/** Driver class for Gitlet, a subset of the Git version-control system.
 *  @author Bowen
 */
public class Main {

    /** Usage: java gitlet.Main ARGS, where ARGS contains
     *  <COMMAND> <OPERAND1> <OPERAND2> ... 
     */
    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter a command.");
            System.exit(0);
        }
        String firstArg = args[0];
        switch(firstArg) {
            case "init":
                Repository.initCommend(args);
                break;
            case "add":
                Repository.addCommend(args);
                break;
            case "commit":
                Repository.commitCommend(args);
                break;
            case "rm":
                Repository.rmCommend(args);
                break;
            case "log":
                Repository.logCommend(args);
                break;
            case "global-log":
                Repository.globalLogCommend(args);
                break;
            case "find":
                Repository.findCommend(args);
                break;
            case "status":
                Repository.printStatus(args);
                break;
            case "checkout":
                Repository.checkoutCommend(args);
                break;
            case "branch":
                Repository.branchCommend(args);
                break;
            case "rm-branch":
                Repository.removeBranch(args);
                break;
            case "reset":
                Repository.resetCommend(args);
                break;
            case "merge":
                Repository.mergeCommend(args);
                break;
            default:
                System.out.println("No command with that name exists.");
                System.exit(0);
        }
    }
}