public class Main {
   public static void main(String[] args) {

      Post p = new Post("Chris Mascarolls", "Deck the halls.");

      for (int i = 0; i < 32; i++) {
         p.react(0);
      }

      for (int i = 0; i < 13; i++) {
         p.react(1);
      }

      p.react(2);

      p.addComment(new Comment("Wanda Nauwittol", "What are your plans?!"));
      p.addComment(new Comment("Jude Alkingtomie", "Yay!"));
      p.addComment(new Comment("Grinch Grinch", "Nope!"));

      p.display();
   }
}