/**
 * This REST controller handles basic greeting operations.
 * It provides endpoints for both generic and personalized greetings.
 *
 * @author [Albert Ondicho]
 */
package codebaze.co.ke.Introduction_To_SpringBoot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * The @RestController annotation indicates that this class handles REST requests.
 * It combines @Controller and @ResponseBody, meaning:
 * - Every method returns a domain object instead of a view
 * - Responses are automatically converted to JSON/XML
 * - No explicit view resolution is needed
 *
 * The @RequestMapping("/api/") annotation:
 * - Acts as a base path for all mappings in this controller
 * - All endpoints in this controller will start with /api/
 * - Example: @GetMapping("hello") becomes /api/hello
 * - Helps organize related endpoints under a common prefix
 */
@RestController
@RequestMapping("/api/")
public class ApplicationController {

    /**
     * The service layer that handles greeting operations.
     * This bean is automatically injected by Spring.
     */
    @Autowired
    private IntroductionService introductionService;

    /**
     * Returns a generic greeting message.
     *
     * @return A simple "hello world" message
     */
    @GetMapping(value = "hello")
    public String helloWorld() {
        return introductionService.helloWorld();
    }

    /**
     * Returns a personalized greeting message based on the provided name.
     *
     * @param name The name to include in the greeting
     * @return A greeting message including the provided name
     */
    @GetMapping(value = "hello/{name}")
    public String helloWorld(@PathVariable String name) {
        return introductionService.personalHello(name);
    }
}