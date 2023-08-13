package code.utils;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class StringConverter {
    public final static Map<Class<?>, Function<String, ?>> methodForType = new HashMap<>();

    static {
        methodForType.put(float.class, e -> {
            Float f = Float.parseFloat(e);
            if(f.isInfinite()) throw new NumberFormatException();
            return f;
        });
        methodForType.put(Float.class, methodForType.get(float.class));
        methodForType.put(int.class, Integer::parseInt);
        methodForType.put(Integer.class, Integer::parseInt);
        methodForType.put(long.class, Long::parseLong);
        methodForType.put(Long.class, Long::parseLong);
        methodForType.put(Double.class, Double::parseDouble);
        methodForType.put(double.class, methodForType.get(Double.class));
        methodForType.put(String.class, e -> e);
    }
}
