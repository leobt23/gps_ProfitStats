package logic.states;

import logic.data.Data;

public class BetsHistory extends StateAdapter {

    public BetsHistory(Data data) {
        super(data);
    }

    @Override
    public EnumStates getState() {
        return EnumStates.BETS_HISTORY;
    }
}
