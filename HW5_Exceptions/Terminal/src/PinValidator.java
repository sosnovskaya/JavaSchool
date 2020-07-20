import java.util.Scanner;

public class PinValidator {

    private boolean isValid = false;

    private TerminalServer server;

    public PinValidator(TerminalServer server) {
        this.server = server;
    }

    public boolean validate() throws TerminalException.WrongPinFormat, TerminalException.AccountIsLockedException{
        if(isValid)
            return true;
        int tries = 3;
        while(true) {
            while(tries > 0) {
                System.out.println("Введите pin :");
                Scanner scanner = new Scanner(System.in);
                String pin = scanner.nextLine();
                if (pin.length() != 4){
                    throw new TerminalException.WrongPinFormat();
                }
                else if(pin.equals(server.getPin())){
                    isValid = true;
                    return true;
                }
                tries--;
                System.out.println("Неврный pin!" + tries + " попыток осталось.");
            }
            if(tries == 0){
                server.block();
                throw new TerminalException.AccountIsLockedException();
            }
        }
    }
}
