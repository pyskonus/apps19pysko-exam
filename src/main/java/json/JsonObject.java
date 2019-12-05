package json;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Andrii_Rodionov on 1/3/2017.
 */
public class JsonObject extends Json {
    private ArrayList<JsonPair> al;

    public JsonObject(JsonPair... jsonPairs) {
        al = new ArrayList<>();
        al.addAll(Arrays.asList(jsonPairs));
    }

    @Override
    public String toJson() {
        if (al.size() == 0) return "{}";
        String result = "{";
        for (JsonPair jp: al) {
            result = result.concat(jp.key + ": " + jp.value.toJson() + ", ");
        }
        result = result.substring(0, result.length() - 2);
        return result + "}";
    }

    public void add(JsonPair jsonPair) {
        al.add(jsonPair);
    }

    public Json find(String name) {
        // ToDo
        return null;
    }

    public JsonObject projection(String... names) {
        JsonObject res = new JsonObject();
        for (int i = 0; i< al.size(); i++) {
            res.add(new JsonPair(names[i], al.get(i).value));
        }
        return res;
    }
}
