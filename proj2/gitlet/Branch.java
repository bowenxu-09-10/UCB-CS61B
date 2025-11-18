package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

public class Branch {

    /** The HEAD reference. */
    public static final File HEAD = join(Repository.GITLET_DIR, "HEAD");
    public static final File BRANCH_DIR = join(Repository.GITLET_DIR, "branches");

    /** Read Head and get the current branch name. */
    public static String readHead() {
        return readContentsAsString(HEAD);
    }

    /** Write current branch name into the HEAD. */
    public static void writeHead() {
        writeContents(HEAD, readHead());
    }

    /** Update the existed branch with new commitPID. */
    public void updateBranch(String branchName, Commit commit) {
        String commitPID = sha1(commit);
        writeBranch(commitPID, branchName);
    }

    /** Create a new branch file. */
    private void newBranch(String branchName) {
        File branch = join(BRANCH_DIR, branchName);
        try {
            branch.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Write commit sha-1 into the branch file. */
    private void writeBranch(String commitPID, String branchName) {
        File branch = join(BRANCH_DIR, branchName);
        writeContents(branch, commitPID);
    }
}
