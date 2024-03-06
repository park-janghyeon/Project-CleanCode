class Seller:
    def __init__(self):
        # 재고 현황과 가격표 (Key: 물품 이름, Value: 수량 또는 가격)
        self.inventory = {'사과': 10, '바나나': 20, '오렌지': 5}
        self.price_list = {'사과': 1000, '바나나': 500, '오렌지': 1500}

    def check_stock(self, item):
        """특정 물품의 재고 수량을 반환합니다."""
        return self.inventory.get(item, 0)

    def check_price(self, item):
        """특정 물품의 가격을 반환합니다."""
        return self.price_list.get(item, 0)

    def calculate_total_price(self, order_list):
        """구매 목록의 총 가격을 계산합니다."""
        total = 0
        for item, quantity in order_list.items():
            stock = self.check_stock(item)
            if stock >= quantity:
                price = self.check_price(item)
                if stock <= 5:  # 재고가 5개 이하면 10% 할인
                    price *= 0.9
                total += price * quantity
        return total

    def add_stock(self, item, quantity):
        """재고 수량을 늘립니다."""
        if item in self.inventory:
            self.inventory[item] += quantity
        else:
            self.inventory[item] = quantity


seller = Seller()
print(seller.check_stock('사과'))  # 사과의 재고 확인
print(seller.check_price('사과'))  # 사과의 가격 확인
print(seller.calculate_total_price({'사과': 2, '바나나': 3}))  # 총 가격 계산
seller.add_stock('사과', 5)  # 사과 재고 추가
print(seller.check_stock('사과'))  # 사과 재고 확인