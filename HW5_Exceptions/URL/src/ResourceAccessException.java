public class ResourceAccessException extends Exception{

    @Override
    public String toString() {
        return "Произошла ошибка! Нет доступа к указанному ресурсу!";
    }
}
