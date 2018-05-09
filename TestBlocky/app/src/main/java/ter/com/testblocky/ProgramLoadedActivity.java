package ter.com.testblocky;

import android.app.Activity;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Set;

/**
 * Created by Julie on 11/03/2018.
 */
public class ProgramLoadedActivity extends Activity {

    final String PROG_NAME = "program_name";
    private BluetoothAdapter bluetoothAdapter;
    public static final java.util.UUID MY_UUID
            = java.util.UUID.fromString("DEADBEEF-0000-0000-0000-000000000000");

    private static ProgramLoadedActivity instance;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        instance=this;
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


        final Button buttonExec = (Button) findViewById(R.id.executer);
        buttonExec.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                bluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
                if (bluetoothAdapter == null)
                    Toast.makeText(ProgramLoadedActivity.this, "Pas de Bluetooth",
                            Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(ProgramLoadedActivity.this, "Avec Bluetooth",
                            Toast.LENGTH_SHORT).show();

                if (!bluetoothAdapter.isEnabled()) {
                    bluetoothAdapter.enable();
                }

                Set<BluetoothDevice> devices;
                devices = bluetoothAdapter.getBondedDevices();
                for (BluetoothDevice blueDevice : devices) {
                    //Toast.makeText(ProgramLoadedActivity.this, "Device = " + blueDevice.getName(), Toast.LENGTH_SHORT).show();
                    if(blueDevice.getName().equals("pcduino3")){
                        /*
                        File file = new File(getApplicationContext().getFilesDir(),"codeTablette.txt");
                        System.out.println("path="+file.getPath()+"name="+file.getName());
                        System.out.println("can read="+file.canRead()+"can write="+file.canWrite());
                        file.setExecutable(true);
                        file.setReadable(true);
                        file.setWritable(true);
                        sendFileToDevice(blueDevice,file);
                        */
                        File file2 = new File("/storage/emulated/0/bluetooth/codeTablette.txt");
                        sendFileToDevice(blueDevice,file2);

                    }
                }

            }

        });
    }

    public void sendFileToDevice(BluetoothDevice device,File file){
        Intent intent = new Intent();
        intent.setAction(Intent.ACTION_SEND);
        intent.setClassName("com.android.bluetooth", "com.android.bluetooth.opp.BluetoothOppLauncherActivity");
        intent.setType("text/plain");
        intent.putExtra(BluetoothDevice.EXTRA_DEVICE, device);
        intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(file));
        startActivity(intent);
    }

    public static Context getAppContext(){
        return instance;
    }

}
