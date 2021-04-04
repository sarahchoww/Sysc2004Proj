
import java.util.Calendar;
import java.util.Date;

public class Comment {

    private String author;
    private String content;
    private Date time;

    public Comment(String content){
        this("", content);
    }

    public Comment(String author, String content){
        this.author = author;
        this.content = content;
        time.getTime();
    }

}
