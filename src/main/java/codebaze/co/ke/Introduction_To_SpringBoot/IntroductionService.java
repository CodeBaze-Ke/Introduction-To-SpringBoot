/**
 * This is a Spring Service class that handles basic greeting operations.
 *
 * A Service class in Spring Boot acts as a layer between your controllers and data access layers,
 * containing the business logic of your application.
 *
 * @author [Albert Ondicho]
 */
package codebaze.co.ke.Introduction_To_SpringBoot;

import org.springframework.stereotype.Service;

/**
 * The @Service annotation marks this class as a Spring Service component.
 * Spring will automatically detect and register this class as a bean in the application context.
 * This enables dependency injection and other Spring features.
 */
@Service
public class IntroductionService {

    /**
     * Returns a simple "hello world" greeting message.
     *
     * This method demonstrates a basic string return operation.
     *
     * @return A static greeting message
     */
    public String helloWorld() {
        return "hello world";
    }

    /**
     * Creates a personalized greeting message using the provided name.
     *
     * This method uses Java's String.format() feature to insert the name parameter
     * into a formatted string. The %s placeholder is replaced with the actual name value.
     *
     * @param name The person's name to include in the greeting
     * @return A formatted greeting message including the provided name
     */
    public String personalHello(String name) {
        return String.format("hello %s", name);
    }
}