import kotlin.test.Test
import kotlin.test.assertTrue

class SellerTest {
    @Test
    fun `존재하는 물품의 수량을 반환`() {
        val seller = Seller()
        seller.addPrice("사과", 1000)
        seller.addStock("사과", 10)
        assertTrue(seller.getStockLeft("사과") == 10)
    }

    @Test
    fun `존재하지 않는 물품의 수량은 Exception`() {
        try {
            val seller = Seller()
            seller.addPrice("사과", 1000)
            seller.addStock("사과", 10)
            seller.getStockLeft("바나나")
        } catch (e: Exception) {
            assertTrue(e is NonSellingItemException)
        }
    }

    @Test
    fun `존재하는 물품의 가격을 반환`() {
        val seller = Seller()
        seller.addPrice("사과", 1000)
        assertTrue(seller.getPrice("사과") == 1000)
    }

    @Test
    fun `존재하지 않는 물품의 가격은 Exception`() {
        try {
            val seller = Seller()
            seller.addPrice("사과", 1000)
            seller.getPrice("바나나")
        } catch (e: Exception) {
            assertTrue(e is NonSellingItemException)
        }
    }

    @Test
    fun `주문한 상품의 총 가격을 반환`() {
        val seller = Seller()
        seller.addPrice("사과", 1000)
        seller.addPrice("바나나", 2000)
        seller.addStock("사과", 10)
        seller.addStock("바나나", 10)
        val order = hashMapOf("사과" to 3, "바나나" to 2)
        assertTrue(seller.getTotalPrice(order) == 7000)
    }

    @Test
    fun `주문한 상품의 총 가격이 재고보다 많으면 Exception`() {
        try {
            val seller = Seller()
            seller.addPrice("사과", 1000)
            seller.addStock("사과", 10)
            val order = hashMapOf("사과" to 20)
            seller.getTotalPrice(order)
        } catch (e: Exception) {
            assertTrue(e is NotEnoughStockException)
        }
    }

    @Test
    fun `주문한 상품의 총 가격이 6개 미만이면 10% 할인`() {
        val seller = Seller()
        seller.addPrice("사과", 1000)
        seller.addStock("사과", 5)
        val order = hashMapOf("사과" to 5)
        assertTrue(seller.getTotalPrice(order) == 4500)
    }

    @Test
    fun `음수 개수로 주문하는 경우`() {
        try {
            val seller = Seller()
            seller.addPrice("사과", 1000)
            seller.addStock("사과", 10)
            val order = hashMapOf("사과" to -5)
            seller.getTotalPrice(order)
        } catch (e: Exception) {
            assertTrue(e is IllegalArgumentException)
        }
    }

    @Test
    fun `재고를 추가하는 경우`() {
        val seller = Seller()
        seller.addPrice("사과", 1000)
        seller.addStock("사과", 10)
        assertTrue(seller.getStockLeft("사과") == 10)
        seller.addStock("사과", 5)
        assertTrue(seller.getStockLeft("사과") == 15)
    }
}