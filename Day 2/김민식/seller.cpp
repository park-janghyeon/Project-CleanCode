#include <iostream>
#include <map>
#include <iomanip>

using namespace std;

class Seller {
    map<string, pair<int, long long > > goods;

public:  
    Seller() 
    {
        goods["Mac Book Pro"] = make_pair(100, 3000000);
        goods["Apple"] = make_pair(40, 5000);
        goods["Bburingcle"] = make_pair(100, 28000);
        goods["Beer"] = make_pair(50, 6000);
        goods["GUCCI BAG"] = make_pair(0, 100000000000);
    }

    int getInven(string name)
    {
        if (goods.find(name) != goods.end())
            return goods[name].first;
        else
        {
            cout << "Error: No such item\n";
            return -1;
        }
    }

    long long getPrice(string name)
    {
        if (goods.find(name) != goods.end())
            return goods[name].second;
        else
        {
            cout << "Error: No such item\n";
            return -1;
        }
    }

    void purchase(map<string, int> purchaseList)
    {
        long long totalPrice = 0;

        cout << "┌---------------------------------------------------------------------┐\n";
        cout << "|                               영수증                                |\n";
        cout << "|                                                                     |\n";
        cout << "|                                                                     |\n";
        cout << left << setw(24) << "| 품목" << setw(15) << "개수" << setw(16) << "가격" << setw(23) << "총 가격" << " |\n";
        cout << "|---------------------------------------------------------------------|\n";
        for (auto it : purchaseList)
        {
            if (goods.find(it.first) != goods.end())
            {
                if (it.second <= goods[it.first].first)
                {
                    totalPrice += goods[it.first].second * it.second;
                    cout << "| " << setw(20) << it.first << setw(13) << it.second << setw(14) << goods[it.first].second << setw(20) << goods[it.first].second * it.second << " |\n";
                    cout << "|                                                                     |\n";
                    goods[it.first].first -= it.second;
                }
                else
                {
                    totalPrice += goods[it.first].second * goods[it.first].first;
                    cout << "| " << setw(20) << it.first << setw(13) << goods[it.first].first << setw(14) << goods[it.first].second << setw(20) << goods[it.first].first * goods[it.first].second << " |\n";
                    cout << "|                                                                     |\n";
                    goods[it.first].first = 0;
                }
            }
        }
        cout << "|---------------------------------------------------------------------|\n";
        cout << right << "| " << setw(51) << "합계 금액: " << setw(20) << totalPrice << " |\n";
        cout << "|---------------------------------------------------------------------|\n";
        cout << right << "| " << setw(56) << "부가세 과제물품가액: " << fixed << setprecision(0) << setw(20) << totalPrice - (totalPrice * 0.1) << " |\n";
        cout << right << "| " << setw(50) << "부가세: " << fixed << setprecision(0) << setw(20) << (totalPrice * 0.1) << " |\n";
        cout << "└---------------------------------------------------------------------┘\n";
    }
};

int main(void)
{
    map<string, int> purchaseList;
    purchaseList["Mac Book Pro"] = 1;
    purchaseList["Banana"] = 4;
    purchaseList["Beer"] = 100;
    Seller seller = Seller();
    seller.purchase(purchaseList);
}
