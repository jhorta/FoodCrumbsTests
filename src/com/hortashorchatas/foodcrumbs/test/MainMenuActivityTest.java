package com.hortashorchatas.foodcrumbs.test;

import android.test.ActivityInstrumentationTestCase2;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.hortashorchatas.foodcrumbs.Main_Menu_Activity;
import com.hortashorchatas.foodcrumbs.R;

public class MainMenuActivityTest extends
		ActivityInstrumentationTestCase2<Main_Menu_Activity> {

	private Main_Menu_Activity mActivity;
	private ImageView profpic;
	private TextView name;
	private ImageButton fav;
	private ImageButton directions;
	private ImageButton random;

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
	    profpic = (ImageView) mActivity.findViewById(com.hortashorchatas.foodcrumbs.R.id.profile_pic);
	    name = (TextView) mActivity.findViewById(com.hortashorchatas.foodcrumbs.R.id.name_text);
	    fav = (ImageButton) mActivity.findViewById(R.id.favorites_button);
	    directions = (ImageButton) mActivity.findViewById(R.id.directions_button);
	    random = (ImageButton) mActivity.findViewById(R.id.random_button);
	}
	
	
	public void testPreconditions() throws Exception {
		// Make sure all of the assets we are testing are not null, otherwise tests will fail
	    assertNotNull("mActivity is null", mActivity);
	    assertNotNull("profpic is null", profpic);
	    assertNotNull("name is null", name);
	    assertNotNull("fav is null", fav);
	    assertNotNull("directions is null", directions);
	    assertNotNull("random is null", random);
	}
	
	
	public void testOnCreateView() throws Exception {
	    // Check the height and picture of the profile pic
        assertEquals(150, profpic.getHeight());
	    assertNotNull(profpic.getDrawable());
	    
	    // Check the text
	    assertEquals("Hello, Michael!", name.getText());
	    
	    // Check the size of the favorites button
	    assertEquals(200, fav.getHeight());
	    assertEquals(200, fav.getWidth());
	    
	    // Check the size of the directions button
	    assertEquals(200, directions.getHeight());
	    assertEquals(200, directions.getWidth());
	    
	    // Check the size of the random button
	    assertEquals(200, random.getHeight());
	    assertEquals(200, random.getWidth());
	}
	
	
	public void testFavoritesView() throws Exception {
		
	}
	
	
	public void testMapView() throws Exception {
		
	}
	
	
	public void testRandomView() throws Exception {
		
	}


}
