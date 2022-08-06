//Topaz Avraham 206842627
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * @author Topaz Avraham
 * This class is used to represent Boolean value.
 */
public class Val implements Expression {
    private boolean result;

    /**
     * Constructor.
     * @param result - the result of the boolean - true/false
     */
    public Val(boolean result) {
        this.result = result;
    }
    @Override
    public Boolean evaluate(Map<String, Boolean> assignment) throws Exception {
        return this.result;
    }
    @Override
    public Boolean evaluate() throws Exception {
        return this.result;
    }
    @Override
    public List<String> getVariables() {
        LinkedList emptyVarList = new LinkedList<>();
        if (emptyVarList.isEmpty()) {
            return emptyVarList;
        }
       return null;
    }
    @Override
    public Expression assign(String var, Expression expression) {
        return this;
    }
    @Override
    public String toString() {
        if (result) {
            return "T";
        } else {
            return "F";
        }

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
