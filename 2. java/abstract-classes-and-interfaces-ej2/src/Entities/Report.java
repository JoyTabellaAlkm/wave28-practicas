package Entities;

import Interfaces.IPrintable;

public class Report implements IPrintable {
    private int textLength;
    private int pagesAmount;
    private String author;
    private String reviewer;

    // CONSTRUCTORS
    public Report(int textLength, int pagesAmount, String author, String reviewer) {
        this.textLength = textLength;
        this.pagesAmount = pagesAmount;
        this.author = author;
        this.reviewer = reviewer;
    }

    // METHODS
    @Override
    public String print() {
        return this.toString();
    }

    @Override
    public String toString() {
        return "Report{" +
                "textLength=" + textLength +
                ", pagesAmount=" + pagesAmount +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'' +
                '}';
    }
}
