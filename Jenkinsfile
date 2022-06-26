// pipeline {
//     agent {
//         docker { image 'openjdk:8' }
//     }
//     tools {
//     maven 'mvn'
//
//   }
//
//     stages {
//         stage('Build') {
//             steps {
//                 sh 'mvn clean package'
//             }
//         }
//     stage('Build Docker Image') {
//             steps {
//                 sh 'docker image build -t siret-retriever .'
//             }
//         }
//     stage('Run Docker Image') {
//             steps {
//                 sh 'docker container run --name siret -p 8080:8080 -d siret-retriever'
//             }
//         }
//     }
// }