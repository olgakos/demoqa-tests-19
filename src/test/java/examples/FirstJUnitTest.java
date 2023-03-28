package examples;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


    public class FirstJUnitTest {

        @AfterAll
        static void afterAll() {
            System.out.println("#### @AfterAll");
        }

        @BeforeAll
        static void beforeAll() {
            System.out.println("#### @beforeAll");
        }

        @BeforeEach
        void beforeEach() {
            System.out.println("#### @BeforeEach");
        }

        @AfterEach
        void afterEach() {
            System.out.println("#### @AfterEach");
        }

        @Test
        void firstTest() {
            Assertions.assertTrue(3 > 2);
            System.out.println(" #### @Test firstTest()");
        }

        @Test
        void secondTest() {
            Assertions.assertTrue(3 > 2);
            System.out.println("#### @Test secondTest()");
        }
    }


