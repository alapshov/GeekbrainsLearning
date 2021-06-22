public class Staff {

    private String fio;
    private String position;
    private String email;
    private String phone;
    private String payment;
    private int age;

    public Staff() {

    }

    public Staff(String fio, String position, String email, String phone, String payment, int age) {
        this.fio = fio;
        this.position = position;
        this.email = email;
        this.phone = phone;
        this.payment = payment;
        this.age = age;
    }

    private Staff[] getArrayStaff() {
        return new Staff[]{
                new Staff("Иванов Иван Иванович", "Менеджер", "ivan@avn.ru", "+72512365665", "150 000", 33),
                new Staff("Петров Сергей Сидорович", "Менеджер", "ivan@avn.ru", "+72512365665", "200 000", 41),
                new Staff("Сидоров Виталий Петрович", "Менеджер", "ivan@avn.ru", "+72512365665", "250 000", 40),
                new Staff("Рабинович Инокентий Васильевич", "Менеджер", "ivan@avn.ru", "+72512365665", "350 000", 45),
                new Staff("Янукович Евгений Анатольевич", "Менеджер", "ivan@avn.ru", "+72512365665", "450 000", 42)
        };
    }

    public void printOverFortyYears() {
        for (Staff staff : getArrayStaff()) {
            if (staff.age > 40) {
                System.out.printf("fio: %s, position: %s, email: %s, phone: %s, payment: %s, age: %s \n", staff.fio, staff.position, staff.email, staff.phone, staff.payment, staff.age);
            }
        }
    }

}
