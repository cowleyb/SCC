public class TestHarness {
    public static void main(String[] args) {
        OptimizedLog<String> log = new OptimizedLog<>();

        OptimizedLog<String> log1 = new OptimizedLog<>();
        log.add("Hello world!");
        log.add("ffdfdfdf");
        log.add("df");
        log.add("34");
        log1.addAll(log);
        
        System.out.println(log);
    }
    
}
