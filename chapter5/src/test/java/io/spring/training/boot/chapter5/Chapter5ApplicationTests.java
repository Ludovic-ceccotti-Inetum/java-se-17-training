package io.spring.training.boot.chapter5;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;

class Chapter5ApplicationTests {


    void testExceptionThrow() throws FileNotFoundException, SQLException {
        try {
            if(Math.random() > 0.5) throw new FileNotFoundException();
            if(Math.random() > 0.5) throw new SQLException();
        } catch (IOException | SQLException e) {
            throw e;
        }
    }

    public void testExceptionThrow2() throws Exception {
        try {
            if(Math.random() > 0.5) throw new FileNotFoundException();
            if(Math.random() > 0.5) throw new SQLException();
        } catch (IOException | SQLException e) {
            final Exception f = e;
            throw f;
        }
    }

}
