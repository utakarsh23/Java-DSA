class SalesTaxCalculator {
    float amount;
    float taxRate;

    SalesTaxCalculator() {
        amount = 100.0f;
        taxRate = 10.2f;
    }

    SalesTaxCalculator(float a, float t) {
        amount = a;
        taxRate = t;
    }

    void calculateTax() {
        float taxAmt = amount * taxRate / 100;
        System.out.println("Tax Amount: " + taxAmt);
    }

    public static void main(String[] args) {
        SalesTaxCalculator obj1 = new SalesTaxCalculator();
        SalesTaxCalculator obj2 = new SalesTaxCalculator(200.0f, 5.0f);

        System.out.println("Object 1:");
        obj1.calculateTax();

        System.out.println("Object 2:");
        obj2.calculateTax();
    }
}