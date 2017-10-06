package utils;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by MD RAFI AKHTAR on 06-10-2017.
 */

public class arrays {
    // Arrays related to books
    public static String algo[] = {
            "Introduction to Algorithms: CLRS",
            "Design and Analysis of Algorithms: Hopcroft, Aho, Ullman",
            "Fundamentals of Computer Algorithms: Horowitz, Sahani",
            "Data Structures with C: Reema Thareja"
    };
    public String dbms[] = {
            "Database System Concepts: Korth, Abraham",
            "Fundamentals of Databases Systems: Ramez, Shamkant"
    };
    public String books[][] = {algo, dbms};

    // User arrays
    public String users[][] = {
            {"Rafi", "alimdrafi@gmail.com", "0", null}
    };

    public static Map<String, String> combo = new HashMap<String, String>() {
        {
            put("alimdrafi@gmail.com12345678", "Rafi");
        }
    };

}
