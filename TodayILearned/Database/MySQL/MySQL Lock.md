>>"해당 글은 `Real MySQL 8.0`의 내용을 토대로 작성되었음을 알려드립니다."
>
>MySQL의 구성은 다음과 같습니다.
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234649465.png)
>MySQL은 동시성 제어를 위해 각 엔진 별로 `MySQL 엔진 Lock` 과 `스토리지 엔진 Lock`으로 나누어 관리합니다.
>
># 실습 환경
>아래에서 시행될 실습은 다음과 같은 환경에서 이루어집니다.
>일전에 만들어두기만 했던 테스트용 `movie DataBase`를 이용하겠습니다. 그 외 실습용을 다운 받으시려면, [샘플 데이터](https://github.com/datacharmer/test_db)를 이용해주세요.
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234649230.png)
>
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234650057.png)
>
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234649257.png)
>
>
>
># 📋 MySQL 엔진 락(Lock)
>스토리지 엔진은 독립적으로 락을 관리하지만, MySQL 엔진 레벨 락은 모든 스토리지 엔진에 영향을 끼칩니다.
>
>## 📌 1. 글로벌 락(Global Lock)
>- 서버 전체의 범위를 잠금
>- 모든 DDL과 데이터를 조회하는 SELECT를 제외한 DML의 실행을 금지합니다.
>(다른 세션의 DDL과 SELECT문을 제외한 DML의 실행을 금지합니다.)
>- 글로벌 락의 영향 범위는 MySQL 서버 전체이며, 작업 대상 테이블이나 DB가 다르더라도 동일하게 영향을 미칩니다.
>- 모든 서버에 락을 실행하기 때문에 비효율적입니다.
>(실제로 MySQL에선 거의 사용하지 않습니다.)
>- MySQL 8.0부터 `Xtrabackup`, `Enterprise Backup` 같이 '백업 락'이라는, 좀 더 가벼운 개념의 락이 추가되었습니다. 
>  - 락 획득:`LOCK INSTANCE FOR BACKUP`, 락 해제 : `UNLOCK INSTANCE`
>
>- `FLUSH TABLES WITH READ LOCK` 명령을 통해 실행할 수 있습니다.
>- 해제는 `UNLOCK TABLES` 명령을 통해 해제할 수 있습니다.
>
>```sql
>mysql> insert into tbl_actor(actor_name, actor_gender, actor_age) values ('김종 완', '남', 26);
>Query OK, 1 row affected (0.01 sec)
>
>mysql> select * from tbl_actor;
>+----------+------------+--------------+-----------+
>| actor_no | actor_name | actor_gender | actor_age |
>+----------+------------+--------------+-----------+
>|        1 | 김종완     | 남           |        26 |
>+----------+------------+--------------+-----------+
>1 row in set (0.01 sec)
>
>mysql> FLUSH TABLES WITH READ LOCK;
>Query OK, 0 rows affected (0.01 sec)
>
>mysql> insert into tbl_actor(actor_name, actor_gender, actor_age) values ('김종 완', '남', 26);
>ERROR 1223 (HY000): Can't execute the query because you have a conflicting read lock
>mysql> select * from tbl_actor;
>+----------+------------+--------------+-----------+
>| actor_no | actor_name | actor_gender | actor_age |
>+----------+------------+--------------+-----------+
>|        1 | 김종완     | 남           |        26 |
>+----------+------------+--------------+-----------+
>1 row in set (0.00 sec)
>
>mysql> UNLOCK TABLES;
>Query OK, 0 rows affected (0.00 sec)
>```
>
>
>## 📌 2. 테이블 락(Table Lock)
>- 개별 테이블 단위로 설정되는 잠금이 가능합니다.
>- 스토리지 엔진에 따라 `명시적 Lock` 과 `묵시적 Lock`으로 나뉩니다.
>  - 명시적 Lock : InnoDB
>    - `LOCK TABLES table_name [ READ | WRITE ]` 명령으로 테이블 락을 획득할 수 있습니다.
>    - 해제는 `UNLOCK TABLES` 명령을 통해 해제할 수 있습니다.
>    - 자동 커밋이 유발되므로, 글로벌 락과 마찬가지로 실제로는 거의 사용하지 않습니다.
>    - InnoDB에서는 레코드 레벨의 테이블 락이 기본으로 설정되어 있어 `DDL`에 대해선 자동으로 락(Lock)이 걸려 있는 상태이고, `DML`에 대해선 별도의 테이블 락 처리가 필요합니다.
>  - 묵시적 Lock : MyISAM, Memory
>    - 테이블에 데이터를 변경하는 쿼리를 실행하면 자동으로 테이블 락이 설정되고, 완료 시에 자동으로 해제됩니다.
>
>### 🎈 LOCK TABLES ~ READ
>- 해당 세션은 messages 테이블을 읽을 수 있습니다 (SELECT 문을 사용할 수 있음).
>- 다른 세션들도 messages 테이블을 읽을 수 있습니다 (SELECT 문을 사용할 수 있음).
>- 그러나, 해당 세션을 포함한 어떤 세션도 messages 테이블에 데이터를 변경할 수 없습니다 (예: INSERT, UPDATE, DELETE 명령을 사용할 수 없음).
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234649262.gif)
>
>
>
>
>### 🎈 LOCK TABLES ~ WRITE
>- 해당 세션은 messages 테이블에 대해 데이터를 읽기, 변경(예: INSERT, UPDATE, DELETE)할 수 있습니다.
>- 다른 세션은 테이블에 대한 읽기 및 쓰기 작업이 불가능하게 되어 이 세션의 락이 해제될 때까지 기다려야 합니다
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234649546.gif)
>
>
>## 📌 3. 네임드 락(Named Lock)
>- 임의의 문자열에 대해 잠금이 가능합니다.
>  - 고유한 이름 혹은 문자로 설정을 하고, 그 이름으로 잠금을 획득하거나 해제합니다.
>  - 분산 락이라고도 불리며 특정 작업들이 서로 간섭하지 않도록 하는데 사용됩니다.
>- MySQL 서버의 메모리에 직접 접근하기 때문에 오버헤드가 적고 빠른 편 입니다.
>- 트랜잭션과는 별개로 동작되어 해제도 직접 실행해주어야 합니다.
>- 실제 사용 사례
>  - [우아한 기술 블로그 - 광고 시스템 활용을 위한 분산 락](https://techblog.woowahan.com/2631/)
>  - 여러 프로세스에서 동시적으로 요청해 MySQL 인스턴스에 접근할 때, 공유 리소스에 대한 액세스를 동기화해야 하는 경우에 사용할 수 있습니다.
>
>- 사용 문법
>  - `GET_LOCK('lock_name', timeout)`
>     - lock_name : 설정 고유 이름, timeout : 잠금 시간 설정(음수 설정 시 잠금을 획득할 때까지 무한대로 대기하게 됩니다.)
>     - 하나의 세션이 잠금을 유지하고 있으면 다른 세션은 동일한 잠금을 획득할 수 없습니다.
>     - 결과 값은 1(성공), 0(실패), null(에러 발생) 을 반환
>     - 5.7버전 이상부턴 동시에 여러 네임드 락 가능, 설정 고유 이름 길이 60자 제한
>  - `RELEASE LOCK('lock_name')`
>    - 해당 lock_name에 대한 네임드 락 해제
>    - 결과 값은 1(성공), 0(실패, 현재 스레드에서 미사용 잠금), null(해당 잠금 미존재)
>  - `RELEASE ALL LOCKS()`
>    - 현재 세션에서 유지 중인 모든 네임드 락 해제 후 해제 갯수 반환
>  - `IS_FREE_LOCK('lock_name')`
>    - 해당 lock name에 대해서 잠금 획득이 가능한 지 여부 반환
>    - 결과 값으로 1(해당 이름의 잠금이 없을 때), 0(해당 이름의 잠금이 존재), null(에러 발생)
>  - `IS_USED_LOCK('lock_name')`
>    - 해당 lock name에 대해서 잠금이 사용 중인 지 확인
>    - 사용 중이라면 connection Id를, 미사용 중이라면 null 반환
>  
>
>## 📌 4. 메타데이터 락(MetaData Lock)
>- 테이블, 뷰 등 DB 객체의 이름이나 구조를 변경할 때 사용하는 잠금입니다.
>- 명령어를 작성하여 설정하는 것이 아닌, 테이블이나 뷰의 이름 혹은 구조를 변경하는 경우에 자동으로 설정됩니다.
>
># 📋 스토리지 엔진 락(Lock)
>**MyISAM, MEMORY, ARCHIVE 등의** 스토리지 엔진은 자체적인 락을 가지지 않고 MySQL에서 제공해주는 테이블 락을 그대로 사용합니다. 트랜잭션이 없어 쿼리 단위로 필요한 락을 획득하기 때문에 데드락이 발생하지 않지만, 그만큼 동시성 처리를 할 수 없습니다. 해당 스토리지 엔진들은 테이블 락 중 묵시적 락에 속하며 쿼리문 실행 시 자동적으로 테이블 단위의 락이 적용됩니다.
>
>**InnoDB** 스토리지 엔진은 **인덱스의 레코드 기반 락**을 사용하여 기존의 스토리지 엔진 보다 동시성 처리가 뛰어납니다. 
>
>락에 대한 정보 조회는 MySQL 5.1버전부터 제공된 `INFORMATION_SCHEMA`의 `INNODB_TRX`, `INNODB_LOCKS`, `INNODB_LOCK_WAITS` 테이블에서 확인이 가능합니다. 현재 어떤 트랜잭션이 어떠한 락을 가지고 있는 지, 장시간 락을 가지고 있는 클라이언트를 종료시키는 것도 가능합니다.
>
>InnoDB의 락의 종류는 다음과 같습니다.
>
>## 📌 1. 공유 락 / 배타 락(Shared Lock / Exclusive Lock)
>- 비관적 락(Pessimistic Locking) 방식에서 사용됩니다.
>- 레코드 레벨의 락 입니다.
>
>### 🎈 공유 락(Shared Lock, Lock-S)
>- 레코드 레벨에서 `읽기(Select)`에 대한 락입니다. 쓰기 연산이 불가능합니다.
>  - `SELECT FOR SHARE` 를 사용하여 획득할 수 있습니다.
>  ```sql
>  SELECT * FROM table_name WHERE id = 1 FOR SHARE;
>  -- or
>  SELECT * FROM table_name WHERE id = 1 LOCK IN SHARE MODE;
>  ```
>- 한 Record에 대해 여러 트랜잭션이 동시에 S lock을 획득 가능하고, 배타 락은 획득할 수 없습니다.
>- 예를 들어, 트랜잭션 A가 1행(레코드)에 대하여 공유 락을 획득했다면, 트랜잭션 B는 1행을 읽을 순 있지만 수정은 불가능합니다. 이때 트랜잭션 B는 1행에 대해서 새로운 공유 락을 획득할 수 있습니다.
>- 공유 락이 적용 중인 행에 대해 트랜잭션 내에 데이터 변경이 일어나지 않도록 보장해줍니다.
>- 공유 락, 배타 락의 잠금 옵션은 Auto Commit 이 비활성화 되거나, BEGIN 혹은 START TRANSACTION 명령을 통해 트랜잭션이 시작된 상태에서만 잠금이 유지됩니다.
>
>### 🎈 배타 락(Exclusive Lock, Lock-X)
>- 레코드 레벨에서 `쓰기(Update, Delete)`에 대한 락입니다.
>  - `SELECT FOR UPDATE` 를 사용하여 획득할 수 있습니다.
>  ```sql
>  SELECT * FROM table_name WHERE id = 1 FOR UPDATE;
>  ```
>- 레코드에 대해 배타 락을 획득한 트랜잭션은, 독점적으로 읽기 연산과 쓰기 연산을 모두 실행할 수 있습니다. 
>- 배타 락이 걸려있다면 다른 트랜잭션은 공유 락, 배타 락 둘 다 획득 할 수 없습니다.
>
>## 📌 2. 의도 락(Intention Lock)
>- 테이블 레벨의 락 입니다. 하위 레벨의 선행 트랜잭션이 어떤 작업을 수행중인지 알림으로써, 트랜잭션이 대상 데이터에 잠금을 걸 수 있을지 없을지를 신속히 판단할 수 있게 도와주는 잠금입니다.
>  - 예를 들어, 
>  A가 특정 Record에 배타 락(x)을 걸고 B가 테이블 전체에 대한 수정을 하려고 합니다. 배타 락으로 인해 A가 종료될 때까지 B는 대기해야 합니다.
>  
>   B가 테이블에 락을 걸려고 할 때 여부를 파악해야 합니다. 테이블 전체 Record와 관련된 락을 찾아보는 것은 매우 비효율적입니다.
>  
>   따라서, 데이터베이스는 사용자 A가 로우에 베타 락(X)을 거는 시점에, 해당 로우의 상위 객체들(ex, 페이지, 테이블)에 대한 의도 락(IX)을 걸어, 다른 사용자가 더 큰 범위의 자원들에 대해 락을 걸 수 있는지 여부를 빠르게 파악할 수 있도록 돕습니다.
>  
>- InnoDB에선 테이블 레벨의 락 과 레코드 레벨의 락이 공존할 수 있게 해줍니다.
>>**Intention Shared Lock (IS)**- 트랜잭션이 테이블의 개별 레코드에 공유 락 설정
>>**Intention Exclusive Lock (IX)**- 트랜잭션이 테이블의 개별 레코드에 베타 락 설정
>
>- 아래는 Share lock, Exclusive lock, Intention lock이 각각 다른 트랜잭션에서 사용될때, 충돌(Conflict, 대기상태 빠짐), 또는 호환(Compatible, 대기상태에 빠지지 않음)이 되는지에 대해 정리된 표이다.
>
>|                       |    X     |    IX    |    S     |    IS    |
>| :-------------------- | :------: | :------: | :------: | :------: |
>| Exclusive (X)         | Conflict | Conflict | Conflict | Conflict |
>| Intent Exclusive (IX) | Conflict |    O     | Conflict |    O     |
>| Shared (S)            | Conflict | Conflict |    O     |    O     |
>| Intent Shared (IS)    | Conflict |    O     |    O     |    O     |
>
> 기본적으로 표를 보면 Intention Lock 끼리의 호환이 가능하고, 공유 락에 대해선 IS 만이 호환되는 것을 확인하실 수 있습니다.
>
>## 📌 3. 레코드 락(Record Lock) 
>- 이름은 레코드 락이지만, InnoDB에서는 레코드의 인덱스에 락을 적용시킵니다.
>  ```sql
>  # id = 1인 레코드에 대해 S-Lock
>  SELECT id FROM tb_1 WHERE id = 1 FOR SHARE; 
>  # id = 1인 레코드에 대해 X-Lock
>  SELECT id FROM tb_1 WHERE id = 1 FOR UPDATE;
> ```
>  - 다음 예시에서 인덱스 레코드 락에 대해서 알아보겠습니다.
>  ```sql
>  # 결과 값이 100개
>  SELECT COUNT(*) FROM tb_1 WHERE index_column > 3;
>  
>  # 결과 값이 1개
>  SELECT COUNT(*) FROM tb_1 WHERE index_column > 3 and normal_column = 1;
>  
>  # 레코드 락은 인덱스 컬럼 기준으므로 100개가 걸림.
>  UPDATE tb_1 SET some_column = 2 WHERE index_column > 3 and normal_column = 1;
> ```
>  이렇게 된다면 `WHERE index_column > 3` 이 포함된 쓰기 작업은 모두 대기가 걸리게 됩니다.
>  - 그러면 왜 InnoDB는 인덱스에 락을 적용시킬까요?
>    -  B+tree 인덱스 자료구조로 데이터를 저장하고 검색하는데, 이때 특정 데이터에 접근하기 위해 인덱스 레코드를 탐색해야 되기 때문에 필요합니다.
>    - 인덱스에 대해서만 락을 적용하기 때문에 다른 트랜잭션과 충돌이 최소화됩니다.
>    
>- 만약 테이블에 조건에 맞는 인덱스가 없다면, 테이블 레코드를 풀스캔하고 전체 레코드에 레코드 락을 적용합니다.
>
>## 📌 4. 갭 락(Gap Lock)
>
>- 레코드와 레코드 사이의 간격을 잠금합니다.
>-  첫 번째 레코드 앞(Negative Infinity) 과 마지막 레코드 뒤(Positive Infinity)에 가상의 레코드가 있다고 가정하고 생성하는 것도 가능합니다. 이러한 가상 레코드를 'Supremum' 가상 레코드라고 합니다.
>- Gap lock을 통해서 같은 SELECT 쿼리를 두번 실행했을 때 다른 트랜잭션에서 데이터가 수정되었더라도 같은 결과가 리턴되는 것을 보장할 수 있습니다. (Phantom read 방지)
>예) SELECT id FROM t WHERE id BETWEEN 10 and 20 FOR UPDATE
>위 쿼리를 실행하면 에서 c1=10~20 사이에 X락이 걸리기때문에 다른 트랜잭션에서 c1=15를 가지는 데이터를 INSERT하려면 대기 상태로 빠진다.
>
>- 격리 레벨을 "READ COMMITTED"를 사용하면 Phantom Read가 해결되기 때문에 Gap Lock은 사용되지 않습니다.
>
>- 컬럼에 대한 WHERE 절로 많은 row들을 제외시키고 하나의 레코드만 추출되었을때, Record lock과 Gap lock 어느것이 사용될까?
>  - 기본적으로 컬럼에 unique index가 걸려 있다면 record lock이 사용됩니다.
>  - 인덱스가 없는 컬럼이나 not unique 인덱스는 gap lock을 사용합니다.
>  
>
>## 📌 5. 넥스트 키 락(Next Key Lock)
>- 갭 락(Gap Lock) 과 레코르 락(Record Lock)이 합쳐진 락입니다.
>
>- ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234650466.png)
>
>- 넥스트 키 락의 경우 바이너리 로그가 기록되는 쿼리가 레플리카 서버에서 실행될 때, Source Server의 결과와 일치하도록 보장합니다. 로그 포맷의 경우 statement, row, mixed로 나누어지는데, 아래와 같은 특징을 가집니다.
>  - statement: 가장 오래된 포맷, 데이터 변경으로부터 사용되는 모든 쿼리를 저장
>  - row : 변경된 모든 레코드에 대한 정보 기록
>  - mixed: statement + row를 혼합하여 사용하는 방법 
>
> 기존에는 statement 포맷의 바이너리 로그를 사용하는 것이 보편적이었으나, 이 경우 repeatable-read 이상의 격리 수준을 사용해야 한다는 점과 (read-committed 사용 시 실행 시점마다 결과가 달라질 수 있어서) 쿼리의 실행마다 결과가 달라지는 경우 (사용자 정의 함수, 프로시저 사용 등) 해당 쿼리는 사용할 수 없었다는 단점이 있었습니다. 또한, 넥스트 키 락과 갭 락으로 인해 데드락이 발생할 수 있으니 바이너리 로그 포맷을 ROW 형태로 바꿔서 락 자체를 줄이는 것이 좋다. (MySQL 8.0부터는 ROW 포맷의 바이너리 로그가 기본이다.)
>
>> **바이너리 로그란?**
>> DDL 이나 DML 로 인한 이벤트를 기록하는 이진 파일을 말한다.
>> (1) Replica 와 Source Server 간의 데이터 Sync 를 맞추기 위해 사용
>> (2) 서버 장애 시 데이터를 복구하기 위해 사용
>
>## 📌 6. 삽입 의도 락(Insert Intention Lock)
>- INSERT 구문이 실행될 때 묵시적으로 설정되는 일종의 갭 락이다.
>- 여러 개의 트랜잭션이 갭 내부의 서로 다른 위치에 삽입을 진행하려고 할 때 대기 없이 실행되도록 하는 것이 목적입니다. 기본적으로 삽입 의도 락들끼리는 충돌이 발생하지 않기 때문입니다. 
>
>만약 id = 3, 7인 레코드가 있을 때 트랜잭션 A는 id = 5를, 트랜잭션 B는 id = 4을 삽입하는 상황을 가정해보겠습니다.
>![](/Users/kimjong-wan/workspace/Blog/TodayILearned/Database/images/MySQL Lock/image-20240225234650701.png)
>
>기본적인 갭 락을 걸었다면 트랜잭션 A가 5를 삽입하는 과정에서 이전 레코드인 3 ~ 5 사이에 갭 락이 걸릴 것이다. 이때, 트랜잭션 B가 id = 4을 삽입하려고 했을 때 이미 3~5 사이에 갭락이 걸려 있기 때문에 종료될 때까지 기다려야 해서 대기 시간이 존재합니다.
>
>반면에, 삽입 의도 락을 걸었다면 트랜잭션 A가 5를 삽입하는 과정에서 3 ~ 5 사이에 삽입 의도 락이 걸립니다. 이때, 트랜잭션 B가 id = 4를 삽입하려고 할 때 삽입 의도 락은 충돌이 가능하기 때문에 대기 시간 없이 바로 삽입이 가능해집니다. 삽입을 위한 X-Lock을 얻기 위해 삽입 의도 락을 통해서 묵시적으로 락을 걸어두게 됩니다.
>
>## 📌 7. 자동 증가 락(Auto-Increment Lock)
>- 자동 증가 락은 MySQL 에서 AUTO_INCREMENT 칼럼이 사용되는 테이블에서 자동 증가 값을 채번할 때 중복되지 않은 값을 채번하기 위해서 사용하는 락입니다.
>- 새로운 레코드를 저장하는 쿼리시에만 필요하며, 트랜잭션과는 무관하게 INSERT or REPLACE 문장에서 AUTO_INCREMENT 값을 가져오는 순간만 잠시 락이 걸렸다 즉시 해제됩니다.
>- 아주 짧은 시간 지속되기 때문에 거의 문제가 되지 않습니다.
># 📒 REFERENCES
>- [[MySQL 공식 문서 - MySQL Lock]](https://dev.mysql.com/doc/refman/8.0/en/innodb-locking.html)
>- [[MySQL 구성 사진, InnoDB 락]](https://cl8d.tistory.com/100)
>- [[MySQL 엔진 Lock, 데드락]](https://ksh-coding.tistory.com/124)
>- [[MySQL 네임드 락 - 우아한 기술 블로그]](https://techblog.woowahan.com/2631/)
>- [[MySQL 네임드 락 - 정의]](https://velog.io/@this-is-spear/MySQL-Named-Lock)
>- [[공유 락, 배타 락]](https://chanos.tistory.com/entry/MySQL-DB%EC%9D%98-%EB%8F%99%EC%8B%9C%EC%84%B1-%EC%A0%9C%EC%96%B4%EB%A5%BC-%EC%9C%84%ED%95%9C-Lock%EA%B3%BC-MVCC)
>- [[넥스트 키 락]](https://www.letmecompile.com/mysql-innodb-lock-deadlock/)
