From openjdk:13
copy ./target/employeeSevice-0.0.1-SNAPSHOT.jar employeeSevice-0.0.1-SNAPSHOT.jar
CMD ["java","-jar","employeeSevice-0.0.1-SNAPSHOT.jar"]