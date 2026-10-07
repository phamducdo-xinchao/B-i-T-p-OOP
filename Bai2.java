public class Bai2 {

    interface EmailSender {
        void sendEmail(String to, String content);
    }

    interface Programmer {
        void writeCode();
    }

    interface Salesperson {
        void sell(String product);
    }

    static class OfficeEmployee implements EmailSender {
        private String name;

        public OfficeEmployee(String name) {
            this.name = name;
        }

        @Override
        public void sendEmail(String to, String content) {
            System.out.println("[Văn phòng] " + name + " gửi email cho " + to + ": " + content);
        }
    }

    static class TechnicalEmployee implements Programmer, EmailSender {
        private String name;

        public TechnicalEmployee(String name) {
            this.name = name;
        }

        @Override
        public void writeCode() {
            System.out.println("[Kỹ thuật] " + name + " đang viết code.");
        }

        @Override
        public void sendEmail(String to, String content) {
            System.out.println("[Kỹ thuật] " + name + " gửi email cho " + to + ": " + content);
        }
    }

    static class SalesEmployee implements Salesperson, EmailSender {
        private String name;

        public SalesEmployee(String name) {
            this.name = name;
        }

        @Override
        public void sell(String product) {
            System.out.println("[Bán hàng] " + name + " đang bán sản phẩm: " + product);
        }

        @Override
        public void sendEmail(String to, String content) {
            System.out.println("[Bán hàng] " + name + " gửi email cho " + to + ": " + content);
        }
    }

    public static void main(String[] args) {
        OfficeEmployee office = new OfficeEmployee("An");
        TechnicalEmployee tech = new TechnicalEmployee("Binh");
        SalesEmployee sales = new SalesEmployee("Chi");

        System.out.println("--- Chức năng của từng nhân viên ---");
        office.sendEmail("sep@congty.com", "Báo cáo tuần này");
        tech.writeCode();
        tech.sendEmail("khachhang@gmail.com", "Đã sửa xong lỗi");
        sales.sell("Laptop");
        sales.sendEmail("khachhang@gmail.com", "Báo giá sản phẩm");

        System.out.println();
        System.out.println("--- Cả công ty cùng gửi email ---");
        EmailSender[] senders = { office, tech, sales };
        for (EmailSender s : senders) {
            s.sendEmail("all@congty.com", "Thông báo họp lúc 9h sáng");
        }
    }
}