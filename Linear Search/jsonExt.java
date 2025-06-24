import com.google.gson.*;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.util.*;
import java.util.regex.*;

public class jsonExt {

    public static void main(String[] args) throws IOException {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        Reader reader = new FileReader("questions.json");

        // Read list of questions from JSON
        Type listType = new TypeToken<List<Map<String, Object>>>() {}.getType();
        List<Map<String, Object>> questions = gson.fromJson(reader, listType);
        reader.close();

        List<Map<String, String>> outputList = new ArrayList<>();

        for (Map<String, Object> q : questions) {
            String slug = (String) q.get("slug");

            String javaCode = (String) q.get("java");
            String cppCode = (String) q.get("c++");
            String pythonCode = (String) q.get("python");

            Map<String, String> result = new HashMap<>();
            result.put("slug", slug);
            result.put("java_method", extractSignature(javaCode, "java"));
            result.put("cpp_method", extractSignature(cppCode, "cpp"));
            result.put("python_method", extractSignature(pythonCode, "python"));

            outputList.add(result);
        }

        // Write result to new JSON file
        Writer writer = new FileWriter("extracted_methods.json");
        gson.toJson(outputList, writer);
        writer.flush();
        writer.close();

        System.out.println("✅ Extraction complete. Check 'extracted_methods.json'");
    }

    public static String extractSignature(String code, String lang) {
        if (code == null) return "";

        code = code.replaceAll("```.*?\\n", "").trim();  // remove markdown code fences if present

        String regex = "";
        switch (lang.toLowerCase()) {
            case "java":
                regex = "(public|private|protected)?\\s*[\\w\\<\\>\$begin:math:display$\\$end:math:display$]+\\s+\\w+\\s*\$begin:math:text$[^)]*\\$end:math:text$";
                break;
            case "cpp":
                regex = "[\\w\\:\\<\\>\\&\\*\\s]+\\s+\\w+\\s*\$begin:math:text$[^)]*\\$end:math:text$";
                break;
            case "python":
                regex = "def\\s+\\w+\\s*\$begin:math:text$[^)]*\\$end:math:text$";
                break;
        }

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(code);
        if (matcher.find()) {
            return matcher.group();
        }
        return "";
    }
}