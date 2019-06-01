package com.entity.motionlesselements;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

/**
 * The TestSuite for motionless elements.
 * @author Antoine Chauvel
 * @version 1.0
 *
 */
@RunWith(Suite.class)
@SuiteClasses({ DirtTest.class, ExitDoorTest.class, PathTest.class, WallsTest.class })
public class AllTestsMotionless {

}
