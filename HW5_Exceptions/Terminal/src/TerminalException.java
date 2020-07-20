public class TerminalException extends Exception {

    public static class PinIsNotEntered extends TerminalException{

        @Override
        public String toString() {
            return "Pin не был введен! Выполнение операций недоступно";
        }
    }

    public static class AccountIsLockedException extends TerminalException{

        int ms = 0;

        public AccountIsLockedException() {
        }

        public AccountIsLockedException(int ms) {
            this.ms = ms;
        }

        @Override
        public String toString() {
            if(ms == 0)
                return "Pin был введен неправильно более 3-х раз. Аккаунт был заблокирован на 5 сек.";
            else
                return "Pin был введен неправильно более 3-х раз. До разблокировки " + ms + " секунд.";
        }
    }

    public static class WrongEnterFormat extends TerminalException{

        @Override
        public String toString() {
            return "Неправильный формат ввода! Следуйте инструкции по работе с командами терминала!";
        }
    }

    public static class IsNotMultiple extends TerminalException{

        @Override
        public String toString() {
            return "Введенная сумма не кратна 100. Операция не доступна.";
        }
    }

    public static class WrongPinFormat extends TerminalException{

        @Override
        public String toString() {
            return "Pin это четырхзначный номер. Введенное вами значение неверно.";
        }
    }

    public static class NotEnoughMoney extends TerminalException{

        @Override
        public String toString() {
            return "Pin это четырхзначный номер. Введенное вами значение неверно.";
        }
    }
}



