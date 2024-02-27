package org.csystem.commandprompt;
@FunctionalInterface
public interface ICommandConsumer {
    void accept(String [] cmdInfo);
}
