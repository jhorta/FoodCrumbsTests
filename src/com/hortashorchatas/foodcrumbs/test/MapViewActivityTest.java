package com.hortashorchatas.foodcrumbs.test;

import android.content.Intent;
import android.support.v7.widget.SearchView;
import android.test.ActivityInstrumentationTestCase2;
import android.view.View;

import com.hortashorchatas.foodcrumbs.Globals;
import com.hortashorchatas.foodcrumbs.Map_View_Activity;
import com.hortashorchatas.foodcrumbs.R;

public class MapViewActivityTest extends
ActivityInstrumentationTestCase2<Map_View_Activity>{

	
	private Map_View_Activity mActivity;
	private SearchView sView;


	// Constructor
	public MapViewActivityTest() {
		super(Map_View_Activity.class);
	}
	
	
	@Override
	protected void setUp() throws Exception {

		// Turn off touch mode in the device (for if we send commands to the device)
		setActivityInitialTouchMode(false);

		// Initialize all of the assets we are testing
		Intent i = new Intent(getInstrumentation().getContext(), Map_View_Activity.class);
		i.putExtra("Source", Globals.SOURCE_HOME_PAGE);
		setActivityIntent(i);
		mActivity = getActivity();	
		sView = (SearchView) mActivity.findViewById(R.id.action_search);
	}


	/*
	 * Make sure all the elements are not null
	 */
	public void testPreconditions() throws Exception {
		// Make sure all of the assets we are testing are not null, otherwise tests will fail
		assertNotNull("mActivity is null", mActivity);
		assertNotNull("sView is null", sView);
	}
	

	
	
	/*
	 * Test clicking the search icon - should open a SearchView prompting the user to 
	 * enter a location
	 */
	public void testSearch() throws Exception {		
		// Click the search icon (use instrumentation because it's a menu item)
		getInstrumentation().invokeMenuActionSync(mActivity, R.id.action_search, 0);
		
		
		// SearchView should be visible with the hint text "Current Location"
		assertTrue(View.VISIBLE == sView.getVisibility());
		assertEquals("Current Location", sView.getQueryHint());
	}
	
		
}
