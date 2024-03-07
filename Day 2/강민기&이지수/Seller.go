package main

import "fmt"

type Seller struct {
	stockList map[string][2]interface{}
}

func newSeller() *Seller {
	s := Seller{}
	s.stockList = make(map[string][2]interface{})
	s.stockList["ABCD"] = [2]interface{}{1, 10.0}
	s.stockList["QWER"] = [2]interface{}{2, 15.0}
	return &s
}

func (s Seller) getAmount(name string) int {
	temp := s.stockList[name]
	return temp[0].(int)
}

func (s Seller) getPrice(name string) float64 {
	temp := s.stockList[name]
	return temp[1].(float64)
}

func (s Seller) getTotalPrice(purchaseList map[string]int) float64 {
	totalPrice := 0.0

	for name, quantity := range purchaseList {
		if stock, ok := s.stockList[name]; ok {
			availableQuantity := stock[0].(int)
			price := stock[1].(float64)
			// 구매수량이 재고보다 많은 경우 처리
			if quantity <= availableQuantity { 
				totalPrice += float64(quantity) * price 
			} else { 
				totalPrice += float64(availableQuantity) * price
			}
		}
	}

	return totalPrice
}

func main() {

	seller := newSeller()

	// getTotalPrice 함수 테스트
	purchaseList := map[string]int{
		"ABCD": 1,
		"QWER": 3,
	}
	totalPrice := seller.getTotalPrice(purchaseList)
	fmt.Println("Total Price:", totalPrice)
}
