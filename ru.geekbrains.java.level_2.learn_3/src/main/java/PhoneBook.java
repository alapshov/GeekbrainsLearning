public class PhoneBook {
    private String surname;
    private String phoneNumber;

    public PhoneBook(String surname, String phoneNumber){
        this.surname = surname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "PhoneBook{" +
                "surname='" + surname + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                '}';
    }
}
