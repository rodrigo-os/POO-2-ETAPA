import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static ArrayList<User> users = new ArrayList<User>();
    static boolean mainMenu = true;
    static boolean login = false;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        in.useDelimiter("\r?\n");

        while (mainMenu) {
            printLoginMenu();
            int userOption = in.nextInt();
            switch (userOption) {
                case 1:
                    String registerEmail;
                    String registerPassword;
                    System.out.println("Email: ");
                    registerEmail = in.next();
                    System.out.println("Senha: ");
                    registerPassword = in.next();
                    in.nextLine();
                    int i;
                    int menuOption = 0;

                    for (i = 0; i < users.size(); i++) {
                        if (registerEmail.contentEquals(users.get(i).getEmail()) && registerPassword.contentEquals(users.get(i).getPassword())) {
                            User user = users.get(i);
                            System.out.println("Bem-vindo ao S1mplenote");
                            login = true;
                            while (login) {
                                printMenu();
                                menuOption = in.nextInt();
                                in.nextLine();
                                switch (menuOption) {
                                    case 1:
                                        boolean noteMenu = true;
                                        while (noteMenu) {
                                            printNoteMenu();
                                            int noteOption = in.nextInt();
                                            in.nextLine();
                                            switch (noteOption) {
                                                case 1:
                                                    user.newNote();
                                                    break;

                                                case 2:
                                                    user.showNote();
                                                    break;

                                                case 3:
                                                    user.updateNote();
                                                    break;

                                                case 4:
                                                    user.deleteNote();
                                                    break;

                                                case 5:
                                                    noteMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 2:
                                        boolean trashMenu = true;
                                        while (trashMenu) {
                                            printTrashMenu();
                                            int trashOption = in.nextInt();
                                            in.nextLine();
                                            switch (trashOption) {
                                                case 1:
                                                    user.showTrash();
                                                    break;

                                                case 2:
                                                    user.clearTrash();
                                                    break;

                                                case 3:
                                                    trashMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 3:
                                        boolean tagMenu = true;
                                        while (tagMenu) {
                                            printTagMenu();
                                            int tagOption = in.nextInt();
                                            in.nextLine();
                                            switch (tagOption) {
                                                case 1:
                                                    user.showTag();
                                                    break;

                                                case 2:
                                                    tagMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 4:
                                        boolean settingsMenu = true;
                                        while (settingsMenu) {
                                            printSettingsMenu();
                                            int settingsOption = in.nextInt();
                                            in.nextLine();
                                            switch (settingsOption) {
                                                case 1:
                                                    user.showSettings();
                                                    break;

                                                case 2:
                                                    user.changeSettings();
                                                    break;

                                                case 3:
                                                    settingsMenu = false;
                                                    break;

                                                default:
                                                    System.out.println("Op????o invalida!");
                                                    break;
                                            }
                                        }
                                        break;

                                    case 5:
                                        login = false;
                                        break;

                                    default:
                                        System.out.println("Op????o invalida!");
                                        break;
                                }
                            }
                        }
                    }
                    if (i == users.size() && menuOption != 5) {
                        System.out.println("Seu e-mail ou senha informados s??o inv??lidos - Tente novamente.");
                    }
                    break;

                case 2:
                    System.out.println("Email para cadastro: ");
                    String email = in.next();
                    System.out.println("Senha para cadastro: ");
                    String password = in.next();
                    User user = new User(email, password);
                    users.add(user);
                    System.out.println("Cadastro realizado com sucesso!");
                    break;

                case 3:
                    mainMenu = false;
                    break;

                default:
                    System.out.println("Op????o invalida!");
                    break;
            }
        }
        System.out.println("At?? a pr??xima.");
        in.close();
    }

    static void printLoginMenu() {
        System.out.println("---------------------");
        System.out.println("-[1] - Fa??a seu login");
        System.out.println("-[2] - Cadastre-se");
        System.out.println("-[3] - Sair");
        System.out.println("---------------------");
    }

    static void printMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Anota????es");
        System.out.println("-[2] - Lixeira");
        System.out.println("-[3] - Tags");
        System.out.println("-[4] - Configura????es");
        System.out.println("-[5] - Sair");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printNoteMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Nova anota????o");
        System.out.println("-[2] - Mostrar anota????es");
        System.out.println("-[3] - Atualizar anota????o");
        System.out.println("-[4] - Apagar anota????o");
        System.out.println("-[5] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printTrashMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar Lixeira");
        System.out.println("-[2] - Esvaziar lixeira  ");
        System.out.println("-[3] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printTagMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar TAGS");
        System.out.println("-[2] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }

    static void printSettingsMenu() {
        System.out.println("-------------------------");
        System.out.println("-[1] - Mostrar configura????es");
        System.out.println("-[2] - Alterar configura????es");
        System.out.println("-[3] - Fechar");
        System.out.println("-------------------------");
        System.out.println("Digite sua op????o:");
    }
}