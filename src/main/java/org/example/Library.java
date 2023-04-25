package org.example;

import java.util.Scanner;

public class Library {
    public static void main(String[] args) {

//We will call Scanner so we can have the person type their input
        Scanner scanner = new Scanner(System.in);

//Calling the book class and making 5 new books in the array
        //myBooks is our variable name to call our Books class
        Book myBooks[] = new Book[5];

// We will use the constructor in our Books class and create Five books
        //each book will start with some data
        //"new Book" we use to create a book FROM our constructor, MUST HAVE 5 PARAMETERS
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

            // a list of options that a user can choose from -- showing options to user
            System.out.println("Hi this is Neighborhood Library\nPlease choose an option: \n" +
                    "1. Show Available Books\n" +
                    "2. Show Checked Out Books\n" +
                    "3. Exit-close out of the application");


            // Asking the user to type their option
            int userOption = scanner.nextInt();

            // if the person chooses 1, show available books 
            if( userOption == 1){

//created a method to show available books using the mybooks array -> Book myBooks[] (line 13)
                availableBooks(myBooks);   

                //give the user the option to get a book or go back 
                System.out.println("Do you want to:\nC - Check out\nX - Main menu");
                String input = scanner.next();

//if the user typed c, then we will ask information to help them get the book
                if(input.equalsIgnoreCase("c")){

                    // Ask and Get answer
                    System.out.println("Which book do you want to choose? Please type the book ID:");
                    int userBookId = scanner.nextInt();

                    //go through each book and if the user typed the id of the book, check out
                    for (int i = 0; i < myBooks.length; i++){
                        
                        //check to see if the user typed the correct id of the book
                        if(myBooks[i].getId() == userBookId){
                            
                            //if the user typed the correct book, ask for their name and show them the information
                            if(myBooks[i].getIsCheckedOut() == false){
                                System.out.println("You selected: " + myBooks[i].getTitle() +
                                        "\nPlease type your name: ");
                                String personName = scanner.next();

                                //use the checkout method in the Book Class
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
            //if the person wants to return to the main menu, type x again 
            //(this will end the do{} loop and check the while statment to see if it's true)
                else if(input.equalsIgnoreCase("x")){
                    System.out.println("\nPlease type x to confirm");
                    continue;
                }
                else{
                    return;
                }
            }

//if the user did not type 1, and typed 2 we go do this "else if" statement
            else if (userOption == 2) {
                booksCheckedOut(myBooks);//we use the booksCheckedOut method we created in this class

                //OPTION 'C' - CHECK IN A BOOK || OPTION 'X' GO TO MAIN MENU
                System.out.println("Would you like to:\nC - Check in a book\nX - Main menu\n");
                String checkOrMainMenu = scanner.next();

    //if the user typed c, help them return the book back to the library
                if(checkOrMainMenu.equalsIgnoreCase("c")){
                    System.out.println("\nPlease type the Book ID you would like to check in:");

                    int bookNumber = scanner.nextInt();//user input

            //check all the books
                    for (int i = 0; i < myBooks.length; i++){
                    //if the users input matches the correct book id
                        if(bookNumber == myBooks[i].getId()){
                        //we will call the getIsCheckOut() method FROM Book class
                            if(myBooks[i].getIsCheckedOut() == true){
                            //call the checkIn() method FROM the Book class
                                myBooks[i].checkIn(); //check in erases the name and makes it false
                            }
                        }
                    }
                }
            //if user types x, make them confirm to go back to main menu
                else if(checkOrMainMenu.equalsIgnoreCase("x")){
                    System.out.println("\nPlease type x to confirm");
                    continue;
                }
            //if the person types anything else, tell them to type the correct option
                else{
                    System.out.println("\nPlease type the correct option");
                }
            }

//if the user does not pick 1 or 2 and chooses 3 -> end the program
            else if(userOption == 3){
                System.out.println("\nThank you! Have a Great day! :D");
                return;
            }

        //if the person types anything else, tell them to type the correct option
            else{
                System.out.println("\nPlease type the correct option");
            }

//This is the end of all the options, if the person wants to go back to the menu, type x to
//restart the loop and start from line 47 (do{})
            System.out.println("\nIf you would like to return to the main menu, Type x\n" +
                              "Type anything else to exit\n");
        }
//if the user types x, repeat the code from the beginning, if not x, then stop the program
        while(scanner.next().equalsIgnoreCase("x"));

}


//===================== METHODS CREATED ===================================================


    //create a new method for available book in library
    //Book is our datatype so we have access to it, books[] will get the array mybooks[] to access 
    //the information of each book
    public static void availableBooks(Book books[]){ 

        //create a for loop to access each book information
        for(int i = 0; i < books.length; i++){

            //if each book is equal to false (getIsCheckedOut is our boolean from Book class)
            if(books[i].getIsCheckedOut() == false){
                //if == false, then print the information to the user, books that are available
                System.out.printf("\nBook %d" +
                                "\nId: %d" +
                                "\nISBN: %s" +
                                "\nTitle: %s\n\n",
                        (i + 1),books[i].getId(),books[i].getIsbn(),books[i].getTitle());
            }
        }
    }



    //creating a method to check out books (user taking book home)
        public static void booksCheckedOut(Book books[]){

        //check each book and see if the book is NOT in the library (getIsCheckedOut = true)
        for(int i = 0; i < books.length; i++){
            if(books[i].getIsCheckedOut() == true){
                
                //if the book is not in the library, show the information of that book
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
    
                                   
               
       
