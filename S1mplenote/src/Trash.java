import java.util.ArrayList;

public class Trash {
    private int trashIndex;
    private int amountTrash = 0;
    private boolean empty = true;
    private ArrayList<Note> notesTrash = new ArrayList<Note>();

    public Trash(boolean empty) {
        this.empty = empty;
    }

    public int getTrashIndex() {
        return trashIndex;
    }

    public void setTrashIndex(int trashIndex) {
        this.trashIndex = trashIndex;
    }

    public int getAmountTrash() {
        return amountTrash;
    }

    public void setAmountTrash(int amountTrash) {
        this.amountTrash = amountTrash;
    }

    public boolean getEmpty() {
        return empty;
    }

    public void setEmpty(boolean empty) {
        this.empty = empty;
    }

    public ArrayList<Note> getNotesTrash() {
        return notesTrash;
    }

    public void setNotesTrash(ArrayList<Note> notesTrash) {
        this.notesTrash = notesTrash;
    }

    public void emptyTrash() {
        for (int i = 0; i < notesTrash.size(); i++) {
            if (notesTrash.get(i).getTitle() != null) {
                notesTrash.remove(i);
                empty = true;
            }
        }
    }
}