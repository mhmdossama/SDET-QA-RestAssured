package Days.Day7;

import com.github.javafaker.Faker;
import org.testng.annotations.Test;

public class FakerDataGenerator {
    // This class is used to generate fake data using the Faker library
    // It can be used to generate fake names, addresses, phone numbers, etc.
    // example usage:
//     Faker faker = new Faker();
//     String name = faker.name().fullName();
//     String address = faker.address().fullAddress();

    @Test
    public void testFakerDataGenerator() {
        Faker faker = new Faker();
        String name = faker.name().fullName();
        String address = faker.address().fullAddress();
        String phoneNumber = faker.phoneNumber().phoneNumber();
        String email = faker.internet().emailAddress();

        System.out.println("Name: " + name);
        System.out.println("Address: " + address);
        System.out.println("Phone Number: " + phoneNumber);
        System.out.println("Email: " + email);
    }

}
