package Person;

class Main{

    public static void main(String[] args ) {
        Persona employer = new Persona();
        Persona assistent = new Persona("Pepes", 18, "23677614");
        Persona developer = new Persona("Auri", 19, "23787878", 1.67, 70);
        System.out.println(developer);
    }


}