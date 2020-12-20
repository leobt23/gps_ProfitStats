package logic;

import logic.data.Data;

public class ObservableModel {

    private Data data;

    public ObservableModel(){}

    public int getNumberOfBets(){
        return 0;
    }

    public String getBetId(int idx) {
        return data.getBetName(idx);
    }
}
