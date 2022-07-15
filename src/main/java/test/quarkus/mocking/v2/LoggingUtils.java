package test.quarkus.mocking.v2;

class LoggingUtils {
    public static void logClassAndHash(String label, Object obj) {
        System.out.println("___________________________________");
        System.out.printf("label: %s %n", label);
        System.out.println(obj.getClass());
        System.out.println(obj.hashCode());
        System.out.println("___________________________________");
    }

}

