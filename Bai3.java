import java.util.Locale;

public class Bai3 {
    static abstract class Payment {
        protected String paymentType;
        protected String methodName;

        public Payment(String paymentType, String methodName) {
            this.paymentType = paymentType;
            this.methodName = methodName;
        }

        public abstract void pay(double amount);

        protected String formatMoney(double amount) {
            return String.format(Locale.GERMANY, "%,.0f", amount);
        }

        public String getPaymentType() {
            return paymentType;
        }

        public String getMethodName() {
            return methodName;
        }
    }

    static class CreditCardPayment extends Payment {
        public CreditCardPayment() {
            super("Không dùng tiền mặt", "Thẻ tín dụng");
        }

        @Override
        public void pay(double amount) {
            System.out.println("Thanh toán " + formatMoney(amount) + " bằng thẻ tín dụng.");
        }
    }

    static class PayPalPayment extends Payment {
        public PayPalPayment() {
            super("Không dùng tiền mặt", "PayPal");
        }

        @Override
        public void pay(double amount) {
            System.out.println("Thanh toán " + formatMoney(amount) + " qua PayPal.");
        }
    }

    static class CashPayment extends Payment {
        public CashPayment() {
            super("Trực tiếp", "Tiền mặt");
        }

        @Override
        public void pay(double amount) {
            System.out.println("Thanh toán " + formatMoney(amount) + " bằng tiền mặt.");
        }
    }

    static class MoMoPayment extends Payment {
        public MoMoPayment() {
            super("Không dùng tiền mặt", "MoMo");
        }

        @Override
        public void pay(double amount) {
            System.out.println("Thanh toán " + formatMoney(amount) + " qua MoMo.");
        }
    }

    static class Order {
        private String customerName;
        private double amount;
        private Payment payment;

        public Order(String customerName, double amount, Payment payment) {
            this.customerName = customerName;
            this.amount = amount;
            this.payment = payment;
        }

        public void checkout() {
            System.out.println("Khách hàng: " + customerName);
            payment.pay(amount);
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Order o1 = new Order("An", 200000, new CreditCardPayment());
        Order o2 = new Order("Bình", 150000, new PayPalPayment());
        Order o3 = new Order("Chi", 100000, new CashPayment());
        Order o4 = new Order("Dũng", 300000, new MoMoPayment());

        o1.checkout();
        o2.checkout();
        o3.checkout();
        o4.checkout();
    }
}