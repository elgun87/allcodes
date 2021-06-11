package tests;
import cities.CityApp;
public class CityAppTest {
    public static void main(String[] args) {
        CityApp city1 = new CityApp();
        //Get the population of city
        String cityName = "San Jose";
        System.out.println("Population of " + cityName + " is " + city1.population(cityName));
        System.out.println("-----------------------------------------------------------------");
        //Get the State of a given city belongs to
        System.out.println("State of " + cityName + " is " + city1.state(cityName));
        System.out.println("-----------------------------------------------------------------");
        //Find the city based on its rank
        int rank = 25;
        System.out.println("The " + rank + "th largest city in USA is " + city1.cityByRank(rank));
        System.out.println("-----------------------------------------------------------------");
        //Count the cities in the given state
        String state = "New York";
        System.out.println("The cities in the " + state + " is " + city1.citiesInState(state));
        System.out.println("-----------------------------------------------------------------");
        //Get the latitude of a given city
        System.out.println("The latitude of the " + cityName + " is " + city1.getLatitude(cityName));
        System.out.println("-----------------------------------------------------------------");
        //Get the latitude of a given city
        System.out.println("The longtitude of the " + cityName + " is " + city1.getLongitude(cityName));
        System.out.println("-----------------------------------------------------------------");
        //Get distance
        String c1 = "New York";
        String c2 = "Chicago";
        System.out.println("The distance between " + c1 + " and " + c2 + " is " + city1.distance(c1,c2) + "km.");

    }
}
