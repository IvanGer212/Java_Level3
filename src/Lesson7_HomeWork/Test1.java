package Lesson7_HomeWork;

public class Test1 {

   @BeforeSuite
   public void createNewObjectForTest(){
       System.out.println("Ready to test");

   }

    @Test(priority = 2)
    void doTest1(){
        System.out.println("Finish Test1");

    }

    @Test(priority = 8)
    void doTest2(){
        System.out.println("Finish Test2");
    }

    @Test(priority = 5)
    void doTest3(){
        System.out.println("Finish Test3");
    }
    @AfterSuite
    void doAfterSuit(){
        System.out.println("Realized method AfterSuite");

    }

}
