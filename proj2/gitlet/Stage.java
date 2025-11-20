package gitlet;

import java.io.File;
import java.util.HashMap;
import java.util.Set;

import static gitlet.Utils.*;

public class Stage {
    /** A Map for staged file for addition. */
    private static HashMap<String, String> stagedAddition;
    /** A Set for staged file for removal. */
    private static Set<String> stagedRemoval;

    /** The index file acts as staging area. */
    public static final File INDEX = join(Repository.GITLET_DIR, "index");

    /** Save file as blob file, and return its pid. */
    private static String saveFile(String fileName) {
        // Read contents in file and make a blob.
        Blob blob = new Blob(fileName);
        return blob.saveBlob();
    }

    /** Check if current file added is the same as commited.
     *  True for is the same as committed. */
    private static boolean checkSameCommit(String fileName) {
        Commit head = Commit.getHeadCommit();
        HashMap<String, String> fileTracted = head.fileNameToBLOB;
        return fileTracted.containsValue(saveFile(fileName));
    }

    /** Check if current file added is the same as staged.
     *  True for is the same as committed. */
    private static boolean checkSameStage(String fileName) {
        Commit head = Commit.getHeadCommit();
        HashMap<String, String> fileTracted = head.fileNameToBLOB;
        return fileTracted.containsValue(saveFile(fileName));
    }

    /** Add file to staging area. If added one is the same as commited, but in staged area,
     *  then remove it from stagedAddition. */
    public static void addStage(String fileName) {
        if (checkSameCommit(fileName)) {
            if (stagedAddition.containsValue(saveFile(fileName))) {
                stagedAddition.remove(fileName);
            }
        }
        stagedAddition.put(fileName, sha1(fileName));
    }

    /** Remove file to staging area, if file is in the stage area then unstage it.
     *  If the file is tracked, then staged for removal. */
    public static void removeStage(String fileName) {
        // If the file is staged, then unstage.
        if (stagedAddition.containsKey(fileName)) {
            stagedAddition.remove(fileName);
            return;
        }
        // If the file is tracked, then stage it removal.
        Commit head = Commit.getHeadCommit();
        if (head.fileNameToBLOB.containsKey(fileName)) {
            stagedRemoval.add(fileName);
            
            return;
        }
        System.out.println("No reason to remove the file.");
        System.exit(0);
    }

    /** Get staded for addition hashmap. */
    public static HashMap<String, String> getStagedAddition() {
        return stagedAddition;
    }

    /** Get staded for removal hashmap. */
    public static Set<String> getStagedRemoval() {
        return stagedRemoval;
    }

    /** Clear all the stage area. */
    public static void clear() {
        stagedAddition = null;
        stagedRemoval = null;
    }
}
