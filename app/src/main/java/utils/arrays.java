package utils;
import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import java.util.HashMap;
import java.util.Map;
import com.example.farzanaakhtar.libraria.Profile;

public class arrays extends Profile {
    // Arrays related to books
    public static String engg[] = {
            "Introduction to Algorithms: CLRS",
            "Fundamentals of Databases Systems: Ramez, Shamkant",
            "Microprocessors and Microcontrollers: N. Senthil Kumar, M. Saravanan and Jeevananthan",
            "Digital Logic Design: Morris Mano",
            "An Introduction to Analog and Digital Communications: Simon Haykin",
            "An Introduction to Formal Languages and Automata: Peter Linz",
            "Advanced Computer Architecture: Kai Hwang",
            "Discrete Mathematics: Kenneth Rosen",
            "Computer Networks: A. S. Tanenbaum",
            "Operating System Design & Implementation: Tanenbaum A.S.",
            "Software Engineering: Pankaj Jalote",
            "Compiler Design in C: Holub",
            "Artificial Intelligence A Modern Approach: Stuart Russel Peter Norvig Pearson"
    };
    public static String fiction[] = {
            "Origin: Dan Brown",
            "Inferno: Dan Brown",
            "The Lost Symbol: Dan Brown",
            "The Da Vinci Code: Dan Brown",
            "Angels and Demons: Dan Brown",
            "Deception Point: Dan Brown",
            "Digital Fortress: Dan Brown",

            "The Hobbit - An Unexpected Journey: J R R Tolkein",
            "The Hobbit - The Desolation of Smaug: J R R Tolkein",
            "The Hobbit - The Battle of the Five Armies: J R R Tolkein",
            "Lord of the Rings - The Fellowship of the Ring: J R R Tolkein",
            "Lord of the Rings - The Two Towers: J R R Tolkein",
            "Lord of the Rings - The Return of the King: J R R Tolkein",
            "Silmarillion: J R R Tolkein",

            "A Song of Ice and Fire - A Game of Thrones: G R R Martin",
            "A Song of Ice and Fire - A Clash of Kings: G R R Martin",
            "A Song of Ice and Fire - A Storm of Swords: G R R Martin",
            "A Song of Ice and Fire - A Feast for Crows: G R R Martin",
            "A Song of Ice and Fire - A Dance of Dragons: G R R Martin"
    };

    public static String non_fiction[] = {
            "Black Boy: Richard Wright",
            "The Seven Habits of Highly Effective People: Stephen Corby",
            "Cracking the Coding Interview: Gayle Laakmann McDowell",
            "Into the Wild: John Krakauer",
            "Steve Job: Walter Isaacson",
            "Sachin -  A Billion Dreams: Sachin Ramesh Tendulkar",
            "Agni Ki Udaan: A. P. J. Abdul Kalam",
            "Bad Blood: Lorna Sage"
    };

    public String books[][] = {engg, fiction, non_fiction};

    public static String temp[] = {"alimdrafi@gmail.com", "0", null};

    public static Map<String, String[]> users = new HashMap<String, String[]>()
    {
        {
            put("Rafi", temp);
        }
    };

    public static Map<String, String> combo = new HashMap<String, String>() {
        {
            put("alimdrafi@gmail.com12345678", "Rafi");
        }
    };

    static TextView issued[] = new TextView[9]; // stack of books issued
    public static int top = 0;

    public static void push(TextView book)
    {
        if (top == 9)
        {
            Snackbar.make(book, "Overflow\n\n", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return;
        }

        Profile.books[top].setVisibility(View.VISIBLE);
        Profile.books[top].setText(book.getText());
        Profile.books[top].setTextColor(Color.rgb(255, 255, 255));
        issued[top++] = book;
        welcome.setText("Hi, "+ name + ". You can issue upto " + (9 - top) + " books right now.");
    }

}
