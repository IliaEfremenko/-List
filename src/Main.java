import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> cases = new ArrayList<>();

        boolean isRun = true;
        while (isRun) {
            System.out.println("Выберите операцию: ");
            showOptions();
            System.out.print("Ваш выбор: ");
            int optionNumber = Integer.parseInt(scanner.nextLine());
            System.out.println();

            switch (optionNumber) {
                case 0:
                    isRun = false;
                    break;
                case 1:
                    System.out.print("Введите название задачи: ");
                    String name = scanner.nextLine();
                    cases.add(name);
                    System.out.println("Добавлено! ");
                    showCases(cases);
                    break;
                case 2:
                    showCases(cases);
                    break;
                case 3:
                    System.out.print("Введите номер для удаления: ");
                    int number = Integer.parseInt(scanner.nextLine()) - 1;
                    if (number < cases.size() && number > 0) {
                        cases.remove(number);
                        System.out.println("Удалено! ");
                        showCases(cases);
                    } else {
                        System.out.println("Такого номера нет!");
                    }
                    break;
                case 4:
                    System.out.print("Введите задачу для удаления: ");
                    String removeName = scanner.nextLine();
                    if (cases.contains(removeName)) {
                        cases.remove(removeName);
                        System.out.println("Удалено! ");
                    } else {
                        System.out.println("Такого дела нет!");
                    }
                    showCases(cases);
                    break;
                case 5:
                    System.out.print("Введите ключевое слово: ");
                    String verb = scanner.nextLine();
                    for (Iterator<String> it = cases.iterator(); it.hasNext();) {
                        String caseName = it.next();
                        if (caseName.contains(verb)) {
                            it.remove();
                        }
                    }
                    System.out.println("Удалены все дела, в которых присутствовало это слово!");
                    showCases(cases);
            }
        }

        System.out.println("Программа завершена!");
    }

    public static void showCases(List<String> cases) {
        System.out.println("Ваш список дел: ");
        for (int i = 0; i < cases.size(); i++) {
            System.out.println((i + 1) + ". " + cases.get(i));
        }
        System.out.println();
    }

    public static void showOptions() {
        System.out.println("0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить все задачи по ключевому слову");
        System.out.println();
    }
}