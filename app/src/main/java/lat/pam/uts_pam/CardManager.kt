package lat.pam.uts_pam

object CartManager {
    val cartItems = mutableListOf<MenuItem>()

    fun clearCart() {
        cartItems.clear()
    }
}