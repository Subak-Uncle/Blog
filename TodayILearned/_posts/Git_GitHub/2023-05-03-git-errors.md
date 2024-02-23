---

---



# git 에러 발생 일지



## "no tracking information for the current branch" 오류

두 개의 pc에서 작업을 진행하면서 겪은 일입니다. 집 pc에서 branch를 생성하여 작업하다가 밖을 나왔는데 제가 branch를 커밋하지 않고 나와 밖에서 같은 이름의 branch를 만들어 작업을 하다 보니 푸시와 풀 둘 다 안되는 현상이 나타났습니다.

위 오류의 내용은

"현재의 로컬 브랜치에 추적 정보가 없어 업스트림 브랜치와 연결이 필요하다" 입니다.

### 해결책

1. 로컬 브랜치를 삭제
   ~~~powershell
   $ git branch -D <삭제할 로컬브랜치명>
   ~~~

2. 업스트림 브랜치와 병합
   ~~~powershell
   $ git branch --set-upstream-to=origin/<원격 브랜치명> <로컬 브랜치명>
   $ git pull --rebase 
   ~~~

   