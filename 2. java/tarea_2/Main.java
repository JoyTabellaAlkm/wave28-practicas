
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

public class Main {
  
  // id, name, description
  static int[] id_category = {0, 1, 2};
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

  // methods 
  static void show_categories(){
    System.out.println("CATEGORIES FOR OUR MARATHONE");
      System.out.println("==================================================================");
    for(int i = 0; i < 3; ++i){
      System.out.println(i + "name: " + name_category[i]);
      System.out.println("Description: ");
      System.out.println("Distance: " + distance[i]);
      System.out.println("Forest: " + forest[i]);
      System.out.println("River: " + river[i]);
      System.out.println("Mud: " + mud[i]);
      System.out.println("Rocks Climbing: " + rock[i]);
      System.out.println("==================================================================");
    }
  }

  public static void main(String[] args) {
    show_categories();

  }
}
