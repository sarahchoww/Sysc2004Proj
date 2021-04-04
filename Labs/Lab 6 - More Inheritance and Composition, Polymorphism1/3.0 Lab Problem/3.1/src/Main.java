public class Main {
   public static void main(String[] args) {

      PostWall wall = new PostWall();

      Post p = new Post("Chris Mascarolls", "Deck the halls.");
      Post p2 = new Post("Sarah", "im tired.");
      wall.addPost(p);
      wall.addPost(p2);

      for (int i = 0; i < 32; i++) {
         p.react(0);

         if (i % 2 == 0){
            p2.react(2);
         }
      }

      for (int i = 0; i < 13; i++) {
         p.react(1);

         if (i % 3 == 0){
            p2.react(4);
         }
      }

      p.react(2);

      p.addComment(new Comment("Wanda Nauwittol", "What are your plans?!"));
      p.addComment(new Comment("Jude Alkingtomie", "Yay!"));
      p.addComment(new Comment("Grinch Grinch", "Nope!"));

      p2.addComment(new Comment("user123", "agreed"));
      p2.addComment(new Comment("user987", "me too"));



      wall.generate();



   }
}