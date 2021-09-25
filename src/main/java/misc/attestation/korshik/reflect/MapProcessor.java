package misc.attestation.korshik.reflect;

import java.util.Map;
import java.util.Set;

public class MapProcessor implements ReflectionProcessor {
    private Map<String, Object> object;
    private String objectClass;

    public MapProcessor(Object object) {
        this.object = (Map<String, Object>) object;
        this.objectClass = object.getClass().getName();
    }

    @Override
    public void process(Set<String> fieldsToCleanup, Set<String> fieldsToOutput) {
        checkKeyAvailability(fieldsToCleanup);
        checkKeyAvailability(fieldsToOutput);

        deleteKeys(fieldsToCleanup);
        printValues(fieldsToOutput);
    }

    /**
     * Удаляет указанные в <code>keysToCleanup</code> ключи из коллекции
     *
     * @param keysToCleanup список ключей, которые необходимо удалить
     */
    protected void deleteKeys(Set<String> keysToCleanup) {
        for (String key : keysToCleanup) {
            object.remove(key);

        }
    }

    /**
     * Печатает все значения из <code>object</code> с ключами, соответствующими <code>keysToOutput</code>
     *
     * @param keysToOutput для каких ключей выводить значения
     */
    protected void printValues(Set<String> keysToOutput) {
        for (String key : keysToOutput) {
            Object value = object.get(key);
            
            if (value != null) {
                System.out.println(CleanerPrinter.valueToString(value));
            }
        }
    }

    /**
     * Проверяет в обрабатываемом объекте наличие ключей, к которым будут обращаться
     *
     * @param keysToCheck множество ключей, которые должны быть в коллекции
     */
    protected void checkKeyAvailability(Set<String> keysToCheck) {
        for (String key : keysToCheck) {
            if (!object.containsKey(key)) {
                throw new IllegalArgumentException("В объекте '" + objectClass + "' нет ключа '" + key + "'!");
            }
        }
    }
}
