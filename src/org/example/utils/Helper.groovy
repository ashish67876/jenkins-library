def call(Map config = [:]) {
    pipeline {
        agent any
        environment {
            DOCKER_IMAGE = "${config.dockerImage ?: 'default-image'}"
        }
        stages {
            stage('Push Docker Image') {
                steps {
                    sh """
                    docker push ${DOCKER_IMAGE}:${env.BUILD_NUMBER}
                    """
                }
            }
        }
    }
}

