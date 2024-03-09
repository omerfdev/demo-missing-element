import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class MissingElement {

    public static void main(String[] args) {
        List<Integer> originalList = generateRandomList(100);
        List<Integer> copyList = new ArrayList<>(originalList);
        Random random = new Random();
        copyList.remove(random.nextInt(100));

        int missingElement = findMissingElement(originalList, copyList);
        System.out.println("Missing element: " + missingElement);
    }

    private static List<Integer> generateRandomList(int size) {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            list.add(i);
        }
        Collections.shuffle(list);
        return list;
    }

    private static int findMissingElement(List<Integer> originalList, List<Integer> copyList) {
        return originalList.stream().filter(e -> !copyList.contains(e)).findFirst().get();
    }
}