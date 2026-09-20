public class ShoppingCart {
    private double[] prices;
    private int itemCount;
    private final String cartId;
    public ShoppingCart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new double[maxItems];
        this.itemCount = 0;
    }
    public void addItem(double price) {
        if (itemCount < prices.length) {
            prices[itemCount] = price;
            itemCount++;
        } else {
            System.out.println("Cart is full.");
        }
    }
    public double getTotal() {
        double total = 0;
        for (int i = 0; i < itemCount; i++) {
            total = total + prices[i];
        }
        return total;
    }
    public int getItemCount() {
        return itemCount;
    }
    public String getCartId() {
        return cartId;
    }
    public static void main(String[] args) {
        ShoppingCart cart =
                new ShoppingCart("CART-5", 20);
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        System.out.println("Cart ID: "
                + cart.getCartId());
        System.out.println("Total: "
                + cart.getTotal());
        System.out.println("Item count: "
                + cart.getItemCount());
    }
}