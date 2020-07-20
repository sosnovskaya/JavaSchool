import java.math.BigDecimal;
import java.util.Scanner;

public class Main {

    public static Terminal terminal = new TerminalImpl();
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {

        while (true){
            System.out.println("Выберете одну из предложенных операций");
            String menu =   "|==============================|\n" +
                            "|1: - Проверит состояние счёта.|\n" +
                            "|2: - Снять деньги со счёта.   |\n" +
                            "|3: - Положить деньги на счёт .|\n" +
                            "|==============================|\n" ;
            System.out.println(menu);
            try {
                if (!scanner.hasNextInt()) {
                    throw new TerminalException.WrongEnterFormat();
                }

                int cmd = scanner.nextInt();
                switch (cmd){
                    case 1:
                    BigDecimal res = terminal.checkAccount();
                    if(res != null);
                        System.out.println("Состояние счёта: " + res);
                    break;
                    case 2: terminal.withdrawMoney(enterSum());
                    break;
                    case 3: terminal.putMoney(enterSum());
                    break;
                    default: throw new TerminalException.WrongEnterFormat();
                }
            }
            catch (TerminalException e){
                System.out.println("Ошибка!\n" + e.toString());
            }
        }
    }

    public static BigDecimal enterSum() throws TerminalException.IsNotMultiple, TerminalException.WrongEnterFormat {
        System.out.println("Введите сумму: ");
        if(!scanner.hasNextDouble())
            throw new TerminalException.WrongEnterFormat();
        Double sum = scanner.nextDouble();
        if(Double.compare((sum % 100),0)!= 0)
            throw new TerminalException.IsNotMultiple();
        return new BigDecimal(sum);
    }
}
