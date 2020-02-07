package com.timi;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootTest
public class ApplicationTest {
    @Autowired
    DataSource dataSource;
    @Test
    void contextTest() throws SQLException {
        System.out.println(dataSource.getClass());  //查看数据源
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }
}
