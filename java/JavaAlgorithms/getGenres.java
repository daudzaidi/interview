package JavaAlgorithms;

/**
 * Created by shalvi on 22/06/16.
 */
import java.io.BufferedReader;

import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class getGenres {

    public static void main(String[] args) {
        try {
            URL url = new URL("http://54.88.142.8:8080/v1/content/discovery?datatype=content&n=10&pos=100&status=PUBLISH_PUBLISHED&language=en");
            HttpURLConnection openConnection = (HttpURLConnection) url.openConnection();
            BufferedReader in = new BufferedReader(new InputStreamReader(
                    openConnection.getInputStream()));
            String inputLine;
            StringBuilder sb = new StringBuilder();

            while ((inputLine = in.readLine()) != null)
                sb.append(inputLine + "\n");
            in.close();

            String outputString = sb.toString();

            JSONParser parser = new JSONParser();
            JSONObject json = (JSONObject) parser.parse(outputString);
            //String result = json.g
            JSONArray result = (JSONArray) json.get("result");
            for(int i=0;i<result.size();i++ )
            {
                JSONObject contentMetadata = (JSONObject) result.get(i);
                JSONObject data = (JSONObject) contentMetadata.get("contentMetadata");
                System.out.println();
            }
            //long total = (long) json.get("total");


            //System.out.println(jsonMainArr.toJSONString());
            //System.out.println(total);





        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
