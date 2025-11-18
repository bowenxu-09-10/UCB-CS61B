package gitlet;

import static gitlet.Utils.*;

public class Branch {

    /** Read Head and get the current branch name. */
    public static String readHead() {
        return readContentsAsString(Repository.HEAD);
    }

    /** Write current branch name into the HEAD. */
    public static void writeHead() {
        writeContents(Repository.HEAD, readHead());
    }

}
