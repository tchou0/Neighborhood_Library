package org.example;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //Calling the book class
        Book myBooks[] = new Book[5];

        // Five books
        myBooks [0] = new Book(31,
                "J-103576-850",
                "Of Mice and Men",
                false,
                "" );

        myBooks [1] = new Book (61,
                "A-104586-263",
                "Five on a Treasure Island",
                true,
                "Erick");
        myBooks [2] = new Book (47,
                "C-113667-321",
                "Lord of the Rings",
                false,
                "");
        myBooks [3] = new Book (23,
                "B-259386-798",
                "Wonder",
                true,
                "Tou");
        myBooks [4] = new Book (56,
                "Q-165874-281",
                "Great Expectations",
                false,
                "");

        //Create a loop until the user wants to quit the program
        do{
            // a list of options tha  t a user can choose from
            System.out.println("Hi this is Neighborhood Library\nPlease choose an option: \n" +
                    "1. Show Available Books\n" +
                    "2. Show Checked Out Books\n" +
                    "3. Exit-close out of the application");

            // Asking the user to type an option
            int userOption = scanner.nextInt();

            // if the person chooses 1
            if( userOption == 1){
                availableBooks(myBooks);

                System.out.println("Do you want to:\nC - Check out\nX - Main menu");
                String input = scanner.next();

                if(input.equalsIgnoreCase("c")){
                    // Ask and Get answer
                    System.out.println("Which book do you want to choose? Please type the book ID:");
                    int userBookId = scanner.nextInt();

                    for (int i = 0; i < myBooks.length; i++){
                        if(myBooks[i].getId() == userBookId){
                            if(myBooks[i].getIsCheckedOut() == false){
                                System.out.println("You selected: " + myBooks[i].getTitle() +
                                        "\nPlease type your name: ");
                                String personName = scanner.next();
                                myBooks[i].checkOut(personName);
                                System.out.printf(
                                        "\nId: %d" +
                                                "\nISBN: %s" +
                                                "\nTitle: %s" +
                                                "\nChecked out to: %s\n",
                                        myBooks[i].getId(),myBooks[i].getIsbn(),myBooks[i].getTitle(),
                                        myBooks[i].getCheckedOutTo());
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
                else if(input.equalsIgnoreCase("x")){
                    System.out.println("\nPlease type x to confirm");
                    continue;
                }
                else{
                    return;
                }
            }
            else if (userOption == 2) {
                booksCheckedOut(myBooks);

                //OPTION 'C' - CHECK IN A BOOK || OPTION 'X' GO TO MAIN MENU
                System.out.println("Would you like to:\nC - Check in a book\nX - Main menu\n");
                String checkOrMainMenu = scanner.next();

                if(checkOrMainMenu.equalsIgnoreCase("c")){
                    System.out.println("\nPlease type the Book ID you would like to check in:");

                    int bookNumber = scanner.nextInt();

                    for (int i = 0; i < myBooks.length; i++){
                        if(bookNumber == myBooks[i].getId()){
                            if(myBooks[i].getIsCheckedOut() == true){
                                myBooks[i].checkIn();
                            }
                        }
                    }
                }
                else if(checkOrMainMenu.equalsIgnoreCase("x")){
                    System.out.println("\nPlease type x to confirm");
                    continue;
                }
                else{
                    System.out.println("\nPlease type the correct option");
                }
            }
            else if(userOption == 3){
                System.out.println("\nThank you! Have a Great day! :D");
                return;
            }
            else{
                System.out.println("\nPlease type the correct option");
            }
            System.out.println("\nIf you would like to return to the main menu, Type x\n" +
                    "Type anything else to exit\n");
        }while(scanner.next().equalsIgnoreCase("x"));
        scanner.close();
    }
    //create a new method for available book in library
    public static void availableBooks(Book books[]){
        for(int i = 0; i < books.length; i++){
            if(books[i].getIsCheckedOut() == false){
                System.out.printf("\nBook %d" +
                                "\nId: %d" +
                                "\nISBN: %s" +
                                "\nTitle: %s\n\n",
                        (i + 1),books[i].getId(),books[i].getIsbn(),books[i].getTitle());
            }
        }
    }
    public static void booksCheckedOut(Book books[]){
        for(int i = 0; i < books.length; i++){
            if(books[i].getIsCheckedOut() == true){
                System.out.printf("\nBook %d" +
                                "\nId: %d" +
                                "\nISBN: %s" +
                                "\nTitle: %s" +
                                "\nChecked out to: %s\n\n",
                        (i + 1),books[i].getId(),books[i].getIsbn(),books[i].getTitle(),books[i].getCheckedOutTo());
            }
        }
    }
}