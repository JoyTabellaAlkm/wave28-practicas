package documents;

import printer.IPrintable;

public class BookInPdf implements IPrintable {
    private int pages;
    private String author;
    private String title;
    private String genre;

    public BookInPdf(int numberOfPages, String authorName, String title, String genre) {
        this.pages = numberOfPages;
        this.author = authorName;
        this.title = title;
        this.genre = genre;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return " numberOfPages=" + pages +
                ", authorName='" + author + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'';
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo libro: " + this);
    }
}
