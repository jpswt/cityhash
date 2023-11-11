import java.util.Scanner;

public class Main {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    String cityName = promptForCityName(scanner);

    String country = promptForCountry(scanner);

    int population = promptForPopulation(scanner);

    City newCity = new City(cityName, country, population);

    CityPopulationTracker tracker = new CityPopulationTracker();
    tracker.addCity(newCity);

    System.out.println("City added to the tracker: " + newCity.getName());
  }

  public static boolean isNullOrBlank(String input) {
    return input == null || input.isBlank();
  }

  public static boolean incorrectPopulation(int population) {
    return population <= 0;
  }

  public static String promptForCityName(Scanner scanner) {
    while (true) {
      System.out.print("\nPlease enter a valid city name: ");
      if (scanner.hasNextLine()) {
        String cityName = scanner.nextLine();
        if (isNullOrBlank(cityName)) {
          System.out.println("Name cannot be null or blank");
        } else {
          return cityName;
        }
      } else {
        scanner.nextLine();
      }
      // TODO
    }
  }

  public static String promptForCountry(Scanner scanner) {
    while (true) {
      System.out.print("\nPlease enter a valid country: ");
      if (scanner.hasNextLine()) {
        String country = scanner.nextLine();
        if (isNullOrBlank(country)) {
          System.out.println("Country cannot be null or blank");
        } else {
          return country;
        }
      } else {
        scanner.nextLine();
      }
      // TODO
    }
  }

  public static int promptForPopulation(Scanner scanner) {
    while (true) {
      System.out.print("\nPlease enter a valid population (greater than 0): ");
      if (scanner.hasNextInt()) {
        int population = scanner.nextInt();
        if (incorrectPopulation(population)) {
          System.out.println("Population must be greater than zero");
        } else {
          return population;
        }
      } else {
        scanner.next();
        continue;
      }
    }
  }
}
