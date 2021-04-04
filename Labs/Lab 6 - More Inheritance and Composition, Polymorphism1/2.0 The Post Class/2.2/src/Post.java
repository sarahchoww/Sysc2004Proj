import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;

// STUDENT NAME
// STUDENT NUMBER
public class Post {

    private String author;
    private Calendar cal = Calendar.getInstance();
    private Date time = cal.getTime();
    private String content;
    private int reactions[] = {0, 0, 0, 0};
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
            commentStr += this.comments.get(j).print() + "\n";
        }

        String s = String.format(
                "%s on (%s):\n" + "'%s'\n" + "=)(%d) =|(%d) =((%d) =O(%d)\n" + "Comments:\n" + "%s",
                this.author, "DATE",
                this.content, this.reactions[0], this.reactions[1],
                this.reactions[2], this.reactions[3], commentStr);


        System.out.println(s);
    }



    public void react(int reactionInt){
        if (reactionInt >= 0 && reactionInt < 4){
            this.reactions[reactionInt]++;
        }
    }


    public void addComment(Comment newComment){
        comments.add(newComment);
    }


}
