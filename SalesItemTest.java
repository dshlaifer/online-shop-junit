import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 * The test class SalesItemTest.
 *
 * @author  mik
 * @version 0.1
 */
public class SalesItemTest
{
    private SalesItem item;
    private Comment c1, c2, c3;
    /**
     * Default constructor for test class SalesItemTest
     */
    public SalesItemTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @Before
    public void setUp()
    {
        item = new SalesItem("Bluetooth Speaker", 4999);
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @After
    public void tearDown()
    {
    }

    /**
     * Test that a comment can be added, and that the comment count is correct afterwards.
     */
    @Test
    public void testAddComment()
    {
        SalesItem salesIte1 = new SalesItem("Brain surgery for Dummies", 21998);
        assertEquals(true, salesIte1.addComment("James Duckling", "This book is great. I perform brain surgery every week now.", 4));
        assertEquals(1, salesIte1.getNumberOfComments());
    }

    /**
     * Test that a comment using an illegal rating value is rejected.
     */
    @Test
    public void testIllegalRating()
    {
        SalesItem salesIte1 = new SalesItem("Java For Complete Idiots, Vol 2", 19900);
        assertEquals(false, salesIte1.addComment("Joshua Black", "Not worth the money. The font is too small.", -5));
    }

    /**
     * Test that a sales item is correctly initialised (name and price).
     */
    @Test
    public void testInit()
    {
        SalesItem salesIte1 = new SalesItem("test name", 1000);
        assertEquals("test name", salesIte1.getName());
        assertEquals(1000, salesIte1.getPrice());
    }
    public void testFindMostHelpfulCommentNoComments()
    {
        assertNull(item.findMostHelpfulComment());
    }
    public void testFindMostHelpfulCommentHighestRating()
    {
        item.addComment("Alice", "Good sound", 4);
        item.addComment("Bob", "too quiet",2);
        item.addComment("Charlie", "Excellent bass", 5);
        
        Comment mostHelpful = item.findMostHelpfulComment();
        
        assertNotNull(mostHelpful);
        assertEquals("Charlie", mostHelpful.getAuthor());
        assertEquals(5, mostHelpful.getRating());
    }
    public void testAddCommentDuplicateAuthor() {
        //Add a comment by same author twice
        item.addComment("Alice", "Good sound", 4);
        boolean result = item.addComment("Alice", "Changed my mind", 5);
        
        assertFalse(result);
    }
    public void testFindMostHelpfulCommentAfterUpvotes() {
        item.addComment("alice", "Good", 3);
        item.addComment("Bob", "Better", 3);
        
        item.upvoteComment(0);
        item.upvoteComment(0);
        
        Comment mostHelpful = item.findMostHelpfulComment();
        assertEquals("Alice", mostHelpful.getAuthor());
}
      public void testAddCommentBoundaryRating() {
          assertTrue(item.addComment("Eve", "Lowest rating allowed", 0));
          assertTrue(item.addComment("Frank", "Highest rating allowed", 5));
          assertFalse(item.addComment("John", "too high", 6));
          assertFalse(item.addComment("David", "Too low", -1));
      }
    }

