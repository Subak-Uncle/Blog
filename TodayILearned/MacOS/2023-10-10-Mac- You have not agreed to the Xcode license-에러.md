#  You have not agreed to the Xcode license 에러 해결

IOS 업데이트 이후 깃이 사용이 되지 않아 brew install git을 사용하자

~~~
kimjong-wan@gimjong-wan-ui-MacBookAir ~ % brew install git 
Error: You have not agreed to the Xcode license. Please resolve this by running:
  sudo xcodebuild -license accept
~~~

이런 에러가 발생했다.

## 해결 방법

1. 터미널에서 `sudo xcodebuild -license`
2. 패스워드 입력
3. Enter 입력
4. 'agree' 타이핑. 하면 완료된다.