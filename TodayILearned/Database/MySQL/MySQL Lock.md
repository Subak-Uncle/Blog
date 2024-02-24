>"해당 글은 `Real MySQL 8.0`의 내용을 토대로 작성되었음을 알려드립니다."

MySQL의 구성은 다음과 같습니다.
![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image-20240224234755617.png)
MySQL은 동시성 제어를 위해 각 엔진 별로 `MySQL 엔진 Lock` 과 `스토리지 엔진 Lock`으로 나누어 관리합니다.

# 실습 환경
아래에서 시행될 실습은 다음과 같은 환경에서 이루어집니다.
일전에 만들어두기만 했던 테스트용 `movie DataBase`를 이용하겠습니다. 그 외 실습용을 다운 받으시려면, [샘플 데이터](https://github.com/datacharmer/test_db)를 이용해주세요.
![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image-20240224234755605.png)

![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image.png)

![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image-20240224234755567.png)



# 📋 MySQL 엔진 락(Lock)
스토리지 엔진은 독립적으로 락을 관리하지만, MySQL 엔진 레벨 락은 모든 스토리지 엔진에 영향을 끼칩니다.

## 📌 1. 글로벌 락(Global Lock)
- 서버 전체의 범위를 잠금
- 모든 DDL과 데이터를 조회하는 SELECT를 제외한 DML의 실행을 금지합니다.
(다른 세션의 DDL과 SELECT문을 제외한 DML의 실행을 금지합니다.)
- 글로벌 락의 영향 범위는 MySQL 서버 전체이며, 작업 대상 테이블이나 DB가 다르더라도 동일하게 영향을 미칩니다.
- 모든 서버에 락을 실행하기 때문에 비효율적입니다.
(실제로 MySQL에선 거의 사용하지 않습니다.)
- `FLUSH TABLES WITH READ LOCK` 명령을 통해 실행할 수 있습니다.
- 해제는 `UNLOCK TABLES` 명령을 통해 해제할 수 있습니다.

```sql
mysql> insert into tbl_actor(actor_name, actor_gender, actor_age) values ('김종 완', '남', 26);
Query OK, 1 row affected (0.01 sec)

mysql> select * from tbl_actor;
+----------+------------+--------------+-----------+
| actor_no | actor_name | actor_gender | actor_age |
+----------+------------+--------------+-----------+
|        1 | 김종완     | 남           |        26 |
+----------+------------+--------------+-----------+
1 row in set (0.01 sec)

mysql> FLUSH TABLES WITH READ LOCK;
Query OK, 0 rows affected (0.01 sec)

mysql> insert into tbl_actor(actor_name, actor_gender, actor_age) values ('김종 완', '남', 26);
ERROR 1223 (HY000): Can't execute the query because you have a conflicting read lock
mysql> select * from tbl_actor;
+----------+------------+--------------+-----------+
| actor_no | actor_name | actor_gender | actor_age |
+----------+------------+--------------+-----------+
|        1 | 김종완     | 남           |        26 |
+----------+------------+--------------+-----------+
1 row in set (0.00 sec)

mysql> UNLOCK TABLES;
Query OK, 0 rows affected (0.00 sec)
```


## 📌 2. 테이블 락(Table Lock)
- 개별 테이블 단위로 설정되는 잠금이 가능합니다.
- 스토리지 엔진에 따라 `명시적 Lock` 과 `묵시적 Lock`으로 나뉩니다.
  - 명시적 Lock : InnoDB
    - `LOCK TABLES table_name [ READ | WRITE ]` 명령으로 테이블 락을 획득할 수 있습니다.
    - 해제는 `UNLOCK TABLES` 명령을 통해 해제할 수 있습니다.
    - 자동 커밋이 유발되므로, 글로벌 락과 마찬가지로 실제로는 거의 사용하지 않습니다.
    - InnoDB에서는 레코드 레벨의 테이블 락이 기본으로 설정되어 있어 `DDL`에 대해선 자동으로 락(Lock)이 걸려 있는 상태이고, `DML`에 대해선 별도의 테이블 락 처리가 필요합니다.
  - 묵시적 Lock : MyISAM, Memory
    - 테이블에 데이터를 변경하는 쿼리를 실행하면 자동으로 테이블 락이 설정되고, 완료 시에 자동으로 해제됩니다.

### 🎈 LOCK TABLES ~ READ
- 해당 세션은 messages 테이블을 읽을 수 있습니다 (SELECT 문을 사용할 수 있음).
- 다른 세션들도 messages 테이블을 읽을 수 있습니다 (SELECT 문을 사용할 수 있음).
- 그러나, 해당 세션을 포함한 어떤 세션도 messages 테이블에 데이터를 변경할 수 없습니다 (예: INSERT, UPDATE, DELETE 명령을 사용할 수 없음).
![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image.gif)




### 🎈 LOCK TABLES ~ WRITE
- 해당 세션은 messages 테이블에 대해 데이터를 읽기, 변경(예: INSERT, UPDATE, DELETE)할 수 있습니다.
- 다른 세션은 테이블에 대한 읽기 및 쓰기 작업이 불가능하게 되어 이 세션의 락이 해제될 때까지 기다려야 합니다
![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/MySQL Lock/image-20240224234755851.gif)


## 📌 3. 네임드 락(Named Lock)
- 임의의 문자열에 대해 잠금이 가능합니다.
  - 고유한 이름 혹은 문자로 설정을 하고, 그 이름으로 잠금을 획득하거나 해제합니다.
  - 분산 락이라고도 불리며 특정 작업들이 서로 간섭하지 않도록 하는데 사용됩니다.
- MySQL 서버의 메모리에 직접 접근하기 때문에 오버헤드가 적고 빠른 편 입니다.
- 트랜잭션과는 별개로 동작되어 해제도 직접 실행해주어야 합니다.
- 실제 사용 사례
  - [우아한 기술 블로그 - 광고 시스템 활용을 위한 분산 락](https://techblog.woowahan.com/2631/)
  - 여러 프로세스에서 동시적으로 요청해 MySQL 인스턴스에 접근할 때, 공유 리소스에 대한 액세스를 동기화해야 하는 경우에 사용할 수 있습니다.

- 사용 문법
  - `GET_LOCK('lock_name', timeout)`
     - lock_name : 설정 고유 이름, timeout : 잠금 시간 설정(음수 설정 시 잠금을 획득할 때까지 무한대로 대기하게 됩니다.)
     - 하나의 세션이 잠금을 유지하고 있으면 다른 세션은 동일한 잠금을 획득할 수 없습니다.
     - 결과 값은 1(성공), 0(실패), null(에러 발생) 을 반환
     - 5.7버전 이상부턴 동시에 여러 네임드 락 가능, 설정 고유 이름 길이 60자 제한
  - `RELEASE LOCK('lock_name')`
    - 해당 lock_name에 대한 네임드 락 해제
    - 결과 값은 1(성공), 0(실패, 현재 스레드에서 미사용 잠금), null(해당 잠금 미존재)
  - `RELEASE ALL LOCKS()`
    - 현재 세션에서 유지 중인 모든 네임드 락 해제 후 해제 갯수 반환
  - `IS_FREE_LOCK('lock_name')`
    - 해당 lock name에 대해서 잠금 획득이 가능한 지 여부 반환
    - 결과 값으로 1(해당 이름의 잠금이 없을 때), 0(해당 이름의 잠금이 존재), null(에러 발생)
  - `IS_USED_LOCK('lock_name')`
    - 해당 lock name에 대해서 잠금이 사용 중인 지 확인
    - 사용 중이라면 connection Id를, 미사용 중이라면 null 반환
  

## 📌 4. 메타데이터 락(MetaData Lock)
- 테이블, 뷰 등 DB 객체의 이름이나 구조를 변경할 때 사용하는 잠금입니다.
- 명령어를 작성하여 설정하는 것이 아닌, 테이블이나 뷰의 이름 혹은 구조를 변경하는 경우에 자동으로 설정됩니다.

# 📋 스토리지 엔진 락(Lock)

# 📒 REFERENCES
- [[MySQL 구성 사진]](https://cl8d.tistory.com/100)
- [[MySQL 엔진 Lock]](https://ksh-coding.tistory.com/124)
- [[MySQL 네임드 락 - 우아한 기술 블로그]](https://techblog.woowahan.com/2631/)
- [[MySQL 네임드 락 - 정의]](https://velog.io/@this-is-spear/MySQL-Named-Lock)