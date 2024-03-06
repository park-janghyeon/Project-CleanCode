class Seller:
    def __init__(self):
        self.products = {"Yoo": 1000, "yong": 2000, "min": 3000}
        self.prices = {"Yoo": 10000, "yong": 20000, "min": 30000}
        self.total_price=0

    

    def Jaego(self, product):
        if product in self.products:
            print("물품 재고 수량:{}".format(self.products[product]))
        else:
            print("유용민밖에 없어용")

    def Gagyuk(self, product):
        if product in self.products:
            print(f"가격 현황: {self.prices[product]}")
        else:
            print("우리 용민이 아니에용")

    def Buy(self,buy_things):
        # print(buy_things)
        

        for products in buy_things.keys():
            self.total_price += self.prices[products]*buy_things[products]
            self.products[products]=self.products[products]-buy_things[products]
            print("남은 재고 수량: {}".format(self.products[products]))
        return self.total_price
            
            

seller1 = Seller()

seller1.Jaego("Yoo")
seller1.Gagyuk("Yoo")
print(seller1.Buy({"Yoo":2,"yong":3,"min":4}))
    
            

