package minicalc.ch06_ast;

import java.util.List;
import java.util.Objects;

public final class ReferenceByName<N extends Named>  {

    private String name;
    private N referenced;

    public static <N extends Named> ReferenceByName<N> ReferenceByName(String name, N referenced) {
        return new ReferenceByName(name, referenced);
    }

    private ReferenceByName(String name, N referenced) {
        this.name = Objects.requireNonNull(name, "name is required");
        this.referenced = referenced;
    }

    public boolean attemptToResolve(List<N> candidates) {

        this.referenced = candidates.stream()
                                    .filter(c -> c.name().equals(name))
                                    .findFirst()
                                    .orElse(null);

        return referenced != null;

    }

    public String name() {
        return name;
    }

    public N referenced() {
        return referenced;
    }

    @Override
    public String toString() {

        return referenced == null
               ? "Ref(" + name + ")[Unsolved]"
               : "Ref(" + name + ")[Solved]";
    }
}
