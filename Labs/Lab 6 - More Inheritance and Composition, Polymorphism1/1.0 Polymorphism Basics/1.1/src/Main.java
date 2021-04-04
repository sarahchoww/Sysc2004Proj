public class Main {
   public static void main(String[] args) {

      Parent[] parentArray = {new Parent(), new Child(), new Parent()};

      for (Parent p : parentArray) {
         p.aMethod();
      }
   }
}