package logic.data;

import logic.EnumBetStatus;

public class Data {
    private User user;

    /*public Data(User user, BettingHistory bettingHistory, Time time){
        this.user = user;
        this.bettingHistory = bettingHistory;
        this.time = time;
    }*/

    public Data() {

    }

    public void setUser(User user) {
        this.user = user;
    }

    //TODO: fazer funções
    public String getBetName(int idx) {
        return user.betsHistory.getBets().get(idx).getBetName();
    }

    public String getBetRegistryDate(int idx) {
        return user.betsHistory.getBets().get(idx).getBetRegisterDate();
    }

    public int getBetNumberOfGames(int idx) {
        return user.betsHistory.getBets().get(idx).getNumberOfGames();
    }

    public int getBetNumberOfBets(int idx) {
        return user.betsHistory.getBets().get(idx).getNumberOfBets();
    }

    public float getBetValueBetted(int idx) {
        return user.betsHistory.getBets().get(idx).getTotalValueBetted();
    }

    public float getBetPossibleWinnings(int idx) {
        return user.betsHistory.getBets().get(idx).getPossibleWinnings();
    }

    public EnumBetStatus getBetStatus(int idx) {
        return user.betsHistory.getBets().get(idx).getStatus();
    }

    public int getBetId(int idx) {
        return user.betsHistory.getBets().get(idx).getBetId();
    }

    public String getBetCloseDate(int idx) {
        return user.betsHistory.getBets().get(idx).getBetCloseDate();
    }

    public void setBetStatus(int betId, EnumBetStatus status) {
        user.betsHistory.getBets().forEach(
                b -> {
                    if(b.getBetId() == betId) {
                        b.setStatus(status);
                    }
                }
        );
    }
}
