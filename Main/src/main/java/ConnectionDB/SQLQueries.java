package ConnectionDB;

public interface SQLQueries {
//    String CREATE_NEW_SQL_TABLE = "CREATE TABLE IF NOT EXISTS `SolutionEquation` (" +
//            "`Number` INT PRIMARY KEY AUTO_INCREMENT," +
//            "`Equation` VARCHAR(200)," +
//            "`Roots` VARCHAR(200)," +
//            "`Date` VARCHAR(200))";

    String CREATE_NEW_SQL_TABLE = "CREATE TABLE IF NOT EXISTS SolutionEquation (" +
            "Number SERIAL PRIMARY KEY," +
            "Equation VARCHAR(200)," +
            "Roots VARCHAR(200)," +
            "Date VARCHAR(200))";


    String SELECT_MAX_NUMBER_FROM_TABLE = "SELECT MAX(solutionequation.Number) FROM solutionequation";
    String DELETE_LAST_DATA_FROM_DB = "delete from solutionequation where Number = %d";
    String GET_DATA_ON_NUMBER_ROWS = "SELECT number, equation, roots, date FROM solutionEquation ORDER BY number LIMIT %d";
    String GET_ALL_DATA_FROM_DB = "SELECT number, equation, roots, date FROM solutionEquation";
    String INSERT_DATA_INTO_TABLE = "INSERT INTO SolutionEquation(Number, Equation, Roots, Date) VALUES (%d,'%s','%s','%s')";
}