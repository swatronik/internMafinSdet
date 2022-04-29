package services.Commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import services.Validators.ParametrsValidator;

@Parameters(
        commandNames = "arguments",
        commandDescription = "Parametr means that three arguments expected after command 'arguments'"
)
public class CommandArguments {
    @Parameter(
            names = {"--firstArr", "-a"},
            description = "Required parametr of first argument of equation",
            required = true,
            validateWith = ParametrsValidator.class
    )
    private double firstArr;

    @Parameter(
            names = {"--secondArr", "-b"},
            description = "Required parametr of second argument of equation",
            required = true
    )
    private double secondArr;

    @Parameter(
            names = {"--thirdArr", "-c"},
            description = "Required parametr of third argument of equation",
            required = true
    )
    private double thirdArr;

    public double getFirstArr() {
        return firstArr;
    }

    public double getSecondArr() {
        return secondArr;
    }

    public double getThirdArr() {
        return thirdArr;
    }
}