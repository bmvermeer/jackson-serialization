package nl.brianvermeer.example.jackson.serialization;

public class Tea extends HotDrink {
    @Override
    public String toString() {
        return String.format("Tea{name='%s'}", name);
    }
}