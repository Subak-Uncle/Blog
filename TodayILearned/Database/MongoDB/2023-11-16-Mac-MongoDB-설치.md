# Mac M1 MongoDB 설치 방법 ( brew )



*homebrew가 없다면 먼저 설치해야 한다.

## 1 MacOS 터미널에서 MongoDB Homebrew tap을 추가한다.

~~~ powershell
brew tap mongodb/brew
~~~

~~~
kimjong-wan@gimjong-wan-ui-MacBookAir ~ % brew tap mongodb/brew
Running `brew update --auto-update`...
==> Auto-updated Homebrew!
Updated 2 taps (homebrew/core and homebrew/cask).
==> New Formulae
asitop          bkcrack         geoip2fast      minder          ruler
biodiff         flyscrape       intercept       pdfalyzer       witness
==> New Casks
douyin-chat         hoppscotch          libndi              ok-json

You have 30 outdated formulae installed.

kimjong-wan@gimjong-wan-ui-MacBookAir ~ % 
~~~



![image-20231116203630409](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116203630409.png)

## 2.  brew 최신 버전으로 업데이트

 ~~~powershell
 brew update
 ~~~



## 3. brew로 MongoDB 설치

~~~powershell
brew install mongoDB-community@6.0
~~~



### 🍀 MongoDB CLI 작업 가능하게 만들기

~~~powershell
kimjong-wan@gimjong-wan-ui-MacBookAir ~ % mongo
zsh: command not found: mongo
~~~

=>

~~~
brew install mongodb-community-shell
~~~

![image-20231116204042048](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116204042048-0134846.png)

이제 간단하게 mongo 입력으로 실행 가능!

![image-20231116204217582](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116204217582.png)



## MongoDB Compress(GUI) 설치

[**https://www.mongodb.com/products/compass**](https://www.mongodb.com/products/compass)

해당 URL을 접근!

![image-20231116204445004](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116204445004.png)

초록색  다운로드 버튼을 꾹!
본인 사양에 맞게 찾아서 설치하심 됩니다!
<img src="/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116204523744.png" alt="image-20231116204523744" style="zoom:50%;" />

다운로드가 완료되면,

![image-20231116204705928](/Users/kimjong-wan/workspace/Subak-Uncle.github.io/_posts/Database/images/2023-11-16-Mac-MongoDB-설치/image-20231116204705928.png)

이런 화면이 나올텐데 `Connect` 버튼을 눌러서 다음 화면으로 이동되면 연결 성공!

## MongoDB 실행 / 정지 명령어

### 실행

~~~
brew services start mongodb-community
~~~



### 중지

~~~
brew services stop mongodb-community
~~~

