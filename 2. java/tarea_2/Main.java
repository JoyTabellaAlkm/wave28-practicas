
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;
import java.util.function.*;

public class Main {
  
  // id, name, description
  static int[] id_category = {0, 1, 2};
  static int[] pay = {0, 0, 0};
  static String[] name_category = {"Beginner", "Regular", "Grand"};
  static int[] distance = {2, 5, 10};
  static boolean[] forest = {true, true, true};
  static boolean[] river = {true, true, true};
  static boolean[] mud = {false , true, true};
  static boolean[] rock = {false , false, true};

  //0 beginner, 1 medium, 2 advance
  static Set<Integer>[] code = new HashSet[3];// participants number
  static Map<Integer, String>[] names = new HashMap[3];
  static Map<Integer, String>[] dni = new HashMap[3];
  static Map<Integer, String>[] lst_name = new HashMap[3];
  static Map<Integer, String>[] cel = new HashMap[3];
  static Map<Integer, String>[] rh = new HashMap[3];
  static Map<Integer, Integer>[] age = new HashMap[3];
  static Map<Integer, String>[] em_cel = new HashMap[3];//emergency
  static Map<Integer, Integer> category_by_runner = new HashMap<>();

  // methods 
  static void show_categories(){
    System.out.println("CATEGORIES FOR OUR MARATHONE");
      System.out.println("==================================================================");
    for(int i = 0; i < 3; ++i){
      System.out.println(i + "Name: " + name_category[i]);
      System.out.println("Description: ");
      System.out.println("Distance: " + distance[i]);
      System.out.println("Forest: " + forest[i]);
      System.out.println("River: " + river[i]);
      System.out.println("Mud: " + mud[i]);
      System.out.println("Rocks Climbing: " + rock[i]);
      System.out.println("==================================================================");
    }
  }

  static void show_by_category(){
  }

  public static void main(String[] args) {
    show_categories();
    
    //Runners to add ==========================
    int[] codes_add = {26, 16, 3, 21};
    String[] names_add = {"Nicolas", "Mariana", "Oscar", "Luisa"};
    String[] dni_add = {"0001", "0010", "0011", "0100"};
    String[] lst_name_add = {"Arias", "Ramirez", "Sierra", "Arias"};
    String[] cel_add = {"42", "42", "42", "42"};
    String[] rh_add = {"A-", "O+", "B+", "AB"};
    String[] em_cel_add = {"42", "42", "42"};
    int[] age_add = {17, 18, 22, 24};
    //=========================================

    //Runners to delete =======================
    int code_del = 26; //Nicolas will be deleted
    //=========================================

    BiConsumer<Integer, Integer> add_runner = (Integer i, Integer cat) -> {// cat for category
      code[cat].add(codes_add[cat]);
      names[cat].put(codes_add[cat], names_add[cat]);
      lst_name[cat].put(codes_add[cat], lst_name_add[cat]);
      dni[cat].put(codes_add[cat], names_add[cat]);
      cel[cat].put(codes_add[cat], names_add[cat]);
      rh[cat].put(codes_add[cat], rh_add[cat]);
      age[cat].put(codes_add[cat], age_add[cat]);
      em_cel[cat].put(codes_add[cat], em_cel_add[cat]);
    };

    BiFunction<Integer, Integer, Integer> value_pay = (Integer cat, Integer age_cur) -> {
      if(cat == 0){
        return age_cur >= 18 ? 1500 : 1300;
      } else if( cat == 1 ){
        return age_cur >= 18 ? 2300 : 2000;
      }else return 2800;
    };

    //ADDING RUNNERS

    int n = 4;
    for(int i = 0; i < n; ++i){
      add_runner.accept(i, i % 3);
      pay[i % 3] += value_pay.apply(i % 3, age_add[i]);
      category_by_runner.put(codes_add[i], i % 3);
    }

    //SHOW RUNNERS BY CATEGORY
    show_by_category();

    //DELETE Runner
    int id = code_del;
    int is_category = category_by_runner.get(id);
    pay[is_category] -= value_pay.apply(is_category, age[is_category].get(id));
    code[is_category].remove(id);
    names[is_category].remove(id);
    lst_name[is_category].remove(id);
    cel[is_category].remove(id);
    dni[is_category].remove(id);
    rh[is_category].remove(id);
    age[is_category].remove(id);
    em_cel[is_category].remove(id);

    show_by_category();

    //SHOW AMOUNT PAID
    int total = 0;
    for(int i = 0; i < 3; ++i){
      System.out.println("Category id: " + i);
      System.out.println("Amount paid: $" + pay[i]);
      total += pay[i];
    }
    
    System.out.println("Total amount: $" + total);
  }
}
