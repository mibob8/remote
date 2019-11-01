import java.util.HashMap;
import java.util.ArrayList;
import java.util.Map;
import java.util.Collections;

public class Library {
    public static void main(String[] args) {
        HashMap<String, Integer> booksCounter = createBooksCounter();

        for (String book : BOOKS)
            countBook(booksCounter, book);

        ArrayList<String> whiteRavens = findWhiteRavens(booksCounter);
        printWhiteRavens(whiteRavens);
    }

    private static String[] BOOKS = { "Priests Of Dawn", "Chicken Abroad", "Lord With Sins", "Chicken Abroad",
            "Fish And Horses", "Mistress Of Devotion", "Bandit Of The Void", "Lord With Sins",
            "Guardians And Gangsters", "Lions Of Dread", "Chicken Abroad", "Future Of Fire", "Priests Of Dawn",
            "Fish And Horses", "Chicken Abroad", "Fish And Horses", "Guardians And Gangsters", "Inception Of Heaven",
            "Lord With Sins", "Future Of Fire", "Driving Into The Depths", "Starting The Demons", "Maid With Blue Eyes",
            "Mistress Of Devotion", "Lovers In The Forest", "Fish And Horses", "Maid With Blue Eyes",
            "Destruction Of The Faceless Ones", "Guardians And Gangsters", "Chicken Abroad" };

    public static HashMap<String, Integer> createBooksCounter() {
        HashMap<String, Integer> result = new HashMap<>();

        for (String book : BOOKS)
            result.put(book, 0);

        return result;
    }

    public static void countBook(HashMap<String, Integer> booksCounter, String book) {

        if (booksCounter.containsKey(book)) {

            int currentCount = booksCounter.get(book);
            booksCounter.put(book, ++currentCount);
        }
    }

    public static ArrayList<String> findWhiteRavens(HashMap<String, Integer> booksCounter) {
        ArrayList<String> result = new ArrayList<>();

        for (Map.Entry<String, Integer> book : booksCounter.entrySet()) {

            String bookTitle = book.getKey();
            Integer numberOfCopies = book.getValue();

            if (numberOfCopies == 1)
                result.add(bookTitle);
        }

        return result;
    }

    public static void printWhiteRavens(ArrayList<String> whiteRavens) {

        System.out.println("Białe kruki w bibliotece to:\n");
        Collections.sort(whiteRavens);

        for (String bookTitle : whiteRavens) {
            System.out.println(bookTitle);
        }
    }
}