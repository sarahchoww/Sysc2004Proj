/**
 * This document depicts the class VideoPost. It is a subclass of Post.
 * @author Sarah Chow, L3
 */
public class VideoPost extends Post{
    /**
     * This is a constructor for VideoPost. It sets the author and url of the post. It calls Post's constructor.
     * @param author represents the author of the post, String
     * @param url represnets the URL for the post, String
     */
    public VideoPost(String author, String url){
        super(author, url);
    }

    /**
     * This method displays the post. It overrides the super function and then calls on it.
     */
    public void display(){
        System.out.println("-VIWEWER DISCRETION ADVISED-");
        super.display();
    }

}
