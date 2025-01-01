pipeline {
    agent any

    tools {
        maven 'sonar-maven' 
    }

    environment {
        SONAR_SCANNER_PATH = "C:\\Users\\Pooja\\Downloads\\sonar-scanner-cli-6.2.1.4610-windows-x64\\sonar-scanner-6.2.1.4610-windows-x64\\bin"
    }

    stages {
        stage('Checkout Code') {
            steps {
                checkout scm
            }
        }
      
        stage('Build and Test') {
            steps {
                script {
                    bat '''
                    mvn clean install
                    '''
                }
            }
        }

        stage('SonarQube Analysis') {
            environment {
                SONAR_TOKEN = credentials('sonar-token')
            }
            steps {
                bat '''
                mvn clean verify sonar:sonar \
                -Dsonar.projectKey=Maven_AutomationTesting \
                -Dsonar.sources=src/main/java \
                -Dsonar.tests=src/test/java \
                -Dsonar.jacoco.reportPaths=target/jacoco.exec \
                -Dsonar.inclusions=**/*.java \
                -Dsonar.host.url=http://localhost:9000 \
                -Dsonar.login=%SONAR_TOKEN%
                '''
            }
        }
    }

    post {
        success {
            echo 'Pipeline completed successfully!'
        }
        failure {
            echo 'Pipeline failed. Check the logs for errors.'
        }
        always {
            echo 'This runs regardless of the result.'
        }
    }
}
