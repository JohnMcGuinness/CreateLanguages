package minicalc.ch06_ast;

import java.util.List;

public final class ReferenceByName<N extends Named>  {

    public String name;
    public N referenced;

    private ReferenceByName(String name, N referenced) {
        this.name = name;
        this.referenced = referenced;
    }

    public boolean attemptToResolve(List<N> candidates) {

        this.referenced = candidates.stream()
                                    .filter(c -> c.name().equals(name))
                                    .findFirst()
                                    .orElse(null);

        return referenced != null;

    }

    @Override
    public String toString() {

        return referenced == null
               ? "Ref(" + name + ")[Unsolved]"
               : "Ref(" + name + ")[Solved]";
    }
}
