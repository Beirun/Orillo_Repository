import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;
public class Agogoy {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        int choice = 0, element = 0, index = 0;
        Scanner sc = new Scanner(System.in);
        System.out.println(Arrays.toString(arr));
        while (choice != 6) {
            try {
                System.out.print("\n1. Insert an element at the beginning.\n2. Insert an element at the end.\n3. Delete an element from a specific position." +
                        "\n4. Search for an element and return its index.\n5. Update an element at a specific position.\n6. Exit\nEnter choice: ");
                choice = sc.nextInt();

                if (choice == 1 || choice == 2 || choice == 4 || choice == 5) {
                    System.out.print("\nEnter element: ");
                    element = sc.nextInt();
                }
                if (choice == 3 || choice == 5) {
                    while (true) {
                        if (choice == 3) System.out.println();
                        System.out.print("Enter index: ");
                        index = sc.nextInt();
                        if (index < arr.length && index >= 0) break;
                        System.out.println("Invalid index!");
                    }
                }
            }catch (InputMismatchException e){
                System.out.println("Invalid!");
                sc.nextLine();
                continue;
            }
            if (choice==1) arr = insertElement(arr, element, choice);
            else if (choice==2) arr = insertElement(arr, element, choice);
            else if (choice==3) arr = deleteElement(arr, index);
            else if (choice==4) searchElement(arr, element);
            else if (choice==5) arr[index] = element;
            if(choice<6 && choice>0)System.out.println("\nUpdated Array: "+Arrays.toString(arr)+".");
        }
    }
    static int[] insertElement(int[] arr, int element, int choice){
        int[] tempArr = new int[arr.length+1];
        if(choice==1){
            tempArr[0] = element;
            for (int i = 0; i < arr.length; i++) tempArr[i+1] = arr[i];
        } else {
            tempArr[tempArr.length-1] = element;
            for (int i = arr.length-1; i >= 0; i--) tempArr[i] = arr[i];
        }
        return tempArr;
    }
    static int[] deleteElement(int[] arr, int index){
        int[] tempArr = new int[arr.length-1];
        for (int i = 0, j = 0; i<arr.length; i++) if(i!=index) tempArr[j++] = arr[i];
        return tempArr;
    }
    static void searchElement(int[] arr, int element){
        int[] indexes = new int[arr.length];
        int indexCounter = 0;
        for (int i = 0; i < arr.length; i++) if(element==arr[i]) indexes[indexCounter++] = i;
        if(indexCounter!=0) {
            System.out.print("\n"+element+" is at index: ");
            for(int i = 0; i<indexCounter; i++) {
                if (i!=0) System.out.print(", ");
                System.out.print(indexes[i]);
            } System.out.println();
        } else System.out.println("No element found!");
    }
}