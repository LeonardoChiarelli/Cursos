import java.util.Random;
import java.util.ArrayList;

public class RandomWord {
    public static void main(String[] args) {

        ArrayList<String> wordList = new ArrayList<String>();

        for (int i = 0; i < args.length; i++){
            wordList.add(args[i]);
        }

        Random random = new Random();
        int randomIndex = random.nextInt(wordList.size());
        String randomWord = wordList.get(randomIndex);

        System.out.printf("Escolhendo uma palavra aleatória das passadas '%s'\n", randomWord);
    }
}
