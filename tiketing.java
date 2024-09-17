import java.util.Scanner;

class TicketMachine {
    private int ticketPrice;
    private int balance;
    private int totalSales;

    public TicketMachine(int price) 
    {
        ticketPrice = price;
        balance = 0;
        totalSales = 0;
    }

    public void insertMoney(int amount) 
    {
        if (amount > 0) {
            balance += amount;
            System.out.println("Anda memasukkan uang sebesar: Rp " + amount);
        } else {
            System.out.println("Jumlah uang tidak valid!");
        }
    }

    public void buyTicket() 
    {
        if (balance >= ticketPrice) 
        {
            balance -= ticketPrice;
            totalSales += ticketPrice;
            printReceipt();
        } else {
            System.out.println("Uang tidak cukup! Silakan masukkan tambahan uang.");
        }
    }

    public void refundMoney()
     {
        if (balance > 0) {
            System.out.println("Kembalian Anda sebesar: Rp " + balance);
            balance = 0;
        } else {
            System.out.println("Tidak ada uang yang dapat dikembalikan.");
        }
    }

   
    private void printReceipt() 
    {
        System.out.println("===== Tanda Terima =====");
        System.out.println("Tiket dibeli seharga: Rp " + ticketPrice);
        System.out.println("Sisa saldo: Rp " + balance);
        System.out.println("========================");
    }

    public void showTotalSales() 
    {
        System.out.println("Total penjualan tiket: Rp " + totalSales);
    }
}

public class Main 
{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TicketMachine machine = new TicketMachine(5000); // Harga tiket adalah Rp 5000

        boolean running = true;
        while (running) {
            System.out.println("\n1. Masukkan Uang");
            System.out.println("2. Beli Tiket");
            System.out.println("3. Kembalikan Uang");
            System.out.println("4. Lihat Total Penjualan");
            System.out.println("5. Keluar");
            System.out.print("Pilih opsi: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Masukkan jumlah uang: ");
                    int amount = scanner.nextInt();
                    machine.insertMoney(amount);
                    break;
                case 2:
                    machine.buyTicket();
                    break;
                case 3:
                    machine.refundMoney();
                    break;
                case 4:
                    machine.showTotalSales();
                    break;
                case 5:
                    System.out.println("Terima kasih telah menggunakan mesin tiket.");
                    running = false;
                    break;
                default:
                    System.out.println("Pilihan tidak valid. Silakan coba lagi.");
            }
        }

        scanner.close();
    }
}
