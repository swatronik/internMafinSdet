import bridge.logic.DBStorage;
import bridge.logic.FileStorage;
import bridge.object.Cat;
import bridge.object.Organism;
import bridge.object.Person;
import bridge.output.FIleLog;
import bridge.output.Log;
import statePattern.CreateJob;
import statePattern.State;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        /*ArrayList<Organism> fedors = new ArrayList<>();

        Person fedor = new Person("Fedor", new FileStorage(), new Log());
        Person fedor1 = new Person("Fedor1", new DBStorage(), new FIleLog());
        Cat cat = new Cat("Cat Fedor2", new FileStorage(), new Log());
        Person fedor3 = new Person("Fedor3", new DBStorage(), new FIleLog());

        fedors.add(fedor);
        fedors.add(fedor1);
        fedors.add(cat);
        fedors.add(fedor3);

        for(Organism fedorEl: fedors){
            fedorEl.store();
        }
        for(Organism fedorEl: fedors){
            fedorEl.log();
        }*/

        State job = new CreateJob();
        job.toLog();
        job = job.accept()
                .cancel()
                .accept()
                .accept()
                .accept()
                .accept()
                .denide();
        job.toLog();

    }

}
