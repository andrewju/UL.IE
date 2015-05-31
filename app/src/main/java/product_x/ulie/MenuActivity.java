package product_x.ulie;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class MenuActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button timetable_button, map_button, mail_button, lib_button, hours_button,
                links_button, call_button, emergency_button, settings_button, about_button;

        timetable_button = (Button) findViewById(R.id.timetable_button);
        map_button = (Button) findViewById(R.id.map_button);
        mail_button = (Button) findViewById(R.id.mail_button);
        lib_button = (Button) findViewById(R.id.lib_button);
        hours_button = (Button) findViewById(R.id.hours_button);
        links_button = (Button) findViewById(R.id.links_button);
        call_button = (Button) findViewById(R.id.call_button);
        emergency_button = (Button) findViewById(R.id.emergency_button);
        settings_button = (Button) findViewById(R.id.settings_button);

        settings_button.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(MenuActivity.this, SettingsActivity.class);
                startActivity(intent);
            }

        });
        about_button = (Button) findViewById(R.id.about_button);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
