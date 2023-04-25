package org.example;

public class Book {

    //we are naming our properties to use for our setters and getters
    private int id;
    private String isbn;
    private String title;
    private boolean isCheckedOut;
    private String checkedOutTo;


//=================SETTTERS====================

    //when a person types the id in Library.java, it will go to the setId(parameter)
//The person must type the correct datatype for the parameter
    public void setId(int id){
        this.id = id;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setTitle(String title){
        this.title = title;
    }

    public void setIsCheckedOut(boolean isCheckedOut){
        this.isCheckedOut = isCheckedOut;
    }

    public void setCheckedOutTo(String checkedOutTo){
        this.checkedOutTo = checkedOutTo;
    }


    // =======================GETTERS=============================

    //getters will return the datatype we used for our setters parameter
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean getIsCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }


    //============ CONSTRUCTOR =============
//we will set the variable names that is in the property and it will equal to the parameter
    public Book (int id, String isbn, String title, boolean isCheckedOut, String checkedOutTo ){
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = isCheckedOut;
        this.checkedOutTo = checkedOutTo;
    }



    //============ METHOD TO CHECK OUT THE BOOK================

    //============ Person checking out =============
    public void checkOut(String name){
//we will set the the name from the parameter and use setCheckedOutTo from line 32
        setCheckedOutTo(name);

//We will set the isCheckedOut setter to true from line 28
        setIsCheckedOut(true);
    }

    //========== When a book is checked in ==============
    public void checkIn(){
//when using the method, we will set the setter setCheckedOutTo -> have no name "" (string)
        setCheckedOutTo("");

//we will also set the setter setIsCheckedOut to false; meaning that the book is returned
        setIsCheckedOut(false);
    }

}