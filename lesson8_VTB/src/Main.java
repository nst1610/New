import java.util.Comparator;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//  1. Создайте массив с набором слов, и с помощью Stream API найдите наиболее часто
//  встречающееся;
//  2. Создайте массив объектов типа Сотрудник (с полями Имя, Возраст, Зарплата) и вычислите
//  среднюю зарплату сотрудника;
//  3. Напишите метод, способный найти в массиве сотрудников из п. 2 найдите N самых старших
//  сотрудников и отпечатает в консоль сообщение вида "N самых старших сотрудников зовут:
//  имя1, имя2, имяN;".

public class Main {
    public static void main(String[] args) {
        String[] words = {"cat", "dog", "frog", "cat", "lion", "cat", "dog"};
        String result = Stream.of(words)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()))
                .entrySet()
                .stream()
                .max(Comparator.comparingLong(w -> w.getValue()))
                .get()
                .getKey();
        System.out.println(result);

        Employee[] staff = {
                new Employee("A", 20, 30000),
                new Employee("B", 42, 120000),
                new Employee("C", 34, 84000),
                new Employee("D", 28, 90000),
                new Employee("E", 40, 50000)
        };

        System.out.println(averageSalary(staff));

        System.out.println(nOldest(4, staff));

    }

    public static double averageSalary(Employee[] staff){
        double result = Stream.of(staff)
                .mapToDouble(e -> e.getSalary())
                .average()
                .getAsDouble();
        return result;
    }

    public static String nOldest(int n, Employee[] staff){
        String result = Stream.of(staff)
                .sorted((e1, e2) -> e2.getAge() - e1.getAge())
                .limit(n)
                .map((Function<Employee, String>) e -> e.getName())
                .collect(Collectors.joining(", ", n + " самых старших сотрудников зовут: ", "."));
        return result;
    }
}

