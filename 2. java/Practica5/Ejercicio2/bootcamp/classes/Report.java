package bootcamp.classes;

public class Report extends Document{
    private String text;
    private Integer pages;
    private String author;
    private String reviewer;

    public Report(String text, Integer pages, String author, String reviewer) {
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

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String title) {
        this.author = title;
    }

    public String getReviewer() {
        return reviewer;
    }

    public void setReviewer(String reviewer) {
        this.reviewer = reviewer;
    }

    @Override
    public void print(){
        System.out.println("Author: " + author);
        System.out.println("Cantidad de páginas: " + pages);
        System.out.println("Revisor: " + reviewer);
        System.out.println("Texto: " + text);
    }
}
