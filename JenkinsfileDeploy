pipeline {
    agent any

    tools {
        maven '3.8.6'
    }

    stages {
        stage('Deploy') {
            steps {
                sh "mvn -Dmaven.test.skip=true tomcat7:redeploy"
            }
        }
    }
}