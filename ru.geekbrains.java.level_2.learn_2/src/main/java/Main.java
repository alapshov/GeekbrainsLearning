public class Main {
    public static void main(String[] args) {
        ArrayDepositor arrayDepositor = new ArrayDepositor();
        String[][] strings = new String[][]{

                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"},
                {"1", "2", "3", "4", "5"}

        };

        String[][] strings2 = new String[][]{

                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "4"},
                {"1", "2", "3", "asssad"}

        };

        try{
            arrayDepositor.putArray(strings);
        } catch (MySizeArrayException e){
            e.printStackTrace();
        }

        try {
            arrayDepositor.putArray(strings2);
        } catch (MyArrayDataException e){
            e.printStackTrace();
        }


    }
}
