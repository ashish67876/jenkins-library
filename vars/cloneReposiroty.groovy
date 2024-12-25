def call(Map config = [:]) {
    pipeline {
        agent any
        stages {
            stage('CheckOut source code') {
                steps {
                    checkout scm
                }
            }
        }
    }
}

