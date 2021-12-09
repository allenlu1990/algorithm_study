import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

/**
 * @author allen
 * @date 2021年12月08日 15:34
 */
public class String2Map {
    public static void main(String[] args) {
        String aa ="hello world";
        AtomicInteger i = new AtomicInteger();
        Map<String, String> collect = Arrays.stream(aa.split(""))
                .map(c -> (i.getAndIncrement()) + "_" + c)
                .collect(Collectors.toMap(key -> key.split("_")[0], v -> v.split("_")[1]));
        collect.forEach((k,v)-> System.out.println("key: "+ k + " value: " + v));

    }
}
