package com.example.birthday.calendar;



import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.widget.CalendarView;
 
 

public class MainActivity extends Activity {
	
	private int mYear;
	private int mMonth;
	private int mDay;
	public static final String EXTRA_MESSAGE = "com.example.birthday.calendar.selectedDate";
	@Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        CalendarView calendar = new CalendarView(this);
        calendar.setOnDateChangeListener(dateSetListener);
        setContentView(calendar);
    }
	
	private CalendarView.OnDateChangeListener dateSetListener =new CalendarView.OnDateChangeListener() {
			public void onSelectedDayChange(CalendarView view, int year,int monthOfYear, int dayOfMonth) {
				mYear = year;
				mMonth = monthOfYear;
				mDay = dayOfMonth;
				String selectedDate = new StringBuilder().append(mMonth + 1).append("-").append(mDay).append("-").append(mYear).append(" ").toString();
				/*Bundle b = new Bundle();
				b.putString("dateSelected", selectedDate); 
				//Add the set of extended data to the intent and start it
				Intent intent = new Intent();
				intent.putExtras(b);
				setResult(RESULT_OK,intent);      
				finish();*/
				changeActivity(selectedDate);
				
				}
			};
		public void changeActivity(String selectedDate){
			Intent intent = new Intent(this,DisplayActivity.class);
	    	intent.putExtra(EXTRA_MESSAGE,selectedDate);
	    	startActivity(intent);
		}

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
     

    
}
