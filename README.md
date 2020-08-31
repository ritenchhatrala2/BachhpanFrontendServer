# BachhpanFrontendServer
Bachhpan Backend server

### Tools:
- Download below software for faster and easy development experience.
1. IDE: [Eclipse](https://www.eclipse.org/downloads/), [IntelliJ](https://www.jetbrains.com/idea/download/#section=mac). I use IntelliJ.
2. [Postman](https://www.postman.com/)
    - It is great tool for API development and very help in testing API.

### Project Setup:

1. GIT Repository setup:
    1. [How to import a GitHub project into Eclipse?](How to import a GitHub project into Eclipse)
    2. [Cloning a repository](https://docs.github.com/en/github/creating-cloning-and-archiving-repositories/cloning-a-repository)
2. Build Project locally:
    1. `cd ~/$ProjectRoot` For Example: cd ~/BachhpanWorkSpace/BachhpanFrontend. I cloned project from git in **~/BachhpanWorkSpace/BachhpanFrontend** directory on my MAC. You need to CD where your project is cloned.
    2. `./gradlew clean compileJava --stacktrace` . This will build the project and generate required artifacts.
        1. You may see error while building make sure your gradle version in project is *4.10*. Run below command to check gradle version and change it to 4.10 if required.
           - `./gradlew -v`
           - comment **compileJava.dependsOn(buildStudentStoreServerCode, buildUserAuthServerCode)** line in build.gradle file.
           - `./gradlew wrapper --gradle-version 4.10`
           - uncomment **compileJava.dependsOn(buildStudentStoreServerCode, buildUserAuthServerCode)** line in build.gradle file.
3. Run and Debug locally:
    1. `./gradlew bootRun` . This command will start the backend server.
    2. Alternatively, if you are using IDE your can directly run main() method in FrontendApplication.java file.
    3. Once server is started you can star sending request.
        1. `curl http://localhost:8080/public/users/login\?username\=admin\&password\=admin`
        1. You can use postman to send request to server and test your APIs.

### Reference:
1. [End to End Restful API development using OpenAPI Specification](https://medium.com/swlh/end-to-end-restful-api-development-using-openapi-specification-c73d45e98c8d)
2. [SECURING A REST API WITH SPRING SECURITY](https://octoperf.com/blog/2018/03/08/securing-rest-api-spring-security/)