package bridge.object;

import bridge.logic.Storage;
import bridge.output.Output;

public class Cat implements Organism {

    private final String name;

    private final Storage storage;
    private final Output output;

    public Cat(String name, Storage storage, Output output) {
        this.name = name;
        this.storage = storage;
        this.output = output;
    }

    public void store() {
        storage.store(name);
    }

    @Override
    public void log() {
        output.log();
    }
}
