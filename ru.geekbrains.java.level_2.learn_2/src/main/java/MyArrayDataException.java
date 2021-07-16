public class MyArrayDataException extends NumberFormatException {
    private String message;

    public MyArrayDataException(String message, int i, int j) {
        this.message = message + " Ошибка в я чейке " + i + ", " + j;
    }


    @Override
    public void printStackTrace() {
        System.err.println(message);
    }
}
