import java.util.ArrayList;
import java.util.Date;

// STUDENT NAME
// STUDENT NUMBER
public class Post {

    private String author;
    private Date time;
    private String content;
    private ArrayList<String> reactions = new ArrayList<>();
    private String ValidReactions[] = {"=)", "=|", "=(", "=O"};

    private ArrayList<Comment> comments = new ArrayList<Comment>();

    public Post(String author, String content){
        this.author = author;
        this.content = content;

        this.time.getTime();


    }

    public void display() {

        /*TODO*/
        String commentStr = "";
        for (int j = 0; j < comments.size(); j++){
            commentStr += "->" + this.comments.get(j) + "\n";
        }

        String s = String.format(
                "%s on (%s):\n" +
                        "'%s'\n" +
                        "=)(%d) =|(%d) =((%d) =O(%d)\n" +
                        "Comments:\n" +
                        "%s"
                , "", "", "", 0, 0, 0, 0, "", this.author, this.time,
                this.content, this.reactions.get(0), this.reactions.get(1),
                this.reactions.get(2), this.reactions.get(3), commentStr);


        System.out.println("hello");

        System.out.println(s);
    }



    public void react(int reactionInt){
        if (reactionInt >= 0 && reactionInt < 4){
            this.reactions.add(ValidReactions[reactionInt]);
        }
    }


    public void addComment(Comment newComment){
        comments.add(newComment);
    }


}
