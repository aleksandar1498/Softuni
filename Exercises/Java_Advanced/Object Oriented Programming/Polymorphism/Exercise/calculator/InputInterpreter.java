package calculator;
public class InputInterpreter {
    private CalculationEngine engine;

    public InputInterpreter(CalculationEngine engine){
        this.engine = engine;
    }

    public boolean interpret(String input) {
        try {
            engine.pushNumber(Integer.parseInt(input));
        }catch (Exception ex){
            if(input.equals("ms")){
                this.engine.saveInMemory();
            }else if(input.equals("mr")){
                engine.pushNumber(this.engine.callFromMemory());
            }else{
                engine.pushOperation(this.getOperation(input));
            }

        }
        return true;
    }
    public Operation getOperation(String operation) {
        if (operation.equals("*")) {
            return new MultiplicationOperation();
        }else if(operation.equals("/")){
            return new DivisionOperation();
        }

        return null;
    }
}
