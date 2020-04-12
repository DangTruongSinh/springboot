This project will send mail using gmail smtp with spring boot. To use it, you must need javaMail. Add dependence to your 
pom project:
<dependency>
	<groupId>org.springframework.boot</groupId>
	<artifactId>spring-boot-starter-mail</artifactId>
</dependency>
To have send mail you have 2 deceive:
1. Register app password. Follow url below to register:
  https://support.google.com/accounts/answer/185833?p=InvalidSecondFactor
2. Using your password gmail