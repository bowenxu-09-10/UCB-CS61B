package gitlet;

import java.io.File;
import java.util.HashMap;
import java.util.HashSet;

import static gitlet.Utils.*;

public class Checkout {

    private static void checkoutFile(String[] args) {
        if (!checkCommendFormat(args)) {
            System.exit(0);
        }
    }

    private static void checkoutBranch(String branch) {

    }

    private static void checkoutCommit() {
        String commitID = checkPrefix("25e7ffa38a235de");
        // Check is the commend legal. Todo: uncomment
//        if (!(checkCommendFormat(args) || commitID.equals(""))) {
//            System.exit(0);
//        }
//        File commitFile = Utils.join(Commit.COMMIT_DIR, commitID);
//        Commit commit = readObject(commitFile, Commit.class);
//        String fileName = args[3];
//        HashMap<String, String> blobs = commit.getFileNameToBLOB();
//        if (!blobs.containsKey(fileName)) {
//            System.out.println("File does not exist in that commit.");
//        }
//        File file = join(Repository.CWD, fileName);
//        File replaceFile = join(Blob.BLOB_FOLDER, blobs.get(fileName));
//        byte[] content = readContents(replaceFile);
//        writeContents(file, content);
        // Todo: delete it
        File commitFile = Utils.join(Commit.COMMIT_DIR, commitID);
        Commit commit = readObject(commitFile, Commit.class);
        String fileName = "test1";
        HashMap<String, String> blobs = commit.getFileNameToBLOB();
        if (!blobs.containsKey(fileName)) {
            System.out.println("File does not exist in that commit.");
        }
        File file = join(Repository.CWD, fileName);
        String blob = blobs.get(fileName);
        File replaceFile = join(Blob.BLOB_FOLDER, blob);
        byte[] content = readContents(replaceFile);
        writeContents(file, content);
    }

    /**
     * Check if commit id is the only one with such prefix.
     * @return the according commitID.
     */
    private  static String checkPrefix(String prefix) {
        int count = 0;
        String target = "";
        for (String commit : plainFilenamesIn(Commit.COMMIT_DIR)) {
            if (commit.equals(prefix)) {
                return commit;
            } else if (commit.contains(prefix)){
                target = commit;
                count++;
            }
            // If current id prefix is not
            if (count > 1) {
                // ToDo: see if there are designated message.
                System.out.println("multiple commit with that prefix.");
                System.exit(0);
            }
        }
        if (count == 1) {
            return target;
        }
        System.out.println("No commit with that id exists.");
        System.exit(0);
        return "";
    }

    /**
     *  Takes the version of the file as it exists in the head commit and puts
     *  it in the working directory, overwriting the version of the file that’s
     *  already there if there is one. The new version of the file is not staged.
     */
    public static void getCheckoutFile(String[] args) {
        checkoutFile(args);
    }

    /**
     *  Takes the version of the file as it exists in the commit with the given
     *  id, and puts it in the working directory, overwriting the version of the
     *  file that’s already there if there is one. The new version of the file is
     *  not staged.
     */
    public static void getCheckoutBranch(String branch) {
        checkoutBranch(branch);
    }

    /**
     *  Takes all files in the commit at the head of the given branch, and puts
     *  them in the working directory, overwriting the versions of the files that
     *  are already there if they exist. Also, at the end of this command, the
     *  given branch will now be considered the current branch (HEAD). Any files
     *  that are tracked in the current branch but are not present in the
     *  checked-out branch are deleted.
     */
    // Todo: Uncomment
    public static void getCheckoutCommit() {
        checkoutCommit();
//        checkoutCommit(args);
    }

    /**
     * Check if commend is obey the format.
     */
    public static boolean checkCommendFormat(String[] args) {
        if (args.length == 3 && args[1].equals("--")) {
            return true;
        }
        if (args.length == 4 && args[2].equals("--") && args[1].length() <= 40) {
            return true;
        }
        return false;
    }
}
