import java.util.ArrayList;

public class Main {
   public static void main(String[] args) {
      PostWall wall = new PostWall();

      MessagePost p = new MessagePost("Chris Mascarolls", "Deck the halls.");
      VideoPost p2 = new VideoPost("Sarah", "im tired. https://www.youtube.com/watch?v=WwzbkaqT8Ow&t=12749s&ab_channel=LoungeVFilms-RelaxingMusicandNatureSounds");

      ArrayList<String> pollReact = new ArrayList<>();
      pollReact.add("tired");
      pollReact.add("awake");
      pollReact.add("tired");

      PollPost p3 = new PollPost("Chow", "Are you tired?", pollReact);

      wall.addPost(p);
      wall.addPost(p2);

      wall.addPost(p3);

      for (int i = 0; i < 32; i++) {
         p.react(0);

         if (i % 2 == 0){
            p2.react(2);
         }

         if (i % 3 == 0){
            p3.react(1);
         }
      }

      for (int i = 0; i < 13; i++) {
         p.react(1);

         if (i % 3 == 0){
            p2.react(3);
         }

         if (i % 2 == 0){
            p3.react(3);
         }
      }

      p.react(2);

      p.addComment(new Comment("Wanda Nauwittol", "What are your plans?!"));
      p.addComment(new Comment("Jude Alkingtomie", "Yay!"));
      p.addComment(new Comment("Grinch Grinch", "Nope!"));

      p2.addComment(new Comment("user123", "agreed"));
      p2.addComment(new Comment("user987", "me too"));

      p3.addComment(new Comment("i_am_tired", "i am so tired"));
      p3.addComment(new Comment("new_user", "i want to sleep"));


      wall.generate();

   }
}