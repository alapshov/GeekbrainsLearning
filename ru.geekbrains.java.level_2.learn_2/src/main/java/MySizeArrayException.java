public class MySizeArrayException extends ArrayIndexOutOfBoundsException {
    private String message;

    public MySizeArrayException(String message) {
        this.message = message;
    }

    @Override
    public void printStackTrace() {
        System.err.println(message);
    }

}
