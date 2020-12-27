package logic.states;

import logic.data.Data;

public class UserProfile extends StateAdapter {

    public UserProfile(Data data) {
        super(data);
    }

    @Override
    public IState editUserProfile() {
        return this;
    }

    @Override
    public EnumStates getState() {
        return EnumStates.USER_PROFILE;
    }
}
