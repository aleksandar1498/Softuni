package militaryElit.common;

import militaryElit.enums.State;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, State state) {
        this.codeName = codeName;
        this.state = state;
    }


    public String getCodeName() {
        return this.codeName;
    }


    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s",this.getCodeName(),this.state.name());
    }
}
