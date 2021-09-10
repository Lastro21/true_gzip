pipeline {

    agent any
    tools {
        maven "my_maven"
    }
    stages {
        stage("Init") {
            steps {
                echo "Init step..."
            }
        }
        stage("Build") {
            steps {
                echo "Build step..."
                sh "mvn clean package"
            }
            post {
                success {
                    echo "Archiving..."
                    archiveArtifacts artifacts: "**/target/*.war"
                }
            }
        }
        stage("Deploy to noda") {

            steps {
                echo "Deploy step 1..."
                sh "cp **/*.war /Users/a17750897/Downloads"
                echo "Deploy step 2..."
                echo "Finish...."
            }
        }
    }
}