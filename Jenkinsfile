pipeline {
    agent any

    tools {
        maven '3.8.6'
    }

    stages {
        stage('Build') {
            steps {
                sh "mvn -Dmaven.test.failure.ignore=false clean package"
            }

            post {
                success {
                    junit '**/target/surefire-reports/TEST-*.xml'
                    archiveArtifacts 'target/*.war'
                }
            }
        }
        stage('Deploy') {
            steps {
                sh "mvn tomcat7:deploy"
            }
    }
}