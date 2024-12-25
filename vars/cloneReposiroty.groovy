def call(Map config) {
    if (!config.repoUrl) {
        error "repoUrl is required"
    }
    echo "Cloning repository from ${config.repoUrl}"
    checkout([$class: 'GitSCM', branches: [[name: '*/main']],
              userRemoteConfigs: [[url: config.repoUrl]]])
}
