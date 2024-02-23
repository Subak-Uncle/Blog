### spring security Filter 순서

![img](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/images/spring-security-filter/images%2Ftmdgh0221%2Fpost%2F55da7ebe-17e1-472f-ba31-7bce3156e7bb%2Fsecurity-filters.png)

하지만, 만약 OAuth 2.0 로그인을 사용한다면, `UsernamePasswordAuthenticationFilter` 대신 `OAuth2LoginAuthenticationFilter` 가 호출된다.