//Topaz Avraham 206842627
import java.util.TreeMap;
import java.util.Map;
import java.util.List;
import java.util.LinkedList;

/**
 * @author Topaz Avraham
 * This class is used to represent a variable in a logical expression.
 */
public class Var implements Expression {
    private String variable;

    /**
     * Constructor.
     * @param var - the variable
     */
    public Var(String var) {
        variable = var;
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {

        Boolean res;
        if (assignment.containsKey(variable)) {
            res = assignment.get(variable);
            return res;
        } else {
            String notFound = ("the var you typed does not exist in the expression");
            throw new Exception(notFound);
        }
    }
    @Override
    public Boolean evaluate() throws Exception {
        TreeMap map = new TreeMap<>();
        Boolean res = evaluate(map);
        return res;
    }
    @Override
    public List<String> getVariables() {
        List<String> varList = new LinkedList<String>();
        varList.add(variable);
        return varList;
    }
    @Override
    public Expression assign(String var, Expression expression) {
        if (variable.compareTo(var) == 0) {
            return expression;
        } else {
            return this;
        }
    }
    @Override
    public String toString() {
        return this.variable;
    }
    @Override
    public Expression nandify() {
        return this;
    }
    @Override
    public Expression norify() {
        return this;
    }
    @Override
    public Expression simplify() {
        return this;
    }
}
