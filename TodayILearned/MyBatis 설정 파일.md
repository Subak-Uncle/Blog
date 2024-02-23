~~~java
package com.onemorething.layered.configuration;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
@MapperScan(value = "com.onemorething.layered.infra.repository", sqlSessionFactoryRef = "SqlSessionFactory")
public class MyBatisConfiguration {

    @Value("${mybatis.mapper-locations}")
    String mPath;

    @Bean(name = "dataSource")
    @ConfigurationProperties(prefix = "spring.datasource")
    public DataSource DataSource() {
        return DataSourceBuilder.create().build();
    }


    @Bean(name = "SqlSessionFactory")
    public SqlSessionFactory SqlSessionFactory(@Qualifier("dataSource") DataSource DataSource, ApplicationContext applicationContext) throws Exception {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(DataSource);
        sqlSessionFactoryBean.setMapperLocations(applicationContext.getResources(mPath));
        return sqlSessionFactoryBean.getObject();
    }

    @Bean(name = "SessionTemplate")
    public SqlSessionTemplate SqlSessionTemplate(@Qualifier("SqlSessionFactory") SqlSessionFactory firstSqlSessionFactory) {
        return new SqlSessionTemplate(firstSqlSessionFactory);
    }

}
~~~



~~~java
# mySQL
spring.datasource.driver=com.mysql.cj.jdbc.Driver
spring.datasource.jdbc-url=jdbc:mysql://localhost:3306/developerdb?&serverTimezone=UTC&autoReconnect=true&allowMultiQueries=true&characterEncoding=UTF-8
spring.datasource.username=root
spring.datasource.password=1234

# myBatis
mybatis.type-aliases-package=com.onemorething.layered.domain.aggregate.entity
mybatis.mapper-locations=classpath:/mapper/*.xml
~~~



~~~java
<?xml version="1.0" encoding="UTF-8" ?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="UserRepository">
    <select id="getPhoneList" resultType="com.onemorething.layered.menu.domain.aggregate.entity.Member">
        SELECT * FROM USER
    </select>
</mapper>
~~~



~~~java
package com.onemorething.layered.menu.domain.repository;

import com.onemorething.layered.menu.domain.aggregate.entity.Member;

import java.util.List;

public interface UserRepository {

    public List<Member> getPhoneList();
}
~~~

