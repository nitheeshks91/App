package app.generic.com.app.data.api.Response;

/**
 * Created by nitheesh on 6/9/16.
 */

public class SampleResponse {

  // field Name should match the response json

  //{
  //  "data":{"name":"chakkudu","age":26},"error":null
  //}

  public RData data;
  public String error;

  public class RData {
    public String name;
    public String age;
  }
}
