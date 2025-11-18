# Gitlet Design Document

**Name**:

## Classes and Data Structures

### Repository

1. setUpPersistence(): Create dirs and files allow persistent data.
2. initSystem(): Create a version control system. 

### Commit

#### Fields

1. String message: The commit message
2. String timestamp: The timestamp current COMMIT commit
3. String parent: The parent commit, in SHA-1
4. HashSet<String> file: A set store the file name being tracked.
5. HashSet<String> filePID: A set store the file tracked in SHA-1 
6. Commit()：Initial commit, set message = "intial commit", timestamp = 00:00:00 UTC, Thursday, 1 January 1970
7. Commit(String message, String parent):

### Branch

#### Fields

1. readHead(): Read Head and get the current branch name.
2. writeHead(): Write current branch name into the HEAD.
3. updateBranch(String branchName, Commit commit): Update the existed branch with new commitPID.
4. newBranch(String branchName): Create a new branch file.
5. writeBranch(String commitPID, String branchName): Write commit sha-1 into the branch file.


## Algorithms

## Persistence

- .gitlet: where store all the metadata.
  - commit: where commit files locate.
  - index: the staging area.
