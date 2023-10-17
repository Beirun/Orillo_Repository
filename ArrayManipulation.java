import java.util.Scanner;
import java.util.Arrays;
public class ArrayManipulation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter elements (separate by spacebar): ");
        String string = sc.nextLine();
        String[] arr = string.split(" ");

        System.out.println("Current elements: " + Arrays.toString(arr));

        String[] updatedArray = arr;
        String choiceCheck;
        int choice =0;
        do{
            System.out.println("\nChoose an operation:");
            System.out.println("1. Insert at the beginning");
            System.out.println("2. Insert at the end");
            System.out.println("3. Delete an element");
            System.out.println("4. Search for an element");
            System.out.println("5. Update an element");
            System.out.println("6. Print array");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choiceCheck = sc.nextLine(); // Consume the newline character
            try{
                choice = Integer.parseInt(choiceCheck);
            }catch (Exception e){
                System.out.println("Please only enter a number!");
                continue;
            }
            switch (choice) {
                case 1 -> updatedArray = insertAtBeginning(updatedArray, sc);
                case 2 -> updatedArray = insertAtEnd(updatedArray, sc);
                case 3 -> updatedArray = deleteElement(updatedArray, sc);
                case 4 -> searchElement(updatedArray, sc);
                case 5 -> updatedArray = updateElement(updatedArray, sc);
                case 6 -> System.out.println("Updated elements: " + Arrays.toString(updatedArray));
                case 7 -> System.out.println("Exiting the program.");
                default -> System.out.println("Invalid choice. Please enter a valid option.");
            }
            if(choice>0 && choice<6 && choice!=4) System.out.println("Updated elements: " + Arrays.toString(updatedArray));
        }while(choice != 7);
    }
    public static String[] insertAtBeginning(String[] arr, Scanner sc) {
        String beginningInsert = enterElement(sc);
        String[] insertBeginning = new String[arr.length + 1];
        insertBeginning[0] = beginningInsert;
        System.arraycopy(arr, 0, insertBeginning, 1, arr.length);
        return insertBeginning;
    }
    public static String[] insertAtEnd(String[] arr, Scanner sc) {
        String endInsert = enterElement(sc);
        String[] insertEnd = Arrays.copyOf(arr, arr.length + 1);
        insertEnd[arr.length] = endInsert;
        return insertEnd;
    }
    public static String[] deleteElement(String[] arr, Scanner sc) {
        System.out.println("Elements: " + Arrays.toString(arr));
        int deleteIndex = enterIndex(sc, arr);
        String[] updatedArray = new String[arr.length - 1];
        System.arraycopy(arr, 0, updatedArray, 0, deleteIndex);
        System.arraycopy(arr, deleteIndex + 1, updatedArray, deleteIndex, arr.length - deleteIndex - 1);
        return updatedArray;
    }
    public static void searchElement(String[] arr, Scanner sc) {
        String el = enterElement(sc);
        int[] index = new int[arr.length];
        int counter = 0;
        for (int i = 0; i < arr.length; i++) if (arr[i].equals(el)) index[counter++] = i;
        if(counter!=0) {
            System.out.print("Element " + el + " is at index ");
            for (int i = 0; i < counter; i++) {
                if(i==counter-1 && counter!=1) System.out.print(" and ");
                else if (i!=0) System.out.print(", ");
                System.out.print(index[i]);
            }
            System.out.println();
        } else System.out.println("Element not found.");
    }
    public static String[] updateElement(String[] arr, Scanner sc) {
       arr[enterIndex(sc, arr)] = enterElement(sc);
       return arr;
    }
    public static String enterElement(Scanner sc){
        System.out.print("Enter element: ");
        return sc.nextLine();
    }
    public static int enterIndex(Scanner sc, String[] arr){
        int index = 0;
        do {
            System.out.print("Enter element index: ");
            index = sc.nextInt();
            sc.nextLine();
            if (index> arr.length-1 || index<0) System.out.println("Invalid index.");
        }while (index>arr.length-1 || index<0);
        return  index;
    }
}