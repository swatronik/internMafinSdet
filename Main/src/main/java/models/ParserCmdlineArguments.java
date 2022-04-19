package models;
import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParserCmdlineArguments {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Parameter(
            names = {"--firstArr", "-a"},
            description = "Enter number that will be first argument of quadratic equation",
            required = true
    )
    public double firstArr;
    @Parameter(
            names = {"--secondArr", "-b"},
            description = "Enter number that will be second argument of quadratic equation",
            required = true
    )
    public double secondArr;
    @Parameter(
            names = {"--thirdArr", "-c"},
            description = "Enter number that will be third argument of quadratic equation",
            required = true
    )
    public double thirdArr;

    @Parameter(
            names = {"--help", "-h"},
            help = true
    )
    private boolean help = false;

    private boolean isHelp() {
        return help;
    }

    public ParserCmdlineArguments(String[] args) {
        inputArgs(args);
    }

    private void inputArgs(String[] args) {
        JCommander jct = JCommander.newBuilder().addObject(this).build();
        jct.setProgramName("Quadratic equation");
        try {
            jct.parse(args);
            if (this.isHelp()) {
                jct.usage();
            }
        } catch (ParameterException e) {
            logger.error(e.getLocalizedMessage());
            jct.usage();
        }
    }
}