---
layout: single
title: "[MySQL] Join의 정의"

categories: MySQL
tags: [MySQL, Join]

toc: true # Table of Contents : 목차 사용 여부
toc_sticky: true

author_profile: false
date: 2023-07-03
last_modified_at: 2023-07-03
sidebar:
  nav: "docs"


---

# 1. Join

> 🎈 💡 JOIN은 두 개 이상의 테이블을 관련있는 컬럼을 통해 결합하는데 사용된다.
>
> 두 개 이상의 테이블은 반드시 연관있는 컬럼이 존재해야 하며 이를 통해 JOIN된 테이블들의 컬럼을 모두 활용할 수 있다.



## 1-1. ALIAS

- SQL문의 컬럼 또는 테이블에 별칭을 달아줄 수 있다. 이러한 별칭을 ALIAS라고 한다.

- 컬럼 별칭
  - resultSet의 컬럼명이 별칭으로 바뀜
  - 별칭에 띄어쓰기나 특수기호가 없다면 홑따옴표(')와 AS는 생략 가능하다.

~~~mysql
SELECT 
    menu_code AS 'code',
    menu_name AS name,
    menu_price 'price'
FROM
    tbl_menu
ORDER BY price;
~~~

| 12   | 날치알스크류바       | 2000  |
| ---- | -------------------- | ----- |
| 1    | 열무김치라떼         | 4500  |
| 2    | 우럭스무디           | 5000  |
| 21   | 돌미나리백설기       | 5000  |
| 3    | 생갈치쉐이크         | 6000  |
| 17   | 아이스가리비관자육수 | 6000  |
| 4    | 갈릭미역파르페       | 7000  |
| 10   | 코다리마늘빵         | 7000  |
| 13   | 직화구이젤라또       | 8000  |
| 9    | 홍어마카롱           | 9000  |
| 16   | 흑마늘아메리카노     | 9000  |
| 19   | 까나리코코넛쥬스     | 9000  |
| 11   | 정어리빙수           | 10000 |
| 15   | 죽방멸치튀김우동     | 11000 |
| 6    | 생마늘샐러드         | 12000 |
| 5    | 앙버터김치찜         | 13000 |
| 14   | 과메기커틀릿         | 13000 |
| 7    | 민트미역국           | 15000 |
| 8    | 한우딸기국밥         | 20000 |
| 20   | 마라깐쇼한라봉       | 22000 |
| 18   | 붕어빵초밥           | 35000 |



- 테이블 별칭

  - 테이블에 별칭을 작성할 수 있으며 어떤 테이블 소속인지를 쉽게 알 수 있게 한다.
  - 테이블 별칭은 AS를 써도 되고 생략도 가능하다.

  ~~~mysql
  SELECT
      a.category_code,
      a.menu_name
  FROM
      -- tbl_menu AS a
      tbl_menu a
  ORDER BY 
      a.category_code,
      a.menu_name;
  ~~~

  

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/371cda8e-b837-4d28-a1bb-4cbf1946be91)

## 1-2. JOIN의 종류



### 1-2-1. INNER JOIN

- 두 테이블의 교집합을 반환하는 SQL JOIN 유형
- INNER JOIN에서 INNER 키워드는 생략이 가능하다.
  - ON을 활용한 JOIN
    - 컬럼명이 같거나 다를 경우 ON으로 서로 연관있는 컬럼에 대한 조건을 작성하여 JOIN하는 경우

~~~mysql
SELECT 
    a.menu_name,
    b.category_name
FROM 
    tbl_menu a
-- INNER JOIN tbl_category b ON a.category_code = b.category_code;
JOIN tbl_category b ON a.category_code = b.category_code;
~~~

![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/d3d04995-c1c3-4207-a14e-a826edb61f03)

- USING을 활용한 JOIN

  - 컬럼명이 같을 경우 USING으로 서로 연관있는 컬럼에 대한 조건을 작성하여 JOIN하는 경우

  ~~~mysql
  SELECT 
      a.menu_name,
      b.category_name
  FROM 
      tbl_menu a
  INNER JOIN tbl_category b USING (category_code);
  ~~~

  

### 1-2-2. LEFT JOIN

- 첫 번째(왼쪽) 테이블의 모든 레코드와 두 번째(오른쪽) 테이블에서 일치하는 레코드를 반환하는 SQL JOIN 유형

  ~~~mysql
  SELECT 
      a.menu_name,
      b.category_name
  FROM 
      tbl_menu a
  RIGHT JOIN tbl_category b ON a.category_code = b.category_code;
  ~~~

  

  ![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/662af6d1-a8d8-4bdf-a30c-d1a8496c7035)

### 1-2-3. RIGHT JOIN

- 두 번째(오른쪽) 테이블의 모든 레코드와 첫 번째(왼쪽) 테이블에서 일치하는 레코드를 반환하는 SQL JOIN 유형

  ~~~mysql
  SELECT 
      a.menu_name,
      b.category_name
  FROM 
      tbl_menu a
  RIGHT JOIN tbl_category b ON a.category_code = b.category_code;
  ~~~

  ![image](https://github.com/Subak-Uncle/Subak-Uncle/assets/115992753/cb96f3ac-76c8-4c43-aea7-2e96d16519b1)



### 1-2-4. CROSS JOIN

- 두 테이블의 모든 가능한 조합을 반환하는 SQL JOIN 유형

~~~mysql
SELECT 
    a.menu_name,
    b.category_name
FROM 
    tbl_menu a
CROSS JOIN tbl_category b;
~~~





### 1-2-5. SELF JOIN

- 같은 테이블 내에서 행과 행 사이의 관계를 찾기 위해 사용되는 SQL JOIN 유형
- 카테고리별 대분류 확인을 위한 SELF JOIN 조회

~~~mysql
SELECT
    a.category_name,
    b.category_name
FROM 
    tbl_category a
JOIN tbl_category b ON a.ref_category_code = b.category_code
WHERE a.ref_category_code IS NOT NULL;
~~~

![image-20230703200522538](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230703200522538.png)

## 1-3. JOIN 알고리즘

### 1-3-1. NESTED LOOP JOIN

- MySQL은 기본적으로 NESTED LOOP JOIN을 사용한다.
- 두 개 이상의 테이블에서 하나의 집합을 기준으로 순차적으로 상대방 Row를 결합하여 조합하는 방식
- 중첩 반복문처럼 첫번 째 테이블의 Row와 관련된 두번째 테이블에 대한 Row를 검색하고 이후 첫 번째 테이블의 다음 Row에 대해 두번쨰 테이블에 대한 것을 검색하며 이후 이와 같은 방식을 반복한다.
- MySQL은 기본적으로 NESTED LOOP JOIN을 사용하지만 이를 강제하려면 힌트절을 작성해 HASH JOIN을 사용하지 않도록 강제할 수 있다.

~~~mysql
SELECT /*+ NO_HASH_JOIN(a) */
    a.menu_name,
    b.category_name
FROM 
    tbl_menu a
JOIN tbl_category b ON a.category_code = b.category_code;
~~~

![image-20230703201504965](C:\Users\user\AppData\Roaming\Typora\typora-user-images\image-20230703201504965.png)

### 1-3-2. HASH JOIN

- MySQL8.0.18버전 이후 지원하게 되었다.
- 대규모 데이터 세트에 대한 조인 연산을 효과적으로 진행할 수 있다.
- 해싱 단계에서 조인을 수행하는 두 테이블 중 작은 쪽을 선택하여 해시 테이블을 만들어 메모리에 저장하고 해시 함수를 사용해서 각 행을 특정 "해시 버킷"에 할당한다.
- 조인 단계에서 다른 테이블을 순회하며 각 행에 대해 동일한 해시 함수를 사용하여 해당 행이 어떤 버킷에 속하는지 결정하고 이 버킷의 모든 행과 해당 행을 비교하여 조인 조건을 만족한다.
- 이 방법은 조인할 테이블 중 하나가 메모리에 적합할 만큼 충분히 작아야 한다. 그렇지 않으면 해시 테이블이 메모리를 넘어서 디스크로까지 넘어가고 이는 성능 저하를 초래한다.
- HASH JOIN은 등가 조인('=' 연산자를 사용하는 조인)에만 사용할 수 있고 비등가 조인에는 사용할 수 없다.

~~~mysql
SELECT /*+ HASH_JOIN(a) */
    a.menu_name,
    b.category_name
FROM
    tbl_menu a
JOIN tbl_category b ON a.category_code = b.category_code;
~~~