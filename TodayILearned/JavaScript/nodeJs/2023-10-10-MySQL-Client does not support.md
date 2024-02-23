## 문제 발생

NodeJs에서 MySQL을 연동할 때 발생하는 에러로,
~~~powershell
  code: 'ER_NOT_SUPPORTED_AUTH_MODE',
  errno: 1251,
  sqlMessage: 'Client does not support authentication protocol requested by server; consider upgrading MySQL client',
  sqlState: '08004',
  fatal: true
~~~

해당 문제는 mysql 패스워드 플러그인 "caching_sha2_password"을 소화하지 못해서 생기는 오류입니다.



## 해결 방법

다행히 해당 에러는 자주 발생하기도 하고 레퍼런스가 많아 금방 해결하였습니다.
root 계정으로 접근하여, Database 권한이 있는 계정의 mysql_native_password를 설정해주면 된다.

~~~javascript
alter user 'midnight'@'%' identified with mysql_native_password by 'midnight';
~~~

