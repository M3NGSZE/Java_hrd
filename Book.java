public class Book {
    private int id ;
    private String title;
    private  Author author;
    private int published;
    private int status;

    public Book(int id, String title, Author author, int published, int status) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.published = published;
        this.status = status;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public int getPublished() {
        return published;
    }

    public void setPublished(int published) {
        this.published = published;
    }

    public int isStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", author=" + author +
                ", published=" + published +
                ", status=" + status +
                '}';
    }
}
