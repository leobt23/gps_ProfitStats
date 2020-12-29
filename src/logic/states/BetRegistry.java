package logic.states;

import logic.data.Data;

public class BetRegistry extends StateAdapter {

    public BetRegistry(Data data) {
        super(data);
    }

    @Override
    public IState saveBet(int numberOfGames, int numberOfBets, String betRegisterDate, String betCloseDate, float totalValueBetted, float possibleWinnings, String betName) {
//        List<Erros> listaErros = data.saveBet();
        return this;
    }


    @Override
    public EnumStates getState() {
        return EnumStates.BET_REGISTRY;
    }
}
