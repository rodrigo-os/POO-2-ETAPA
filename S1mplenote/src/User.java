import java.util.ArrayList;
import java.util.Scanner;

public class User {
    private String email;
    private String password;
    private ArrayList<Note> notes = new ArrayList<Note>();
    private int numTrash = 0;
    private int numTags = 0;
    private Trash trash = new Trash(true);
    private Settings settings = new Settings(true, true);

    public User(String email, String password) {
        this.email = email;
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void newNote() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Título:");
        String title = in.nextLine();
        System.out.println("Texto:");
        String text = in.nextLine();
        Note note = new Note(title, text);
        notes.add(note);

        while (true) {
            note.printMenuTag();
            int userOption = in.nextInt();
            if (userOption == 1) {
                numTags++;
                note.newTag();
                break;
            }
            if (userOption == 2) {
                break;
            }
        }
        System.out.println("Anotação criada com sucesso.");
    }

    public void showNote() {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i) != null) {
                System.out.println("-------------------------");
                System.out.println("|" + i + "| Título: " + notes.get(i).getTitle());
                System.out.println("'" + notes.get(i).getText() + "'");
                System.out.println("TAG:" + notes.get(i).getTag().getName());
                System.out.println();
            }
        }
    }

    public void updateNote() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Índice a ser alterado:");
        int indice = in.nextInt();

        if (indice < notes.size()) {
            Note note = notes.get(indice);

            System.out.println("Deseja atualizar o Título?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int titleUpdate = in.nextInt();
            if (titleUpdate > 2 || titleUpdate < 1) {
                System.out.println("Opção invalida!");
                System.out.println();
            }
            if (titleUpdate == 1) {
                System.out.println("Título:");
                String title = in.next();
                note.setTitle(title);
                System.out.println("Título alterado com sucesso.");
                System.out.println();
            }

            System.out.println("Deseja atualizar o Texto?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int textUpdate = in.nextInt();
            if (textUpdate > 2 || textUpdate < 1) {
                System.out.println("Opção invalida!");
                System.out.println();
            }
            if (textUpdate == 1) {
                System.out.println("Texto:");
                String text = in.next();
                note.setText(text);
                System.out.println("Texto alterado com sucesso.");
                System.out.println();
            }
        } else {
            System.out.println("Índice [" + indice + "] não encontrado.");
        }
    }

    public void deleteNote() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        System.out.println("Índice a ser deletado:");
        int indice = in.nextInt();

        if (indice < notes.size()) {
            if (notes.get(indice).getTag().getName() != null) {
                numTags--;
            }
            trash.getNotesTrash().add(notes.get(indice));
            notes.remove(indice);
            numTrash++;
            trash.setEmpty(false);
            trash.setTrashIndex(indice);
            System.out.println("Índice [" + trash.getTrashIndex() + "] apagado.");
        } else {
            System.out.println("Índice [" + trash.getTrashIndex() + "] não encontrado.");
        }
    }

    public void showTrash() {
        for (int i = 0; i < trash.getNotesTrash().size(); i++) {
            if (trash.getNotesTrash().get(i) != null) {
                System.out.println("-------------------------");
                System.out.println("|" + i + "| Título: " + trash.getNotesTrash().get(i).getTitle());
                System.out.println("'" + trash.getNotesTrash().get(i).getText() + "'");
                System.out.println("TAG:" + trash.getNotesTrash().get(i).getTag().getName());
                System.out.println();
            }
        }
    }

    public void clearTrash() {
        trash.setAmountTrash(numTrash);
        trash.emptyTrash();
    }

    public void showTag() {
        for (int i = 0; i < notes.size(); i++) {
            if (notes.get(i) != null) {
                System.out.println("TAG:" + notes.get(i).getTag().getName());
            }
        }
        Tag tag = new Tag(null);
        tag.setNumTags(numTags);
        tag.amountTag();
    }

    public void showSettings() {
        settings.showConfig();
    }

    public void changeSettings() {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");
        boolean changeMenu = true;
        while (changeMenu) {
            System.out.println("Ordenar?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int sortOption = in.nextInt();
            switch (sortOption) {
                case 1:
                    settings.setSort(true);
                    break;

                case 2:
                    settings.setSort(false);
                    break;

                default:
                    System.out.println("Opção invalida!");
                    System.out.println();
                    break;
            }

            System.out.println("Sincronizar?");
            System.out.println("-[1] - Sim");
            System.out.println("-[2] - Não");
            int syncOption = in.nextInt();
            switch (syncOption) {
                case 1:
                    settings.setSync(true);
                    break;

                case 2:
                    settings.setSync(false);
                    break;

                default:
                    System.out.println("Opção invalida!");
                    System.out.println();
                    break;
            }
            changeMenu = false;
        }
    }
}
