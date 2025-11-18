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

    /** Create a new branch file. */
    public void newBranch(String name) {
        File branch = join(BRANCH_DIR, name);
        try {
            branch.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    // ToDo write commitPID into the branch file
    public void writeBranch(String commitPID, String name) {
        File branch = join(BRANCH_DIR, name);
        writeContents(branch, commitPID);
    }
}
