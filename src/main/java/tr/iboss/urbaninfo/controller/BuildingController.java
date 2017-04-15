package tr.iboss.urbaninfo.controller;
 
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import tr.iboss.urbaninfo.dto.BuildingDto;
 
@RestController
public class BuildingController {
 
    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
 
    @ApiOperation(value = "getGreeting", nickname = "getGreeting")
    @RequestMapping(method = RequestMethod.GET, path="/greeting", produces = "application/json")
    @ApiImplicitParams({
        @ApiImplicitParam(name = "name", value = "User's name", required = false, dataType = "string", paramType = "query", defaultValue="Niklas")
      })
    public BuildingDto greeting(@RequestParam(value="name", defaultValue="World") String name) {
        return new BuildingDto(counter.incrementAndGet(),
                String.format(template, name));
    }
}