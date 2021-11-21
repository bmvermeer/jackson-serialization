package nl.brianvermeer.example.jackson.serialization;

//@JsonTypeInfo(use=JsonTypeInfo.Id.CLASS, include=JsonTypeInfo.As.PROPERTY, property="@class")
public abstract class HotDrink {
    public String name;
}
