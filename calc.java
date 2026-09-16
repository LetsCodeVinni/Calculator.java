import java.util.Scanner;

public class calc {
    static Scanner magic = new Scanner(System.in);

    public static void main(String[] args) throws InterruptedException {
        loadinganimation();
        welcome();

        if (login()) {
            char rpt = 'y';
            while (rpt == 'y') {
                rpt = calculator();
            }
        }
    }

    public static char calculator() throws InterruptedException {
        System.out.print("Zahl 1:  ");
        double z1 = magic.nextDouble();

        System.out.print("Rechenart:  ");
        char operator = magic.next().charAt(0);

        System.out.print("Zahl 2:  ");
        double z2 = magic.nextDouble();

        double e = switch (operator) {
            case '+' -> z1 + z2;
            case '-' -> z1 - z2;
            case '*' -> z1 * z2;
            case '/' -> z1 / z2;
            default -> {
                System.out.println("Unbekannter Operator!");
                yield 0;
            }
        };

        if (operator == '/' && z2 == 0) {
            System.out.println("Kann es sein dass du dumm bist?");
        } else if (operator != '+' && operator != '-' && operator != '*' && operator != '/') {
            System.out.println("Falsche taste bro");
        } else {
            System.out.println("Ergebnis:" + formatResult(e));
        }

        System.out.println("Möchtest du eine weitere Berechnung durchführen? [y/n]");
        return magic.next().charAt(0);
    }

    public static void loadinganimation() throws InterruptedException {
        for (int i = 0; i < 1; i++) {
            System.out.print("\rLoading.   ");
            Thread.sleep(200);
            System.out.print("\rLoading..  ");
            Thread.sleep(200);
            System.out.print("\rLoading... ");
            Thread.sleep(200);
        }
    }

    public static void welcome() {
        System.out.print("\r             \r");
        System.out.println("---------NetaCalc---------");
        System.out.println("Welcome to NetaCalc - A Calculator, sponsored by our Prime Minister Benjamin Netanyahu");
        System.out.println("Please enter your login credentials!");
    }

    public static String formatResult(double value) {
        if (value == Math.floor(value) && !Double.isInfinite(value)) {
            return String.valueOf((long) value);   // ganze Zahl -> ohne Komma
        } else {
            return String.valueOf(value);           // hat Nachkommastellen -> normal
        }
    }

    public static boolean login() {
        System.out.println("Username:");
        String username = magic.next();
        System.out.println("Password:");
        String password = magic.next();

        if (username.equals("test") && password.equals("test")) {
            System.out.println("Login erfolgreich!");
            return true;
        } else {
            System.out.println("Username und Passwort stimmen nicht überein!");
            System.out.println("--------------------------------------------");
            return false;
        }
    }
}