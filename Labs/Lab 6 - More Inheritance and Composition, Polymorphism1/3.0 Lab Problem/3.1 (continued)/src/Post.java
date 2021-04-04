import java.util.ArrayList;
import java.util.Date;
import java.util.Calendar;
import java.util.HashMap;

/**
 * This document depicts the class Post. It takes in the author's name and the content of the post.
 * It has an array to keep track of the emoji reactions and another ArrayList of type StringIntPair to
 * keep track of the non-emoji reactions.
 * @author Sarah Chow, L3
 */
public class Post {

    private String author;
    private Calendar cal = Calendar.getInstance();
    private Date time = cal.getTime();
    private String content;

    private int reactions[] = {0, 0, 0, 0};
    private String ValidReactions[] = {"=)", "=|", "=(", "=O"};
    private HashMap<String, Integer> wordReacts = new HashMap<>();

    private ArrayList<Comment> comments = new ArrayList<Comment>();

    /**
     * This is a default constructor.
     */
    public Post(){
        this("", "");
    }

    /**
     * This is the constructor for Post. It sets the time of the post.
     * @param author represents the author of the post, String
     * @param content represents the content of the post, String
     */
    public Post(String author, String content){
        this.author = author;
        this.content = content;

        this.time.getTime();

    }

    /**
     * This method prints the post. It displays the author, content, and reactions to the post.
     */
    public void display() {
        /*TODO*/
        String commentStr = "";
        for (int j = 0; j < comments.size(); j++){
            commentStr += this.comments.get(j).print() + "\n";
        }

        String reactStr = "";
        if (this instanceof PollPost){
            PollPost poll = (PollPost)this;
            wordReacts = poll.getWordReacts();

            for(String wordReact : wordReacts.keySet()){
                reactStr += String.format("%s (%d)\n", wordReact, wordReacts.get(wordReact));
            }

        }

        for(int i = 0; i < this.reactions.length; i++){
            reactStr += String.format("%s(%d) ", this.ValidReactions[i], this.reactions[i]);
        }

        String s = String.format(
                "%s on (%s):\n" + "'%s'\n" + "%s\n" + "Comments:\n" + "%s",
                this.author, String.valueOf(this.time),
                this.content, reactStr, commentStr);

        System.out.println(s);
    }

    /**
     * This method adds reactions to the post. It takes in an integer value to increment the emoji reactions.
     * @param reactionInt represents the index of the emoji the user is reacting to, int
     */
    public void react(int reactionInt){
        if (reactionInt >= 0 && reactionInt < 4){
            this.reactions[reactionInt]++;
        }
    }

    /**
     * This method adds comments to the post. It takes in a Comment object that is added to the Comment
     * ArrayList.
     * @param newComment represents the comment to be added to the post, Comment
     */
    public void addComment(Comment newComment){
        comments.add(newComment);
    }

}
