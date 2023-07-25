public class Formatter {

    public static String getRubleInTheCorrectCase(double ruble) {
        int number = (int) Math.floor(ruble);
        int i = number % 100 / 10;
        if (i == 1) {
            return " рублей";
        }
        switch (number % 10) {
            case 1:
                return " рубль";
            case 2:
            case 3:
            case 4:
                return " рубля";
            default:
                return " рублей";
        }
    }
}
