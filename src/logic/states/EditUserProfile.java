package logic.states;

import logic.data.Data;

public class EditUserProfile extends StateAdapter{

    public EditUserProfile(Data data) {
        super(data);
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
    public EnumStates getState() {
        return EnumStates.EDIT_USER_PROFILE;
    }
}
