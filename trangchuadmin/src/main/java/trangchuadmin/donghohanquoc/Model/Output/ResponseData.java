package trangchuadmin.donghohanquoc.Model.Output;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseData <T>{
    private String code;
    private String message;
    private T data= null;
}
