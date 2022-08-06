//Topaz Avraham 206842627
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Topaz Avraham
 * This class is used to test the program built.
 */
public class ExpressionsTest {

    /**
     * The main method creates an expression with three variables.
     * Prints the expression.
     * Prints the value of the expression with an assignment to every variable.
     * Print the Nandified version of the expression.
     * Print the Norified version of the expression.
     * Print the simplified version of the expression.
     * @param args - no use
     */
    public static void main(String[] args) {
        Expression e = new And(new Val(true),
                               new And(new Or(new Var("x"), new Var("y")), new Var("z")));

        String s = e.toString();
        System.out.println(s);

        Map<String, Boolean> assignment = new TreeMap<>();
        assignment.put("x", false);
        assignment.put("y", false);
        assignment.put("z", true);

        try {
            Boolean value = e.evaluate(assignment);
            System.out.println(value);
        } catch (Exception e1) {
            System.out.println("program not working");
        }

        Expression eAfterNandify = e.nandify();
        Expression eAfterNorify = e.norify();
        Expression eAfterSimplify = e.simplify();

        System.out.println(eAfterNandify);
        System.out.println(eAfterNorify);
        System.out.println(eAfterSimplify);
    }
}
