package com.pluralsight;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Library library = new Library();
        System.out.println("Welcome to the library!");
        library.showMenu();
    }
}

class Library {
    public static class Book {
        private final int id;
        private final String isbn;
        private final String title;
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

        // Method to check out the books.
        public void checkOut(String name) {
            if (!isCheckedOut) {
                isCheckedOut = true;
                checkedOutTo = name;
                System.out.println("Book checked out successfully to " + name + ".");
            } else {
                System.out.println("This book is already checked out.");
            }
        }
    }

    private final List<Book> inventory;

    public Library() {
        inventory = new ArrayList<>();
        // Initialize inventory with some books
        Book book1 = new Book(1, "10500", "Hunger Games");
        Book book2 = new Book(2, "10501", "Away");
        Book book3 = new Book(3, "10502", "Spirited Away");
        Book book4 = new Book(4, "10503", "Maximus Ride");
        Book book5 = new Book(1, "10504", "Eclipse");
        Book book6 = new Book(2, "10505", "Little People");
        Book book7 = new Book(3, "10506", "Attack on Titans");
        Book book8 = new Book(4, "10507", "My Hero Academia");
        Book book9 = new Book(1, "10508", "FullMetal Alchemist");

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
            if (!book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle());
            }
        }
    }

    // Method to show checked out books.
    public void showCheckedOutBooks() {
        System.out.println("Checked out books: ");
        for (Book book : inventory) {
            if (book.isCheckedOut()) {
                System.out.println("ID: " + book.getId() + ", ISBN: " + book.getIsbn() + ", Title: " + book.getTitle() + ", Checked Out To: " + book.getCheckedOutTo());
            }
        }
    }

    // Method to check out a book.
    public void checkOutBook(int id, String name) {
        System.out.println("Checking out a book:");
        for (Book book : inventory) {
            if (book.getId() == id && !book.isCheckedOut()) {
                book.checkOut(name);
                return;
            }
        }
        System.out.println("Book with ID " + id + " is either not available or already checked out.");
    }

    // Method to check in a book.
    public void checkInBook(int id) {
        System.out.println("Checking in a book:");
        for (Book book : inventory) {
            if (book.getId() == id && book.isCheckedOut()) {
                book.checkIn();
                return;
            }
        }
        System.out.println("Book with ID " + id + " is either not checked out or doesn't exist.");
    }

    // Method to display menu options
    public void showMenu() {
        System.out.println("\nMenu:");
        System.out.println("1. Show Available Books");
        System.out.println("2. Show Checked Out Books");
        System.out.println("3. Check Out a Book");
        System.out.println("4. Check In a Book");
        System.out.println("5. Exit");
    }
}