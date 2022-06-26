# Siret Retriever

This project is for retrieving company information, in France, based on the unique SIRET numbers, used as identifiers. 

### We used
- Spring (Boot)
- Maven
- Junit
- OpenCsv
- Docker

### Structure
This project is structured as a Maven project. It takes as input a txt file that has some sample siret numbers. The http client (Spring RestTemplate) is used to query the external API to get the company information. Then, a local data storage system is used (csv) to store the fields that are of interest. This microservice can also be built as a Docker image. 

As a data model, there is the main Company class, which includes an Etablissement, which in its turn along with other fields, includes a UniteLegale.


### Local Build
Since it is a maven project, in order to build the microservice, run the unit tests and pack the jar spring boot application, we can do
> mvn clean package

To start the spring boot application,
> mvn spring-boot:run

Then on the browser, we can do 
> localhost:8080/retrieve

Which in its turn will produce a csv file, by using OpenCsv library, on the root of the project called "Companies.csv". 

### Docker
On the root of our project, we can run 
> mvn clean package

To build the docker image containing a version of our microservice
> docker image build -t siret-retriever .

And then to run it, 
> docker container run --name *container-name* -p 8080:8080 -d siret-retriever

Finally, to have the Companies.csv available outside of the Docker file system, we can do
> docker cp *container-name*:/Companies.csv *location_to_be_saved_in_local_filesystem*


### Things to improve
Of course, this could have a Jenkinsfile. For the moment it is commented.


