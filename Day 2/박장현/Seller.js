// -------------- 예시 데이터 ------------
// 재고현황 => 물품: 수량
let stock_status = {
    "바나나" : 10,
    "사과" : 6,
    "딸기" : 4,
}

// 가격표 => 물품 : 가격
let price_table = {
    "바나나" : 1000,
    "사과" : 2000,
    "딸기" : 3000,
}

// 구매목록 => 물품: 구매수량
let buy_list = {
    "바나나" : 0,
    "사과" : 0,
    "딸기" : 0,
}


// -----------------------------------

class Seller{
    constructor(stock_status, price_table, buy_list){
        this.stock_status = stock_status;
        this.price_table = price_table;
        this.buy_list = buy_list;
    }

    // 메소드 1
    return_stock_number(item){
        if (stock_status[item] == undefined){
            return "존재하지 않는 물품입니다.";
        }

        return stock_status[item];
    }
    
    // 메소드 2
    return_price_table(item){
        if (price_table[item] == undefined){
            return "존재하지 않는 물품입니다.";
        }
        
        return price_table[item];
    }

    // 메소드 3
    return_buy_list(item_list){
        buy_list = item_list;
        let total_price = 0;
        for (let i = 0; i < buy_list.length; i++){
            let purchasable = false
            let purchase_quantity = buy_list[i][1];
            if (purchase_quantity > stock_status[buy_list[i][1]]){
                console.log("재고가 부족합니다.");
            }
            else{
                purchasable = true;
            }

            if(purchasable) {
                let price = this.return_price_table(buy_list[i][0]);
                total_price += (price * purchase_quantity);
            }

        }
        return total_price;
    }
    

};


// 인스턴스 생성
var person = new Seller(stock_status, price_table, buy_list);


// 찍어보기
console.log(person.return_stock_number("바나나"));
console.log(person.return_price_table("바나나"));
console.log(person.return_buy_list([["바나나", 3], ["사과", 2], ["딸기", 1]]) );
