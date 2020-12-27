package logic.states;

import logic.Status;

public interface IState {

    //Bet Registry
    IState betRegistry();
    IState saveBet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate,
                   float totalValueBetted, float possibleWinnings, String betName);

    //User profile
    IState userProfile();

    //Edit user profile
    IState editUserProfile();
    IState cancelEditUserProfile();
    IState saveProfile();

    //BetsHistory
    IState betsHistory();
    IState editBet();
    IState updateBetStatus(Status status);
    IState saveEditedBet(int betId, int numberOfGames, int numberOfBets, String betRegisterDate,
                         String betCloseDate, float totalValueBetted, float possibleWinnings,
                         String betName);
    IState cancelBetEdit();

    //Notifications
    IState notifications();
    IState resetNotifications();
    IState saveSettings();

    //Statistics
    IState statistics();

    EnumStates getState();
}
