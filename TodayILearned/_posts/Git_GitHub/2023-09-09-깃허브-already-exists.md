

## already exists **and** **is** **not** an empty directory 해결

### 1. 경로 이동

해당 디렉토리로 경로 이동한다.

~~~powershell
cd {해당 경로}
~~~



### 2. git 삭제 및 초기화

기존에 있던 git을 삭제하고 초기화한다.(초기화 시 새로운 git 파일이 생성됨)
~~~powershell
rm -rf .git
git init
~~~



### 3. remote 연결

~~~powershell
git remote add origin {깃허브 레포지토리 주소}
~~~



### 4. Repository clone

~~~powershell
git pull origin master(main) --allow-unrelated-histories
~~~

