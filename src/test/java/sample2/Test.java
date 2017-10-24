package sample2;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bloomberg.inventory.config.AppConfig;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.service.DealService;
import com.bloomberg.inventory.util.Util;

public class Test
{

  public static void main(String[] args)
  {
    System.out.println("Hello world..");

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    // PersonService personService = context.getBean(PersonService.class);
    //
    // personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));
    //
    // // Get Persons
    // List<Person> persons = personService.listPersons();
    // for (Person person : persons)
    // {
    // System.out.println("Id = " + person.getId());
    // System.out.println("First Name = " + person.getFirstName());
    // System.out.println("Last Name = " + person.getLastName());
    // System.out.println("Email = " + person.getEmail());
    // System.out.println();
    // }

    // DealService dealService = context.getBean(DealService.class);
    //
    // dealService.add(new Deal("1", null, null, null, null, null));
    //
    // // Get Persons
    // List<Deal> deals = dealService.listDeals();
    // for (Deal deal : deals)
    // {
    // System.out.println("Id = " + deal.getDealUniqueId());
    // // System.out.println("First Name = " + person.getFirstName());
    // // System.out.println("Last Name = " + person.getLastName());
    // // System.out.println("Email = " + person.getEmail());
    // System.out.println();
    // }

    Util util = new Util();
    DealService dealService = context.getBean(DealService.class);

    try
    {
      List<String[]> rows = util.readCsv();
      for (String[] row : rows)
      {
        System.out.println("  - " + row[0] + row[1] + row[2] + row[3]);
        dealService.remove(new Deal(row[0], row[1], row[2], row[3], row[4], null));
      }
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    try
    {
      long start = System.currentTimeMillis();
      System.out.println("------------------------------------------------------------------");
      System.out.println("                  DATA LOADING IS STARTING NOW");
      System.out.println("------------------------------------------------------------------");
      // System.out.println(" - Extract-Load the data from " +
      // this.dataFileName);

      List<String[]> rows = util.readCsv();
      for (String[] row : rows)
      {
        System.out.println("  - " + row[0] + row[1] + row[2] + row[3]);
        dealService.add(new Deal(row[0], row[1], row[2], row[3], row[4], null));
      }

      long end = System.currentTimeMillis();
      System.out.println("------------------------------------------------------------------");
      System.out.println("                  DATA LOADING ENDING NOW");
      System.out.println("------------------------------------------------------------------");
      String totalTime = Util.toFriendlyDuration(end - start);
      System.out.println("Time taken to read, parse the CSV file: " + totalTime);
    }
    catch (Exception e)
    {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

    context.close();
  }
}
