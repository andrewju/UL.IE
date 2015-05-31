package product_x.ulie;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.pm.PackageManager.NameNotFoundException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;
import android.net.Uri;

public class FirstTimeUserActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_user);
        Button verifyButton, downloadButton, nextButton;

        verifyButton = (Button) findViewById(R.id.verify_button);
        downloadButton = (Button) findViewById(R.id.download_button);
        nextButton = (Button) findViewById(R.id.submit_button);

        final EditText et1 = (EditText) findViewById(R.id.id_1);
        final EditText et2 = (EditText) findViewById(R.id.id_2);

        final SharedPreferences.Editor prefsEDT = getPreferences(MODE_PRIVATE).edit();

        verifyButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                if (isPackageInstalled(getApplicationContext())){
                    Toast.makeText(getApplicationContext(),"App Installed!", Toast.LENGTH_LONG).show();
                }
                else {
                    Toast.makeText(getApplicationContext(),"App Not Installed!", Toast.LENGTH_LONG).show();
                }
            }
        });

        downloadButton.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(Intent.ACTION_VIEW,Uri.parse("market://details?id=com.microsoft.exchange.mowa"));
                startActivity(intent);
            }
        });

        nextButton.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    if((et1.getText().length() < 7 || et1.getText().length() > 8) || (et2.getText().length() < 7 || et2.getText().length() >8)){
                        Toast.makeText(getApplicationContext(), "Please enter the correct student ID!", Toast.LENGTH_LONG).show();
                    }
                    else if(!et1.getText().toString().equalsIgnoreCase(et2.getText().toString())) {
                        Toast.makeText(getApplicationContext(), "Please make sure it's the same!", Toast.LENGTH_LONG).show();
                    }
                    else {
                        prefsEDT.putString("s_id", et1.getText().toString());
                        prefsEDT.commit();
                        Intent intent = new Intent(FirstTimeUserActivity.this, MenuActivity.class);
                        startActivity(intent);
                    }
                }

        });


    }

    private boolean isPackageInstalled(Context context) {
        PackageManager pm = context.getPackageManager();
        try {
            pm.getPackageInfo("com.microsoft.exchange.mowa", PackageManager.GET_ACTIVITIES);
            return true;
        } catch (NameNotFoundException e) {
            return false;
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_first_time_user, menu);
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
