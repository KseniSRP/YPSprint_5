import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm(new ArrayList<>());
        farm.addAnimal(Animal.DOG, "Rex");
        farm.addAnimal(Animal.CAT);
        farm.addAnimal("Bella");
        System.out.println(farm.getFarmAnimals());
    }
}