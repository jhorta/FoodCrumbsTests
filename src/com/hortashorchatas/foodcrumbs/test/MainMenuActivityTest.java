package com.hortashorchatas.foodcrumbs.test;

import java.util.Calendar;

import android.test.ActivityInstrumentationTestCase2;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.hortashorchatas.foodcrumbs.Main_Menu_Activity;
import com.hortashorchatas.foodcrumbs.R;

public class MainMenuActivityTest extends
ActivityInstrumentationTestCase2<Main_Menu_Activity> {

	private Main_Menu_Activity mActivity;
	private ImageView profpic;
	private TextView name;
	private Button fav;
	private Button directions;
	private Button random;

	// Constructor
	public MainMenuActivityTest() {
		super(Main_Menu_Activity.class);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();

		// Turn off touch mode in the device (for if we send commands to the device)
		setActivityInitialTouchMode(false);

		// Initialize all of the assets we are testing
		mActivity = getActivity();
		profpic = (ImageView) mActivity.findViewById(R.id.profile_pic);
		name = (TextView) mActivity.findViewById(R.id.name_text);
		fav = (Button) mActivity.findViewById(R.id.favorites_button);
		directions = (Button) mActivity.findViewById(R.id.directions_button);
		random = (Button) mActivity.findViewById(R.id.random_button);
	}


	/*
	 * Make sure all the elements are not null
	 */
	public void testPreconditions() throws Exception {
		// Make sure all of the assets we are testing are not null, otherwise tests will fail
		assertNotNull("mActivity is null", mActivity);
		assertNotNull("profpic is null", profpic);
		assertNotNull("name is null", name);
		assertNotNull("fav is null", fav);
		assertNotNull("directions is null", directions);
		assertNotNull("random is null", random);
	}


	/*
	 * Test the onCreateView - profile pic, welcome text, buttons
	 */
	public void testOnCreateView() throws Exception {
		
		// Check the height and picture of the profile pic
		assertEquals(160, profpic.getHeight());
		assertEquals(160, profpic.getWidth());
		assertNotNull(profpic.getDrawable());

		
		// Check the text
		int hour = Calendar.getInstance().get(Calendar.HOUR_OF_DAY);
		if (hour >= 7 && hour < 12) {
			assertEquals("Good morning, \ntestUser!", name.getText());
		} else if (hour >= 12 && hour < 18) {
			assertEquals("Good afternoon, \ntestUser!", name.getText());
		} else if (hour >= 18 && hour < 24) {
			assertEquals("Good evening, \ntestUser!", name.getText());
		} else {
			assertEquals("Good night, \ntestUser!", name.getText());
		}

		
		// Check that all the buttons are visible
		assertEquals(fav.getVisibility(), View.VISIBLE);
		assertEquals(directions.getVisibility(), View.VISIBLE);
		assertEquals(random.getVisibility(), View.VISIBLE);
	}


}
