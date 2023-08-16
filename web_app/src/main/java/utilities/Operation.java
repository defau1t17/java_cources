package utilities;

public class Operation {

    private Double num1;
    private Double num2;
    String operation_name;
    String result;
    User user;


    public Double getNum1() {
        return num1;
    }

    public void setNum1(Double num1) {
        this.num1 = num1;
    }

    public Double getNum2() {
        return num2;
    }

    public void setNum2(Double num2) {
        this.num2 = num2;
    }

    public String getOperation_name() {
        return operation_name;
    }

    public void setOperation_name(String operation_name) {
        this.operation_name = operation_name;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        String operation = "";
        switch (operation_name) {
            case "sum":
                operation = "+";
                break;
            case "multiply":
                operation = "*";
                break;

            case "diff":
                operation = "-";
                break;
            case "div":
                operation = "/";
                break;
        }
        return num1 + " " + operation + " " + num2 + " = " + result;

    }
}
