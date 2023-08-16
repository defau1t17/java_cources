package utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class History {

    Operation operation;

    private final static List<Operation> operations = new ArrayList<>();

    public void add_operation(Operation operation) {
        operations.add(operation);
    }

    public Optional<Operation> findOperationsByUserName(String userName) {
        for (Operation op : operations) {
            if (op.getUser().getUserName().equals(userName)) {
                return Optional.of(op);
            }
        }
        return Optional.empty();
    }


}
