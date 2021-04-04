
import java.util.Calendar;
import java.util.Date;

public class Comment {

    private String author;
    private String content;
    private Calendar cal = Calendar.getInstance();
    private Date time = cal.getTime();


    public Comment(String author, String content){
        this.author = author;
        this.content = content;
        time.getTime();
    }

    public String getAuthor(){
        return this.author;
    }

    public String print() {
        return ("-> \'" + content + "\' - " + author + " (DATE)");
    }
}
