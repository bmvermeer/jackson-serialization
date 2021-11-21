package nl.brianvermeer.example.jackson.serialization;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class Main {

    public static String breakfastJson = """
            {
                "food":"sandwich",
                "drink":["nl.brianvermeer.example.jackson.serialization.Tea",{"name":"oolong"}]
            }
            """;

    public static String secondBreakfastJson = """
            {
                "food":"sandwich",
                "drink":["nl.brianvermeer.example.jackson.serialization.Coffee",{"name":"espresso"}]
            }
            """;

    public static String secondBreakfastJson2 = """
            {
                "food":"sandwich",
                "drink":["nl.brianvermeer.example.jackson.serialization.Gadget", "ls -l"]
            }
            """;


    public static void main(String[] args) throws IOException {
        var om = new ObjectMapper();
        om.enableDefaultTyping();

        var myBreakfast = om.readValue(breakfastJson, Breakfast.class);
        System.out.println("breakfast hotdrink:"+myBreakfast.drink);

        var mySecondBreakfast = om.readValue(secondBreakfastJson, SecondBreakfast.class);
        System.out.println("Second breakfast hotdrink:"+mySecondBreakfast.drink);

        mySecondBreakfast = om.readValue(secondBreakfastJson2, SecondBreakfast.class);
        System.out.println("Second breakfast hotdrink:"+mySecondBreakfast.drink);
    }

    public static void createBreakFast(ObjectMapper om) throws JsonProcessingException {
        var tea = new Tea();
        tea.name = "oolong";

        Breakfast bf = new Breakfast();
        bf.food = "sandwich";
        bf.drink = tea;

        var json = om.writeValueAsString(bf);
        System.out.println(json);
    }

}
