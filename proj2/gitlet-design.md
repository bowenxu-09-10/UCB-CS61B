# Gitlet Design Document

**Name**: Bowen 

## Classes and Data Structures

### Stage

#### Field

1. stagedAddition: A Map for staged file for addition.
2. stagedRemoval: A Set for staged file for removal.
3. saveFile(): Save file as blob file, and return its pid.
4. checkSameCommit(): Check if current file added is the same as commited. True for is the same as committed
5. addStage(): Add file to staging area. If added one is the same as commited, but in staged area, then remove it from 
   stagedAddition.
6. removeStage(): Remove file to staging area, if file is in the stage area then unstage it. If the file is tracked, 
   then staged for removal.
7. getStagedAddition(): Get staded for addition hashmap.
8. getStagedRemoval(): Get staded for removal hashmap.
9. clear(): Clear all the stage area.

### Repository

#### Fields

1. stagedAddition: A Map for staged file for addition.
2. stagedRemoval: A Set for staged file for removal. 
3. setUpPersistence(): Create dirs and files allow persistent data. 
4. initSystem(): Create a version control system.
5. addFile(): Add new created file or edited file to staging area.

### Add

#### Fields

1. stagedAddition: A HashMap for files staging for addition.

### Commit

#### Fields

1. String message: The commit message
2. String timestamp: The timestamp current COMMIT commit
3. String parent: The parent commit, in SHA-1
4. HashMap<String, String> fileNameToBlob: A set store the file being tracked.
5. Commit()：Initial commit, set message = "intial commit", timestamp = 00:00:00 UTC, Thursday, 1 January 1970
6. Commit(String message, String parent): new commit
7. getParent(): Get parent commit.
8. updateFile: Copy its parent tracking file and update it according to the staging area.

### Branch

#### Fields

1. readHead(): Read Head and get the current branch name.
2. writeHead(): Write current branch name into the HEAD.
3. updateBranch(String branchName, Commit commit): Update the existed branch with new commitPID.
4. newBranch(String branchName): Create a new branch file.
5. writeBranch(String commitPID, String branchName): Write commit sha-1 into the branch file.

### Blob

1. contents: saved file contents.
2. getContents(): return contents in specific Blob.
3. saveBlob(): save contents in a file named by sha-1 created by its content.

## Algorithms

## Persistence

- .gitlet: where store all the metadata.
  - commit: where commit files locate.
  - index: the staging area.
  - HEAD: store the current branch.
  - branches: branch area.