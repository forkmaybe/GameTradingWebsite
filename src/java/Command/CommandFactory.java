package Command;

/**
 *
 * @author d00133633
 */
public class CommandFactory {

    /**
     * This creates an instantiated command object.
     * Depending on the CommandStr, we return a specific action.
     * 
     * @param commandStr Used to find the required command to execute.
     * @return the Command Object.
     */
    public CommandInterface createCommand(String commandStr) {
        CommandInterface command;

        if (commandStr.equalsIgnoreCase("login")) {
            command = new LoginCommand();
        } else if (commandStr.equalsIgnoreCase("logOut")) {
            command = new LogoutCommand();
        } else if (commandStr.equalsIgnoreCase("register")) {
            command = new RegisterCommand();
        } else if (commandStr.equalsIgnoreCase("addFunds")) {
            command = new AddFundsCommand();
        } else if (commandStr.equalsIgnoreCase("haves")) {
            command = new UserHavesCommand();
        } else if (commandStr.equalsIgnoreCase("wants")) {
            command = new UserWantsCommand();
        } else if (commandStr.equalsIgnoreCase("removeUser")) {
            command = new RemoveUserCommand();
        } else if (commandStr.equalsIgnoreCase("editDetails")) {
            command = new UpdateProfileCommand();
        } else if (commandStr.equalsIgnoreCase("removeGame")) {
            command = new RemoveGameCommand();
        } else if (commandStr.equalsIgnoreCase("removeWant")) {
            command = new RemoveWantCommand();
        } else if (commandStr.equalsIgnoreCase("removeHave")) {
            command = new RemoveHaveCommand();
        } else if (commandStr.equalsIgnoreCase("search")) {
            command = new SearchCommand();
        } else if (commandStr.equalsIgnoreCase("addHave")) {
            command = new AddHaveCommand();
        } else if (commandStr.equalsIgnoreCase("viewAll")) {
            command = new ViewAllCommand();
        } else if (commandStr.equalsIgnoreCase("viewGame")) {
            command = new ViewGameCommand();
        } else if (commandStr.equalsIgnoreCase("buyGame")) {
            command = new BuyGameCommand();
        } else if (commandStr.equalsIgnoreCase("sellGame")) {
            command = new SellGameCommand();
        } else if (commandStr.equalsIgnoreCase("addGame")) {
            command = new AddGameCommand();
        } else if(commandStr.equalsIgnoreCase("Trade")){
            command = new TradeCommand();
        } else if(commandStr.equalsIgnoreCase("addWant")){
            command = new AddWantCommand();
        } else if(commandStr.equalsIgnoreCase("completeTrade")){
            command = new CompleteTradeCommand();
        }else {
            command = null;
        }
        //Return the instantiated Command object to the calling code...
        return command;
    }
}
