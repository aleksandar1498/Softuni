package validator;

public class Error {
    private String problem;
    public Error(String problem) { this.problem = problem; }
    public String getProblem() { return problem; }

    @Override
    public String toString() {
        return problem;
    }
}
