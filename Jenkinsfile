pipeline {
    agent any

    tools {
        jdk 'myjdk21'
        maven 'MyMaven3.9.12'
    }

    environment {
        IMAGE_NAME = "springboot-app"
        CONTAINER_NAME = "springboot-container"
    }

    stages {
		stage('Verify Tools') {
         steps {
          bat 'java -version'
          bat 'mvn -version'
             }
         }

        stage('Checkout Code') {
            steps {
               git branch: 'main', url: 'https://github.com/naqueeb-khan/testing.git'
            }
        }

        stage('Build Spring Boot Jar') {
            steps {
				dir('demo') {
                bat 'mvn clean package -DskipTests'
				}
            }
        }

        stage('Build Docker Image') {
            steps {
				dir('demo') {
                bat 'docker build -t %IMAGE_NAME% .'
				}
            }
        }

        stage('Stop Old Container') {
            steps {
                bat 'docker stop %CONTAINER_NAME% || exit 0'
                bat 'docker rm %CONTAINER_NAME% || exit 0'
            }
        }

        stage('Run Docker Container') {
            steps {
                bat 'docker run -d -p 8186:8186 --name %CONTAINER_NAME% %IMAGE_NAME%'
            }
        }

    }
}