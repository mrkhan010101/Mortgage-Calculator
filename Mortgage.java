import java.text.NumberFormat;
import java.util.Scanner;

public class Mortgage {
    public static void main(String[] args) {
        final byte month_in_year = 12;
        final byte percent = 100;
        int principal = 0;
        float anual_Interest_rate = 0;
        float monthly_Interest = 0;
        byte year = 0;
        int number_Of_Payment = 0;

        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.print("principal ($1k - $1M): ");
            principal = sc.nextInt();
            if (principal >= 1000 && principal <= 1000000)
                break;
            System.out.println("Enter a number between 1,000 to 1,000,000.");
        }
        while (true) {
            System.out.print("Anual Rate(1 to 30): ");
            anual_Interest_rate = sc.nextFloat();
            monthly_Interest = anual_Interest_rate / month_in_year / percent;
            if (anual_Interest_rate >= 1 && anual_Interest_rate <= 30)
                break;
            System.out.println("Enter the value Greater than 0 and less than or equal to 30");
        }
        while (true) {
            System.out.print("Period: ");
            year = sc.nextByte();
            number_Of_Payment = year * month_in_year;
            if (year >= 1 && year <= 30)
                break;
            System.out.println("Enter Value between 1 and 30");
        }
        /*
         * Mortgage formula M=P*(r(1+r)**n)/((1+r)**n)-1 where, M=mortgage p=principal
         * r=monthly rate(annual interest/percent(100)/month in year(12)) n=number of
         * payment(year*month in year)
         */
        double mortgage = principal * (monthly_Interest * Math.pow(1 + monthly_Interest, number_Of_Payment))
                / (Math.pow(1 + monthly_Interest, number_Of_Payment) - 1);
        String mortgageFormat = NumberFormat.getCurrencyInstance().format(mortgage);

        System.out.println("Mortgage: " + mortgageFormat);
    }
}
