package course.labs.activitylab.test;

import course.labs.activitylab.ActivityOne;
import com.robotium.solo.*;

import android.test.ActivityInstrumentationTestCase2;


public class Test2 extends ActivityInstrumentationTestCase2<ActivityOne> {
  	private Solo solo;
  	
  	public Test2() {
		super(ActivityOne.class);
  	}

  	public void setUp() throws Exception {
		solo = new Solo(getInstrumentation());
		getActivity();
  	}
  
   	@Override
   	public void tearDown() throws Exception {
        solo.finishOpenedActivities();
		assertTrue("Activity stack not empty.", solo.waitForEmptyActivityStack(5000));

  	}
  
	public void testRun() {
		// Wait for activity: 'course.labs.activitylab.ActivityOne'
		assertTrue("course.labs.activitylab.ActivityOne is not found!", solo.waitForActivity(course.labs.activitylab.ActivityOne.class));
		// Check for proper counts
		assertTrue("onCreate() count was off.", solo.searchText("onCreate\\(\\) calls: 1"));
		assertTrue("onStart() count was off.", solo.searchText("onStart\\(\\) calls: 1"));
		assertTrue("onResume() count was off.", solo.searchText("onResume\\(\\) calls: 1"));
		assertTrue("onRestart() count was off.", solo.searchText("onRestart\\(\\) calls: 0"));

		// Click on Start Activity Two
		solo.clickOnView(solo.getView(course.labs.activitylab.R.id.bLaunchActivityTwo));
		// Wait for activity: 'course.labs.activitylab.ActivityTwo'
		assertTrue("course.labs.activitylab.ActivityTwo is not found!", solo.waitForActivity(course.labs.activitylab.ActivityTwo.class));
		// Check for proper counts
		assertTrue("onCreate() count was off.", solo.searchText("onCreate\\(\\) calls: 1"));
		assertTrue("onStart() count was off.", solo.searchText("onStart\\(\\) calls: 1"));
		assertTrue("onResume() count was off.", solo.searchText("onResume\\(\\) calls: 1"));
		assertTrue("onRestart() count was off.", solo.searchText("onRestart\\(\\) calls: 0"));

		// Rotate the screen
		solo.setActivityOrientation(Solo.LANDSCAPE);
		// Check for proper counts
		assertTrue("onCreate() count was off.", solo.searchText("onCreate\\(\\) calls: 2"));
		assertTrue("onStart() count was off.", solo.searchText("onStart\\(\\) calls: 2"));
		assertTrue("onResume() count was off.", solo.searchText("onResume\\(\\) calls: 2"));
		assertTrue("onRestart() count was off.", solo.searchText("onRestart\\(\\) calls: 0"));

		// Rotate the screen
		solo.setActivityOrientation(Solo.PORTRAIT);
		// Check for proper counts
		assertTrue("onCreate() count was off.", solo.searchText("onCreate\\(\\) calls: 3"));
		assertTrue("onStart() count was off.", solo.searchText("onStart\\(\\) calls: 3"));
		assertTrue("onResume() count was off.", solo.searchText("onResume\\(\\) calls: 3"));
		assertTrue("onRestart() count was off.", solo.searchText("onRestart\\(\\) calls: 0"));
		

	}
}
