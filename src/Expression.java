//Topaz Avraham 206842627
import java.util.List;
import java.util.Map;

/**
 * @author Topaz Avraham
 * This interface is used to represent a logical expression.
 */
public interface Expression {
    /**
     * Evaluate the expression using the variable values provided in the assignment, and return the result.
     * If the expression contains a variable which is not in the assignment, an exception is thrown.
     * @param assignment - the map
     * @return - the result of the expression
     * @throws Exception - if the expression contains a variable not in the assigment
     */
    Boolean evaluate(Map<String, Boolean> assignment) throws Exception;

    /**
     * A convenience method. Like the `evaluate(assignment)` method above, but uses an empty assignment.
     * @return the result of the expression
     * @throws Exception - if the expression contains a variable not in the assigment
     */
    Boolean evaluate() throws Exception;

    /**
     * @return a list of the variables in the expression.
     */
    List<String> getVariables();

    /**
     * @return a nice string representation of the expression.
     */
    String toString();

    /**
     * This method replace all occurrences of the variable var in the provided expression.
     * @param var - the var who's instead we use the expression provided
     * @param expression - the expression to put instead of var
     * @return Returns a new expression in which all occurrences of the variable var are replaced
     * with the provided expression (Does not modify the current expression).
     */
    Expression assign(String var, Expression expression);

    /**
     * @return the expression tree resulting from converting all the operations to the logical Nand operation.
     */
   Expression nandify();

    /**
     * @return the expression tree resulting from converting all the operations to the logical Nor operation.
     */
   Expression norify();

    /**
     * @return a simplified version of the current expression.
     */
    Expression simplify();
}
