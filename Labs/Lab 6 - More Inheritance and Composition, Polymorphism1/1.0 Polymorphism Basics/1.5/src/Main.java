public class Main {
   public static void main(String[] args) {

      Parent[] parentArray = {
              new Parent("Jim"),
              new Child("Kevin", "Count Seconds"),
              new Child("Jeanine", "Ski"),
              new Parent("Maurice")};

      for (Parent p : parentArray) {
         p.aMethod();
      }
   }
}