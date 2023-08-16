package utilities;

public class Operations {
    double num1;
    double mun2;
    String operation;

    public Operations() {
    }

    public Operations(double num1, double mun2, String operation) {
        this.num1 = num1;
        this.mun2 = mun2;
        this.operation = operation;
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getMun2() {
        return mun2;
    }

    public void setMun2(double mun2) {
        this.mun2 = mun2;
    }

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public double calculate(double num1, double num2, String operation) {
        switch (operation) {
            case "sum":
                return num1 + num2;

            case "multiply":
                return num1 * num2;

            case "diff":
                return num1 - num2;

            case "div":
                return num1 / num2;
        }
        return 0;

    }
}
