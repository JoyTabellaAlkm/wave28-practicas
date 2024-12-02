package Entities;

import Interfaces.IPrintable;

public class PdfBook implements IPrintable {
    private int pagesAmount;
    private String authorName;
    private String title;
    private String genre;

    // CONSTRUCTOR
    public PdfBook(int pagesAmount, String authorName, String title, String genre) {
        this.pagesAmount = pagesAmount;
        this.authorName = authorName;
        this.title = title;
        this.genre = genre;
    }

    // METHODS
    @Override
    public String print() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "PdfBook{" +
                "pagesAmount=" + pagesAmount +
                ", authorName='" + authorName + '\'' +
                ", title='" + title + '\'' +
                ", genre='" + genre + '\'' +
                '}';
    }
}
