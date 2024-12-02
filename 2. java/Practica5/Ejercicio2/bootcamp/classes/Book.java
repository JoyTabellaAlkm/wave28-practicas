package bootcamp.classes;

public class Book extends Document {
    private String author;
    private Integer pages;
    private String title;
    private String genre;

    public Book(String author, String title, String genre, Integer pages){
        this.author = author;
        this.title = title;
        this.pages = pages;
        this.genre = genre;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
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
    public void print(){
        System.out.println("Libro: " + title);
        System.out.println("Author: " + author);
        System.out.println("Cantidad de páginas: " + pages);
        System.out.println("Género: " + genre);
    }

}
