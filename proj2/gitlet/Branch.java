package gitlet;

import java.io.File;
import java.io.IOException;

import static gitlet.Utils.*;

public class Branch {

    /** The HEAD reference. */
    public static final File HEAD = join(Repository.GITLET_DIR, "HEAD");
    public static final File BRANCH_DIR = join(Repository.GITLET_DIR, "branches");

    /** Read Head to get the current branch name. */
    private static String readHeadBranch() {
        return readContentsAsString(HEAD);
    }

    /** Write current branch name into the HEAD. */
    private static void writeHead() {
        writeContents(HEAD, readHeadBranch());
    }

    /** Update the existed branch with new commitPID. */
    public static void updateBranch(String branchName, Commit commit) {
        String commitPID = sha1(commit);
        writeBranch(commitPID, branchName);
    }

    /** Return HEAD branch's SHA-1. */
    public static String getHeadBranch() {
        String branchName = readContentsAsString(Branch.HEAD);
        File head = join(Branch.BRANCH_DIR, branchName);
        return readContentsAsString(head);
    }

    /** Create a new branch file. */
    public static void newBranch(String branchName) {
        File branch = join(BRANCH_DIR, branchName);
        try {
            branch.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /** Write commit sha-1 into the branch file. */
    public static void writeBranch(String commitPID, String branchName) {
        File branch = join(BRANCH_DIR, branchName);
        writeContents(branch, commitPID);
    }
}
