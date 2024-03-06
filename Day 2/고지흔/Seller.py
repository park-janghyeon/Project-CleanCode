class Seller:
    def __init__(self):
        self.item_num = {"TV" : 100, "냉장고" : 50, "세탁기" : 30, "에어컨" : 20}
        self.item_price = {"TV" : 100, "냉장고" : 80, "세탁기" : 20, "에어컨" : 50}
    def get_num(self, item):
        return self.item_num.get(item, -1)
    def get_price(self, item):
        return self.item_price.get(item, -1)
    def order(self, item_dict):
        total_price = 0
        for item, num in item_dict.items():
            if self.get_num(item) < num:
                print(f"{item}의 재고가 부족합니다, 다시 주문해주세요")
                return
            if self.get_num(item) <= 5:
                total_price += (self.get_price(item) * num) * 0.9
            elif self.get_num(item) - num <= 5:
                total_price += (self.get_price(item) * (self.get_num(item) - 5)) + (self.get_price(item) * (num - (self.get_num(item) - 5))) * 0.9
            else:
                total_price += self.get_price(item) * num
            self.item_num[item] -= num
        print(total_price)
    def set_num(self, item, num):
        self.item_num[item] = num

seller1= Seller()
print(seller1.get_num("TV"))
print(seller1.get_price("TV"))
seller1.set_num("TV", 10)
print(seller1.get_num("TV"))
seller1.order({"TV" : 7})
seller1.order({"TV" : 7, "냉장고" : 2, "세탁기" : 1, "에어컨" : 1})