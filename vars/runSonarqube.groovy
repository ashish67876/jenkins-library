def call(Map args) {
    def projectKey = args.projectKey ?: error("Missing projectKey")
    def branchName = args.branchName ?: error("Missing branchName")
    stage("SonarQube Analysis") {
        withSonarQubeEnv('SonarQube') { // Replace with your SonarQube server name
            sh """
                sonar-scanner \
                -Dsonar.projectKey=${projectKey} \
                -Dsonar.branch.name=${branchName} \
                -Dsonar.sources=. \
                -Dsonar.host.url=${env.SONAR_HOST_URL} \
                -Dsonar.login=${env.SONAR_AUTH_TOKEN}
            """
        }
    }
}
