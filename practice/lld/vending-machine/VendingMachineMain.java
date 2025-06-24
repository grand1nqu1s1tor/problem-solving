package vending

public class VendingMachineMain {
    public static void main(String[] args) {
        Product coke = new Product(1, "Coke", 125); // price in cents ($1.25)
        Inventory inventory = new Inventory();
        inventory.addItem(coke, 5); // Add 5 Cokes to machine

        // 2. Create supporting components
        vending.PaymentProcessor processor = new vending.PaymentProcessor();
        Dispenser dispenser = new Dispenser();

        // 3. Initialize VendingMachineService
        vending.VendingMachineService machine = new vending.VendingMachineService(inventory, processor, dispenser);

        // 4. User Interaction Flow
        System.out.println("=== Buying a Coke ===");

        machine.insertCoin(Coin.DOLLAR);    // +$1.00
        machine.insertCoin(Coin.QUARTER);   // +$0.25

        machine.selectProduct(1);           // Coke
        machine.dispense();                 // Dispenses product & change (if any)

        // 5. Inventory After Purchase
        machine.showInventory();
    }
}
