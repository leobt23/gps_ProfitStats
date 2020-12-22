package logic.states;

import logic.data.Data;

public class Statistics extends StateAdapter {

    public Statistics(Data data) {
        super(data);
    }

    @Override
    public IState notifications() {
        return super.notifications();
    }

    @Override
    public EnumStates getState() {
        return super.getState();
    }
}
