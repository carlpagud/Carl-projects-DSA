import java.util.LinkedList;
import java.util.Collections;
import java.util.Scanner;

public class CASE_STUDY_2 {

    public static void main(String[] args) {

        LinkedList<String> list = new LinkedList<>();

        // 20 names
        list.add("Bea");
        list.add("Ben");
        list.add("Ciao");
        list.add("Daniel");
        list.add("Ethan");
        list.add("Franz");
        list.add("Gab");
        list.add("Hannah");
        list.add("Ivan");
        list.add("James");
        list.add("Kevin");
        list.add("Lara");
        list.add("Maria");
        list.add("Nathan");
        list.add("Olivia");
        list.add("Paolo");
        list.add("Queen");
        list.add("Ryan");
        list.add("Sarah");
        list.add("Trisha");

        Collections.sort(list);

        Scanner scan = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println("       NAME SEARCH SYSTEM");
        System.out.println("=================================");
        System.out.println("Names in the list: " + list.size());
        System.out.println();

        System.out.println("1. Search Name");
        System.out.println("2. Search and Replace");
        System.out.print("Choose an option: ");
        int option = scan.nextInt();
        scan.nextLine();

        System.out.print("\nEnter name to search: ");
        String search = scan.nextLine();

        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).equalsIgnoreCase(search)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            System.out.println("\nName \"" + search + "\" was not found.");
        }
        else {

            System.out.println("\nName found: " + list.get(index));

            if (option == 2) {

                System.out.print("Enter new name: ");
                String replace = scan.nextLine();

                list.set(index, replace);

                Collections.sort(list);

                System.out.println("\nName replaced successfully!");

            }
            else if (option != 1) {
                System.out.println("\nInvalid option.");
            }
        }

        System.out.println("\n=================================");
        System.out.println("          FINAL NAME LIST");
        System.out.println("=================================");

        for (int i = 0; i < list.size(); i++) {
            System.out.println((i + 1) + ". " + list.get(i));
        }
    }
}