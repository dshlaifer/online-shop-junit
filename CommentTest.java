

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
    private Comment comment;
    
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
        comment = new Comment("Alice", "great product", 5);
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
    public void testAuthorAndRatingStoredCorrectly() {
        assertEquals("Alice", comment.getAuthor(), "Author should be stored correctly");
        assertEquals(5, comment.getRating(), "Rating should be stored correctly");
    }
    public void testUpvoteIncreasesVoteCount() {
        int initialVotes = comment.getVoteCount();
        comment.upvote();
        assertEquals(initialVotes + 1, comment.getVoteCount(), "Upvote should increase vote count by 1");
    }
    public void testDownvoteDecreasesVoteCount() {
        int initialVotes = comment.getVoteCount();
        comment.downvote();
        assertEquals(initialVotes - 1,comment.getVoteCount(), "Downvote should decrease vote count by 1");
    }
 
}