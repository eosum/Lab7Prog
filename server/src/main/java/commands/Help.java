package commands;

import app.CollectionManager;
import app.Server;
import data.HumanBeing;
import util.Response;
import util.UserInfo;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * Help class
 */
public class Help implements Command {
    private final HashMap<String, Command> commands;
    private CollectionManager collectionManager;


    public Help(HashMap<String, Command> commands, CollectionManager collectionManager) {
        this.commands = commands;
        this.collectionManager = collectionManager;
    }

    /**
     * Prints references for commands
     *
     * @param args     arguments
     * @param object
     * @param response
     */
    @Override
    public void execute(String args, HumanBeing object, UserInfo userInfo, Response response) {
        LinkedList<String> descriptionCommands = new LinkedList<>();
        for (Command description: commands.values()) {
            descriptionCommands.add(description.toString());
        }
        response.setObject(descriptionCommands);
        Server.sendResponse(response, response.getKey());
    }

    @Override
    public String toString() {
        return "help - выводит справку по доступным командам";
    }
}
