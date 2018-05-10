package ter.com.testblocky;

import android.os.Bundle;

import com.google.blockly.android.AbstractBlocklyActivity;
import com.google.blockly.android.codegen.CodeGenerationRequest;
import com.google.blockly.android.codegen.LanguageDefinition;

import java.io.File;

import java.io.FileOutputStream;
import java.io.IOException;

import java.util.Arrays;
import java.util.List;

public class MyBlockyActivity extends AbstractBlocklyActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    /**
    * Charge la toolbox personnalisée
    */
    @Override
    protected String getToolboxContentsXmlPath() {
        return "lua/toolbox.xml";
    }

    private static final List<String> BLOCK_DEFINITIONS = Arrays.asList(
            "lua/blocks.json"
    );

    /**
    * Charge la définition des blocs personnalisés
    */
    @Override
    protected List<String> getBlockDefinitionsJsonPaths() {
        return BLOCK_DEFINITIONS;
    }

    private static final List<String> LUA_GENERATORS = Arrays.asList(
            "lua/blocks.js"
    );

    /**
    * Charge le code des blocs personnalisés
    */
    @Override
    protected List<String> getGeneratorsJsPaths() {
            return LUA_GENERATORS;
    }

    /**
    * Génère le code des blocs et l'enregistre dans un fichier
    */
    CodeGenerationRequest.CodeGeneratorCallback mCodeGeneratorCallback = new CodeGenerationRequest.CodeGeneratorCallback(){
        @Override
        public void onFinishCodeGeneration(String code){
            System.out.println("Le code ");
            System.out.println(code);
            try {
                SaveGeneratdeCode(code);
            }
            catch (IOException e){
                e.printStackTrace();
            }
        }
    };

    /**
    * Génère le code pour l'afficher dans l'application
    */
    @Override
    protected CodeGenerationRequest.CodeGeneratorCallback getCodeGenerationCallback() {
        return mCodeGeneratorCallback;
    }

    /**
    * Initialisation des variables
    */
    @Override
    protected void onInitBlankWorkspace() {
        getController().addVariable("item");
    }

    /**
    * Définit le langage utilisé
    */
    @Override
   protected LanguageDefinition getBlockGeneratorLanguage() {
        return new LanguageDefinition("lua/lua_compressed.js", "Blockly.Lua");
    }

    /**
    * Enregistre le code dans un fichier
    * @param code le code lua/ino à enregistrer
    */
 void SaveGeneratdeCode(String code) throws IOException {

        System.out.println("code"+code);

        File file = new File("/storage/emulated/0/bluetooth/codeTablette.txt");

        FileOutputStream fos = new FileOutputStream(file);

        fos.write(code.getBytes());

        fos.flush();
        fos.close();

    }

}
