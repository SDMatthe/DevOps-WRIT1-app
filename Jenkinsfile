pipeline {
  agent any

  environment {
    DOCKERHUB = credentials('DockerHub')
    IMAGE_NAME = 'DevOps-WRIT1-app'
  }

  stages {
    stage('Build Java Application') {
      steps {
        sh '''
          cd CollegeCarPark
          mvn clean package
        '''
      }
    }

  stages {
    stage('Docker Login') {
      steps {
        sh 'echo "$DOCKERHUB_PSW" | docker login -u "$DOCKERHUB_USR" --password-stdin'
      }
    }

    stage('Pull , build and Run dockerfile ') {
      steps {
        sh '''
          docker stop DevOps-WRIT1-app || true
          docker rm DevOps-WRIT1-app || true
          docker rmi SDMatthe/DevOps-WRIT1-app || true
          docker build -t SDMatthe/DevOps-WRIT1-app .
          docker compose up -d
        '''
      }
    }

    stage('Run Tests') {
      steps {
        sh "cd CollegeCarPark && mvn test"
      }
    }

    stage('cleaning') {
      steps {
        sh 'docker compose down || true'
      }
    }
  }
}
