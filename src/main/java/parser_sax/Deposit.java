package main.java.parser_sax;

public class Deposit {
    private String name;
    private String id;
    private String country;
    private String type;
    private long account;
    private double profitability;

    public Depositor depositor;
    public AmountOnDeposit amountOnDeposit;
    public TimeConstraints timeConstraints;

    public Deposit() {
        this.depositor = new Depositor();
        this.amountOnDeposit = new AmountOnDeposit();
        this.timeConstraints = new TimeConstraints();
    }

    public void setName(String name) {
        this.name = name;
    }


    public void setCountry(String country) {
        this.country = country;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setAccount(long account) {
        this.account = account;
    }

    public void setProfitability(double profitability) {
        this.profitability = profitability;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Deposit{" +
                "name='" + name + '\'' +
                ", id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", type='" + type + '\'' +
                ", account=" + account +
                ", profitability=" + profitability +
                ", depositor=" + depositor +
                ", amountOnDeposit=" + amountOnDeposit +
                ", timeConstraints=" + timeConstraints +
                '}';
    }

    class Depositor {
        private String sex;
        private byte age;
        private String firstName;
        private String lastName;

        public void setSex(String sex) {
            this.sex = sex;
        }

        public void setAge(byte age) {
            this.age = age;
        }

        public void setFirstName(String firstName) {
            this.firstName = firstName;
        }

        public void setLastName(String lastName) {
            this.lastName = lastName;
        }

        @Override
        public String toString() {
            return "Depositor{" +
                    "sex='" + sex + '\'' +
                    ", age=" + age +
                    ", firstName='" + firstName + '\'' +
                    ", lastName='" + lastName + '\'' +
                    '}';
        }
    }

    class AmountOnDeposit {

        private int dollars = 0;
        private int hrivnas = 0;

        public void setDollars(int dollars) {
            this.dollars = dollars;
        }

        public void setHrivnas(int hrivnas) {
            this.hrivnas = hrivnas;
        }

        @Override
        public String toString() {
            return "AmountOnDeposit{" +
                    "dollars=" + dollars +
                    ", hrivnas=" + hrivnas +
                    '}';
        }
    }

    class TimeConstraints {
        private int days;

        public void setDays(int days) {
            this.days = days;
        }

        @Override
        public String toString() {
            return "TimeConstraints{" +
                    "days=" + days +
                    '}';
        }
    }
}
