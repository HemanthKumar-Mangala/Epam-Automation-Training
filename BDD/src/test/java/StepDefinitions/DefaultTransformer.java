package StepDefinitions;




import io.cucumber.java.DefaultDataTableCellTransformer;
import io.cucumber.java.DefaultDataTableEntryTransformer;
import io.cucumber.java.DefaultParameterTransformer;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.JavaType;
import io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper;

import java.lang.reflect.Type;

public class DefaultTransformer {

ObjectMapper objectMapper = new io.cucumber.messages.internal.com.fasterxml.jackson.databind.ObjectMapper();

   @DefaultParameterTransformer
   @DefaultDataTableEntryTransformer
   @DefaultDataTableCellTransformer
   public Object defaultTransformer(Object fromValue, Type toValueType) {
  JavaType javaType = objectMapper.constructType(toValueType);
  return objectMapper
         .convertValue(fromValue, javaType);
   }
}