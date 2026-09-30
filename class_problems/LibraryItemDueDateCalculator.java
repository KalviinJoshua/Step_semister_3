import java.time.LocalDate;
import java.util.Scanner;

abstract class LibraryItem {
    protected String title;

    LibraryItem(String title) {
        this.title = title;
    }

    abstract LocalDate calculateDueDate(LocalDate currentDate);
}

class Book extends LibraryItem {

    Book(String title) {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(14);
    }
}

class DVD extends LibraryItem {

    DVD(String title) {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(7);
    }
}

class Magazine extends LibraryItem {

    Magazine(String title) {
        super(title);
    }

    @Override
    LocalDate calculateDueDate(LocalDate currentDate) {
        return currentDate.plusDays(3);
    }
}

public class LibraryItemDueDateCalculator {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        sc.nextLine();

        LocalDate currentDate = LocalDate.of(2023, 10, 26);

        LibraryItem[] items = new LibraryItem[n];

        for (int i = 0; i < n; i++) {

            String line = sc.nextLine();

            String type = line.substring(0, line.indexOf(" "));
            String title = line.substring(line.indexOf(" ") + 1);

            title = title.replace("\"", "");

            switch (type) {

                case "BOOK":
                    items[i] = new Book(title);
                    break;

                case "DVD":
                    items[i] = new DVD(title);
                    break;

                case "MAGAZINE":
                    items[i] = new Magazine(title);
                    break;
            }
        }

        for (int i = 0; i < n; i++) {

            LocalDate dueDate = items[i].calculateDueDate(currentDate);

            System.out.println(
                items[i].title + ": " + dueDate
            );
        }

        sc.close();
    }
}