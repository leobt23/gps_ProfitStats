package logic.states;

import logic.Status;
import logic.data.Data;

public abstract class StateAdapter implements IState {

    private Data data;

    public StateAdapter(Data data) {
        this.data = data;
    }

    @Override
    public IState saveBet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate, float totalValueBetted, float possibleWinnings, String betName) {
        return this;
    }

    @Override
    public IState editUserProfile() {
        return this;
    }

    @Override
    public IState cancelEditUserProfile() {
        return this;
    }

    @Override
    public IState saveProfile() {
        return this;
    }

    @Override
    public IState editBet() {
        return this;
    }

    @Override
    public IState updateBetStatus(Status status) {
        return this;
    }

    @Override
    public IState saveEditedBet(int betId, int numberOfGames, int numberOfBets, String betRegisterDate,
                                String betCloseDate, float totalValueBetted, float possibleWinnings,
                                String betName) {
        return this;
    }

    @Override
    public IState cancelBetEdit() {
        return this;
    }

    @Override
    public IState notifications() {
        return this;
    }

    @Override
    public IState resetNotifications() {
        return this;
    }

    @Override
    public IState saveSettings() {
        return this;
    }

    @Override
    public IState statistics() {
        return this;
    }

    @Override
    public EnumStates getState() {
        return null;
    }
}
