package JavaAlgorithms;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/**
 * Created by shalvi on 16/06/16.
 */
public class GsonParserDemo {

    public static void main(String[] args) {
        HashMap<String, Object> jsonData = new HashMap<String, Object>();
        jsonData.put("name", "sanaulla");
        jsonData.put("place", "bangalore");
        jsonData.put("interests", Arrays.asList("blogging", "coding"));
        Gson gson = new Gson();

        String jsonString = gson.toJson(jsonData);
        System.out.println("From Map: " + jsonString);


        Person person = gson.fromJson(jsonString, Person.class);

        System.out.println("From Person.class: " + gson.toJson(person));
    }

    class Person {
        public final String name;
        public final String place;
        private final List<String> interests;

        public Person(String name, String place, List<String> interests) {
            this.name = name;
            this.place = place;
            this.interests = interests;
        }

        public List<String> interests(){
            return Collections.unmodifiableList(interests);
        }
    }
}