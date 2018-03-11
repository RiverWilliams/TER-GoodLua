package ter.com.testblocky;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by Julie on 11/03/2018.
 */
public class NewProgActivity extends Activity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.new_prog_activity);

        final Button newButton = (Button) findViewById(R.id.valider);
        newButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(NewProgActivity.this, ProgramLoadedActivity.class);
                startActivity(intent);
            }
        });
    }

}
