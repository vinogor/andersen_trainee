package intrnshp_07_Chat.main;

import intrnshp_07_Chat.client.Client;
import intrnshp_07_Chat.server.Server;

import java.util.Scanner;


/**
 * Стартовая точка программы. Содержит единственный метод main
 *
 * запуск из консоли:
 * java -cp d:\projects\andersen_trainee\target\classes\ intrnshp_07_Chat.main.Main
 *
 *  IP    127.0.0.1   =  «localhost»
 */
public class Main {

    /**
     * Спрашивает пользователя о режиме работы (сервер или клиент) и передаёт
     * управление соответствующему классу
     *
     * @param args
     *            параметры командной строки
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        System.out.println("Запустить программу в режиме сервера или клиента? (S (Server) / C (Client))");
        while (true) {
            char answer = Character.toLowerCase(in.nextLine().charAt(0));
            if (answer == 's') {
                new Server();
                break;
            } else if (answer == 'c') {
                new Client();
                break;
            } else {
                System.out.println("Некорректный ввод. Повторите.");
            }
        }
    }

}
