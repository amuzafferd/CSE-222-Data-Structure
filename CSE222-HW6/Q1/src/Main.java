import java.util.ArrayList;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Random r = new Random();
        ArrayList<Integer> randomNumbers = new ArrayList<>();

        for (int i = 0; i < 14; i++) {
            int random = r.nextInt(100);
            for (int j = 0; j < randomNumbers.size(); j++) {
                while (randomNumbers.get(j) == random)
                    random = r.nextInt(100);
            }
            randomNumbers.add(random);

        }

        for (int i = 0; i < 14; i++) {
            for (int j = 0; j < 14; j++) {
                if(randomNumbers.get(i) < randomNumbers.get(j)){
                    int temp = randomNumbers.get(i);
                    randomNumbers.set(i, randomNumbers.get(j));
                    randomNumbers.set(j, temp);
                }
            }
        }

        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();

        for (int i = 0; i < randomNumbers.size(); i++)
            redBlackTree.add(randomNumbers.get(i));

        System.out.println(redBlackTree.toString());

    }
}
