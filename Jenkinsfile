pipeline {
    agent any
    environment {
        API_ALLURE_RESULTS = 'api-test/target/allure-results'
        MAVEN_TOOL = 'M3'
    }

    tools {
        jdk 'JDK_21'
    }

    stages {
        stage('Checkout Code') {
            steps {
                git branch: 'main',
                    url: 'https://github.com/avoevodin81/test-framework-example.git'
            }
        }

        stage('Build') {
            steps {
                withMaven(maven: MAVEN_TOOL) {
                sh "mvn clean compile"}
            }
        }

        stage('Test') {
            steps {
                withMaven(maven: MAVEN_TOOL) {
                    sh "mvn verify -Dtest.logging=${LOGGING}"
                }
            }
        }

        stage('Allure Report') {
            steps {
                script {
                    allure([
                        allureCmd: 'Allure',
                        includeProperties: false,
                        reportBuildPolicy: 'ALWAYS',
                        results: [[path: API_ALLURE_RESULTS]]
                    ])
                }
            }
            when {
                expression { currentBuild.result != 'NOT_BUILT' }
            }
        }
    }
}