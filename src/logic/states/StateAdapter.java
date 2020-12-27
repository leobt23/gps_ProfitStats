package logic.states;

import logic.EnumBetStatus;
import logic.data.Data;

public abstract class StateAdapter implements IState {

    private Data data;

    public StateAdapter(Data data) {
        this.data = data;
    }

    @Override
    public IState betRegistry() {
        return new BetRegistry(data);
    }

    @Override
    public IState saveBet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate,
            float totalValueBetted, float possibleWinnings, String betName) {
        return this;
    }

    @Override
    public IState userProfile() {
        return new UserProfile(data);
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
    public IState updateBetStatus(EnumBetStatus enumBetStatus) {
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
        return new Notifications(data);
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
        return new Statistics(data);
    }

    @Override
    public IState betsHistory() {
        return new BetRegistry(data);
    }

    @Override
    public EnumStates getState() {
        return null;
    }
}
