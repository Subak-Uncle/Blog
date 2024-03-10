> "📣 본 내용은 **[김영한 저자 - 자바 ORM 표준 JPA]** 책 내용을 기반으로 정리하였음을 알려드립니다."

# 1. 🐳 JPA(Java Persistance API) 개요

![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image.png)


- 자바 진영의 <span style="background-color:#fff5b1">**ORM(Object Relational Mapping) 기술 표준**으로, ORM 기술을 사용하기 위한 **표준 인터페이스의 모음(API 표준 명세)**</span>입니다.
  - 인터페이스 종류(JPA 2.1 기준)
  ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325792.png)

- ORM 프레임워크를 이용하여 **패러다임 불일치** 문제를 개발자 대신 해결해줍니다.

  > **ORM(Object Relational Mapping)**
  >
  > <span style="background-color:#fff5b1">'객체관계 매핑'</span>입니다.
  >
  > 자바 플랫폼 SE와 EE를 사용하는 응용프로그램에서 <span style="background-color:#fff5b1">**객체는 객체 지향적으로 설계하고, 관계형 데이터베이스는 관계형 데이터베이스의 패러다임대로 설계**</span>할 수 있도록 중간에서 매핑을 해주는 기술을 말합니다. 즉, 패러다임 불일치 문제를 해결해줍니다.
  >
> *대중적인 언어에는 대부분 ORM이 존재합니다.
  
  - **🐬 저장 과정**
  persist() 메소드로 저장.
![](https://velog.velcdn.com/images/kko0369/post/989bb0fb-6e60-413f-bfe7-527992154009/image.png)

  - **🐬 조회 과정**
  find() 메소드로 조회 가능.
![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325303.png)

## 1-1. 🌊 JPA 역사
- 1997년 IBM에서 개발되었고, 1999년에 Sun Microsystems로 인수된 <span style="background-color:#fff5b1">**EJB(Enterprise JavaBeans)라는 자바 표준이 있었는데 지저분한 코드와 느리고 제대로 동작하지도 않는 결함이 많은 기술**</span>이었습니다.
  >**EJB** 
  >비지니스로직과 시스템 서비스를 이용하는 로직을 분산하고 그 사이의 규약을 정의한 것으로 비지니스 로직을 탑제한 부분을 <span style="background-color:#fff5b1">**'Enterprise Bean'**</span>이라고 부르며 Database 및 Transaction 처리와 같은 시스템 서비스 로직을 탑제한 부분을 'Container'라고 부릅니다.
  
- **Gavin King**이 EJB 컨테이너에 의존하지 않는 ORM 프레임워크인 **Hibernate**를 만들게 되고 오픈소스화가 되어 EJB는 사라지게 되었습니다.

- 이후 **Java와 GavinKing**이 같이 Java표준을 만들게 되었고 2006년에 JPA 1.0이라는 JPA의 초기버전이 나온 이후 현재까지 JPA는 2.1버전까지 사용되고 있습니다.

  `JPA 1.0은 2006년 5월 11일, 자바커뮤니티 프로세스 JSR220에서 최종 배포`
  `JPA 2.0은 2009년 12월 10일에 배포`
  `JPA 2.1은 2013년 4월 22일에 배포`

  출처 : [위키백과](https://ko.wikipedia.org/wiki/%EC%9E%90%EB%B0%94_%ED%8D%BC%EC%8B%9C%EC%8A%A4%ED%84%B4%EC%8A%A4_API)

## 1-2. 🌊 왜 JPA를 사용해야 할까?

- ### 1) 📌 생산성
  자바 컬렉션을 이용하면 데이터베이스와의 패러다임 불일치 문제가 발생하지 않아 저장이 쉽습니다. 
  
  하지만 영구적인 데이터 저장이 안되고, 연관된 데이터의 수정 시 객체를 모두 찾아 수정해야 되는 등 불편함이 존재합니다.

  JPA를 활용하면 자바 컬렉션에 객체를 저장하듯이 JPA에게 객체를 전달하면 알아서 데이터베이스에 SQL을 보내줍니다.
  ```java
  entityManager.persist(member) // 저장
  entityManager.find(Member.class, memberId) // 조회
  ```
  이처럼 간단한 코드로 반복적인 SQL 작성을 직접 하지 않아도 됩니다. 즉, <span style="background-color:#fff5b1">데이터베이스 설계 중심의 패러다임을 객체 설계 중심으로 역전</span>시켜줍니다.
  
  또한, native SQL를 지원해주어 SQL 직접 작성도 가능합니다.
  
- ### 2) 📌 유지보수
  <span style="background-color:#fff5b1">SQL 의존적인 개발을 진행할 시, 엔티티에 필드 하나를 추가할 시에도 작성해둔 SQL(JDBC API 코드) 모두를 수정해야 하는 번거로움이 존재했습니다.</span> 하지만 JPA를 사용한다면, 대신 SQL을 생성해주기 때문에 유지보수 면에서 유리합니다.
  
- ### 3) 📌 패러다임의 불일치 해결
  해당 내용은 `1-2. 🐳 패러다임 불일치`에서 자세히 다루겠습니다.
   JPA는 `상속`, `연관 관계`, `객체 그래프 탐색`, `동등성/동일성 비교` 와 같은 패러다임 불일치를 해결해줍니다.

- ### 4) 📌 성능
  JPA는 애플리케이션과 데이터베이스 사이에서 다양한 성능 최적화 기능을 제공합니다.
  다음 코드를 살펴보고 SQL MAPPER와 JPA의 경우를 나눠서 생각해보겠습니다.
  ```java
  line 1 :  String memberId = "SubakUncle";
  line 2 : Member member1 = entityManager.find(Member.class, memberId);
  line 3 : Member member2 = entityManager.find(Member.class, memberId);
  ```
  - SQL MAPPER
  `line 2`와 `line 3` <span style="background-color:#fff5b1">각각 SQL을 사용해서 데이터베이스와 두 번의 통신을 사용했을 겁니다.</span>
  두 개의 객체는 다른 주소를 가진 별개의 객체입니다.
  
  - JPA
  `line 2`에서는 처음 SQL을 사용해서 데이터베이스와 통신을 합니다.
  `line 3`에서는 캐싱을 활용해 조회해 온 객체를 재사용합니다. 즉, <span style="background-color:#fff5b1">데이터베이스와 한 번의 통신을 사용했습니다.</span>
  
- ### 5) 📌 데이터 접근 추상화와 벤더 독립성
  말이 어렵습니다만, 애플리케이션과 데이터베이스 사이에 추상화된 데이터 접근 계층을 제공해서 여러 종류의 데이터베이스와 연결이 가능합니다.
  ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325414.png)

  <span style="background-color:#fff5b1">Paging의 경우, 각각의 데이터베이스마다 달라서 사용법을 각각 배워야 겠지만, JPA를 활용한다면 데이터베이스 기술에 종속되지 않고 사용이 가능합니다.</span>
  
- ### 6) 📌 표준
  JPA는 ORM 기술 표준입니다. 즉, <span style="background-color:#fff5b1">다른 구현 기술로 손쉽게 변경이 가능합니다.</span>
  JPA의 근간은 Hibernate이고, 거의 복사한 수준이라 다른 ORM으로 변경이 쉽다는 얘기인 것 같습니다.

# 1-2. 🐳 패러다임 불일치
저희는 개발 시 객체지향언어(Java, Scala, Kotlin, C# 등등)를 선호해서 사용합니다. 

객체지향언어 내에선 객체 중심으로 데이터와 메소드를 묶어 관리하는 반면, RDB(Relational DataBase)에선 테이블 간의 관계를 형성해 데이터를 관리합니다. 이 <span style="background-color:#fff5b1">두 프로그램 내 패러다임의 차이점에서 비롯된 문제들을 **패러다임 불일치**</span>라고 합니다.

### 1-2-1. 📌 발생하는 문제와 JPA를 통한 해결 방법
<!-- 객체지향 프로그래밍은 `추상화`, `캡슐화`, `정보 은닉`, `상속`, `다형성` 등의 특징을 보유하고 있어 시스템의 복잡성을 제어할 수 있게 도와줍니다. -->

- #### 1) 🎈 상속
  ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325951.png) **a. Album 객체의 데이터를 DataBase에 저장하기 위해선**

  1. 객체 분해
  2. SQL 작성 및 호출
  ```sql
  INSERT INTO ITEM (ITEM_ID, NAME, PRICE, DTYPE) VALUES     (?, ?, ?, ?);
  INSERT INTO ALBUM (ITEM_ID, ARIST) VALUES (?, ?);
  ```
  의 과정을 거쳐야 합니다.

  **b. 조회 시,**

  1. JOIN 사용
  ```sql
  SELECT * FROM ITEM I JOIN ALBUM A ON I.ITEM_ID =   A.ITEM.ID;
  ```
  2. 객체 생성 후 데이터 삽입

  등의 복잡한 과정을 계속해서 거쳐야 합니다.

- #### 1-1) 🤪 JPA 상속 해결
  자바 컬렉션에 객체를 저장하듯이 JPA에게 객체를 저장합니다.
  **a. 저장 시 , entityManager.persist(album)**

  ```sql
  	-- JPA에서 SQL문 작성 후 실행.
  	-- ITEM, ALBUM 테이블에 나눠서 저장
  	INSERT INTO ITEM ...
   	INSERT INTO ALBUM ...
  ```
  
  **b. 조회 시, entityManager.find(Album.class, albumId)**
  ```java
  String albumId = "id100";
  entityManager.find(Album.class, albumId);
  ```
  ```sql
    -- JPA는 ITEM과 ALBUM 두 테이블을 조인해서 필요한 데이터를 조회합니다.
    SELECT I.*, A.*
      FROM ITEM I
     WHERE ALBUM A ON I.ITEM_ID = A.ITEM_ID;
  ```
  
- #### 2) 🎈 연관 관계
  
  **객체** -> 객체 참조를 통해 연관 관계 객체 조회, 단 방향
  ```java
  class Member {
  
    private String id:  
    private TEAM team;  
    private String username;
  
  	...setter/getter
  }
  
  class Team {
  
  	private Long id;
    private String name;
    
    ...setter/getter
  }
  
  // 조회한 Member 객체
  member.getTeam(); // member -> team 객체 접근
  
  // Team 객체에선 Member 객체를 필드에 두지 않아 접근 못함.
  team.getMember(); // syntax error
  ```
  

  **테이블** -> 외래키를 통해 연관 관계 조인 테이블 조회, 양 방향
  ```sql
   SELECT M.*, T.*
      FROM MEMBER M
     WHERE TEAM T ON M.TEAM_ID = T.TEAM_ID;
     
   -- or
   
   SELECT M.*, T.*
      FROM TEAM T
     WHERE MEMBER M ON T.TEAM_ID = M.TEAM_ID;
  ```
- **2-1) 🎈 연관 관계 - 객체를 테이블에 맞추어 모델링**
  ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325775.png)  테이블 컬럼에 초점을 두어 객체 설계 시, 저장과 조회에서는 편리합니다.

  하지만, 연관된 객체 참조 시에 문제가 됩니다. 
  <span style="background-color:#fff5b1">JPA를 통해서 조회해온 Member 객체에서 Team 객체에 접근이 불가능하여, teamId를 통해 다시 한번 데이터베이스에 접근해 관련된 Team 객체 데이터를 구해야 합니다.</span>
  ```java
  class Member {
  
    private String id:  // MEMBER_ID 컬럼 사용
    private Long teamId;  // TEAM_ID FK 컬럼 사용
    private String username;	// USERNAME 컬럼 사용
  
  	...setter/getter
  }
  
  class Team {
  
  	private Long id;	// TEAM_ID PK 사용
    private String name;	// NAME 칼럼 사용
    
    ...setter/getter
  }
  
  //  JPA를 통해 Member 객체 조회 후
  Team team = member.getTeam(); // -> syntax error
  Long teamId = member.getTeamId();
  Team team = entityManager.find(Team.class, teamId);
  ```
  이 설계는 <span style="background-color:#fff5b1">좋은 객체 모델링은 기대하기 어렵고 결국 객체지향의 특징을 잃어버리게 됩니다.</span>
- **2-2) 🤪 JPA 연관 관계**
```java
  class Member {
  
    private String id:  
    private TEAM team;  
    private String username;
  
  	...setter/getter
  }
  
  class Team {
  
  	private Long id;
    private String name;
    
    ...setter/getter
  }
  
  // Member 객체 저장 시
  member.setTeam(team);  // Team 객체를 구해와야 함. 연관 관계 설정
  entityManager.persist(member); // 회원과 연관관계 함께 저장
  
  // 조회 시
  Member member = entityManager(Member.class, memberId);
  Team team = member.getTeam();
```

- **3) 🎈 객체 그래프 탐색**
  ![](/Users/kimjong-wan/workspace/Blog/TodayILearned/images/자바 ORM 표준 API - 01장. JPA 개요/image-20240310204325221.png)JPA 사용 시,  자유로운 객체 탐색이 가능합니다.
  ```java
  member.getOrder().getOrderItem()... // 건너 건너 객체까지 접근 가능함.
  ```

  SQL로 조회 시, 해당 연관 관계 만큼 JOIN이 필요합니다. TEAM 테이블과 MEMBER 테이블 조인 조회 시엔 `member.getOrder()`가 null 값입니다..ㅠㅠ

  따라서, Repository나 DAO에서 메소드를 상황에 따라 여러 벌 만들어서 사용해야 합니다.
  ```java
  	memberRepository.getMember(); // Member만 조회
   	memberRepository.getMemberWithTeam(); // Member와 Team 조회
  	memberRepository.getMemberWithOrderWithDelivery(); // Member와 Order와 Delivery 조회
  ```
- **3-1) 🤪 JPA의 객체 그래프 탐색**
  앞에서 언급했듯이, JPA를 이용하면 객체 연관 관계 간 자유로운 탐색이 가능합니다.
  ```java
  member.getOrder().getOrderItem()...
  ```
  <span style="background-color:#fff5b1">JPA는 연관 관계를 사용하는 시점에 `SELECT SQL`을 실행합니다. 실제 객체를 사용하는 시점까지 데이터베이스 조회를 미룬다고 해서 지연 로딩이라고 합니다.</span> '김영한 저자'님 께서는 연관 관계 설정할 때 모두 `지연로딩` 설정을 해두고 필요 시 `즉시 로딩` 설정을 하길 권장해주셨습니다.
  
  Member와 Order 객체를 조회한다고 가정하겠습니다.
  ```java
  	// 처음 조회 시점에 SELECT MEMBER SQL
  	Member member = entityManager.find(Member.class, memberId);
   
  	Order order = member.getOrder();
  	order.getOrderDate(); // Order를 사용하는 시점에 SELECT ORDER SQL
  ```
  Member를 사용할 때마다 Order를 함께 사용한다면, Member를 조회하는 시점에 SQL JOIN을 사용해서 함께 조회하는 것이 효과적입니다. 
  
- **4. 데이터 타입**
  Java 데이터 타입 > DataBase 데이터 타입
- **5) 🎈 데이터 식별 방법**
  데이터베이스는 기본 키의 값으로 row를 구분합니다.
  반면에, 객체는 동일성(identity)와 동등성(equality) 비교를 통해 구분합니다.
  
  - 동일성 비교 : == 비교. 객체 인스턴스의 주소 값 비교
  - 동등성 비교 : equals() 메소드를 사용해서 객체 내부의 값을 비교
  
  실제 SQL MAPPER에서의 데이터 비교와 JPA에서의 데이터 비교를 해보겠습니다.
  
  <span style="background-color:#fff5b1">** SQL MAPPER**</span>
  ```java
    	String memberId = "100"; 
  	Member member1 = memberDAO.getMember (memberId); 
  	Member member2 = memberDAO.getMember (memberId);
    
    	member1 == member2; // 다르다.
  ```

  <span style="background-color:#fff5b1">**JPA**</span>
  ```java
   String memberId = "100"; 
    Member member1 = entityManager.find (Member.class, memberId); // SQL 실행
    Member member2 = entityManager.find (Member.class, memberId); // 캐시
    
    member1 == member2; // 같다.
  ```
# 1-3. 🐳 SQL Mapper의 문제점

- <span style="background-color:#fff5b1">반복 잡업</span>
  - 테이블이 100개라면, 100개의 CRUD SQL 문과 객체로 결과 값을 변환해주는 작업 코드가 필요합니다.
  
- <span style="background-color:#fff5b1">SQL 의존적인 개발진행</span>

  - 테이블 칼럼, 객체 필드 추가 시 많은 수정 발생
  ```java
  class Member {
  	private String memberId;
    private String name;
    private String tel; // 추가
  }
  ```
   <span style="background-color:#fff5b1">이렇게 되면 SQL 문의 `tel 컬럼`을 모두 추가해주어야 하는 큰 작업을 해야 합니다.</span>

  - 객체 참조 추가 시는 SQL문에 Table JOIN SQL문으로 변경해주어야 합니다.

  - JPA 사용 시 객체를 조회해오고 객체를 수정하면 update 됩니다.
- 진정한 의미의 계층 분할이 어렵습니다.
  - <span style="background-color:#fff5b1">데이터 접근 계층을 두어서 SQL을 은닉해두어도 어쩔 수 없이 DAO나 Repository를 열어서 어떤 SQL이 실행되는지 확인해야 합니다.</span> -> 결국 엔티티를 신뢰하고 사용할 수 없게 됩니다.