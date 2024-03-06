using namespace std;

class CPP {
private:
    map<string, long long> price_list;
    map<string, long long> stock_list;

public:
    long long get_price(string product){
        for(auto iter = price_list.begin(); iter != product_list.end(); iter++){
            if(product.compare(iter->first) == 0){
                return iter->second;
            }
        }

        return -1;
    }

    long long get_stock(string product){
        for(auto iter = stock_list.begin(); iter != stock_list.end(); iter++){
            if(product.compare(iter->first) == 0){
                return iter->second;
            }
        }

        return 0;
    }

    long long buy_product(map<string, long long> buy_list){
        long long total_price = 0;

        for(auto iter_buy = buy_list.begin(); iter_buy != buy_list.end(); iter_buy++){
            if(iter_buy->second < 0){
                continue;
            }

            string cur_product = iter_buy->first;
            for(auto iter_stock = stock_list.begin(); iter_stock != stock_list.end(); iter_stock++){
                if(cur_product.compare(iter_stock->first) == 0
                    && iter_stock->second >= iter_buy->second){
                    iter_stock->second -= iter_buy->second;
                    total_price += price_list[cur_product] * (iter_stock <= 5 ? 9 / 10 : 1) * iter_buy->second;
                }
            }

            return total_price;
        }
    }

    long long insert_stock(string product, long long count){
        if(count < 0){
            return -1;
        }

        stock_list[product] += count;
        return stock_list[product];
    }
}