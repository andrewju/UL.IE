package product_x.ulie;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class SettingsActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        Button updateButton;
        final EditText et1, et2;

        et1 = (EditText) findViewById(R.id.edit_id_1);
        et2 = (EditText) findViewById(R.id.edit_id_2);

        updateButton = (Button) findViewById(R.id.update_button);

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String id = prefs.getString("s_id", null);

        et1.setText(id);
        et2.setText(id);

        updateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor prefsEDT = getPreferences(MODE_PRIVATE).edit();

                if((et1.getText().length() < 7 || et1.getText().length() > 8) || (et2.getText().length() < 7 || et2.getText().length() >8)){
                    Toast.makeText(getApplicationContext(), "Please enter the correct student ID!", Toast.LENGTH_LONG).show();
                }
                else if(!et1.getText().toString().equalsIgnoreCase(et2.getText().toString())) {
                    Toast.makeText(getApplicationContext(), "Please make sure it's the same!", Toast.LENGTH_LONG).show();
                }
                else {
                    prefsEDT.putString("s_id", et1.getText().toString());
                    prefsEDT.commit();
                    Intent intent = new Intent(SettingsActivity.this, MenuActivity.class);
                    startActivity(intent);
                }

            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_settings, menu);
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
