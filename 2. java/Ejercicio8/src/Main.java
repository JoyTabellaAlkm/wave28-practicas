//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Integer integer1 = 3;
        IntegerSeries integerSeries = new IntegerSeries(integer1);

        for (int index = 0; index < 10; index++){
            System.out.println(integerSeries.next());
        }
    }
}