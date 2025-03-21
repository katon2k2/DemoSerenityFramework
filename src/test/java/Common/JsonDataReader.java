package Common;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonDataReader {
    public static Data getTestData() throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                Paths.get("src/test/resources/Data.json").toFile(),
                Data.class
        );
    }
}
