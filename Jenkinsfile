pipeline {
    agent any;

    stages {
        stage("Build") {
            steps {
                echo 'Building...'
                bat """
                    mvn clean install -DskipTests=true
                """
            }
        }
        stage("Test") {
            steps {
                echo 'Testing...'
                bat """
                    mvn test -Dsurefire.useFile=false
                """
            }
        }
        stage("SonarQube") {
            steps {
                echo 'SQ scanning...'
                bat """
                    mvn org.sonarsource.scanner.maven:sonar-maven-plugin:3.9.1.2184:sonar -D sonar.login=admin -D sonar.password=sonar
                """
            }
        }
        stage("Docker build") {
            steps {
                 echo 'Docker is building...'
                 bat """
                     docker build -t lesson-06 .
                 """
            }
        }
        stage("Deploy") {
            steps {
                 echo 'Deploying...'
                 bat """
                    docker run --detach -p 18889:18889 lesson-06
                 """
            }
        }
    }
}
