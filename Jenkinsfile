node {
  stage('SCM') {
    checkout scm
  }
  stage('SonarQube Analysis') {
    def mvn = tool 'mvn';
    withSonarQubeEnv() {
      sh "${mvn}/bin/mvn clean install sonar:sonar -Dserver.port=8090 -Dsonar.projectKey=id-gate_fido_management_ap_AYa1GJfxWHKZrROAl57P"
    }
  }

  stage('Build & Push Image') {
      docker.withRegistry(
          'https://123860609515.dkr.ecr.ap-east-1.amazonaws.com',
          'ecr:ap-east-1:managementAP') {
              def myImage = docker.build('managementap');
              myImage.push('latest');
          }
  }

  stage('Rollout') {
    withAWS(credentials: 'managementAP', region: 'ap-east-1') {
        sh 'aws eks update-kubeconfig --name idgate --region ap-east-1';
        sh "kubectl apply -f \"${env.WORKSPACE}/dummy-config.yml\"";
        sh "kubectl apply -f \"${env.WORKSPACE}/dummy2-config.yml\"";
        sh "kubectl apply -f \"${env.WORKSPACE}/deployment.yml\"";
        sh "kubectl apply -f \"${env.WORKSPACE}/service.yml\"";
        sh "kubectl rollout restart deployment/managementap";
    }
  }
}
