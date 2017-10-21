package sample2;

import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.bloomberg.inventory.config.AppConfig;
import com.bloomberg.inventory.jpa.Deal;
import com.bloomberg.inventory.jpa.Person;
import com.bloomberg.inventory.service.DealService;
import com.bloomberg.inventory.service.PersonService;

public class Test
{

  public static void main(String[] args)
  {
    System.out.println("Hello world..");

    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

    PersonService personService = context.getBean(PersonService.class);

    personService.add(new Person("Sunil", "Bora", "suni.bora@example.com"));

    // Get Persons
    List<Person> persons = personService.listPersons();
    for (Person person : persons)
    {
      System.out.println("Id = " + person.getId());
      System.out.println("First Name = " + person.getFirstName());
      System.out.println("Last Name = " + person.getLastName());
      System.out.println("Email = " + person.getEmail());
      System.out.println();
    }

    DealService dealService = context.getBean(DealService.class);

    dealService.add(new Deal("1", null, null, null, null, null));

    // Get Persons
    List<Deal> deals = dealService.listDeals();
    for (Deal deal : deals)
    {
      System.out.println("Id = " + deal.getDealUniqueId());
      // System.out.println("First Name = " + person.getFirstName());
      // System.out.println("Last Name = " + person.getLastName());
      // System.out.println("Email = " + person.getEmail());
      System.out.println();
    }

    context.close();
  }
}
