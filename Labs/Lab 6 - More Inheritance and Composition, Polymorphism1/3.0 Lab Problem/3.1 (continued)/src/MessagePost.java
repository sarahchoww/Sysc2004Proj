/**
 * This class is a subclass of Post. It sets the author and content of the post.
 * @author Sarah Chow, L3
 */
public class MessagePost extends Post {

    /**
     * This is a constructor for MessagePost. It sets the author and content of the post. It calls Post's constructor.
     * @param author represents the author's name, String
     * @param content represents the content of the post, String
     */
    public MessagePost(String author, String content){
        super(author, content);
    }

}
