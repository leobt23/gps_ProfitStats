package logic.states;

import logic.data.Data;

public class Notifications extends StateAdapter{

    public Notifications(Data data) {
        super(data);
    }

    @Override
    public IState resetNotifications() {
        return super.resetNotifications();
    }

    @Override
    public IState saveSettings() {
        return super.saveSettings();
    }

    @Override
    public EnumStates getState() {
        return EnumStates.NOTIFICATIONS;
    }
}
