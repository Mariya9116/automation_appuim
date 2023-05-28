import org.testng.annotations.*;

public class annotationSample {

    @Test(priority = 2)
    public void anotationTest()
    {
        System.out.println("this is out first test");
    }

    @Test(priority = 2)
    public void anotationTest2()
    {
        System.out.println("this is out 2nd test");
    }

    @Test(priority = 0)
    public void anotationTest3()
    {
        System.out.println("this is out 3rd test");
    }


    @AfterTest
    public void anotationTest_3()
    {
        System.out.println("AfterTest");
    }
    @AfterMethod
    public void anotationTest4()
    {
        System.out.println("AfterMethod____");
    }
    @BeforeTest
    public void secondndAfterMethos()
    {
        System.out.println("AfterMethodRequestedByMariya");
    }



    @BeforeMethod
    public void anotationTest6()
    {
        System.out.println("BeforeMethod");
    }

    @BeforeClass
    public void anotationTest7()
    {
        System.out.println("BeforeClass");
    }
    @AfterClass
    public void anotationTest8()
    {
        System.out.println("AfterClass");
    }

}