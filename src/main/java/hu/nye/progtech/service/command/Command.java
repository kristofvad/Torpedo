package hu.nye.progtech.service.command;

/**
 * Decides if the input can be processed.
 */
public interface Command {

    /**
     * Determines if the given input can be processed by the command.
     *
     * @param input the input as string
     * @return {@code true} if the command can be processed, {@code false} otherwise
     */
    boolean canProcess(String input);

    /**
     * Processes the given input.
     *
     * @param input the input as a string to be processed
     */
    void process(String input);


}
