package services.Commands;

import com.beust.jcommander.Parameter;
import com.beust.jcommander.Parameters;
import services.Validators.ValidateREGEX;

@Parameters(
        commandNames = "formula",
        commandDescription = "Parametr means that full formula of quadratic equation expected afet space"
)
public class CommandFormula {
    @Parameter(
            names = {"--equation", "-e"},
            description = "Required parametr after cmd 'formula'",
            required = true,
            validateWith = ValidateREGEX.class
    )
    private String equation;

    public String getEquation() {
        return equation;
    }
}

