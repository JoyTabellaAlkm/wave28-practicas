package documents;

import printer.IPrintable;

public class Report implements IPrintable {
    private String text;
    private int pages;
    private String author;
    private String reviewer;

    public Report(String text, int pages, String author, String reviewer) {
        this.text = text;
        this.pages = pages;
        this.author = author;
        this.reviewer = reviewer;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public String toString() {
        return " text='" + text + '\'' +
                ", numberOfPages='" + pages + '\'' +
                ", author='" + author + '\'' +
                ", reviewer='" + reviewer + '\'';
    }

    @Override
    public void print() {
        System.out.println("Imprimiendo informe: " + this);
    }
}
