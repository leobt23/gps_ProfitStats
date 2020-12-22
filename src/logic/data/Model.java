package logic.data;

import logic.Status;
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

    public String getBetRegistryDate(int idx) {
        return data.getBetRegistryDate(idx);
    }

    public int getBetNumberOfGames(int idx) {
        return data.getBetNumberOfGames(idx);
    }

    public int getBetNumberOfBets(int idx) {
        return data.getBetNumberOfBets(idx);
    }

    public float getBetValueBetted(int idx) {
        return data.getBetValueBetted(idx);
    }

    public float getBetPossibleWinnings(int idx) {
        return data.getBetPossibleWinnings(idx);
    }

    public Status getBetStatus(int idx) {
        return data.getBetStatus(idx);
    }

    public int getBetId(int idx) {
        return data.getBetId(idx);
    }

    public String getBetCloseDate(int idx) {
        return data.getBetCloseDate(idx);
    }
}
