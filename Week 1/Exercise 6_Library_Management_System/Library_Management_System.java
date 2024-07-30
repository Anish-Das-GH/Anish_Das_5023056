import java.util.Arrays;
import java.util.Scanner;

public class Library_Management_System {

    public static class Book {
        private int bookId;
        private String title;
        private String author;

        public Book(int bookId, String title, String author) {
            this.bookId = bookId;
            this.title = title;
            this.author = author;
        }

        public int getBookId() {
            return bookId;
        }

        public String getTitle() {
            return title;
        }

        public String getAuthor() {
            return author;
        }

        @Override
        public String toString() {
            return "Book{" +
                    "bookId=" + bookId +
                    ", title='" + title + '\'' +
                    ", author='" + author + '\'' +
                    '}';
        }
    }

    public static class BookSearch {

        public static Book linearSearch(Book[] books, String searchTitle) {
            for (Book book : books) {
                if (book.getTitle().equalsIgnoreCase(searchTitle)) {
                    return book;
                }
            }
            return null; // Book not found
        }

        public static Book binarySearch(Book[] books, String searchTitle) {
            int left = 0;
            int right = books.length - 1;

            while (left <= right) {
                int mid = left + (right - left) / 2;
                Book midBook = books[mid];

                int comparison = midBook.getTitle().compareToIgnoreCase(searchTitle);

                if (comparison == 0) {
                    return midBook;
                }

                if (comparison < 0) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }

            return null; // Book not found
        }
    }

    public static void main(String[] args) {
        Book[] books = {
            new Book(1, "A", "ABCD"),
            new Book(2, "B", "EFGH"),
            new Book(3, "C", "ABCD"),
            new Book(4, "D", "IJKL"),
            new Book(5, "E", "PQRS")
        };

        // Sort books by title for binary search
        Arrays.sort(books, (b1, b2) -> b1.getTitle().compareToIgnoreCase(b2.getTitle()));

        Scanner scanner = new Scanner(System.in);
        boolean continueSearching = true;

        while (continueSearching) {
            System.out.println("Library Management System");
            System.out.println("1. Linear Search by Title");
            System.out.println("2. Binary Search by Title");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book Title to search: ");
                    String linearSearchTitle = scanner.nextLine().trim();
                    Book foundBookLinear = BookSearch.linearSearch(books, linearSearchTitle);
                    System.out.println("Linear Search Result: " + (foundBookLinear != null ? foundBookLinear : "Book not found"));
                    break;

                case 2:
                    System.out.print("Enter Book Title to search: ");
                    String binarySearchTitle = scanner.nextLine().trim();
                    Book foundBookBinary = BookSearch.binarySearch(books, binarySearchTitle);
                    System.out.println("Binary Search Result: " + (foundBookBinary != null ? foundBookBinary : "Book not found"));
                    break;

                case 3:
                    continueSearching = false;
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }

        scanner.close();
    }
}
