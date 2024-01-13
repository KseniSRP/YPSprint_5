import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

class AnimalFarm {
    private List<String> farmAnimals;

    public AnimalFarm(List<String> farmAnimals) {
        this.farmAnimals = farmAnimals;
    }

    /**
     * Метод для подсчета количества каждого вида животных на ферме.
     * Проходит по списку farmAnimals, разделяет каждую строку на вид животного и имя,
     * затем увеличивает счетчик для соответствующего вида в HashMap.
     * Если строка содержит неверное название вида животного, выводит сообщение об ошибке
     * и учитывает это как NOT_DEFINED.
     * @return HashMap<Animal, Integer> - хеш-карта с подсчетом животных по видам.
     */
    public HashMap<Animal, Integer> countedAnimals() {
        HashMap<Animal, Integer> count = new HashMap<>();
        for (String entry : farmAnimals) {
            String[] parts = entry.split(" ");
            try {
                Animal animal = Animal.valueOf(parts[0]);
                count.put(animal, count.getOrDefault(animal, 0) + 1);
            } catch (IllegalArgumentException e) {
                System.out.println("Please correct string [" + entry + "]. Incorrect input data.");
                count.put(Animal.NOT_DEFINED, count.getOrDefault(Animal.NOT_DEFINED, 0) + 1);
            }
        }
        return count;
    }

    /**
     * Метод для получения уникальных имен животных на ферме.
     * Проходит по списку farmAnimals и добавляет второе слово (имя животного) в HashSet,
     * если оно присутствует. Если второго слова нет, выводит сообщение об ошибке.
     * @return Set<String> - множество уникальных имен животных.
     */
    public HashSet<String> uniqueNames() {
        HashSet<String> names = new HashSet<>();
        for (String entry : farmAnimals) {
            String[] parts = entry.split(" ");
            if (parts.length < 2) {
                System.out.println("Please correct string [" + entry + "]. Incorrect input data.");
            } else {
                names.add(parts[1]);
            }
        }
        return names;
    }

    // Добавление животного по виду и имени
    public void addAnimal(Animal type, String name) {
        farmAnimals.add(type.name() + " " + name);
    }

    // Добавление животного по виду
    public void addAnimal(Animal type) {
        farmAnimals.add(type.name() + " N");
    }

    // Добавление животного по имени
    public void addAnimal(String name) {
        farmAnimals.add(Animal.NOT_DEFINED.name() + " " + name);
    }

    public List<String> getFarmAnimals() {
        return farmAnimals;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (String animal : farmAnimals) {
            sb.append(animal).append("\n");
        }
        return sb.toString();
    }
}

