package lesson7.Test.JUnit;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ RectangleTest.class, RectangleTest2.class })
public class AllTests {

}

