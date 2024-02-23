~~~
spring:
  jpa:
    generate-ddl: true
    hibernate:
      ddl-auto: create
    database-platform: org.hibernate.dialect.MySQL57Dialect
    properties:
      hibernate:
        format_sql: 'true'
        show_sql: 'true'
      database: mysql
      defer-datasource-initailization: 'true'
      show-sql: 'true'
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    hikari:
      auto-commit: 'true'
    password: loveloveshot
    username: loveloveshot
    url: jdbc:mysql://localhost:3306/loveloveshot?allowPublicKeyRetrieval=true&useSSL=false&characterEncoding=UTF-8&useUnicode=true&serverTimezone=Asia/Seoul

  security:
    oauth2:
      client:
        registration:
          naver:
            client-id: P49b_mn4NxNzwGnizT3Z
            client-secret: eLT1QzLgKx
            redirect-uri: http://localhost:8080/login/oauth2/code/naver
            authorization-grant-type: authorization_code
            scope: nickname, email, gender, age, profile_image
            client-name: Naver
          kakao:
            client-id: 8b4b612558dd6e8b0fb4e34aef5d4bf6
            client-secret: spXJ2MYyMmEayVs1UKfvLDSOhIFCm`TTO
            redirect-uri: http://localhost:8080/login/oauth2/code/kakao
            authorization-grant-type: authorization_code
            scope: profile_nickname, profile_image, gender, age_range
            client-name: kakao
            client-authentication-method: POST
          google:
            client-id: 830336666072-9fj7rhs05bnln8rb7amdrsuq3bjav1j5.apps.googleusercontent.com
            client-secret: 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
            redirect-uri: http://localhost:8080/login/oauth2/code/google
            scope: profile, email
            client-name: google

        provider:
          naver:
            authorization-uri: https://nid.naver.com/oauth2.0/authorize
            token-uri: https://nid.naver.com/oauth2.0/token
            user-info-uri: https://openapi.naver.com/v1/nid/me
            user-name-attribute: response
          kakao:
            authorization-uri: https://kauth.kakao.com/oauth/authorize
            token-uri: https://kauth.kakao.com/oauth/token
            user-info-uri: https://kapi.kakao.com/v2/user/me
            user-name-attribute: id

cors:
  allowed-origins: 'http://localhost:3000'
  allowed-methods: GET,POST,PUT,DELETE
  allowed-headers: '*'
  max-age: 3600

jwt.secret: '8sknjlO3NPTBqo319DHLNqsQAfRJEdKsETOds'

app:
  auth:
    tokenSecret: 926D96C90030DD58429D2751AC1BDBBC
    tokenExpiry: 1800000
  oauth2:
    authorizedRedirectUris:
      - http://localhost:3000/oauth2/redirect
~~~





