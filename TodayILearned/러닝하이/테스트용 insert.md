```sql
CREATE PROCEDURE loopInsert()
BEGIN
    DECLARE i INT DEFAULT 1;
    -- 날짜는 순차적이지 않고 중복이 존재하는 컬럼을 가정해서 테스트하기 위해 랜덤하게 insert
    WHILE i <= 5000000 DO
            INSERT INTO post(title, content , create_at)
            VALUES(concat('제목',i), concat('내용',i), DATE_SUB(NOW(), INTERVAL FLOOR( 1 + RAND() * (3600 -1 ) ) SECOND));
            SET i = i + 1;
        END WHILE;
END$$
DELIMITER $$

CALL loopInsert;
```

