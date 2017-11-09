package minicalc.ch06_ast;

import java.lang.reflect.Field;
import java.util.Collection;
import java.util.function.Consumer;
import java.util.logging.Level;
import java.util.logging.Logger;

public interface Node {

    public Position position();

    public default void process(Consumer<Node> operation) {
        operation.accept(this);

        for(Field field : getClass().getDeclaredFields()) {

            try {

                final Object value = field.get(this);

                if(value instanceof Node) {
                    ((Node) value).process(operation);
                }
                else if (value instanceof Collection<?>) {

                    ((Collection<?>) value).forEach(

                        v -> {
                            if(v instanceof Node) {
                                ((Node) v).process(operation);
                            }
                        }
                    );
                }
            }
            catch (IllegalArgumentException | IllegalAccessException ex) {
                Logger.getLogger(Node.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
