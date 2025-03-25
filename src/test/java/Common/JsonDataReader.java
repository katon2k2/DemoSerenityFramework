package Common;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.nio.file.Paths;

public class JsonDataReader {
    public static DataWeb getTestDataWeb(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                Paths.get(filePath).toFile(),
                DataWeb.class
        );
    }

    public static DataApi getTestDataApi(String filePath) throws IOException {
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.readValue(
                Paths.get(filePath).toFile(),
                DataApi.class
        );
    }
}
