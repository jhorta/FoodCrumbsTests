package com.hortashorchatas.foodcrumbs.test;

import com.hortashorchatas.foodcrumbs.Favorites_View_Activity;
import com.hortashorchatas.foodcrumbs.Main_Menu_Activity;
import com.hortashorchatas.foodcrumbs.Map_View_Activity;
import com.hortashorchatas.foodcrumbs.R;
import com.hortashorchatas.foodcrumbs.Random_Generator_Activity;

import android.app.Instrumentation.ActivityMonitor;
import android.test.InstrumentationTestCase;
import android.test.TouchUtils;
import android.widget.Button;

public class TestCases extends InstrumentationTestCase {

	private Main_Menu_Activity menuActivity;
	private Map_View_Activity mapActivity;
	private Random_Generator_Activity randomActivity;
	private Favorites_View_Activity favActivity;
	private ActivityMonitor receiverActivityMonitor;
	private Button directions;
	private Button random;
	private Button fav;



	@Override
	protected void setUp() throws Exception {
		super.setUp();

	
		// Launch the main menu activity
		receiverActivityMonitor =
				getInstrumentation().addMonitor(Main_Menu_Activity.class.getName(),
						null, false);
		launchActivity("com.hortashorchatas.foodcrumbs", Main_Menu_Activity.class, null);
		menuActivity = (Main_Menu_Activity) receiverActivityMonitor.waitForActivity();
		assertNotNull("Main Menu Activity is null", menuActivity);
		assertEquals("Activity is of wrong type", Main_Menu_Activity.class, menuActivity.getClass());
		getInstrumentation().removeMonitor(receiverActivityMonitor);

		// Initialize buttons
		directions = (Button) menuActivity.findViewById(R.id.directions_button);
		random = (Button) menuActivity.findViewById(R.id.random_button);
		fav = (Button) menuActivity.findViewById(R.id.favorites_button);
	}


	/*
	 * TC-2: View Map Screen.
	 * The user is currently viewing the Main Menu Screen and then presses the Map button.
	 * The Map Screen should be shown.
	 */
	public void testCase2() throws Exception {
		// Set up an ActivityMonitor
		receiverActivityMonitor =
				getInstrumentation().addMonitor(Map_View_Activity.class.getName(),
						null, false);


		// Click the directions button
		TouchUtils.clickView(this, directions);


		// Use the ActivityMonitor to make sure that the Map View Activity has started
		mapActivity = (Map_View_Activity)
				receiverActivityMonitor.waitForActivity();
		assertNotNull("Map View Activity is null", mapActivity);
		assertEquals("Monitor for ReceiverActivity has not been called",
				1, receiverActivityMonitor.getHits());
		assertEquals("Activity is of wrong type",
				Map_View_Activity.class, mapActivity.getClass());
		getInstrumentation().removeMonitor(receiverActivityMonitor);


		// Close the Map View Activity and Menu Activity
		mapActivity.finish();
		menuActivity.finish();
	}



	/*
	 * TC-7: View Favorites Screen.
	 * The user is currently viewing the Main Menu Screen and then presses the Favorites button.
	 * The Favorites Screen should be shown.
	 */
	public void testCase7() throws Exception {	
		// Set up an ActivityMonitor
		receiverActivityMonitor =
				getInstrumentation().addMonitor(Favorites_View_Activity.class.getName(),
						null, false);


		// Click the favorites button
		TouchUtils.clickView(this, fav);


		// Use the ActivityMonitor to make sure that the Favorites View Activity has started
		favActivity = (Favorites_View_Activity)
				receiverActivityMonitor.waitForActivity();
		assertNotNull("Favorites View Activity is null", favActivity);
		assertEquals("Monitor for ReceiverActivity has not been called",
				1, receiverActivityMonitor.getHits());
		assertEquals("Activity is of wrong type",
				Favorites_View_Activity.class, favActivity.getClass());
		//getInstrumentation().removeMonitor(receiverActivityMonitor);

		
		// Close the Favorites View Activity and Menu Activity
		favActivity.finish();
		menuActivity.finish();
	}

	
	
	
	/*
	 * TC-9: View Roulette Screen.
	 * The user is currently viewing the Main Menu Screen and then presses the Random button.
	 * The Roulette Screen should be shown.
	 */
	public void testCase9() throws Exception {
		// Set up an ActivityMonitor
		receiverActivityMonitor =
				getInstrumentation().addMonitor(Random_Generator_Activity.class.getName(),
						null, false);


		// Click the random button
		TouchUtils.clickView(this, random);


		// Use the ActivityMonitor to make sure that the Random Generator Activity has started
		randomActivity = (Random_Generator_Activity)
				receiverActivityMonitor.waitForActivity();
		assertNotNull("Random Generator Activity is null", randomActivity);
		assertEquals("Monitor for ReceiverActivity has not been called",
				1, receiverActivityMonitor.getHits());
		assertEquals("Activity is of wrong type",
				Random_Generator_Activity.class, randomActivity.getClass());
		getInstrumentation().removeMonitor(receiverActivityMonitor);


		// Close the Random Generator Activity and Menu Activity
		randomActivity.finish();
		menuActivity.finish();
	}



	@Override 
	protected void tearDown() throws Exception {
		super.tearDown();	
	}
}
