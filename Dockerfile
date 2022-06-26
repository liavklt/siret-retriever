From openjdk:8
RUN mkdir resources
COPY ./resources/input.txt /resources/input.txt
COPY ./target/siret-retriever.jar siret-retriever.jar
CMD ["java","-jar","siret-retriever.jar"]