
class normalBook extends Book {
    int stock;

    normalBook(String isbn, String title, int year, double price, String author, int stock) {
        super(isbn, title, year, price, author);
        this.stock = stock;
    }

    boolean isForSale() { return true; }

    double buy(int quantity, String email, String address) {
        if (stock < quantity) {
            throw new RuntimeException("Quantum book store: Not enough stock");
        }
        stock -= quantity;
        ShippingService.ship(title, address);
        return price * quantity;
    }
}