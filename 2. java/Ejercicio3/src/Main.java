//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.


public class Main {
    public static void main(String[] args) {
        Person person = new Person();
        Person anotherPerson = new Person("Horus Lupercal", "31", "00000000");
        Person lastPerson = new Person("Robute Guilleman", 32, "00000002", 100.0, 2.10);
        //Person catastrophicPerson = new Person("Horus Lupercal", "31");
        System.out.println(lastPerson.toString());
    }
}
