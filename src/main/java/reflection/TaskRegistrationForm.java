package reflection;

// класс для тестирования аннотаций и класса Validator
// данные регистрации задачи в трекере
public class TaskRegistrationForm {

    @MinMaxLength(minLength = 6, maxLength = 250)
    private String name;

    @NotEmpty
    private String description;

    @Min(0)
    @Max(100)
    private int completionPercent;

    private String author;

    @Min(0)
    private double cost;

    @NotEmpty
    private int priority;

    public TaskRegistrationForm(String name, String description, int completionPercent, String author, int cost, int priority) {
        this.name = name;
        this.description = description;
        this.completionPercent = completionPercent;
        this.author = author;
        this.cost = cost;
        this.priority = priority;
    }

    public static void main(String[] args) {
        Validator validator = new Validator();

        TaskRegistrationForm task1 = new TaskRegistrationForm(
                "W0153_13",
                "Разработка класса Validator",
                50,
                "Буйлин",
                180,
                1);
        try {
            validator.validate(task1); // нет ошибок
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в task1: " + e.getMessage());
        }

        TaskRegistrationForm task2 = new TaskRegistrationForm(
                "W01534567",
                "000",
                147,
                "Буйлин",
                -100,
                0);
        try {
            validator.validate(task2); // ошибки по всех контролируемых полях
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в task2: " + e.getMessage());
        }

        TaskRegistrationForm task3 = new TaskRegistrationForm(
                "Task".repeat(100),
                null,
                -5,
                "Буйлин",
                -10,
                0);
        try {
            validator.validate(task3); // другие ошибки по всех контролируемых полях
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка в task3: " + e.getMessage());
        }
    }
}
