package one.maling;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class JsonObjTest {
    public static void main(String[] args) {

        JSONArray jsonArray = new JSONArray();
        for (int i = 0; i < 2; i++) {
            JSONObject jsonObject = new JSONObject();
            jsonObject.put("AGE", 10);
            jsonObject.put("FULL NAME", "Doe " + i);
            jsonObject.put("DATE OF BIRTH", "2022/11/12 12:12:12");
            jsonArray.add(jsonObject);
        }
        String jsonOutput = jsonArray.toJSONString();
        System.out.println(jsonOutput);
    }
}
