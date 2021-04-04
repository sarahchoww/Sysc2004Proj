import java.util.ArrayList;

/**
 * This document shows the PostWall class. It handles all the posts. It has an ArrayList of type Post.
 * @author Sarah Chow, L3
 */

public class PostWall{

    private ArrayList<Post> wall = new ArrayList<>();

    /**
     * This is the default constructor.
     */
    public PostWall(){

    }

    /**
     * This method adds a new post to the Post Wall.
     * @param p reprents the post to be added, Post
     */
    public void addPost(Post p){
        wall.add(p);
    }

    /**
     * This method generates the Post Wall. It calls on the post's display method.
     */
    public void generate(){
        for (Post p : wall){
            p.display();
            System.out.println("------------------------------------\n");
        }
    }

}
