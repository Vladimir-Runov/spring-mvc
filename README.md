		<dependency>
			<groupId>org.postgresql</groupId>
			<artifactId>postgresql</artifactId>
			<scope>runtime</scope>
		</dependency>
		<dependency>
			<groupId>com.h2database</groupId>
			<artifactId>h2</artifactId>
			<scope>runtime</scope>
		</dependency>

		<dependency>
			<groupId>org.springframework.security</groupId>
			<artifactId>spring-security-test</artifactId>
			<scope>test</scope>
		</dependency>
		<dependency>
			<groupId>org.springframework.boot</groupId>
			<artifactId>spring-boot-starter-security</artifactId>
		</dependency>

server:
  port: 8189
  servlet:
    context-path: /rrr
spring.datasource: 
  platform: postgres
  driverClassName: org.postgresql.Driver
  driver-class-name: org.postgresql.Driver
url:
  jdbc: postgresql://localhost:5432/postgres?currentSchema=prodmag
  username: postgres
  password: postgres
jpa:
 show-sql: true
 properties:
 hibernate: 
   current_session_context_class:thread

spring.jpa:
  database: POSTGRESQL
  hibernate.ddl-auto: create-drop
  show-sql: true

------

====================
server:
  port: 8189
  servlet:
    context-path: /rrr
spring.datasource: 
    driver-class-name: org.h2.Driver
    url: jdbc:h2:mem:mydatabase;MODE=PostgreSQL
    username: sa
    password: sa
jpa:
    show-sql: true
    properties:
      hibernate:
        dialect: org.hibernate.dialect.H2Dialect
h2:
    console:
      enabled: true
      settings:
        web-allow-others: false
        