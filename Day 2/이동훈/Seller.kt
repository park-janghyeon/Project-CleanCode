import kotlin.math.roundToInt

class Seller {
    // 재고현황
    private val stocks = hashMapOf<String, Int>()

    // 가격표
    private val prices = hashMapOf<String, Int>()

    // 현재 남아있는 재고의 수량을 반환하는 함수
    fun getStockLeft(name: String): Int {
        if (stocks.contains(name).not()) throw NonSellingItemException("${name}은 판매하지 않습니다.")
        return stocks.getOrDefault(name, 0)
    }

    // 해당 상품의 가격을 반환하는 함수
    fun getPrice(name: String): Int {
        if (prices.contains(name).not()) throw NonSellingItemException("${name}은 판매하지 않습니다.")
        return prices.getOrDefault(name, 0)
    }

    // 주문한 상품의 총 가격을 반환하는 함수
    fun getTotalPrice(list: HashMap<String, Int>): Int {
        var totalPrice = 0
        list.map { (name, number) ->
            if (number < 0) throw IllegalArgumentException("주문 수량은 0보다 커야합니다.")
            totalPrice += if (getStockLeft(name) < number) throw NotEnoughStockException("재고가 부족합니다. 현재 ${name}의 재고는 ${getStockLeft(name)}개 입니다.")
            else if (getStockLeft(name) < 6) (getPrice(name) * number * 0.9).roundToInt()
            else getPrice(name) * number
        }
        return totalPrice
    }

    // 주문을 하는 함수
    fun order(list: HashMap<String, Int>) {
        list.map { (name, number) ->
            if (stocks.getOrDefault(
                    name,
                    0
                ) < number
            ) throw NotEnoughStockException("재고가 부족합니다. 현재 ${name}의 재고는 ${stocks.getOrDefault(name, 0)}개 입니다.")
            stocks[name] = stocks.getOrDefault(name, 0) - number
        }
    }

    // 재고를 추가하는 함수
    fun addStock(name: String, number: Int) {
        if (prices.contains(name).not()) throw NonSellingItemException("재고를 추가할 수 없습니다. 가격표에 추가 후 다시 시도해주세요.")
        stocks[name] = stocks.getOrDefault(name, 0) + number
    }

    // 가격표에 상품을 추가하는 함수
    fun addPrice(name: String, price: Int) {
        prices[name] = price
    }
}
