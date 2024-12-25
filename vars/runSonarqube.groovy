def call(Map config = [:]) {
    pipeline {
        agent any
        environment {
            SONAR_PROJECT_KEY = "${config.sonarProjectKey ?: 'default-key'}"
        }
        stages {
            stage('SonarQube Analysis') {
                steps {
                    script {
                        withSonarQubeEnv('SonarQube') { // Replace 'SonarQube' with your server name
                            sh """
                            mvn sonar:sonar \
                                -Dsonar.projectKey=${SONAR_PROJECT_KEY} \
                                -Dsonar.host.url=${env.SONAR_HOST_URL} \
                                -Dsonar.login=${env.SONAR_AUTH_TOKEN}
                            """
                        }
                    }
                }
            }
        }
    }
}

