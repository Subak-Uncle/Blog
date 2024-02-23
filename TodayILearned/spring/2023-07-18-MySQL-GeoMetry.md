```java
// hibernate 버전 확인
System.out.println(org.hibernate.Version.getVersionString());

// 방금 확인한 버전을 넣어줌
implementation group: 'org.hibernate', name: 'hibernate-spatial', version: '5.6.15.Final'
```



Entity 컬럼에

~~~java
    @Column(nullable = false, columnDefinition = "GEOMETRY")
    private Point geography;
~~~

