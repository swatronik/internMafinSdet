import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Country[] countries = new Country[]{new Country("country_name1", 10000, 4000),
                new Country("country_name2", 1000, 5000),
                new Country("country_name2", 999, 4999),
                new Country("country_name2", 100000, 200000),
                new Country("country_name2", 10, 5000),
                new Country("country_name2", 100000, 5000)};
        getCountryWithMaxDensity(countries);
    }

    public static Country getCountryWithMaxDensity(Country[] countries) {
        return null;
    }

    static class Country {
        public String name;
        public int population;
        public double area;

        public Country(String name, int population, double area) {
            this.name = name;
            this.population = population;
            this.area = area;
        }

        public String getName() {
            return name;
        }

        public int getPopulation() {
            return population;
        }

        public double getArea() {
            return area;
        }
    }
}
