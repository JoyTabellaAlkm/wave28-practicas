package Documents;

public class Documents {
    protected String name;
    protected String content;

    public Documents(String name, String content){
        this.name = name;
        this.content = content;
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }
}
