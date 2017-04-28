package test;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ testCheckerMove.class, testGameEngine.class, testStartupUI.class })
public class AllTests {

}
