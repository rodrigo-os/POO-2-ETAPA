import java.util.Scanner;

public class Note {
    private String title;
    private String text;
    private Tag tag = new Tag(null);

    public Note(String title, String text) {
        this.title = title;
        this.text = text;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public void newTag() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Nome:");
        String name = in.next();
        tag.setName(name);
    }

    public void printMenuTag() {
        System.out.println("Deseja inserir uma tag?");
        System.out.println("--------------------");
        System.out.println("-[1] - Sim");
        System.out.println("-[2] - Não");
        System.out.println("--------------------");
        System.out.println("Digite sua opção:");
    }
}