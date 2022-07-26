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
    }
}
