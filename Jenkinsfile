pipeline {
    agent any
    
    environment {
        DOCKER_CREDENTIALS_ID = 'yousif050' // ID of Jenkins credentials
        DOCKER_IMAGE = 'yousif050/maven-webapp'
    }
    
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/yousif050/Yousif-lab3.git'
            }
        }
        
        stage('Build Maven Project') {
            steps {
                sh 'mvn clean package -DskipTests'
            }
        }
        
        stage('Docker Login') {
            steps {
                withCredentials([usernamePassword(credentialsId: "${DOCKER_CREDENTIALS_ID}", passwordVariable: 'DOCKER_PASSWORD', usernameVariable: 'DOCKER_USERNAME')]) {
                    sh 'echo "$DOCKER_PASSWORD" | docker login -u "$DOCKER_USERNAME" --password-stdin'
                }
            }
        }
        
        stage('Docker Build') {
            steps {
                sh 'docker build -t $DOCKER_IMAGE .'
            }
        }
        
        stage('Docker Push') {
            steps {
                sh 'docker push $DOCKER_IMAGE'
            }
        }
        
        stage('Clean Up') {
            steps {
                sh 'docker rmi $DOCKER_IMAGE'
            }
        }
    }
}
