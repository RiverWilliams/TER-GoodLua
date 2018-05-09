package ter.com.testblocky;

import android.content.Context;
import android.os.Bundle;
import android.widget.Toast;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LanguageDefinition;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.List;

import static android.content.Context.MODE_APPEND;


public class MyBlockyActivity extends AbstractBlocklyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }


    @Override

    protected String getToolboxContentsXmlPath() {
        return "lua/toolbox.xml";
    }

    private static final List<String> BLOCK_DEFINITIONS = Arrays.asList(
            "lua/blocks.json"
    );

    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {
        return BLOCK_DEFINITIONS;
    }

    private static final List<String> LUA_GENERATORS = Arrays.asList(
            "lua/blocks.js"
    );

    @Override
    protected List<String> getGeneratorsJsPaths() {
        return LUA_GENERATORS;
    }

    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback = new CodeGenerationRequest.CodeGeneratorCallback(){
        @Override
        public void onFinishCodeGeneration(String code){
            System.out.println("Le code");
            System.out.println(code);
            try {
                SaveGeneratdeCode(code);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    };
            //new LoggingCodeGeneratorCallback(this, "LoggingTag");


    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {

        return mCodeGeneratorCallback;
    }

    @Override
    protected void onInitBlankWorkspace() {
        // Initialize available variable names.
        getController().addVariable("item");
    }

    //@Override
   protected LanguageDefinition getBlockGeneratorLanguage() {
        return new LanguageDefinition("lua/lua_compressed.js", "Blockly.Lua");
    }

 void SaveGeneratdeCode(String code) throws IOException {

        System.out.println("code"+code);

        File file = new File("/storage/emulated/0/bluetooth/codeTablette.txt");

        FileOutputStream fos = new FileOutputStream(file);

        fos.write(code.getBytes());

        fos.flush();
        fos.close();

        /*
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        OutputStreamWriter osw = new OutputStreamWriter(fileOutputStream);
        osw.write(code);


        Toast.makeText(ProgramLoadedActivity.getAppContext(), file.toString(), Toast.LENGTH_SHORT).show();

        osw.flush();
        osw.close();*
         */

       /* File file = new File(ProgramLoadedActivity.getAppContext().getFilesDir(),"codeTablette.txt");

        Toast.makeText(ProgramLoadedActivity.getAppContext(), "path="+file.getPath()+"name="+file.getName(), Toast.LENGTH_SHORT).show();


     //OutputStreamWriter osw = new OutputStreamWriter(out);
        //osw.write(code);
     // osw.flush();
     // osw.close();
        /*
        File path = this.getFilesDir();
        System.out.println(path.toString());
        String chemin = path.toString();
        try {
            FileInputStream in = openFileInput("codeTablette.txt");
            InputStreamReader isr = new InputStreamReader(in);
            char [] buffer = new char[2000];
            isr.read(buffer);
            String code2 = new String(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }*/
    }

    void verifFichier(File path) {
        String chemin = path.toString();
        try {
            FileInputStream in = openFileInput("test.txt");
            InputStreamReader isr = new InputStreamReader(in);
            char [] buffer = new char[2000];
            isr.read(buffer);
            String code = new String(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
