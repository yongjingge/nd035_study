package com.example.demo;

import com.example.demo.model.ChatMessage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.jupiter.api.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Lesson5FinalReviewApplicationTests {

    @LocalServerPort
    private Integer port;

    private static WebDriver driver;
    private SignupPage signupPage;
    private LoginPage loginPage;
    private HomePage homePage;

    private String baseURL;

    @BeforeAll
    public static void beforeAll () {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
    }

    @AfterAll
    public static void afterAll () {
        driver.quit();
        driver = null;
    }

    @BeforeEach
    public void beforeEach () {
        baseURL = "http://localhost:" + port;
    }

    @Test
    void testLoginUserChatMessage () throws InterruptedException {
        String firstname = "John";
        String lastname = "Smith";
        String username = "johnsmith";
        String password = "try123";
        String message = "hello"; // to post a chat message

        // test sign up
        driver.get(baseURL + "/signup");
        signupPage = new SignupPage(driver);
        signupPage.signup(firstname, lastname, username, password);
        Thread.sleep(3000);

        // test log in
        driver.get(baseURL + "/login");
        loginPage = new LoginPage(driver);
        loginPage.login(username, password);
        Thread.sleep(3000);

        // test home page
        driver.get(baseURL + "/home");
        homePage = new HomePage(driver);
        homePage.addPost(message);

        ChatMessage messageInThePage = homePage.getMessage();

        assertEquals(username, messageInThePage.getUsername());
        assertEquals(message, messageInThePage.getMessagetext());
    }

}
