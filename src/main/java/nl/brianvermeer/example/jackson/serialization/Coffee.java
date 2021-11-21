package nl.brianvermeer.example.jackson.serialization;

public class Coffee extends HotDrink {
    @Override
    public String toString() {
        return String.format("Coffee{name='%s'}", name);
    }
}
