public class Author {
    private String name;
    private String active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }

    public Author(String name, String active) {
        this.name = name;
        this.active = active;
    }

    @Override
    public String toString() {
        return "Author{" +
                "name='" + name + '\'' +
                ", active='" + active + '\'' +
                '}';
    }
}
