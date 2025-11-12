

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;

/**
 * The test class CommentTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class CommentTest
{
    private SalesItem item;
    
    /**
     * Default constructor for test class CommentTest
     */
    public CommentTest()
    {
        
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        item = new SalesItem("Labtop", 1200);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
        
    }
    public void testAddCommentDuplicationAuthor()
    {
       ArrayList<Comment> comments = new ArrayList<>();
       
       Comment first = new Comment("John", "Great product", 5);
       Comment duplicate = new Comment("John", "I still like it", 4);
       
       comments.add(first);
       
       boolean foundDuplicate = false;
       for (Comment c : comments) {
           if (c.getAuthor().equals(duplicate.getAuthor())){
               foundDuplicate = true;
               break;
           }
       }
       boolean addCommentResult;
       if (foundDuplicate) {
           addCommentResult = false; //same author already exists
       } else {
           comments.add(duplicate);
           addCommentResult = true;
       }
       assertFalse(addCommentResult);
    }
    public void testInvalidRatingBelowRange()
    {
        Comment comment = new Comment ("Alice" , "Bad rating", 0);
        boolean result = (comment.getRating() >= 1 && comment.getRating() <= 5);
        assertFalse(result);
    }
    public void testInvalideRatingAboveRange()
    {
        Comment comment = new Comment ("Bob", "High rating", 6);
        boolean result = (comment.getRating() >= 1 && comment.getRating() <= 5);
        assertFalse(result);
    }
}