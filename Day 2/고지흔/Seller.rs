use std::collections::HashMap;

struct Seller {
    item_num: HashMap<String, i32>,
    item_price: HashMap<String, i32>,
}

impl Seller {
    fn new() -> Seller {
        let mut item_num = HashMap::new();
        item_num.insert("TV".to_string(), 100);
        item_num.insert("냉장고".to_string(), 50);
        item_num.insert("세탁기".to_string(), 30);
        item_num.insert("에어컨".to_string(), 20);

        let mut item_price = HashMap::new();
        item_price.insert("TV".to_string(), 100);
        item_price.insert("냉장고".to_string(), 80);
        item_price.insert("세탁기".to_string(), 20);
        item_price.insert("에어컨".to_string(), 50);

        Seller {
            item_num,
            item_price,
        }
    }

    fn get_num(&self, item: &str) -> i32 {
        *self.item_num.get(item).unwrap_or(&-1)
    }

    fn get_price(&self, item: &str) -> i32 {
        *self.item_price.get(item).unwrap_or(&-1)
    }

    fn order(&mut self, item_dict: &HashMap<String, i32>) {
        let mut total_price = 0;
        for (item, num) in item_dict {
            let stock = self.get_num(item);
            if stock < *num {
                println!("{}의 재고가 부족합니다, 다시 주문해주세요", item);
                return;
            }

            let item_price = self.get_price(item);
            if stock <= 5 {
                total_price += item_price * num * 9 / 10;
            } else if stock - num <= 5 {
                let discount_price = item_price * 9 / 10;
                total_price += item_price * (stock - 5) + discount_price * (num - (stock - 5));
            } else {
                total_price += item_price * num;
            }

            *self.item_num.entry(item.to_string()).or_insert(0) -= num;
        }
        println!("{}", total_price);
    }

    fn set_num(&mut self, item: &str, num: i32) {
        self.item_num.insert(item.to_string(), num);
    }
}

fn main() {
    let mut seller1 = Seller::new();
    println!("{}", seller1.get_num("TV"));
    println!("{}", seller1.get_price("TV"));
    seller1.set_num("TV", 10);
    println!("{}", seller1.get_num("TV"));

    let mut order1 = HashMap::new();
    order1.insert("TV".to_string(), 7);
    seller1.order(&order1);

    let mut order2 = HashMap::new();
    order2.insert("TV".to_string(), 7);
    order2.insert("냉장고".to_string(), 2);
    order2.insert("세탁기".to_string(), 1);
    order2.insert("에어컨".to_string(), 1);
    seller1.order(&order2);
}
