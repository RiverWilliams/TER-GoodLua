package ter.com.testblocky;

import android.os.Bundle;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LanguageDefinition;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;

import java.util.Arrays;
import java.util.List;



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

    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
            new LoggingCodeGeneratorCallback(this, "LoggingTag");


    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
       /* String s = mCodeGeneratorCallback.toString();
        try {
            SaveGeneratdeCode(s);
        }
        catch (IOException e){
            e.printStackTrace();
        }*/
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

/* void SaveGeneratdeCode(String code) throws IOException {
        FileOutputStream out = openFileOutput("test.lua",MODE_APPEND);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        osw.write(code.getBytes);
        osw.flush();
        osw.close();
        File path = this.getFilesDir();
        System.out.println(path.toString());
        String chemin = path.toString();
        try {
            FileInputStream in = openFileInput("test.lua");
            InputStreamReader isr = new InputStreamReader(in);
            char [] buffer = new char[2000];
            isr.read(buffer);
            String code2 = new String(buffer);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    }*/


}
