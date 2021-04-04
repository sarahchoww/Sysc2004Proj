import java.util.Calendar;
import java.util.Date;

/**
 * This document depicts the class Comment. It holds the comment's author, content, and time.
 * @author Sarah Chow, L3
 */
public class Comment {

    private String author;
    private String content;
    private Calendar cal = Calendar.getInstance();
    private Date time = cal.getTime();


    /**
     * This is the constructor for Comment. It sets the author, content, and time.
     * @param author represents the author of the comment, String
     * @param content represents the content of the comment, String
     */
    public Comment(String author, String content){
        this.author = author;
        this.content = content;
        time.getTime();
    }

    /**
     * This is a getter method for the author attribute.
     * @return a String representing the author's name, String
     */
    public String getAuthor(){
        return this.author;
    }

    /**
     * This returns the comment section of the display of the post.
     * @return a String containing the comment's details, String
     */
    public String print() {
        return ("-> \'" + content + "\' - " + author + " " + String.valueOf(time));
    }
}
