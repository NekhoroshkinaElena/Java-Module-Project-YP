import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("На скольких человек необходимо разделить счёт?");
        int numberOfPersons = getPersonNum(scanner);

        Calculate calculate = new Calculate();
        createNewProducts(scanner, calculate);

        double sum = calculate.getSumForEveryHuman(numberOfPersons);

        System.out.printf("Добавленные товары: \n%s\nКаждый человек должен заплатить по: %.2f %s",
                calculate.allProducts, sum, Formatter.getRubleInTheCorrectCase(sum));
        scanner.close();
    }

    public static int getPersonNum(Scanner scanner) {
        while (true) {
            int numberOfPersons = Utils.parseStringToInteger(scanner.next());
            if (numberOfPersons == 1) {
                System.out.println("Нет необходимости считать сумму на одного гостя. " +
                        "Пожалуйста повторите ввод.");
            } else if (numberOfPersons <= 0) {
                System.out.println("Некорректный ввод. Пожалуйста повторите попытку.");
            } else {
                return numberOfPersons;
            }
        }
    }

    public static void createNewProducts(Scanner scanner, Calculate calculate) {
        while (true) {
            System.out.println("Для добавления товара введите любой символ, " +
                    "для завершения добавления товаров введите \"завершить\"");
            String userInput = scanner.next();
            if (userInput.equalsIgnoreCase("завершить")) {
                break;
            } else {
                System.out.println("Введите название товара");
                scanner.nextLine();
                String productName = scanner.nextLine();

                System.out.println("Введите стоимость товара. Стоимость должна быть в формате" +
                        " рубли.копейки, например 10.45 или 11.40.");
                double productPrice;
                while (true) {
                    productPrice = Utils.parseStringToDouble(scanner.next());
                    if (productPrice <= 0) {
                        System.out.println("Некорректный ввод. Пожалуйста повторите попытку.");
                    } else {
                        break;
                    }
                }
                calculate.addProduct(new Product(productName, productPrice));
            }
        }
    }
}
