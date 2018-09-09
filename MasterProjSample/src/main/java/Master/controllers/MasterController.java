package Master.controllers;

import org.json.simple.JSONArray;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MasterController {
    Master.controllers.testDB db = new Master.controllers.testDB();

    @GetMapping("/records")
   public String getHelloMessage(@RequestParam(value="zipcode", defaultValue="94041") String zipcode){
 /*       String data;
        data = this.db.getData(zipcode);
        //System.out.println(JsonWriter.formatJson(data));
        //String niceFormattedJson = JsonWriter.formatJson(data);

        JSONObject output = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            output = (JSONObject) parser.parse(data);
            System.out.println("********");
            System.out.println(zipcode);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        return "test";

    }
    @GetMapping("/dummy")
    public JSONArray dummy(@RequestParam(value="zipcode", defaultValue="94041") String zipcode){
        JSONArray data;
        data = this.db.getData(zipcode);
        //System.out.println(JsonWriter.formatJson(data));
        //String niceFormattedJson = JsonWriter.formatJson(data);
/*
        JSONObject output = new JSONObject();
        JSONParser parser = new JSONParser();
        try {
            output = (JSONObject) parser.parse(data);
            System.out.println("********");
            System.out.println(zipcode);
        } catch (ParseException e) {
            e.printStackTrace();
        }*/

        return data;

    }
}



