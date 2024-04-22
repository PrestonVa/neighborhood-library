package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class book {
    public static class Book {
        private int id;
        private String isbn;
        private String title;
        private boolean isCheckedOut;
        private String checkedOutTo;

    public Book(int id, String isbn, String title) {
        this.id = id;
        this.isbn = isbn;
        this.title = title;
        this.isCheckedOut = false;
        this.checkedOutTo = "";
    }

    // Getters and Setters.
    public int getId() {
        return id;
    }

    public String getIsbn() {
        return isbn;
    }

    public String getTitle() {
        return title;
    }

    public boolean isCheckedOut() {
        return isCheckedOut;
    }

    public String getCheckedOutTo() {
        return checkedOutTo;
    }

    // Method to check in the books.
    public void checkIn() {
        if (isCheckedOut) {
            isCheckedOut = false;
            checkedOutTo = "";
            System.out.println("Book checked in successfully.");
        } else {
            System.out.println("This book is already checked in.");
        }
    }
}

private List<Book> inventory;

    public Library() {
        inventory = new ArrayList<>();
        // Initialize inventory with some books
        Book book1 = new Book(1, "10500", "Hunger Games", false, "");
        Book book2 = new Book(2, "10501", "Away", false, "");
        Book book3 = new Book(3, "10502", "Spirited Away", false, "");
        Book book4 = new Book(4, "10503", "Maximus Ride", false, "");
        Book book5 = new Book(1, "10504", "Eclipse", false, "");
        Book book6 = new Book(2, "10505", "Little People", false, "");
        Book book7 = new Book(3, "10506", "Attack on Titans", true, "Timmy");
        Book book8 = new Book(4, "10507", "My Hero Academia", false, "");
        Book book9 = new Book(1, "10508", "FullMetal Alchemist", false, "");

        inventory.add(book1);
        inventory.add(book2);
        inventory.add(book3);
        inventory.add(book4);
        inventory.add(book5);
        inventory.add(book6);
        inventory.add(book7);
        inventory.add(book8);
        inventory.add(book9);
    }

    // Method to show available books
    public void showAvailableBooks() {
        System.out.println("Available books:");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
    }
}

// Method to show checked out books.
public void showCheckedOutBooks() {
    System.out.println("Checked out books: ");
    for (Book book : inventory) {
        if (book.isCheckedOut()) {
            System.outprintln("ID: " + book.getId() + "")
        }
    }
}

// Method to show checked out books.
public void CheckedOutBook(int id, String name) {
    System.out.println("Checked out books:");
    for (Book book : inventory) {
        if (book.getId() == id && !book.isCheckedOut()) {
            book.checkOut(name);
            return;
        }
    }
    System.out.println("Book with ID " + id + " is either not available or already checked out.");
}

// Main Method to run the book store interface.
public static void main(String[] args) {
    Library library = new Library();
    System.out.println("Welcome to the Library!");

    while (true) {
        System.out.println("\nStore Home Screen:");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Exit");

        // Assuming user input is taken as number for simplicity.
        int choice = 0 /* code to take user input */;

        switch (choice) {
            case 1:
                library.showAvailableBooks();
                //Prompt user to select a book to check out or go back to home screen.
                // If user wants to check out, Prompt for their name and call checkOutBook method.
                break;
            case 2:
                library.showCheckedOutBooks();
                // Prompt user for option to check in a book or go to the home screen.
                // If user wants to check in, Prompt for the ID and call checkInBook method.
                break;
            case 3:
                System.out.println("Exiting...");
                System.exit(0);
            default
                System.out.println("Invalid choice. Please enter a valid option.");
        }
    }
}