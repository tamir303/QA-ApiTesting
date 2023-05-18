package RestPackage;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;

public class Utils {
    public static JSONObject readJson(String filename) {
        JSONParser jsonParser = new JSONParser();
        FileReader reader = null;
        try {
            reader = new FileReader(filename);
            // Read JSON file
            return (JSONObject) jsonParser.parse(reader);
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
        return null;
    }
}
