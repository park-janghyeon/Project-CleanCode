#include <iostream>
#include <map>

using namespace std;

class Seller {

    map<string,long long> price;
    map<string, long long> inventory;

    public:
        void setPrice(string product, long long pr) {
            if(pr >= 0)
                price.insert({product, pr});
            else 
                cout << "Price must be more than 0\n";
        }

        void setInventory(string product, long long cnt) {
            if(cnt > 0)
                inventory.insert({product, cnt});
            else
                cout << "Count must be more than 1\n";
        }

        long long getProductNum(string product) {
            return inventory[product];
        }

        long long getProductPrice(string product) {
            return price[product];
        }

        long long getList(map<string, long long> list){
            long long totalPrice = 0;

            for(auto iter=list.begin(); iter != list.end(); iter++)
            {
                if(inventory[iter->first] >= iter->second && iter->second >= 0) {
                    totalPrice += price[iter->first] * iter->second;
                }
                else 
                {
                    cout << "No " << iter->first << " here. Sorry\n";
                }
            }

            cout << "total price : " << totalPrice << "\n";
            return totalPrice;
        }
};

int main()
{
    Seller seller;
    map<string, long long> purchase;

    purchase.insert({"strawberry", 10});
    purchase.insert({"apple", 10});
    purchase.insert({"banana", 10});
    purchase.insert({"cat", 10});
    purchase.insert({"CUCCI", 1});

    seller.setPrice("strawberry", 8000);
    seller.setInventory("strawberry", 30);
    seller.setPrice("apple", 3000);
    seller.setInventory("apple", 20);
    seller.setPrice("banana", 2000);
    seller.setInventory("banana", 3);
    seller.setPrice("CUCCI", 5000);
    seller.setInventory("CUCCI", 1);

    seller.getList(purchase);
}
