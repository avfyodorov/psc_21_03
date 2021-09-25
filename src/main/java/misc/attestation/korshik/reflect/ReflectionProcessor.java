package misc.attestation.korshik.reflect;

import java.util.Set;

public interface ReflectionProcessor {

    void process(Set<String> fieldsToCleanup, Set<String> fieldsToOutput);

}
