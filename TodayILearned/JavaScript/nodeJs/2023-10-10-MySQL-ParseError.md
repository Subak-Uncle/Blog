## 문제 발생

token을 프론트에서 받아 디코딩 후에 사용할 때 

### Decoder

~~~javascript
exports.decodeJWT = (bearerToken) => {
  const token = bearerToken.split("Bearer ");
  const claims = jwt.decode(token[1]);
  return claims;
};

exports.getMemberNoFromToken = (token) => {
  return new Promise((resolve) => {
    const jwtoken = this.decodeJWT(token);
    console.log("디코딩된 토큰", jwtoken);
    const memberNo = jwtoken.memberNo;
    console.log(memberNo);
    resolve(memberNo);
  });
};

exports.getExpirationFromToken = (token) => {
  return new Promise((resolve) => {
    const expiration = jwt.decode(token).exp;
    resolve(expiration);
  });
};

~~~

Promise로 반환을 하게 설정을 하였고, 반환 받은 값을 repository와 query 파일에서

### Repository

~~~javascript

exports.findPolicyConsent = (connection, memberNo) => {
  return new Promise((resolve, reject) => {
    console.log("findPolicyConsent 여긴 레포지토리");
    connection.query(
      PolicyQuery.findPolicyConsent(memberNo),
      [memberNo],
      (err, result) => {
        if (err) {
          reject(err);
        }
        console.log("foundPolicyConsent 여긴 레포지토리 결과 : ", result);
        resolve(result);
      }
    );
  });
};

~~~

### Query

~~~javascript
exports.findPolicyConsent = () => {
  return `
        SELECT policyConsent
          FROM TBL_MEMBER
         WHERE memberNo = ?
    `;
};
~~~



평소엔 잘 사용하였지만 어째서인지 parse error가 발생하였다.

~~~powershell
  code: 'ER_PARSE_ERROR',
  errno: 1064,
  sqlMessage: "You have an error in your SQL syntax; check the manual that corresponds to your MySQL server version for the right syntax to use near '' at line 3",
  sqlState: '42000',
  index: 0,
  sql: '\n' +
    '        SELECT policyConsent\n' +
    '          FROM TBL_MEMBERR\n' +
    '         WHERE member_no = \n' +
    '    '
~~~



## 문제 해결

문제 해결은 생각보다 간단했다.

decoder에서 Promise 값을 반환해주다 보니 오류가 나는 것이었다.

~~~javascript
const jwt = require("jsonwebtoken");

exports.decodeJWT = (bearerToken) => {
  const token = bearerToken.split("Bearer ");
  const claims = jwt.decode(token[1]);
  return claims;
};

exports.getMemberNoFromToken = (token) => {
  const jwtoken = this.decodeJWT(token);
  const memberNo = jwtoken.memberNo;
  return memberNo;
};

exports.getExpirationFromToken = (token) => {
  const expiration = jwt.decodeJWT(token).exp;
  return expiration;
};
~~~

decoder 부분을 Promise로 반환해주는 것이 아닌, 비동기처리가 되도록 설정을 하여 해결하였다.

