import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class MapExample {

    public static void main(String[] args) {
        Map<WorkerTaxInfo, GovernmentWorker> workers = new HashMap<>();

        var taxInfo1 = new WorkerTaxInfo(1, "Regular worker");
        var worker1 = new GovernmentWorker("Tomas M.");

        var taxInfo2 = new WorkerTaxInfo(2, "Temporary worker");
        var worker2 = new GovernmentWorker("Jason K.");

        var taxInfo3 = new WorkerTaxInfo(3, "Experienced worker");
        var worker3 = new GovernmentWorker("Debora L.");

        workers.put(taxInfo1, worker1);
        workers.put(taxInfo2, worker2);
        workers.put(taxInfo3, worker3);
        workers.remove(taxInfo1);

        for (Map.Entry<WorkerTaxInfo, GovernmentWorker> pair : workers.entrySet()) {
            System.out.println("Key: " + pair.getKey() + "   Value: " + pair.getValue());
        }
    }

    public static class GovernmentWorker {
        private String fullName;

        public GovernmentWorker(String fullName) {
            this.fullName = fullName;
        }

        @Override
        public String toString() {
            return "GovernmentWorker{" +
                    "fullName='" + fullName + '\'' +
                    '}';
        }
    }

    public static class WorkerTaxInfo implements Comparable<WorkerTaxInfo> {
        private int taxNumber;
        private String taxType;

        public WorkerTaxInfo(int taxNumber, String taxType) {
            this.taxNumber = taxNumber;
            this.taxType = taxType;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            WorkerTaxInfo that = (WorkerTaxInfo) o;
            return taxNumber == that.taxNumber && taxType.equals(that.taxType);
        }

        @Override
        public int hashCode() {
            return Objects.hash(taxNumber, taxType);
        }

        @Override
        public String toString() {
            return "WorkerTaxInfo{" +
                    "taxNumber=" + taxNumber +
                    ", taxType='" + taxType + '\'' +
                    '}';
        }

        @Override
        public int compareTo(WorkerTaxInfo o) {
            return Integer.compare(this.taxNumber, o.taxNumber);
        }
    }
}
