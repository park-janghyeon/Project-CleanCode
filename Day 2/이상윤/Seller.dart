void main() {
  Seller mySeller = Seller();
  print(mySeller.searchSupply("ABCD"));
  print(mySeller.searchPrice("ABCD"));
  Map<String, int> myList = {"ABCD": 1235, "QWER": 5678};
  print(mySeller.getTotal(myList));
  mySeller.addSupply("ABCD");
  print(mySeller.getTotal(myList));
}

class Seller{
  Map<String, int> _supply = {"ABCD": 1234, "QWER": 5678};
  Map<String, int> _valueTag = {"ABCD": 100, "QWER": 200};
  
  int searchSupply(String target){
    if (!_supply.containsKey(target)) return -1;
    return _supply[target]!;
  }
  
  int searchPrice(String target){
    if (!_valueTag.containsKey(target)) return -1;
    return _valueTag[target]!;
  }
  
  double getTotal(Map myList){
    double total = 0;
    for(var entry in myList.entries){
      if (!_supply.containsKey(entry.key)) return -1;
      if (!_valueTag.containsKey(entry.key)) return -1;
      if (entry.value < 0) return -1;
      int cnt = (_supply[entry.key]! < entry.value ? _supply[entry.key] : entry.value);
      total += _valueTag[entry.key]! * cnt * (cnt <= 5 ? 0.9 : 1);
    }
    return total;
  }
  
  void addSupply(String target){
    if (_supply.containsKey(target)) _supply[target] = _supply[target]! + 1;
  }
}
