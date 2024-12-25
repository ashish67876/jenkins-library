/**
 * Clones a Git repository.
 *
 * @param repoUrl The Git repository URL (required).
 * @param branch  The branch to clone (optional, defaults to 'main').
 */
def call(String repoUrl, String branch = 'main') {
    if (!repoUrl) {
        error "Repository URL is required to clone the repository."
    }

    echo "Cloning repository: ${repoUrl} on branch: ${branch}"

    checkout([
        $class: 'GitSCM',
        branches: [[name: "*/${branch}"]],
        userRemoteConfigs: [[url: repoUrl]]
    ])
}
