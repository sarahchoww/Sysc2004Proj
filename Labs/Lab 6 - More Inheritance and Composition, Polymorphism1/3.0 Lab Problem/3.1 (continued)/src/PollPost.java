import java.util.HashMap;
import java.util.ArrayList;

/**
 * This document depicts the call PollPost. It is a subclass of Post. It has an ArrayList of objects of
 * StringIntPair to keep track of the non-emoji reactions.
 * @author Sarah Chow, L3
 */
public class PollPost extends Post {

    private HashMap<String, Integer> wordReacts = new HashMap<>();

    /**
     * This is a constructor for PollPost. It calls on the super constructor to set the author and question.
     * @param author represents the author of the post, String
     * @param question represents the question of the post, String
     */
    public PollPost(String author, String question, ArrayList<String> unsortedWordReacts){

        super(author, question);

        this.react(unsortedWordReacts);

    }

    /**
     * This method adds the non-emoji reactions to the post. It increments the frequency of existing non-emoji
     * reactions.
     * @param unsortedWorkReacts represents the new reaction to the post, String
     */
    public void react(ArrayList<String> unsortedWorkReacts){
        for (String reaction : unsortedWorkReacts){
            if (wordReacts.containsKey(reaction)){
                wordReacts.put(reaction, wordReacts.get(reaction) + 1);
            }
            else{
                wordReacts.put(reaction, 1);
            }
        }
    }


    /**
     * The method is a getter for the non-emoji reaction ArrayList.
     * @return an ArrayList of type StringIntPair representing the collection of non-emoji reactions.
     */
    public HashMap<String, Integer> getWordReacts(){
        return wordReacts;
    }

}
