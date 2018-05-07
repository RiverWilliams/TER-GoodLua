package ter.com.testblocky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by Julie on 11/03/2018.
 */
public class ProgramLoadedActivity extends Activity {

    final String PROG_NAME = "program_name";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.program_loaded_activity);

        Intent intent = getIntent();
        TextView nameDisplay = (TextView) findViewById(R.id.program_name);

        if (intent != null) {
            nameDisplay.setText(intent.getStringExtra(PROG_NAME));
        }

        final Button newButton = (Button) findViewById(R.id.modifier);
        newButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProgramLoadedActivity.this, MyBlockyActivity.class);
                startActivity(intent);
            }
        });
    }

}
