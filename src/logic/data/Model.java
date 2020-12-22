package logic.data;

import logic.states.BetRegistry;
import logic.states.IState;

import java.util.ArrayList;
import java.util.List;

public class Model {

    private Data data;
    private IState state;
    private List<String> events;

    public Model() {
        data = new Data();
        state = new BetRegistry(data);
        events = new ArrayList<>();
    }

    private void setState(IState next) {
        IState previous = state;
        state = next;
        if (previous != next) {
            events.add(PropertyChanges.STATE_CHANGE);
        }
    }

    public String getBetName(int idx) {
        return data.getBetName(idx);
    }

    
}
