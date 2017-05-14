package tr.iboss.urbaninfo.dto;
 
import com.fasterxml.jackson.annotation.JsonProperty;
 
import io.swagger.annotations.ApiModelProperty;
 
public class GreetingDto {
 
    private final long id;
    private final String content;
 
    public GreetingDto(long id, String content) {
        this.id = id;
        this.content = content;
    }
 
    public long getId() {
        return id;
    }
 
    @JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
    public String getContent() {
        return content;
    }
}