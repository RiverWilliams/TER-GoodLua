package ter.com.testblocky;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LanguageDefinition;
import com.google.blockly.android.codegen.LoggingCodeGeneratorCallback;
import com.google.blockly.model.DefaultBlocks;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MyBlockyActivity extends AbstractBlocklyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    protected String getToolboxContentsXmlPath() {
        return "default/toolbox.xml";
    }

    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {
        List<String> assetPaths = new ArrayList<>(DefaultBlocks.getAllBlockDefinitions());
        // Append your own block definitions here.
        return assetPaths;
    }

    private static final List<String> LUA_GENERATORS = Arrays.asList(
            // Custom block generators go here. Default blocks are already included.
    );

    @Override
    protected List<String> getGeneratorsJsPaths() {
        return LUA_GENERATORS;
    }

    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback =
            new LoggingCodeGeneratorCallback(this, "LoggingTag");

    void SaveGeneratdeCode(String code) throws IOException {
        FileOutputStream out = openFileOutput("test.txt",MODE_APPEND);
        OutputStreamWriter osw = new OutputStreamWriter(out);
        osw.write(code);
        osw.flush();
        osw.close();
    }

    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
       String s = mCodeGeneratorCallback.toString();
        try {
            SaveGeneratdeCode(s);
        }
        catch (IOException e){
            e.printStackTrace();
        }
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




}