package tests;

import org.junit.jupiter.api.*;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class SimpleJUnitTest {
       int result;

       @BeforeAll
       static void beforeAll(){
           System.out.println("\nПеред всеми\n");
       }
         @AfterAll
             static void afterAll(){
            System.out.println("\nПосле всех\n");
         }


        @BeforeEach
        void beforeEach(){
            System.out.println("Перед каждым");
            result = getResult();
        }
        @AfterEach
            void afterEach(){
            System.out.println("После каждого\n");
            result = 0;
        }
        @Test
        void FirstTest() {

            System.out.println("Первый");
            Assertions.assertTrue(result>2);
        }

        @Test
        void SecondTest() {
            System.out.println("Второй");
            Assertions.assertTrue(result>2);
        }
        @Test
        void ThirdTest() {
            System.out.println("Третий");
            Assertions.assertTrue(result>2);
        }
        private int getResult() {
            return 3;
        }
}

