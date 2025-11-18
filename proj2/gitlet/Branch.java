package gitlet;

import java.io.File;

import static gitlet.Utils.*;

public class Branch {

    /** The HEAD reference. */
    public static final File HEAD = join(Repository.GITLET_DIR, "HEAD");

    /** Read Head and get the current branch name. */
    public static String readHead() {
        return readContentsAsString(HEAD);
    }

    /** Write current branch name into the HEAD. */
    public static void writeHead() {
        writeContents(HEAD, readHead());
    }

}
